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
import org.cvut.vrchlpet.MCore.core.ReferenceableObject;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.datacore.MData;
import org.cvut.vrchlpet.MCore.model.IMModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetamodelBuilder implements IModelBuilder{

    private Model model;
    private IMModel mmodel;

    public MetamodelBuilder() {
        this.model = getModel();
    }

    public MetamodelBuilder(Model model) {
        this.model = model;
    }


    @Override
    public Model getModel() {
        if ( model == null)
            model = new Model();
        return this.model;
    }

    


    @Override
    public Element createElement(String namespace) {
        if ( mmodel.getModelInfo().isNameSpaceInUse(namespace))
            return null;

        Element el = null;

        if ( (el = model.createElement()) != null ) {
            el.setNameSpace(namespace);
        }

        return el;
    }

    /**
     * Metoda zajisti relaci(nema nic spolecneho s 'Relation' tridou) dedeni.
     * Nelze vytvorit cyklicke dedeni
     *
     * @param concrete element, ktery dedi
     * @param superType element, od ktereho se dedi
     * @return true, pokud je relace navazana, false, pokud neni mozne relaci vytvorit
     */
    @Override
    public boolean setSuperType(Element concrete, Element superType) {


        if ( superType == null) {
            concrete.setSuperElement(null);
            return true;
        }

        if ( !model.getElements().contains(concrete) ||
                !model.getElements().contains(superType))
                return false;


        // kontrola zacykleni potencionalni nove dedicnosti
        for ( Element el : superType.getAllSuperElements()) {
            if ( el == concrete)
                return false;
        }

        concrete.setSuperElement(superType);

        return true;
    }

    /**
     * Vytvori novou relaci a prida ji do seznamu existujicich relaci.
     *
     * @param namespace - relace bude vytvorena s danym namespace
     * @return objekt nove relace. Null jestlize je zadany namespace jiz pouzivan
     */
    @Override
    public Relation createRelation(String namespace) {
        if ( mmodel.getModelInfo().isNameSpaceInUse(namespace))
            return null;

        Relation rel = null;

        if ((rel = model.createRelation()) != null) {
            rel.setNameSpace(namespace);
        }


        return rel;
    }

    @Override
    public Attribute createAttribute(Element el, String name) {
        for ( Attribute a : el.getAttributes()) {
            if ( a.getName().equals(name))
                return null;
        }

        Attribute at = el.createAttribute(name);
        return at;
    }

    @Override
    public Property createProperty(Attribute at, String name, MData data) {

        for (Property prop : at.getProperties()) {
            if ( prop.getName().equals(name))
                return null;
        }

        Property p = null;
        p = at.createProperty(data, name);

        return p;
    }

    /**
     * Vytvori relaci mezi dvema objekty.
     *
     * @param source zdrojovy objekt
     * @param target cilovy objekt
     * @param rel relace mezi objekty
     * @return referenci, odkazujici na zdrojovy element
     */
    @Override
    public Reference createConnection(ReferenceableObject source, ReferenceableObject target, Relation rel) {
        if ( ! model.getRelations().contains(rel))
            return null;

        Reference refSource = null;
        Reference refTarget = null;

        
        refSource = source.createReference(rel,target); // reference zdroje na cil
        refTarget = target.createReference(rel,source); // reference cile na zdroj

        refSource.setOpposite(refTarget);
        refTarget.setOpposite(refSource);

        refSource.setSource(true);
        refTarget.setSource(false);
        
        return refSource;
    }

    @Override
    public void setMModel(IMModel model) {
        this.mmodel = model;
    }

    @Override
    public IMModel getMModel() {
        return this.mmodel;
    }

    @Override
    public boolean removeElement(Element element, boolean erasement) {

        if ( !model.getElements().contains(element))
            return false;

        // nechceme, aby se po kazde provedene akci nad elementem notifykovalo
        // staci, kdyz se bude notifykovat az smazani daneho elementu na urovni modelu
        element.setEnableNotification(false);

        // nejprve odebereme vsechny reference objektum, ktere se na odebirany
        // element odkazuji, pokud je hardErasement = ture, pak se odstrani
        // i vsechny elementy, pro ktere je mazany element kontainerem
        ArrayList<Element> elementsToBeDeleted = new ArrayList<Element>();
        for (Reference ref : element.getReferences()) {
            if ( erasement)
                if ( ref.getRelation().isContainer() && ref.isSource()) {
                    if ( ref.getOpposite().getOwner() instanceof Element &&
                            ref.getOpposite().getOwner() != element)
                        elementsToBeDeleted.add((Element)ref.getOpposite().getOwner());
                }

            // osetreni concurrent exception
            if ( ref.getOpposite().getOwner() != element) {
                ReferenceableObject ro = ref.getOpposite().getOwner();
                ro.removeReference(ref.getOpposite());
            }
        }

        // odebereme vsechny reference odebiraneho elementu
        element.getReferences().clear();

        // zrusime vsechny attributy
        element.getAttributes().clear();

        // odstranime vsechny elementy dedici od daneho elementu (zavisi na hodnote hardErasement)
        for ( Element el : model.getElements()) {
            if ( el.getSuperElement() == element)
                if ( erasement) {
                    elementsToBeDeleted.add(el);
                } else {
                    el.setSuperElement(null);
                }
        }

        element.setEnableNotification(true);
        // odebereme puvodni element
        model.removeElement(element);


        // rekurzivne odebereme vsechny oznacene elementy (urcene k smazani, protoze
        // vystupovali jako potomci nebo jako soucasti mazaneho elementu)
        // zavisi na hodnote hardErasement (true - rekurzivni mazani)
        if ( erasement)
            for (Element el : elementsToBeDeleted) {
                if ( el != element)
                    removeElement(el, true);
            }
        return true;
    }

    @Override
    public boolean removeRelation(Relation relation) {
        if ( ! model.getRelations().contains(relation))
            return false;

        ArrayList<Reference> refToBeRemoved;
        for ( Element el : model.getElements()) {
            refToBeRemoved = new ArrayList<Reference>();
            for ( Reference ref : el.getReferences()) {
                if ( ref.getRelation() == relation) {
                    refToBeRemoved.add(ref);
                }
            }

            for ( Reference ref : refToBeRemoved)
                removeReference(el, ref);
        }

        model.removeRelation(relation);

        return true;
    }

    @Override
    public boolean removeAttribute(Element element, Attribute at) {
        return element.removeAttribute(at);
    }

    @Override
    public boolean removeProperty(Attribute at, Property prop) {
        return at.removeProperty(prop);
    }

    @Override
    public boolean removeReference(Element element, Reference ref) {
        if ( ! element.getReferences().contains(ref))
            return false;

        Reference opposite = ref.getOpposite();
        opposite.setEnableNotification(false);
        ref.setEnableNotification(false);

        opposite.getOwner().removeReference(opposite);
        opposite.setReferenceType(null);
        opposite.setOwner(null);
        opposite.setRelation(null);
        opposite.setOpposite(null);


        ref.getOwner().removeReference(ref);
        ref.setOpposite(null);
        ref.setOwner(null);
        ref.setRelation(null);
        ref.setReferenceType(null);

        return true;
    }



}
