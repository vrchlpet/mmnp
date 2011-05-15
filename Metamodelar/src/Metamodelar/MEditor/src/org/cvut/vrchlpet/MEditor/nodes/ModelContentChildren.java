

package org.cvut.vrchlpet.MEditor.nodes;

import java.util.ArrayList;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelContentChildren extends Children.Keys<IMModel>{

    private ArrayList<IMModel> model;
    private IMasterController controller;

    public ModelContentChildren(IMModel model, IMasterController controller) {
        this.model = new ArrayList<IMModel>();
        this.model.add(model);
        this.controller = controller;
    }



    @Override
    protected Node[] createNodes(IMModel model) {
        ElementsNode result1 = null;
        RelationsNode result2 = null;


        result1 = new ElementsNode(model, this.controller);
        result2 = new RelationsNode(model, this.controller);


        return new Node[] {result1, result2};
    }

    @Override
    public void addNotify() {
        setKeys(model);
    }

}
