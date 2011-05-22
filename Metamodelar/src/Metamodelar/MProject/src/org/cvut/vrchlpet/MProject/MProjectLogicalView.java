
package org.cvut.vrchlpet.MProject;

import java.awt.Image;
import javax.swing.Action;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.netbeans.spi.project.ui.support.CommonProjectActions;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFilter;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

/**
 *
 * Trida se stara o tvorbu stromove struktury projektu ve spravci projektu.
 *
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MProjectLogicalView implements LogicalViewProvider {

    private final MProject project;

    public MProjectLogicalView(MProject project) {
        this.project = project;
    }

    @Override
    public org.openide.nodes.Node createLogicalView() {
        try {
            //Get the project directory
            FileObject mmFileObject = project.getFolder(true);

            //Get the DataObject that represents it
            DataFolder mmDataFolder =
                    DataFolder.findFolder(mmFileObject);

            // potomci uzlu projektu - jednotlive soubory metamodelu
            Children ch = mmDataFolder.createNodeChildren(new DataFilter() {

                @Override
                public boolean acceptDataObject(DataObject d) {
                    String name = d.getPrimaryFile().getPath();

                    // pouze soubory metamodelare se zobrazi
                    if ( !d.getPrimaryFile().isFolder() && (name.endsWith(".mm") || name.endsWith(".MM")))
                        return true;
                    
                    return false;
                }
            }); 
            
            
            
            Node mmFolderNode = new AbstractNode(ch);

            
            return new MMNode(mmFolderNode, project);

        } catch (DataObjectNotFoundException donfe) {
            Exceptions.printStackTrace(donfe);
            return new AbstractNode(Children.LEAF);
        }
    }
    
    
    @Override
    public Node findPath(Node node, Object o) {
        return null;
    }




    // tato trida je ve skutecnosti uzel, ktery vidime ve spravci projektu
    private class MMNode extends FilterNode {

        final MProject project;

        public MMNode(Node node, MProject project) throws DataObjectNotFoundException {
            super(node, new FilterNode.Children(node),
                    //The projects system wants the project in the Node's lookup.
                    //NewAction and friends want the original Node's lookup.
                    //Make a merge of both
                    new ProxyLookup(new Lookup[]{Lookups.singleton(project),
                        node.getLookup()
                    }));
            this.project = project;
        }

        // vyuziti defaultnich NetBeans akci
        @Override
        public Action[] getActions(boolean arg0) {
            Action[] nodeActions = new Action[7];
            nodeActions[0] = CommonProjectActions.newFileAction();
            nodeActions[2] = CommonProjectActions.deleteProjectAction();
            nodeActions[6] = CommonProjectActions.closeProjectAction();
            return nodeActions;
        }

        @Override
        public Image getIcon(int type) {
           return ImageUtilities.loadImage("org/cvut/vrchlpet/MProject/icons/projectIco.png");
        }

        @Override
        public Image getOpenedIcon(int type) {
            return getIcon(type);
        }

        @Override
        public String getDisplayName() {
            return project.getProjectDirectory().getName();
        }

    }
}

