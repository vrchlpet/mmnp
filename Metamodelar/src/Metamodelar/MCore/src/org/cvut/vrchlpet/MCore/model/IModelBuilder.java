/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.model;


import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.ReferenceableObject;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.core.MData;

/**
 *
 * Rozhrani, ktere definuje semantiku modelovani/meta-modelovani
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IModelBuilder {
    public Model getModel();
    public void setMModel(IMModel model);
    public IMModel getMModel();
    public Element createElement(String namespace);
    public boolean removeElement(Element element, boolean erasement);
    public boolean setSuperType(Element concrete, Element superType);
    public Relation createRelation(String namespace);
    public boolean removeRelation(Relation relation);
    public Attribute createAttribute(Element el, String namespace);
    public boolean removeAttribute(Element element, Attribute at);
    public Property createProperty(Attribute at, String name, MData dataType);
    public boolean removeProperty(Attribute at, Property prop);
    public Reference createConnection(ReferenceableObject source,
            ReferenceableObject target, Relation rel);
    public boolean removeReference(Element element, Reference ref);
}
