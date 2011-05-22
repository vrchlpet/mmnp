

package org.cvut.vrchlpet.MEditor;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.openide.windows.TopComponent;

/**
 *
 * Rozhrani view componenty z MVC
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMasterEditorManager {

    public TopComponent getTopComponent();
    public void setController(IMasterController controller);
    public IMasterController getController();
}
