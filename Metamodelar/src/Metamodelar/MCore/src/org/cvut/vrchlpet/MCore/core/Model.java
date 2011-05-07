
package org.cvut.vrchlpet.MCore.core;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Model extends MetaObject{

    public static final String ELEMENT_REMOVED = "el_rm";
    public static final String ELEMENT_ADDED = "el_add";
    public static final String RELATION_REMOVED = "rel_rm";
    public static final String RELATION_ADDED = "rel_add";



    protected Date dateOfCreation;
    protected String version;
    private ArrayList<Relation> relations;
    private ArrayList<Element> elements;

    public static final String DEFAULT_VERSION = "1.0";

    public Model() {
        this.dateOfCreation = new Date();
        this.relations = new ArrayList<Relation>();
        this.elements = new ArrayList<Element>();
        version = DEFAULT_VERSION;
    }



    /**
     * @return the dateOfCreation
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * @param dateOfCreation the dateOfCreation to set
     */
    public void setDateOfCreation(Date created) {
        this.dateOfCreation = created;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
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
