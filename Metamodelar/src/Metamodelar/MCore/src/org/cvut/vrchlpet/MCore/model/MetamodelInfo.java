

package org.cvut.vrchlpet.MCore.model;

import java.util.ArrayList;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * Implementace ModelInfo rozhrani pro meta-modelovani
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

    
    /**
     * 
     * Zjisti, zda zadany namespace je jiz vyuzivan nejakym elementem nebo relaci
     * 
     * @param namespace
     * @return true pokud namespace neni vyuzivatn jinym elementem nebo relaci
     */
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

    /**
     * Nalezne element podle namespace
     * 
     * @param namespace
     * @return element nebo null
     */
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

    
    /**
     * Nalezne relaci podle namespace
     * 
     * @param namespace
     * @return relaci nebo null
     */
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

    /**
     * 
     * najde attribut podle jmena u konkretniho elementu
     * 
     * 
     * @param el
     * @param name
     * @return attribute nebo null
     */
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

    /**
     * 
     * najde property podle jmena u konkretniho atributu
     * 
     * @param at
     * @param namespace
     * @return property nebo null
     */
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
    
    // nasleduje skupina metod s jednoduchou implementaci, pro ucely metamodelovani nejsou 
    // tyto metody vicemene dulezite
    
    @Override
    public ArrayList<Element> getAvailableElements() {
        return model.getModel().getElements();
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

    
    
    
    

}
