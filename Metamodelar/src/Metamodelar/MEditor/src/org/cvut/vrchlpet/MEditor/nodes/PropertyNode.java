
package org.cvut.vrchlpet.MEditor.nodes;


import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MEditor.util.ProxyProperty;
import org.cvut.vrchlpet.MEditor.util.StructuralFeatureSheetFactory;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;




/**
 *
 * Trida predstavujici skutecny uzel property
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyNode extends MAbstractNode implements PropertyChangeListener{

    public PropertyNode(org.cvut.vrchlpet.MCore.core.Property property, IMasterController controller) {
        super(Children.LEAF, Lookups.singleton(property), controller);
        updateDisplayName();
        property.addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(property,this));
    }

    private void updateDisplayName() {
        org.cvut.vrchlpet.MCore.core.Property property = getLookup().lookup(
                org.cvut.vrchlpet.MCore.core.Property.class);
        setDisplayName(property.getName());
    }
    
    
    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/propertyIco.jpg");
    }

    @Override
    protected Sheet createSheet() {

        ArrayList<PropertySupport.Reflection<? extends Object>> props = new ArrayList<PropertySupport.Reflection<? extends Object>>();
        
        org.cvut.vrchlpet.MCore.core.Property property = getLookup().lookup(
                org.cvut.vrchlpet.MCore.core.Property.class);

        ProxyProperty pa = new ProxyProperty(property, controller);

        PropertySupport.Reflection propRef;
        PropertySupport.Reflection<String> propRef2;
        try {
            propRef = new PropertySupport.Reflection(pa, property.getmData().getDataClass(), "value");
            propRef.setName("Value");
            

            propRef2 = new PropertySupport.Reflection<String>(property.getmData(), String.class, "toString", null);
            propRef2.setName("Type");
            props.add(propRef2);
            props.add(propRef);
        } catch (NoSuchMethodException ex) {
            Exceptions.printStackTrace(ex);
        }

        String setName = "set";
        
        Sheet sheet = StructuralFeatureSheetFactory.getSheet(property, controller, props, setName);
        return sheet;
        
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setSheet(createSheet());
        
        if ( org.cvut.vrchlpet.MCore.core.Property.NAME_CHANGED.equals(evt.getPropertyName())) {
            updateDisplayName();
        }
    }


}
