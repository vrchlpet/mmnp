/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MEditor.dialogs.AttributeEditorDialog;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddAttributeNodeAction extends AbstractAction{

    private IMasterController controller;
    private Element element;

    public AddAttributeNodeAction(IMasterController controller, Element element) {
        putValue (NAME, "add attribute");
        this.controller = controller;
        this.element = element;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s = (String)JOptionPane.showInputDialog("Type in the name of the new attribute");
        if (  s == null)
            return;
        
        
        if (s.trim().length() == 0) {
            DialogMessagesManager.showErrorDialog("Empty name!");
            return;
        }


        Attribute at = null;


        if ( (at = controller.getElementManager().createAttribute(element, s)) != null) {
            AttributeEditorDialog attEditorDialog = new AttributeEditorDialog(controller, at);
        } else {
           DialogMessagesManager.showErrorDialog("Exception has occured!");
        }
    }
}
