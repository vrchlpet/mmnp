

package org.cvut.vrchlpet.MEditor.actions;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.util.Serializer;
import org.cvut.vrchlpet.MEditor.IMasterEditorManager;
import org.openide.cookies.SaveCookie;

/**
 *
 * Implementace save podpory
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class SaveSupport implements SaveCookie{

    IMasterEditorManager mem;


    public SaveSupport(IMasterEditorManager mem) {
        this.mem = mem;
    }

    @Override
    public void save() throws IOException {
        try {
            Serializer.createSerializer().serialize(mem.getController().getMModel(), mem.getController().getModelPath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }

        JOptionPane.showMessageDialog(null, "Model " + mem.getController().getMModel().getModel().getNameSpace() + " has been saved.");
    }

}
