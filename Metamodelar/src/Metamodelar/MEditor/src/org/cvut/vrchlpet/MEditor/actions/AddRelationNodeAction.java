
package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.dialogs.AddRelationDialog;
import org.cvut.vrchlpet.MEditor.nodes.MAbstractNode;


/**
 *
 * Akce uzlu Relations pro pridani nove relace
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddRelationNodeAction extends AbstractAction{

    private MAbstractNode man;

    public AddRelationNodeAction(MAbstractNode man) {
        this.man = man;
        putValue (NAME, "Add relation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddRelationDialog addRelationDialog = new AddRelationDialog(man.getController());
    }


}

