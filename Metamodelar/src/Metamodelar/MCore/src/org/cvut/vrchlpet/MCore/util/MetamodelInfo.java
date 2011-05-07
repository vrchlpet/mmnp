/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;

import java.util.ArrayList;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.model.IMModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetamodelInfo implements IModelInfo{

    private IMModel model = null;


    @Override
    public void setMModel(IMModel model) {
        this.model = model;
    }

    @Override
    public IMModel getMModel() {
        return this.model;
    }

    @Override
    public boolean isNameSpaceInUse(String namespace) {
        Model m = this.model.getModel();

        // kontrola nad elementy
        for ( Element el : m.getElements()) {
            if ( el.getNameSpace().equals(namespace))
                return true;
        }

        // kontrola nad relacemi
        for ( Relation rel : m.getRelations()) {
            if ( rel.getNameSpace().equals(namespace))
                return true;
        }


        return false;
    }

    @Override
    public ArrayList<Element> getAvailableElements() {
        return null;
    }

    @Override
    public ArrayList<Reference> getAvailableReferences(Element el) {
        return null;
    }

    @Override
    public ArrayList<Attribute> getAvailableAttributes(Element el) {
        return null;
    }

    @Override
    public ArrayList<Property> getAvailableProperties(Attribute at) {
        return null;
    }

    @Override
    public ArrayList<Relation> getAvailableRelations() {
        return model.getModel().getRelations();
    }

    @Override
    public Element findElement(String namespace) {
        if ( namespace == null)
            return null;

        Element elx = null;
        for ( Element el: getMModel().getModel().getElements())
            if ( el.getNameSpace().equals(namespace)) {
                elx = el;
                break;
            }

        return elx;
    }

    @Override
    public Relation findRelation(String namespace) {
        if ( namespace == null)
            return null;

        Relation rel = null;
        for ( Relation r: getMModel().getModel().getRelations())
            if ( r.getNameSpace().equals(namespace)) {
                rel = r;
                break;
            }

        return rel;
    }

    @Override
    public Attribute findAttribute(Element el, String name) {
        if ( name == null)
            return null;

        for ( Attribute at : el.getAttributes()) {
            if ( at.getName().equals(name)) {
                return at;
            }
        }

        return null;
    }

    @Override
    public Property findProperty(Attribute at, String namespace) {
        if ( namespace == null)
            return null;

        for ( Property prop : at.getProperties()) {
            if ( prop.getName().equals(namespace)) {
                return prop;
            }
        }

        return null;
    }

}
