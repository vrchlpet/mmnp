/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.actions.ActionFactory;
import org.cvut.vrchlpet.MEditor.util.ReferenceAdapter;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceNode extends MAbstractNode implements PropertyChangeListener{

    public ReferenceNode(Reference obj, IMasterController controller) {
        super(Children.LEAF, Lookups.singleton(obj), controller);
        obj.addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(obj,this));
        obj.getRelation().addPropertyChangeListener(this);
        this.addNodeListener( new NodeListenerKiller(obj.getRelation(), this));
        ActionFactory.addActions(obj, this);
        setDisplayName();
    }

    private void setDisplayName() {
        Reference ref = getLookup().lookup(Reference.class);
        setDisplayName("(" + ref.getId() + ")" + ref.getReferenceType().getNameSpace() + ((ref.getOpposite()==null)?"":": " + ref.getOpposite().getId()));
    }
    
    
    @Override
    protected Image getIcon() {

        Reference ref = getLookup().lookup(Reference.class);

        if ( ref.getRelation().isContainer() && ref.isSource()) {
            return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/containerIco.png");
        } else if ( ref.getRelation().isContainer() && !ref.isSource()) {
            return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/containmentIco.png");
        } else {
            return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/regularRefIco.png");
        }
    }


    @Override
    protected Sheet createSheet() {

        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        set.setName("set");

        Reference ref = getLookup().lookup(Reference.class);
        ReferenceAdapter ra = new ReferenceAdapter(ref, controller);



        try {
            Property property0 = new PropertySupport.Reflection(ref.getRelation(), String.class, "getNameSpace", null);

            set.put(property0);
            property0.setName("relation");

            Property property3 = new PropertySupport.Reflection(ra,
                boolean.class, "source");
            set.put(property3);
            property3.setName("source");

            Property property4 = new PropertySupport.Reflection(ra,
                int.class, "lowerBound");
            set.put(property4);
            property4.setName("lower bound");

            Property property5 = new PropertySupport.Reflection(ra,
                int.class, "upperBound");
            set.put(property5);
            property5.setName("upper bound");

            Property property7 = new PropertySupport.Reflection(ra,
                boolean.class, "visible");
            set.put(property7);
            property7.setName("visible");

        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }

        sheet.put(set);
        return sheet;

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setSheet(createSheet());
        
        if ( Relation.CONTAINER_CH.equals(evt.getPropertyName()) ||
                Reference.SOURCE_CH.equals(evt.getPropertyName()) ||
                Reference.RELATION_CH.equals(evt.getPropertyName()) ) {
            this.icon = getIcon();
            fireIconChange();
            fireOpenedIconChange();
        } else if ( Reference.OPPOSITE_CH.equals(evt.getPropertyName())) {
            setDisplayName();
        }
    }
}
