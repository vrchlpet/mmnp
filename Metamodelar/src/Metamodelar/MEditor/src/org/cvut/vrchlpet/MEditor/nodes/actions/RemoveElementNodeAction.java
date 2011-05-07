/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;
import org.cvut.vrchlpet.MEditor.nodes.ElementNode;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RemoveElementNodeAction extends AbstractAction{




    private Element element;
    private IMasterController controller;
    private boolean removementType;

    public RemoveElementNodeAction(Element element, IMasterController controller, boolean rem) {
        this.element = element;
        this.removementType = rem;
        this.controller = controller;
        putValue (NAME, "Remove element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( controller.getModelManager().removeElement(element, removementType)) {
            DialogMessagesManager.showInfoDialog("Element " + element.getNameSpace() + " has been removed.");
        } else {
            DialogMessagesManager.showErrorDialog("Element " + element.getNameSpace() + " cannot be removed!");
        }
    }


}