/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.core;

/**
 *
 * Trida reprezentuje vlastnost elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Property extends StructuralFeature{

    // datovy typ
    private MData mData;

    // data
    private Object value;


    public Property() {
        this.mData = null;
        this.value = null;
    }

    public Property(MData mData) {
        this();
        this.mData = mData;
    }


    /**
     * @return the mData
     */
    public MData getmData() {
        return mData;
    }

    /**
     * @param mData the mData to set
     */
    public void setMData(MData mData) {
        MData old = this.mData;
        this.mData = mData;
        firePropertyChange("mData", old, this.mData);
    }

    /**
     * @return the defaultValue
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setValue(Object defaultValue) {
        if ( !this.mData.getDataClass().isInstance(defaultValue))
            throw new IllegalArgumentException(defaultValue + ": cannot be "
                    + "assigned to this property. Incompatible types!");
        Object old = this.value;
        this.value = defaultValue;
        firePropertyChange("defaultValue", old, this.value);
    }


}
