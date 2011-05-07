/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MEditor.dialogs.CreateReferenceDialog;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class CreateReferenceNodeAction extends AbstractAction{

    private IMasterController controller;
    private String element;

    public CreateReferenceNodeAction(String element, IMasterController controller) {
        this.controller = controller;
        this.element = element;
        putValue (NAME, "create reference");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateReferenceDialog createReferenceDialog = new CreateReferenceDialog(controller, element);
    }

}
