
package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.dialogs.RelationUIEditor;

/**
 *
 * Akce uzlu Relation pro nastaveni grafiky
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
