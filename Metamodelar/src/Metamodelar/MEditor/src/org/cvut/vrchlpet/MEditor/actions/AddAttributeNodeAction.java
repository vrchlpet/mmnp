

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MEditor.dialogs.AttributeEditorDialog;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;
import org.cvut.vrchlpet.MEditor.nodes.MAbstractNode;

/**
 *
 * Akce uzlu Element pro pridani atributu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AddAttributeNodeAction extends AbstractAction{


    private MAbstractNode man = null;

    public AddAttributeNodeAction(MAbstractNode man) {
        putValue (NAME, "add attribute");
        this.man = man;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Attribute at = null;
        Element element = man.getLookup().lookup(Element.class);

        if ( element == null)
            return;


        String s = JOptionPane.showInputDialog("Type in the name of the new attribute");
        if (  s == null)
            return;
        
        
        if (s.trim().length() == 0) {
            DialogMessagesManager.showErrorDialog("Empty name!");
            return;
        }


        

        if ( (at = man.getController().getElementManager().createAttribute(element, s)) != null) {
            AttributeEditorDialog attEditorDialog = new AttributeEditorDialog(man.getController(), at);
        } else {
           DialogMessagesManager.showErrorDialog("Cannot add attribute: " + s);
        }
    }
}
