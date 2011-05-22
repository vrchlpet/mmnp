
package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.dialogs.RelationEditorDialog;

/**
 *
 * Akce uzlu Relation pro vyvolani dialogu s nastavenim
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
