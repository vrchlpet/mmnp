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
import org.cvut.vrchlpet.MCore.core.NamedElement;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MEditor.actions.ActionFactory;
import org.cvut.vrchlpet.MEditor.util.ModelAdapter;
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
public class ModelNode extends MAbstractNode implements PropertyChangeListener{

    public ModelNode(IMModel model, IMasterController controller) {
        //super(new ParameterChildren(attribute), Lookups.singleton(attribute));
        super(new ModelContentChildren(model, controller), Lookups.singleton(model), controller);
        setDisplayName(model.getModel().getNameSpace());
        ActionFactory.addActions(model.getModel(), this);
        model.getModel().addPropertyChangeListener(this);
        setShortDescription(model.getModel().getDescription());
        this.addNodeListener( new NodeListenerKiller(model.getModel(), this));
        
    }

    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/modelIco.png");
    }
    
    
    
    @Override
    public Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        set.setName("set");

        Model model = getLookup().lookup(IMModel.class).getModel();
        ModelAdapter ma = new ModelAdapter(controller, model);
        
        PropertySupport.Reflection<String> property3 = null;
        PropertySupport.Reflection<String> property2 = null;
        try {
            property2 = new PropertySupport.Reflection<String>(ma, String.class, "description");
            property3 = new PropertySupport.Reflection<String>(ma, String.class, "nameSpace");
            set.put(property3);
            property3.setName("namespace");
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
        if ( NamedElement.NAMESPACE_CHANGED.equals(evt.getPropertyName())) {
            setDisplayName((String)evt.getNewValue());
            setSheet(createSheet());
        } else if ( NamedElement.DESCRIPTION_CHANGED.equals(evt.getPropertyName())) {
            setShortDescription((String)evt.getNewValue());
            setSheet(createSheet());
        }
    }
}
