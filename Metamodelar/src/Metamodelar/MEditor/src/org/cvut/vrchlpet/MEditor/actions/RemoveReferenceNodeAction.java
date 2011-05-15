/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RemoveReferenceNodeAction extends AbstractAction{




    private Reference reference;
    private IMasterController controller;

    public RemoveReferenceNodeAction(Reference reference, IMasterController controller) {
        this.reference = reference;
        this.controller = controller;
        putValue (NAME, "Remove reference");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DialogMessagesManager.showInfoDialog("Reference to " + reference.getReferenceType().getNameSpace() + " has been removed.");
        controller.getElementManager().removeReference((Element)reference.getOwner(), reference);
        
    }


}