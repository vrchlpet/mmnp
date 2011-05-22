
package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * Stara se o vytvoreni potomku uzlu References
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferencesChildren extends Children.Keys<Reference> {

    private Element element;
    private IMasterController controller;

    public ReferencesChildren(Element obj, IMasterController controller) {
        this.element = obj;
        this.controller = controller;
    }


    @Override
    protected Node[] createNodes(Reference o) {
        Reference obj =  o;
        return new Node[] { new ReferenceNode(obj, this.controller) };
    }


    @Override
    public void addNotify() {
        setKeys(element.getReferences());
    }

}
