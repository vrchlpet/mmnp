
package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * Rozhrani manageru modelu
 *
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
