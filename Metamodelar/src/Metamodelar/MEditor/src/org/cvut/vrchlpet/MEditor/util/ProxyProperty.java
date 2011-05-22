
package org.cvut.vrchlpet.MEditor.util;

import java.awt.Color;
import java.util.Date;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Property;

/**
 *
 * Proxy objekt property, deleguje udalosti pres controller
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ProxyProperty {


    private Property property;
    private IMasterController controller;

    public ProxyProperty(Property property, IMasterController controller) {
        this.property = property;
        this.controller = controller;
    }


    public Object getValue() {
        return property.getValue();
    }

    public void setValue(String value) {
        controller.getPropertyManager().setValue(property, value);
    }

    public void setValue(Boolean value) {
        controller.getPropertyManager().setValue(property, value);
    }

    public void setValue(Integer value) {
        controller.getPropertyManager().setValue(property, value);
    }

    public void setValue(Double value) {
        controller.getPropertyManager().setValue(property, value);
    }

    public void setValue(Date value) {
        controller.getPropertyManager().setValue(property, value);
    }

    public void setValue(Color value) {
        int red = value.getRed();
        int blue = value.getBlue();
        int green = value.getGreen();
        controller.getPropertyManager().setValue(property, value);
    }

    public void setValue(Character value) {
        controller.getPropertyManager().setValue(property, value);
    }

    public void setValue(Object value) {
        controller.getPropertyManager().setValue(property, value);
    }


}
