
package org.cvut.vrchlpet.MEditor.controller;


import org.cvut.vrchlpet.MCore.core.StructuralFeature;

/**
 *
 * Manager structuralFeature
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFeatureManager implements IStructuralFeatureManager{

    
    
    
    
    @Override
    public void setEditable(StructuralFeature f, boolean editable) {
        f.setEditable(editable);
    }

    @Override
    public boolean setBounds(StructuralFeature f, int low, int up) {

        if ( (up <= -1 && low >= 0) || (up >= 0 && up >= low && low >= 0)) {
            f.setLowerBound(low);
            f.setUpperBound(up);
            return true;
        }
        return false;
    }

    
    
}
