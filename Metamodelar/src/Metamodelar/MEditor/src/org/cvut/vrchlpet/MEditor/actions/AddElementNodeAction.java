

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.dialogs.AddElementDialog;
import org.cvut.vrchlpet.MEditor.nodes.MAbstractNode;

/**
 *
 * Akce uzlu Elements pro pridani noveho elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddElementNodeAction extends AbstractAction{

    private MAbstractNode man;

    public AddElementNodeAction(MAbstractNode man) {
        this.man = man;
        putValue (NAME, "Add element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddElementDialog addElementDialog = new AddElementDialog(man.getController());
    }


}