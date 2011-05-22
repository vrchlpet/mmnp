
package org.cvut.vrchlpet.MEditor;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.openide.windows.TopComponent;

/**
 *
 * Implementace view komponenty z MVC
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MasterEditorManager implements IMasterEditorManager{


    private MEditorTopComponent topComp;
    private IMasterController controller;

    public MasterEditorManager(IMasterController controller) {
        this.controller = controller;
    }

    @Override
    public TopComponent getTopComponent() {
        if ( topComp == null)
            topComp = new MEditorTopComponent(this);

        return topComp;
    }

    @Override
    public void setController(IMasterController controller) {
        this.controller = controller;
    }

    @Override
    public IMasterController getController() {
        return this.controller;
    }
}
