/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MEditor.actions.AddAttributeNodeAction;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributesNode extends MAbstractNode implements PropertyChangeListener{

    public static final String ATTRIBUTES_NODE_NAME = "attributes";

    public AttributesNode(Element el, IMasterController controller) {
        super( new AttributeChildren(el, controller), Lookups.singleton(el), controller);
        setDisplayName(ATTRIBUTES_NODE_NAME);
        this.addAction(new AddAttributeNodeAction(controller, el));
        el.addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(el, this));
        el.getModel().addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(el.getModel(), this));
    }

    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/attributesIco.jpg");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ( Model.ELEMENT_REMOVED.equals(evt.getPropertyName())) {
            if ( getLookup().lookup(Element.class) == evt.getOldValue()) {
                try {
                    destroy();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }


        if ( Element.ATTRIBUTE_ADDED.equals(evt.getPropertyName()) ||
                Element.ATTRIBUTE_REMOVED.equals(evt.getPropertyName())) {

            ((AttributeChildren)getChildren()).addNotify();
        }
    }
    
    
}
