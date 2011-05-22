
package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.NamedElement;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;
import org.openide.windows.WindowManager;

/**
 *
 * Akce uzlu pro zmenu jmeneho prostoru metamodelu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ChangeNamespaceNodeAction extends AbstractAction{

    private IMasterController controller;
    private NamedElement obj;

    public ChangeNamespaceNodeAction(IMasterController controller, NamedElement obj) {
        this.controller = controller;
        this.obj = obj;
        putValue (NAME, "Change namespace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = JOptionPane.showInputDialog(WindowManager.getDefault().getMainWindow(), "Type int a new namespace");
        if ( s != null) {
            if ( !controller.getMetaObjectManager().changeNamespace(obj, s)) {
                DialogMessagesManager.showErrorDialog("Wrong input!");
            }
        }
        
        
    }


}