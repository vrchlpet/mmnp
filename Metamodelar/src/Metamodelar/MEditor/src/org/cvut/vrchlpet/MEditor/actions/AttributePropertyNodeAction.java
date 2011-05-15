/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MEditor.dialogs.AttributeEditorDialog;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributePropertyNodeAction extends AbstractAction{

    private IMasterController controller;
    private Attribute attribute;

    public AttributePropertyNodeAction(IMasterController controller, Attribute attribute) {
        putValue (NAME, "properties");
        this.controller = controller;
        this.attribute = attribute;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AttributeEditorDialog attEditorDialog = new AttributeEditorDialog(controller, attribute);
    }
}
