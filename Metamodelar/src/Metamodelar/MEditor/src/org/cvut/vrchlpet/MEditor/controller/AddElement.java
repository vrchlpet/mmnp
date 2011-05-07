/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.cvut.vrchlpet.MEditor.dialogs.AddElementDialog;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddElement implements ActionListener{

    private AddElementDialog dialog;


    public AddElement(AddElementDialog dialog) {
        this.dialog = dialog;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String name = dialog.getElementName();
        if ( name.length() == 0) {
            DialogMessagesManager.showErrorDialog("Bad input data: " + name);
        } else {
            if ( dialog.getController().getModelManager().addElement(name)) {
                DialogMessagesManager.showInfoDialog("Element " + name + " has been added.");
            } else {
                DialogMessagesManager.showErrorDialog("Element " + name + " already exists");
            }
        }
    }

}
