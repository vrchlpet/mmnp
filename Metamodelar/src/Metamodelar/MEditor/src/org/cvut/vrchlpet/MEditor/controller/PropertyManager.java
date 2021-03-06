
package org.cvut.vrchlpet.MEditor.controller;


import org.cvut.vrchlpet.MCore.core.Property;

/**
 *
 * Manager property
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyManager implements IPropertyManager{

    // unused for now...
    private IMasterController controller;

    public PropertyManager(IMasterController controller) {
        this.controller = controller;
    }

    @Override
    public boolean setValue(Property prop, Object value) {
        
        try {
            prop.setValue(value);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

}
