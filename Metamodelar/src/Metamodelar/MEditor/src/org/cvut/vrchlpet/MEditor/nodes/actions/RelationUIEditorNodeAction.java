/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.dialogs.RelationUIEditor;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationUIEditorNodeAction extends AbstractAction{


    private Relation relation;

    public RelationUIEditorNodeAction(Relation relation) {
        putValue (NAME, "edit UI");
        this.relation = relation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RelationUIEditor relationUIEditor = new RelationUIEditor(relation);

    }
    
}
