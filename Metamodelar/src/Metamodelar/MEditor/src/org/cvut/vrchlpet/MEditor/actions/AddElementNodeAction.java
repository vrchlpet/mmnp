/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.cvut.vrchlpet.MEditor.dialogs.AddElementDialog;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddElementNodeAction extends AbstractAction{

    private IMasterController controller;

    public AddElementNodeAction(IMasterController controller) {
        this.controller = controller;
        putValue (NAME, "Add element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddElementDialog addElementDialog = new AddElementDialog(controller);
    }


}