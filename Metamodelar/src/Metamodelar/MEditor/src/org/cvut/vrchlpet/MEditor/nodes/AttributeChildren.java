/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeChildren extends Children.Keys<Attribute>{

    private Element element;
    private IMasterController controller;

    public AttributeChildren(Element obj, IMasterController controller) {
        this.element = obj;
        this.controller = controller;
    }

    @Override
    protected Node[] createNodes(Attribute o) {
        Attribute obj = (Attribute) o;
        return new Node[] { new AttributeNode(obj, this.controller) };
    }

    @Override
    public void addNotify() {
        setKeys(element.getAttributes());
    }

}
