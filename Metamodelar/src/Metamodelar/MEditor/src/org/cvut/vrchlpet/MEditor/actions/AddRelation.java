

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.cvut.vrchlpet.MEditor.dialogs.AddRelationDialog;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * Obsluha akce tlacitka add v dialogu pro pridani nove relace
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddRelation implements ActionListener{

    private AddRelationDialog dialog;



    public AddRelation(AddRelationDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = dialog.getRelationName();

        name = name.trim();
        if ( name.length() == 0) {
            DialogMessagesManager.showErrorDialog("Bad input data: " + name);
        } else {
            if ( dialog.getController().getModelManager().addRelation(name)) {
                DialogMessagesManager.showInfoDialog("Relation " + name + " has been added.");
            } else {
                DialogMessagesManager.showErrorDialog("Relation " + name + " already exists");
            }
        }
    }
}
