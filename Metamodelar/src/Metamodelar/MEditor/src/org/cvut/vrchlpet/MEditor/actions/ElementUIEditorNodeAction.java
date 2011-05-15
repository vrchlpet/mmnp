/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MEditor.dialogs.ElementUIEditor;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementUIEditorNodeAction extends AbstractAction{


    private Element element;

    public ElementUIEditorNodeAction(Element element) {
        putValue (NAME, "edit UI");
        this.element = element;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ElementUIEditor elementUIEditor = new ElementUIEditor(element);

    }

}
