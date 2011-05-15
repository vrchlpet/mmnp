/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
            //Get the Text directory, creating if deleted
            FileObject mmFileObject = project.getFolder(true);

            //Get the DataObject that represents it
            DataFolder mmDataFolder =
                    DataFolder.findFolder(mmFileObject);
            Children ch = mmDataFolder.createNodeChildren(new DataFilter() {

                @Override
                public boolean acceptDataObject(DataObject d) {
                    String name = d.getPrimaryFile().getPath();
                    if ( !d.getPrimaryFile().isFolder() && (name.endsWith(".mm") || name.endsWith(".MM")))
                        return true;
                    
                    return false;
                }
            }); 
            
            
            //Get its default node-we'll wrap our node around it to change the
            //display name, icon, etc
            Node mmFolderNode = new AbstractNode(ch);

            //This FilterNode will be our project node
            return new MMNode(mmFolderNode, project);

        } catch (DataObjectNotFoundException donfe) {
            Exceptions.printStackTrace(donfe);
            //Fallback-the directory couldn't be created -
            //read-only filesystem or something evil happened
            return new AbstractNode(Children.LEAF);
        }
    }
    
    
    @Override
    public Node findPath(Node node, Object o) {
        return null;
    }




    /** This is the node you actually see in the project tab for the project */
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

        @Override
        public Action[] getActions(boolean arg0) {
            Action[] nodeActions = new Action[7];
            
            nodeActions[0] = CommonProjectActions.newFileAction();
            //nodeActions[1] = CommonProjectActions.copyProjectAction();
            nodeActions[2] = CommonProjectActions.deleteProjectAction();
            //nodeActions[5] = CommonProjectActions.setAsMainProjectAction();
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

