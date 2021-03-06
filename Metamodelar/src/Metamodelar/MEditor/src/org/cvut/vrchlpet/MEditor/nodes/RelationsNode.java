
package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MEditor.actions.AddRelationNodeAction;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * Trida predstavujici skutecny uzel Relations
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationsNode extends MAbstractNode implements PropertyChangeListener{

    public static final String DEFAULT_RELATIONS_NODE_NAME = "relations";


    public RelationsNode(IMModel model, IMasterController controller) {
        super(new RelationChildren(model, controller), Lookups.singleton(model), controller);
        setDisplayName(DEFAULT_RELATIONS_NODE_NAME);
        addAction(new AddRelationNodeAction(this));
        model.getModel().addPropertyChangeListener(this);
        this.addNodeListener(new NodeListenerKiller(model.getModel(), this));
    }


    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/relationsIco.png");
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ((RelationChildren)getChildren()).addNotify();
    }
}
