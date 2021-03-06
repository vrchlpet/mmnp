

package org.cvut.vrchlpet.MEditor.controller;


import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * Manager modelu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelManager implements IModelManager {

    private IMasterController controller;

    public ModelManager(IMasterController controller) {
        this.controller = controller;
    }


    @Override
    public boolean addElement(String namespace) {
        return controller.getMModel().getBuilder().createElement(namespace) != null;
    }

    @Override
    public boolean removeElement(Element element, boolean hardErasement) {
        return controller.getMModel().getBuilder().removeElement(element, hardErasement);
    }

    @Override
    public boolean addRelation(String namespace) {
        return controller.getMModel().getBuilder().createRelation(namespace) != null;
    }

    @Override
    public boolean removeRelation(Relation relation) {
        return controller.getMModel().getBuilder().removeRelation(relation);
    }
    
}
