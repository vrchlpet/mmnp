/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.util.Serializer;
import org.cvut.vrchlpet.MEditor.IMasterEditorManager;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.openide.cookies.SaveCookie;

/**
 *
 * @author Vrchli
 */
public class SaveSupport implements SaveCookie{

    IMasterEditorManager mem;


    public SaveSupport(IMasterEditorManager mem) {
        this.mem = mem;
    }

    @Override
    public void save() throws IOException {
        try {
            Serializer.createSerializer().serialize(mem.getModel(), mem.getController().getModelPath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }

        JOptionPane.showMessageDialog(null, "Model " + mem.getModel().getModel().getNameSpace() + " has been saved.");
    }

}
