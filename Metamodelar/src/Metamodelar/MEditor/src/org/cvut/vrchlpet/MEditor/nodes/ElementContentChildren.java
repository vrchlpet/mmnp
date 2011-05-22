

package org.cvut.vrchlpet.MEditor.nodes;

import java.util.ArrayList;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * Stara se o vytvoreni potomku uzlu Element
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementContentChildren extends Children.Keys<Element> {
    private ArrayList<Element> element;
    private IMasterController controller;

    public ElementContentChildren(Element element, IMasterController controller) {
        this.element = new ArrayList<Element>();
        this.element.add(element);
        this.controller = controller;
    }

    @Override
    protected Node[] createNodes(Element obj) {
        
        return new Node[] { new AttributesNode(obj, this.controller),
                            new ReferencesNode(obj, this.controller)};
    }

    @Override
    public void addNotify() {
        setKeys(element);
    }

}
