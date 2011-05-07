

package org.cvut.vrchlpet.MEditor;

import java.awt.event.ActionListener;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.openide.windows.TopComponent;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMasterEditorManager {

    public TopComponent getTopComponent();
    public void setController(IMasterController controller);
    public IMasterController getController();
    public IMModel getModel();
}
