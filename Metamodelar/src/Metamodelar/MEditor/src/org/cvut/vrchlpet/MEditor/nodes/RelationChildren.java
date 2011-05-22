
package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * Stara se o vytvoreni potomku uzlu Relations
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationChildren extends Children.Keys<Relation>{

    private IMModel model;
    private IMasterController controller;

    public RelationChildren(IMModel model, IMasterController controller) {
        this.model = model;
        this.controller = controller;
    }


    @Override
    protected Node[] createNodes(Relation rel) {
        return new Node [] { new RelationNode(rel, this.controller)};
    }

    @Override
    public void addNotify() {
        setKeys(model.getModel().getRelations());
    }


}
