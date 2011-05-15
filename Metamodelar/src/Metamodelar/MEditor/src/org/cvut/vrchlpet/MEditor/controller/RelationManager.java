/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MEditor.controller.IRelationManager;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationManager implements IRelationManager{

    private IMasterController controller;

    public RelationManager(IMasterController controller) {
        this.controller = controller;
    }

    @Override
    public void setSymetric(Relation rel, boolean b) {
        rel.setSymmetric(b);
    }

    @Override
    public void setContainer(Relation rel, boolean b) {
        rel.setContainer(b);
    }

}
