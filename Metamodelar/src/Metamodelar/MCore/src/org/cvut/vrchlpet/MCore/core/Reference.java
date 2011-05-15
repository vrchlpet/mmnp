

package org.cvut.vrchlpet.MCore.core;

import org.cvut.vrchlpet.MCore.util.Notifyer;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Reference extends Notifyer{


    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    
    public static final boolean DEFAULT_VISIBLE = true;
    public static final boolean DEFAULT_SOURCE = true;

    public static final String LOWER_BOUND_CH = "lb_ch";
    public static final String UPPER_BOUND_CH = "ub_ch";
    
    public static final String VISIBLE_CH = "vis_ch";
    public static final String SOURCE_CH = "source_ch";
    public static final String OWNER_CH = "owner_ch";
    public static final String REFERENCE_TYPE_CH = "ref_type_ch";
    public static final String RELATION_CH = "rel_ch";
    public static final String OPPOSITE_CH = "opp_ch";


    private int lowerBound;
    private int upperBound;
    private boolean visible;
    private boolean source;
    private ReferenceableObject owner;
    private ReferenceableObject referenceType;
    private Reference opposite;
    private Relation relation;
    
    private long id;
    private static long counter = 0;

    public Reference() {}
    
    public Reference(Relation relation) {
        this.owner = null;
        this.referenceType = null;
        this.opposite = null;
        this.relation = relation;
        this.source = DEFAULT_SOURCE;
        this.lowerBound = DEFAULT_LOWER_BOUND;
        this.upperBound = DEFAULT_UPPER_BOUND;
        
        this.visible = DEFAULT_VISIBLE;
        this.id = counter++;
    }

    public long getId() {
        return this.id;
    }
    
    public Reference getOpposite() {
        return this.opposite;
    }

    public void setOpposite(Reference reference) {
            Reference old = this.opposite;
            this.opposite = reference;
            firePropertyChange(OPPOSITE_CH, old, this.opposite);
    }

    public ReferenceableObject getReferenceType() {
        return this.referenceType;
    }

    public void setReferenceType(ReferenceableObject refObj) {
        ReferenceableObject old = this.referenceType;
        this.referenceType = refObj;
        firePropertyChange(REFERENCE_TYPE_CH, old, this.referenceType);
    }

    public ReferenceableObject getOwner() {
        return this.owner;
    }

    /**
     * @return the lowerBound
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * @param lowerBound the lowerBound to set
     */
    public void setLowerBound(int lowerBound) {
        int old = this.lowerBound;
        this.lowerBound = lowerBound;
        firePropertyChange(LOWER_BOUND_CH, old, this.lowerBound);
    }

    /**
     * @return the upperBound
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * @param upperBound the upperBound to set
     */
    public void setUpperBound(int upperBound) {
        int old = this.upperBound;
        this.upperBound = upperBound;
        firePropertyChange(UPPER_BOUND_CH, old, this.upperBound);
    }

    

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        boolean old = this.visible;
        this.visible = visible;
        firePropertyChange(VISIBLE_CH, old, this.visible);
    }
    

    /**
     * @param owner the owner to set
     */
    public void setOwner(ReferenceableObject owner) {
        ReferenceableObject old = this.owner;
        this.owner = owner;
        firePropertyChange(OWNER_CH, old, this.owner);
    }

    /**
     * @return the relation
     */
    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation rel) {
        Relation old = this.relation;
        this.relation = rel;
        firePropertyChange(RELATION_CH, old, this.relation);
    }

    /**
     * @return the source
     */
    public boolean isSource() {
        return source;
    }

    
    public void setSource(boolean source) {
        boolean old = this.source;
        this.source = source;
        firePropertyChange(SOURCE_CH, old, this.source);
        
    }

    @Override
    public String toString() {
        String s = "";
        
        s += "owner: " + owner.getNameSpace() + ", refType: " + referenceType.getNameSpace() + 
                ", source: " + source + ", relation: " + relation.getNameSpace();
        
        return s;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

}
