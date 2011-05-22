

package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * Manager reference
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
    public boolean setRelatoin(Reference reference, Relation relation) {
        if ( controller.getMModel().getModel().getRelations().contains(relation)) {
            reference.setRelation(relation);
            reference.getOpposite().setRelation(relation);
            return true;
        }
        
        return false;
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
    public boolean setBounds(Reference ref, int low, int up) {

        if ( (up <= -1 && low >= 0) || (up >= 0 && up >= low && low >= 0)) {
            ref.setLowerBound(low);
            ref.setUpperBound(up);
            return true;
        }
        return false;
    }

}
