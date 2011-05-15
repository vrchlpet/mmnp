

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RemoveAttributeNodeAction extends AbstractAction{




    private Attribute attribute;
    private IMasterController controller;

    public RemoveAttributeNodeAction(Attribute attribute, IMasterController controller) {
        this.attribute = attribute;
        this.controller = controller;
        putValue (NAME, "Remove attribute");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.getElementManager().removeAttribute(attribute);
        DialogMessagesManager.showInfoDialog("Attribute " + attribute.getName() + " has been removed.");
    }


}