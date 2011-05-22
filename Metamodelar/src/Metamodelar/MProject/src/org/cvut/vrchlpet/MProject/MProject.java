
package org.cvut.vrchlpet.MProject;

import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.DeleteOperationImplementation;
import org.netbeans.spi.project.ProjectState;
import org.netbeans.spi.project.ui.support.DefaultProjectOperations;
import org.openide.filesystems.FileObject;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * Trida predstavujici projekt Metamodelare
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MProject implements Project {

    private final FileObject projectDir; // data
    private final ProjectState state;
    private Lookup lkp;

    public MProject(FileObject projectDir, ProjectState state) {
        this.projectDir = projectDir;
        this.state = state;
    }

    @Override
    public FileObject getProjectDirectory() {
        return projectDir;
    }

    public FileObject getFolder(boolean create) {
        return projectDir;
    }

    
    @Override
    public Lookup getLookup() {
        if (lkp == null) {
            lkp = Lookups.fixed(new Object[]{
                        state, 
                        new ActionProviderImpl(), // standardni akce NetBeans
                        new MDeleteOperation(), // akce mazani
                        new Info(), // info o projektu
                        new MProjectLogicalView(this), // struktura projektu
                    });
        }
        return lkp;
    }

    /**
     *
     * Trida sprostredkujici defaultni operace prostredi NetBeans. Konkretne delete a copy.
     *
     * @author Vrchlavsky Petr
     * @version 1.0
     */
    private final class ActionProviderImpl implements ActionProvider {

        private String[] supported = new String[]{
            ActionProvider.COMMAND_DELETE,
            ActionProvider.COMMAND_COPY,
        };

        @Override
        public String[] getSupportedActions() {
            return supported;
        }

        @Override
        public void invokeAction(String string, Lookup lookup) throws IllegalArgumentException {
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_DELETE)) {
                DefaultProjectOperations.performDefaultDeleteOperation(MProject.this);
            }
            if (string.equalsIgnoreCase(ActionProvider.COMMAND_COPY)) {
                DefaultProjectOperations.performDefaultCopyOperation(MProject.this);
            }
        }

        @Override
        public boolean isActionEnabled(String command, Lookup lookup) throws IllegalArgumentException {
            if ((command.equals(ActionProvider.COMMAND_DELETE))) {
                return true;
            } else if ((command.equals(ActionProvider.COMMAND_COPY))) {
                return true;
            } else {
                throw new IllegalArgumentException(command);
            }
        }
    }

    /**
     *
     * Trida zajistujici delete operaci
     *
     * @author Vrchlavsky Petr
     * @version 1.0
     */
    private final class MDeleteOperation implements DeleteOperationImplementation {

        @Override
        public void notifyDeleting() throws IOException {
        }

        @Override
        public void notifyDeleted() throws IOException {
        }

        @Override
        public List<FileObject> getMetadataFiles() {
            List<FileObject> dataFiles = new ArrayList<FileObject>();
            return dataFiles;
        }

        @Override
        public List<FileObject> getDataFiles() {
            List<FileObject> dataFiles = new ArrayList<FileObject>();
            return dataFiles;
        }
    }

    /**
     *
     * Trida poskytuje informace o projektu.
     *
     * @author Vrchlavsky Petr
     * @version 1.0
     */
    private final class Info implements ProjectInformation {

        @Override
        public Icon getIcon() {
            Image image = ImageUtilities.loadImage("org/cvut/vrchlpet/MProject/icons/projectIco.png");
            return new ImageIcon(image);
        }

        @Override
        public String getName() {
            return getProjectDirectory().getName();
        }

        @Override
        public String getDisplayName() {
            return getName();
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener pcl) {
            //neni treba
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener pcl) {
            //neni treba
        }

        @Override
        public Project getProject() {
            return MProject.this;
        }
    }
}

