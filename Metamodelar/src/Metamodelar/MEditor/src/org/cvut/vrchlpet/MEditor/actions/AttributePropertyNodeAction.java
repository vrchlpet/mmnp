

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MEditor.dialogs.AttributeEditorDialog;
import org.cvut.vrchlpet.MEditor.nodes.MAbstractNode;

/**
 *
 * Akce uzlu Property pro vyvolani dialogu s nastavenim
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributePropertyNodeAction extends AbstractAction{

    private MAbstractNode man;

    public AttributePropertyNodeAction(MAbstractNode man) {
        putValue (NAME, "properties");
        this.man = man;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AttributeEditorDialog attEditorDialog = new AttributeEditorDialog(man.getController(),
                man.getLookup().lookup(Attribute.class));
    }
}
