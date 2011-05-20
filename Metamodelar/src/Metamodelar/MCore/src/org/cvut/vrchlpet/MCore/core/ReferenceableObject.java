/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Trida reprezentujici objekt, na ktery se lze odkazovat a ktery se sam muze odkazovat na dalsi objekty
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceableObject extends NamedElement{

    public static final String REFERENCE_REMOVED  = "ref_rm";
    public static final String REFERECE_ADDED = "ref_add";

    // momentalne nevyizite - rezervace pro vrstvu modelu
    private String id;

    // seznam referenci na dalsi objekty
    private ArrayList<Reference> references;


    public ReferenceableObject(String id) {
        this.id = id;
        this.references = new ArrayList<Reference>();
    }

    // vytvori referenci na objekt definovany parametrem opposite
    public Reference createReference(Relation relation, ReferenceableObject opposite) {
        Reference ref = new Reference(relation);
        ref.setReferenceType(opposite);
        ref.setOwner(this);
        references.add(ref);
        firePropertyChange(REFERECE_ADDED, references, ref);
        return ref;

    }

    public void removeReference(Reference ref) {
        if ( references.remove(ref))
            firePropertyChange(REFERENCE_REMOVED, ref, references);
    }

    public ArrayList<Reference> getReferences() {
        return this.references;
    }

    public List<Reference> getVisibleReferences() {
        ArrayList<Reference> visibleRef = new ArrayList<Reference>();
        for ( Reference ref : references) {
            if ( ref.isVisible())
                visibleRef.add(ref);
        }

        return visibleRef;
    }


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }




}
