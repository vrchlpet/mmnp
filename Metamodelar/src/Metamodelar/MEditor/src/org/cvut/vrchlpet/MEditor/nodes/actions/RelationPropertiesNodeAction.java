/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.dialogs.RelationEditorDialog;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationPropertiesNodeAction extends AbstractAction{

    private IMasterController controller;
    private Relation rel;

    public RelationPropertiesNodeAction(IMasterController controller, Relation rel) {
        this.controller = controller;
        putValue (NAME, "property");
        this.rel = rel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RelationEditorDialog red = new RelationEditorDialog(controller, rel);
    }


}
