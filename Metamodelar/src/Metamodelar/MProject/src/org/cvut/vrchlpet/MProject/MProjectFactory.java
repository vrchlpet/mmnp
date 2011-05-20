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
 * Trida se stara o nahrani/vytvoreni projektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
@org.openide.util.lookup.ServiceProvider(service=ProjectFactory.class)
public class MProjectFactory implements ProjectFactory {

    public static final String PROJECT_DIR = "texts";

    // rozhodne. zda se jedna o projekt
    @Override
    public boolean isProject(FileObject projectDirectory) {
        
        for ( FileObject fn : projectDirectory.getChildren()) {
            String path = fn.getPath();
            if ( fn.isData() && (fn.getPath().endsWith(".mm") || fn.getPath().endsWith(".MM")))
                return true;
        }
        
        return false;
    }

    // rozhodne, zda se jedna o projekt na zaklade parametru dir
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
