
package org.cvut.vrchlpet.MCore.core;

/**
 *
 * Trida reprezentuje vlastnost elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Property extends StructuralFeature{

    public static final MData DEFAULT_TYEP = MData.STRING;
    
    
    // datovy typ
    private MData mData;

    // data
    private Object value;


    public Property() {
        this.mData = DEFAULT_TYEP;
        this.value = mData.getDefault();
    }

    public Property(MData mData) {
        this.mData = mData;
        this.value = mData.getDefault();
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
        
        
        if ( !mData.getClass().isInstance(value))
            setValue(mData.getDefault());
        
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
