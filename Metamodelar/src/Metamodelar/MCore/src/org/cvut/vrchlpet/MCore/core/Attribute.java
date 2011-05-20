

package org.cvut.vrchlpet.MCore.core;


import java.util.ArrayList;

/**
 *
 * Trida reprezentujici kontejner pro vlastnosti elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Attribute extends StructuralFeature{

    
    public static final String PROPERTY_REMOVED = "prop_rm";
    public static final String PROPERTY_ADDED = "prop_add";


    // skutecne vlastnosti
    private ArrayList<Property> properties;

    // kontener atributu
    private Element element;
    
    public Attribute(Element el) {
        this.properties = new ArrayList<Property>();
        this.element = el;
    }



    public boolean removeProperty(Property p) {
        boolean b = false;
        if ( properties.remove(p)) {
            b = true;
            Property old = p;
            p.removePropertyChangeListener(this);
            firePropertyChange(PROPERTY_REMOVED, old, this.properties);
        }

        return b;
    }

    public Property createProperty(MData data, String name) {
        Property property = new Property(data);
        property.setName(name);
        property.addPropertyChangeListener(this);
        properties.add(property);
        firePropertyChange(PROPERTY_ADDED, this.properties, property);
        return property;
    }

    public ArrayList<Property> getProperties() {
        return this.properties;
    }


    @Override
    public String toString() {
        String s = getName() + ", owner: " + element.getNameSpace();
        return s;
    }

    /**
     * @return the element
     */
    public Element getElement() {
        return element;
    }

}
