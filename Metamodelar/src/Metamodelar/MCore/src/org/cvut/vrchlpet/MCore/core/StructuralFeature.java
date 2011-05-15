

package org.cvut.vrchlpet.MCore.core;

import org.cvut.vrchlpet.MCore.util.Notifyer;


/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 * 
 */
public class StructuralFeature extends Notifyer {

    public static final boolean DEFAULT_EDITABLE = true;
    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    public static final String DEFAULT_STRUCTURAL_FEATURE_NAME = "defualt structural feature name";

    public static final String EDITABLE_CHANGED = "editable_ch";
    public static final String LOWER_BOUND_CHANGED = "lowB_ch";
    public static final String UPPER_BOUND_CHANGED = "uppB_ch";
    public static final String NAME_CHANGED = "name_ch";
    

    private boolean editable;
    private int lowerBound;
    private int upperBound;
    private String name;
    

    public StructuralFeature() {
        this.editable = DEFAULT_EDITABLE;
        this.lowerBound = DEFAULT_LOWER_BOUND;
        this.upperBound = DEFAULT_UPPER_BOUND;
        this.name = DEFAULT_STRUCTURAL_FEATURE_NAME;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        boolean old = this.editable;
        this.editable = editable;
        firePropertyChange(EDITABLE_CHANGED, old, this.editable);
    }

    /**
     * @return the required
     */
    public int getLowerBound() {
        return this.lowerBound;
    }

    /**
     * @param required the required to set
     */
    public void setLowerBound(int lowerBound) {
        int old = this.lowerBound;
        this.lowerBound = lowerBound;
        firePropertyChange(LOWER_BOUND_CHANGED, old, this.lowerBound);
    }

    /**
     * @return the unique
     */
    public int getUpperBound() {
        return this.upperBound;
    }

    /**
     * @param unique the unique to set
     */
    public void setUpperBound(int upperBound) {
        int old = this.upperBound;
        this.upperBound = upperBound;
        firePropertyChange(UPPER_BOUND_CHANGED, old, this.upperBound);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        String old = this.name;
        this.name = name;
        firePropertyChange(NAME_CHANGED, old, this.name);
    }

    


}
