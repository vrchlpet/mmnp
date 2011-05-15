/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Property;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyChildren extends Children.Keys<Property>{

    private Attribute attribute;
    private IMasterController controller;

    public PropertyChildren(Attribute obj, IMasterController controller) {
        this.attribute = obj;
        this.controller = controller;
    }

    @Override
    protected Node[] createNodes(Property o) {
        Property obj = (Property) o;
        return new Node[] { new PropertyNode(obj, this.controller) };
    }

    @Override
    public void addNotify() {
        setKeys(attribute.getProperties());
    }

}
