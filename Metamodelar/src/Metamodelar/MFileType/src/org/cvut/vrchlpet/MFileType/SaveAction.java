/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MFileType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.openide.loaders.DataObject;

import org.openide.awt.ActionRegistration;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionID;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(category = "Build",
id = "org.cvut.vrchlpet.MFileType.SaveAction")
@ActionRegistration(displayName = "#CTL_SaveAction")
@ActionReferences({
    @ActionReference(path = "Loaders/text/x-mm/Actions", position = 350)
})
@Messages("CTL_SaveAction=Save")
public final class SaveAction implements ActionListener {

    private final DataObject context;

    public SaveAction(DataObject context) {
        this.context = context;
    }

    public void actionPerformed(ActionEvent ev) {
        try {
            MMDataObject oo = (MMDataObject)context;

            IMModel model = (oo.getCookie(ModelData.class)).getMetamodel();
            
            Serializer.createSerializer().serialize(model, oo.getPrimaryFile().getPath());
            JOptionPane.showMessageDialog(null, "Model " + model.getModel().getNameSpace() + " has been saved.");
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
