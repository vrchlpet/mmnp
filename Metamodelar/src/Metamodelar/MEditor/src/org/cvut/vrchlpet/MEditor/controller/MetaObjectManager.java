/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MEditor.controller.IMetaObjectManager;
import org.cvut.vrchlpet.MCore.core.MetaObject;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetaObjectManager implements IMetaObjectManager{


    private IMasterController controller;

    public MetaObjectManager(IMasterController controller) {
        this.controller = controller;
    }

    @Override
    public boolean changeNamespace(MetaObject obj, String namespace) {
        
        String val = namespace.trim();
        if ( val.length() == 0 || val.equals(""))
            return false;
        
        if ( controller.getMModel().getModelInfo().isNameSpaceInUse(namespace))
            return false;

        obj.setNameSpace(namespace);

        return true;
    }

    @Override
    public boolean changeDescriptio(MetaObject obj, String description) {
        obj.setDescription(description);
        return true;
    }






}
