/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers;

import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IModelManager {
    public boolean addElement(String namespace);
    public boolean removeElement(Element el, boolean rem);
    public boolean addRelation(String namespace);
    public boolean removeRelation(Relation rel);
}
