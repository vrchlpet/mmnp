
package org.cvut.vrchlpet.MEditor.controller;


import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * Manager relace
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

    @Override
    public boolean createRelation(String namespace) {
        return (controller.getMModel().getBuilder().createRelation(namespace) != null);
    }

    @Override
    public boolean removeRelation(String namespace) {
        Relation rel = controller.getMModel().getModelInfo().findRelation(namespace);
        
        if ( rel == null)
            return false;
        
        return controller.getMModel().getBuilder().removeRelation(rel);
    }

}
