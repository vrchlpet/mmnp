/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers.impl;

import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MController.managers.IReferenceManager;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.ReferenceableObject;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceManager implements IReferenceManager{


    private IMasterController controller;

    public ReferenceManager(IMasterController controller) {
        this.controller = controller;
    }

    @Override
    public void setRelatoin(Reference reference, Relation relation) {
        if ( controller.getMModel().getModel().getRelations().contains(relation)) {
            reference.setRelation(relation);
            reference.getOpposite().setRelation(relation);
        }
    }

    @Override
    public void setVisible(Reference reference, boolean visible) {
        reference.setVisible(visible);
    }

    @Override
    public boolean setSource(Reference reference, boolean source) {
        reference.setSource(source);
        reference.getOpposite().setSource(!source);
        return true;
    }

    @Override
    public void setOpposite(Reference reference, Reference opposite) {
        if ( reference.getRelation() == opposite.getRelation()) {
            if ( opposite.getOpposite() != null)
                opposite.getOpposite().getOwner().
                        removeReference(opposite.getOpposite());

            opposite.setOpposite(reference);
            opposite.setReferenceType(reference.getOwner());

            if ( reference.getOpposite() != null)
                reference.getOpposite().getOwner().
                        removeReference(reference.getOpposite());

                reference.setOpposite(opposite);
                reference.setReferenceType(opposite.getOwner());
        }
    }

    @Override
    public void setReferenceType(Reference reference, ReferenceableObject type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean setBounds(Reference ref, int low, int up) {

        if ( (up <= -1 && low >= 0) || (up >= 0 && up >= low)) {
            ref.setLowerBound(low);
            ref.setUpperBound(up);
            return true;
        }
        return false;
    }

}
