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
import org.cvut.vrchlpet.MEditor.actions.CreateReferenceNodeAction;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferencesNode extends MAbstractNode implements PropertyChangeListener{

    public static final String REFERENCES_NODE_NAME = "references";

    public ReferencesNode(Element el, IMasterController controller) {
        super( new ReferencesChildren(el, controller), Lookups.singleton(el), controller);
        setDisplayName(REFERENCES_NODE_NAME);
        el.getModel().addPropertyChangeListener(this);
        el.addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(el, this));
        this.addNodeListener(new NodeListenerKiller(el.getModel(), this));
        this.addAction( new CreateReferenceNodeAction(el.getNameSpace(), controller));
    }

    
    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/referencesIco.png");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ( Model.ELEMENT_REMOVED.equals(evt.getPropertyName()) ||
                Model.RELATION_REMOVED.equals(evt.getPropertyName()) ||
                Element.REFERECE_ADDED.equals(evt.getPropertyName()) ||
                Element.REFERENCE_REMOVED.equals(evt.getPropertyName())) {
            
            ((ReferencesChildren)getChildren()).addNotify();
            if ( getLookup().lookup(Element.class) == evt.getOldValue()) {
                try {
                    destroy();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }
}
