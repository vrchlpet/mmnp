/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MEditor.dialogs.ElementEditorDialog;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementPropertyNodeAction extends AbstractAction{

    private IMasterController controller;
    private Element element;

    public ElementPropertyNodeAction(IMasterController controller, Element element) {
        putValue (NAME, "properties");
        this.controller = controller;
        this.element = element;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ElementEditorDialog elEditDiag = new ElementEditorDialog(controller, element);
    }
}