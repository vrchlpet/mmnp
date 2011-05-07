/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MEditor.dialogs.ReferenceEditorDialog;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferencePropertyNodeAction extends AbstractAction{

    private IMasterController controller;
    private Reference reference;

    public ReferencePropertyNodeAction(IMasterController controller, Reference reference) {
        putValue (NAME, "properties");
        this.controller = controller;
        this.reference = reference;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ReferenceEditorDialog referenceEditorDialog = new ReferenceEditorDialog(controller, reference);
    }

}
