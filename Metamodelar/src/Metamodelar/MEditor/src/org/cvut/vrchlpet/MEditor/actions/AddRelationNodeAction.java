/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MEditor.dialogs.AddRelationDialog;
/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddRelationNodeAction extends AbstractAction{

    private IMasterController controller;

    public AddRelationNodeAction(IMasterController controller) {
        this.controller = controller;
        putValue (NAME, "Add relation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddRelationDialog addRelationDialog = new AddRelationDialog(controller);
    }


}

