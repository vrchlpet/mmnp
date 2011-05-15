

package org.cvut.vrchlpet.MCore.model;

import java.util.ArrayList;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.model.IMModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IModelInfo {
    public void setMModel(IMModel model);
    public IMModel getMModel();
    public boolean isNameSpaceInUse(String namespace);
    public ArrayList<Element> getAvailableElements();
    public ArrayList<Reference> getAvailableReferences(Element el);
    public ArrayList<Attribute> getAvailableAttributes(Element el);
    public ArrayList<Property> getAvailableProperties(Attribute at);
    public ArrayList<Relation> getAvailableRelations();
    public Element findElement(String namespace);
    public Relation findRelation(String namespace);
    public Attribute findAttribute(Element el, String namespace);
    public Property findProperty(Attribute at, String namespace);
}
