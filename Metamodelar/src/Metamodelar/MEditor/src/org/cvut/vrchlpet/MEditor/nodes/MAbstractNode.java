

package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MEditor.actions.ActionFactory;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.Lookup;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class MAbstractNode extends AbstractNode {

    protected ArrayList<Action> actions;
    protected IMasterController controller;

    protected Image icon = null;

    protected abstract Image getIcon();

    public MAbstractNode(Children ch, Lookup look, IMasterController controller) {
        super(ch, look);
        this.actions = new ArrayList<Action>();
        this.controller = controller;
    }

    @Override
    public Image getIcon(int type) {
        if ( icon == null)
            icon = getIcon();
        return icon;
    }

    @Override
    public Image getOpenedIcon(int type) {
        if ( icon == null)
            icon = getIcon();
        return icon;
    }


    @Override
    public Action[] getActions (boolean popup) {
        Action [] actionsTmp = new Action[this.actions.size()];
        return this.actions.toArray(actionsTmp);
    }


    public void addAction(AbstractAction action) {
        this.actions.add(action);
    }

    public void removeAction(AbstractAction action) {
        this.actions.remove(action);
    }

    /**
     * @return the controller
     */
    public IMasterController getController() {
        return controller;
    }


}
