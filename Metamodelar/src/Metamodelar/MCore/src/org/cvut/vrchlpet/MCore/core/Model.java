
package org.cvut.vrchlpet.MCore.core;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * Kontejner pro meta-objekty
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Model extends NamedElement{

    public static final String ELEMENT_REMOVED = "el_rm";
    public static final String ELEMENT_ADDED = "el_add";
    public static final String RELATION_REMOVED = "rel_rm";
    public static final String RELATION_ADDED = "rel_add";


    // seznam relaci
    private ArrayList<Relation> relations;

    // seznam elementu
    private ArrayList<Element> elements;

    public static final String DEFAULT_VERSION = "1.0";

    public Model() {
        this.relations = new ArrayList<Relation>();
        this.elements = new ArrayList<Element>();
    }


    public Element createElement() {
        Element el = new Element(this);
        if (this.elements.add(el)) {
            firePropertyChange(ELEMENT_ADDED, elements, el);
            return el;
        }

        return null;
    }
    
    public void removeElement(Element el) {
        if (this.elements.remove(el)) {
            el.setModel(null);
            firePropertyChange(ELEMENT_REMOVED, el, elements);
        }
    }


    public Relation createRelation() {
        Relation rel = new Relation();
        if (this.relations.add(rel)) {
            firePropertyChange(RELATION_ADDED, relations, rel);
            return rel;
        }
        return null;
    }

    public void removeRelation(Relation rel) {
        if (this.relations.remove(rel))
            firePropertyChange(RELATION_REMOVED, rel, relations);
    }



    /**
     * @return the relations
     */
    public ArrayList<Relation> getRelations() {
        return relations;
    }

    /**
     * @return the elements
     */
    public ArrayList<Element> getElements() {
        return elements;
    }

    
}
