
package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.openide.util.lookup.Lookups;
import org.cvut.vrchlpet.MEditor.actions.AddElementNodeAction;
import org.openide.util.ImageUtilities;


/**
 *
 * Trida predstavujici skutecny uzel Elements
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementsNode extends MAbstractNode  implements PropertyChangeListener{

    public static final String DEFAULT_ELEMENTS_NODE_NAME = "elements";

    public ElementsNode(IMModel model, IMasterController controller) {
        super( new ElementChildren(model, controller), Lookups.singleton(model), controller);
        setDisplayName(DEFAULT_ELEMENTS_NODE_NAME);
        model.getModel().addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(model.getModel(), this));
        addAction(new AddElementNodeAction(this));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ( Model.ELEMENT_ADDED.equals(evt.getPropertyName()) ||
                Model.ELEMENT_REMOVED.equals(evt.getPropertyName()))
            ((ElementChildren)getChildren()).addNotify();
    }

    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/elementsIco.png");
    }


}
