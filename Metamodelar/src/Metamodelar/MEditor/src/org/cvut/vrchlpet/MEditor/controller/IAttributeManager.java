
package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Property;

/**
 *  Rozhrani manageru atributu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IAttributeManager {
    
    public boolean addProperty(Attribute at, String name, String dataType);
    public boolean changeName(Attribute at, String name);
    public boolean removeProperty(Attribute at, Property prop);
}
