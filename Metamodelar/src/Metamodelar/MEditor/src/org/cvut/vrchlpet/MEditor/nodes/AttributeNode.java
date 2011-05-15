/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MEditor.actions.ActionFactory;
import org.cvut.vrchlpet.MEditor.util.StructuralFeatureSheetFactory;
import org.openide.nodes.Sheet;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeNode extends MAbstractNode implements PropertyChangeListener{

    public AttributeNode(Attribute attribute, IMasterController controller) {
        super(new PropertyChildren(attribute, controller), Lookups.singleton(attribute), controller);
        updateName();
        attribute.addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(attribute,this));
        ActionFactory.addActions(attribute, this);
    }

    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/attributeIco.jpg");
    }

    public void updateName() {
        Attribute attribute = getLookup().lookup(Attribute.class);
        setDisplayName(attribute.getName());
    }


    @Override
    protected Sheet createSheet() {
        Attribute at = getLookup().lookup(Attribute.class);
        return StructuralFeatureSheetFactory.getSheet(at, controller, null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setSheet(createSheet());
        
        if ( Attribute.PROPERTY_ADDED.equals(evt.getPropertyName()) ||
                Attribute.PROPERTY_REMOVED.equals(evt.getPropertyName())) {
            
            ((PropertyChildren)getChildren()).addNotify();
        } else if ( Attribute.NAME_CHANGED.equals(evt.getPropertyName())) {
            updateName();
        }
    }



}
