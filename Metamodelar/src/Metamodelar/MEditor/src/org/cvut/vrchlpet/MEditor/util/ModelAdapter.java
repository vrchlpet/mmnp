/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.util;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelAdapter {
    
    private IMasterController controller;
    private Model model;
    
    public ModelAdapter(IMasterController controller, Model model) {
        this.controller = controller;
        this.model = model;
    }
    
    
    
    public void setDescription(String s) {
        controller.getMetaObjectManager().changeDescriptio(model, s);
    }
    
    public void setNameSpace(String s) {
        if ( !controller.getMetaObjectManager().changeNamespace(model, s)) {
            DialogMessagesManager.showErrorDialog("Namespace " + s + " is already used.");
        }
    }
    
    public String getDescription() {
        return model.getDescription();
    }
    
    public String getNameSpace() {
        return model.getNameSpace();
    }
    
    
}
