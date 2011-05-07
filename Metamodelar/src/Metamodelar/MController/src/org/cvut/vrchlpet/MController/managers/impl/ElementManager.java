/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers.impl;

import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MController.managers.IElementManager;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementManager implements IElementManager{



    private IMasterController controller;

    public ElementManager(IMasterController controller) {
        this.controller = controller;
    }




    @Override
    public boolean setElementId(Element element, String id) {

        for ( Element el : controller.getMModel().getModel().getElements()) {
            if ( el.getId().equals(element.getId()))
                return false;
        }

        element.setId(id);

        return false;
    }


    @Override
    public boolean setElementSuperType(Element concrete, String superTypeNameSpace) {
        Element el = null;
        el = controller.getMModel().getModelInfo().findElement(superTypeNameSpace);
        return controller.getMModel().getBuilder().setSuperType(concrete, el);
    }

    @Override
    public Reference makeConnection(Element source, Element target, String relNameSpace) {
        Relation rel = controller.getMModel().getModelInfo().findRelation(relNameSpace);
        return controller.getMModel().getBuilder().createConnection(source, target, rel);
    }

    @Override
    public void removeReference(Element element, Reference ref) {
        controller.getMModel().getBuilder().removeReference(element, ref);
    }

    @Override
    public Attribute createAttribute(Element element, String atNamespace) {
        return controller.getMModel().getBuilder().createAttribute(element, atNamespace);
    }

    @Override
    public void removeAttribute(Attribute at) {
        controller.getMModel().getBuilder().removeAttribute(at.getElement(), at);
    }

}
