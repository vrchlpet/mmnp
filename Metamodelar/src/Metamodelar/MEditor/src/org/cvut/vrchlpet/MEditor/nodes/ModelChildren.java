/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.util.ArrayList;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelChildren extends Children.Keys<IMModel> {

    private ArrayList<IMModel> model;
    private IMasterController controller;

    public ModelChildren(IMModel obj, IMasterController controller) {
        this.model = new ArrayList<IMModel>();
        this.model.add(obj);
        this.controller = controller;
    }

    @Override
    protected Node[] createNodes(IMModel t) {
        ModelNode node = new ModelNode(this.model.get(0),this.controller);
        return new Node[]{node};
    }

    @Override
    public void addNotify() {
        setKeys(model);
    }

}
