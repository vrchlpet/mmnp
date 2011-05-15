/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MProject;

import java.io.File;
import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
@org.openide.util.lookup.ServiceProvider(service=ProjectFactory.class)
public class MProjectFactory implements ProjectFactory {

    public static final String PROJECT_DIR = "texts";

    //Specifies when a project is a project, i.e.,
    //if the project directory "texts" is present:
    @Override
    public boolean isProject(FileObject projectDirectory) {
        
        for ( FileObject fn : projectDirectory.getChildren()) {
            String path = fn.getPath();
            if ( fn.isData() && fn.getPath().endsWith(".mm"))
                return true;
        }
        
        return false;
    }

    //Specifies when the project will be opened, i.e.,
    //if the project exists:
    @Override
    public Project loadProject(FileObject dir, ProjectState state) throws IOException {
        if ( isProject(dir))
            return new MProject(dir, state);
        return null;
    }

    @Override
    public void saveProject(final Project project) throws IOException, ClassCastException {
        /*FileObject projectRoot = project.getProjectDirectory();
        if (projectRoot.getFileObject(PROJECT_DIR) == null) {
            throw new IOException("Project dir " + projectRoot.getPath() +
                    " deleted," +
                    " cannot save project");
        }
        //Force creation of the texts dir if it was deleted:
        ((MProject) project).getTextFolder(true);*/
    }

}
