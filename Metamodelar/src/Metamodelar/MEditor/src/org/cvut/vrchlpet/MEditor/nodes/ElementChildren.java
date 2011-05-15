/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementChildren extends Children.Keys<Element>{

    private IMModel model;
    private IMasterController controller;

    public ElementChildren(IMModel obj, IMasterController controller) {
        this.model = obj;
        this.controller = controller;
    }


    @Override
    protected Node[] createNodes(Element o) {
        Element obj = (Element) o;
        ElementNode elnode = new ElementNode(obj, this, this.controller);
        return new Node[] { elnode };
    }

    @Override
    public void addNotify() {
        setKeys(this.model.getModel().getElements());
    }

    /**
     * @return the model
     */
    public IMModel getModel() {
        return model;
    }
}
