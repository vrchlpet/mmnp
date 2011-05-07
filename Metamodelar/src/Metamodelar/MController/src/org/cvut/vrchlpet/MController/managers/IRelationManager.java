/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers;

import org.cvut.vrchlpet.MCore.core.Relation;


/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IRelationManager {

    public void setSymetric(Relation rel, boolean b);
    public void setContainer(Relation rel, boolean b);

}
