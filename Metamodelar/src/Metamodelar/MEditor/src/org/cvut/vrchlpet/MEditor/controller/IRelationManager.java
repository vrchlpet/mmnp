

package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.Relation;


/**
 *
 *
 * Rozhrani manageru relace
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IRelationManager {

    public void setSymetric(Relation rel, boolean b);
    public void setContainer(Relation rel, boolean b);
    public boolean createRelation(String namespace);
    public boolean removeRelation(String namespace);

}
