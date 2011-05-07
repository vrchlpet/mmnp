/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RemoveRelationNodeAction extends AbstractAction{




    private Relation rel;
    private IMasterController controller;

    public RemoveRelationNodeAction(Relation rel, IMasterController controller) {
        this.rel = rel;
        this.controller = controller;
        putValue (NAME, "Remove relation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( controller.getModelManager().removeRelation(rel)) {
            DialogMessagesManager.showInfoDialog("Relation " + rel.getNameSpace() + " has been removed.");
        } else {
            DialogMessagesManager.showErrorDialog("Relation " + rel.getNameSpace() + " cannot be removed!");
        }
    }


}
