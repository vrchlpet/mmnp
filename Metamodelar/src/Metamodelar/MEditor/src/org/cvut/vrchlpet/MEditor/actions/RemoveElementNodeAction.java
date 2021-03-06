

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * Akce uzlu Element pro odstraneni elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RemoveElementNodeAction extends AbstractAction{




    private Element element;
    private IMasterController controller;
    private boolean removementType;

    public RemoveElementNodeAction(Element element, IMasterController controller, boolean rem) {
        this.element = element;
        this.removementType = rem;
        this.controller = controller;
        putValue (NAME, "Remove element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( controller.getModelManager().removeElement(element, removementType)) {
            DialogMessagesManager.showInfoDialog("Element " + element.getNameSpace() + " has been removed.");
        } else {
            DialogMessagesManager.showErrorDialog("Element " + element.getNameSpace() + " cannot be removed!");
        }
    }


}