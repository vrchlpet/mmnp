/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor;

import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.openide.windows.TopComponent;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MasterEditorManager implements IMasterEditorManager{


    private MEditorTopComponent topComp;
    private IMModel model;
    private IMasterController controller;

    public MasterEditorManager(IMModel model, IMasterController controller) {
        this.model = model;
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

    @Override
    public IMModel getModel() {
        return this.model;
    }


    





}
