
package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.NamedElement;
import org.openide.windows.WindowManager;

/**
 *
 * Akce uzlu pro zmenu popisu metaobjektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ChangeDescriptionNodeAction extends AbstractAction{

    private IMasterController controller;
    private NamedElement obj;

    public ChangeDescriptionNodeAction(IMasterController controller, NamedElement obj) {
        this.controller = controller;
        this.obj = obj;
        putValue (NAME, "Change description");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = JOptionPane.showInputDialog(WindowManager.getDefault().getMainWindow(), "Type int new description", obj.getDescription());
        if ( s != null) {
            controller.getMetaObjectManager().changeDescriptio(obj, s);
        }
        
        
    }


}
