/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers;


import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IElementManager {

    public boolean setElementId(Element element, String id);
    public boolean setElementSuperType(Element concrete, String element);
    public Reference makeConnection(Element source, Element target, String relNameSpace);
    public void removeReference(Element element, Reference ref);
    public Attribute createAttribute(Element element, String atNamespace);
    public void removeAttribute(Attribute at);

}
