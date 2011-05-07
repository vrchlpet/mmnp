/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers.impl;

import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MController.managers.IPropertyManager;
import org.cvut.vrchlpet.MCore.core.Property;

/**
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
