/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;


import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MEditor.actions.ActionFactory;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementNode extends MAbstractNode implements PropertyChangeListener{

    private ElementChildren parrent;

    public ElementNode(Element element, ElementChildren parrent, IMasterController controller) {
        super(new ElementContentChildren(element, controller), Lookups.singleton(element), controller);
        this.parrent = parrent;
        setDisplayName(element.getNameSpace());
        setShortDescription(element.getDescription());
        element.addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(element, this));
        ActionFactory.addActions(element, this);
    }

    /**
     * @return the parrent
     */
    public ElementChildren getParrent() {
        return parrent;
    }


    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/elementIco.png");
    }

    
    
    @Override
    public Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        set.setName("set");

        Element el = getLookup().lookup(Element.class);

        PropertySupport.Reflection<String> property3 = null;
        PropertySupport.Reflection<String> property2 = null;
        PropertySupport.Reflection<String> property1 = null;
        try {
            property2 = new PropertySupport.Reflection<String>(el, String.class, "description");
            property3 = new PropertySupport.Reflection<String>(el, String.class, "getNameSpace", null);
            set.put(property3);
            property3.setName("namespace");
            if ( el.getSuperElement() != null) {
                property1 = new PropertySupport.Reflection<String>(el.getSuperElement(), String.class, "getNameSpace", null);
                set.put(property1);
                property1.setName("super type");
            }
        } catch (NoSuchMethodException ex) {
            Exceptions.printStackTrace(ex);
        }
            set.put(property2);
            property2.setName("description");
            

            sheet.put(set);

        return sheet;
    }
    
    
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ( Element.NAMESPACE_CHANGED.equals(evt.getPropertyName())) {
            setDisplayName((String)evt.getNewValue());
            setSheet(createSheet());
        } else if ( Element.DESCRIPTION_CHANGED.equals(evt.getPropertyName())) {
            setShortDescription((String)evt.getNewValue());
            setSheet(createSheet());
        } else if ( Element.SUPERTYPE_CHANGED.equals(evt.getPropertyName())) {
            setSheet(createSheet());
        }
    }
}
