
package org.cvut.vrchlpet.MEditor.controller;



import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.MData;
import org.cvut.vrchlpet.MCore.core.Property;

/**
 *  Manager atributu
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
    public boolean changeName(Attribute at, String name) {
        if ( name.trim().length() == 0)
            return false;
        
        for ( Attribute a : at.getElement().getAttributes()) {
            if ( a == at)
                continue;
            
            if ( a.getName().equals(name))
                return false;
        }
        
        at.setName(name);
        return true;
    }

    @Override
    public boolean removeProperty(Attribute at, Property prop) {
        return controller.getMModel().getBuilder().removeProperty(at, prop);
    }

    @Override
    public boolean addProperty(Attribute at, String name, String dataType) {
        Property prop = controller.getMModel().getBuilder().createProperty(at, name, MData.getType(dataType));
        
        if ( prop == null)
            return false;
        
        prop.setValue(prop.getmData().getDefault());
        return true;
    }

}
