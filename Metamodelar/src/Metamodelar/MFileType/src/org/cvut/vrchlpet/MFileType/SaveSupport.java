/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MFileType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.util.Serializer;
import org.openide.loaders.DataObject;


    /**
     *
     * Implementace podpory ulozeni metamodelu
     *
     * @author Vrchlavsky Petr
     * @version 1.0
     */
public final class SaveSupport implements ActionListener {

    private final DataObject context;

    public SaveSupport(DataObject context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        MMDataObject oo = (MMDataObject)context;

        IMModel model = (oo.getCookie(ModelData.class)).getMetamodel();
        try {
            Serializer.createSerializer().serialize(model, oo.getPrimaryFile().getPath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }

        JOptionPane.showMessageDialog(null, "Model " + model.getModel().getNameSpace() + " has been saved.");
    }
}
