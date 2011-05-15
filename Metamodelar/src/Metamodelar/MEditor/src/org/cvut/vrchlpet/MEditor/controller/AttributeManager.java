/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.controller;



import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.MData;
import org.cvut.vrchlpet.MCore.core.Property;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeManager implements IAttributeManager{

    // unused for now...
    private IMasterController controller;

    public AttributeManager(IMasterController controller) {
        this.controller = controller;
    }


    @Override
    public void changeName(Attribute at, String name) {
        at.setName(name);
    }

    @Override
    public boolean removeProperty(Attribute at, Property prop) {
        return controller.getMModel().getBuilder().removeProperty(at, prop);
    }

    @Override
    public boolean addProperty(Attribute at, String name, String dataType) {
        Property prop = controller.getMModel().getBuilder().createProperty(at, name, MData.getType(dataType));
        prop.setValue(prop.getmData().getDefault());
        return (prop != null);
    }

}
