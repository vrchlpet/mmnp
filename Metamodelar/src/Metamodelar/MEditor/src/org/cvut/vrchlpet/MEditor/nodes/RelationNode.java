
package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.actions.ActionFactory;
import org.cvut.vrchlpet.MEditor.util.ProxyRelation;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * Trida predstavujici skutecny uzel Relation
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationNode extends MAbstractNode implements PropertyChangeListener{




    public RelationNode(Relation rel, IMasterController controller) {
        super(Children.LEAF, Lookups.singleton(rel), controller);
        setDisplayName(rel.getNameSpace());
        rel.addPropertyChangeListener(this);
        setShortDescription(rel.getDescription());
        this.addNodeListener(new NodeListenerKiller(rel, this));
        ActionFactory.addActions(rel, this);
    }



    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/relationIco.png");
    }

    @Override
    public Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        set.setName("set");

        ProxyRelation relA = new ProxyRelation(getLookup().lookup(Relation.class),controller);

        PropertySupport.Reflection<Boolean> property1 = null;
        PropertySupport.Reflection<String> property2 = null;
        PropertySupport.Reflection<String> property3 = null;
        try {
            property1 = new PropertySupport.Reflection<Boolean>(relA, boolean.class, "symmetric");
            property2 = new PropertySupport.Reflection<String>(relA, String.class, "description");
            property3 = new PropertySupport.Reflection<String>(relA, String.class, "nameSpace");
            
            PropertySupport.Reflection<Boolean> property4 = new PropertySupport.Reflection<Boolean>(relA,
                boolean.class, "container");
            set.put(property4);
            property4.setName("container");
        } catch (NoSuchMethodException ex) {
            Exceptions.printStackTrace(ex);
        }
            set.put(property3);
            property3.setName("nameSpace");
            set.put(property2);
            property2.setName("description");
            set.put(property1);
            property1.setName("symmetry");
            
            
            

            sheet.put(set);

        return sheet;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ( Relation.NAMESPACE_CHANGED.equals(evt.getPropertyName())) {
            setDisplayName(getLookup().lookup(Relation.class).getNameSpace());
                setSheet(createSheet());
        } else if ( Relation.SYMMETRIC_CHANGED.equals(evt.getPropertyName()) || 
                  Relation.CONTAINER_CH.equals(evt.getPropertyName())) {
            setSheet(createSheet());
        } else if ( Relation.DESCRIPTION_CHANGED.equals(evt.getPropertyName())) {
            setShortDescription((String)evt.getNewValue());
            setSheet(createSheet());
        }
    }
}
