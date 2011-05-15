/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.util;

import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.StructuralFeature;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFeatureAdapter {
    
    
    
    private StructuralFeature feature;
    private IMasterController controller;


    public StructuralFeatureAdapter(StructuralFeature feature, IMasterController controller) {
        this.feature = feature;
        this.controller = controller;
    }
    
    public void setEditable(boolean b) {
        controller.getStructuralFeatureManager().setEditable(feature, b);
    }
    
    public boolean isEditable() {
        return feature.isEditable();
    }
    
    public int getLowerBound() {
        return feature.getLowerBound();
    }
    
    public int getUpperBound() {
        return feature.getUpperBound();
    }
    
    public void setLowerBound(int i) {
        controller.getStructuralFeatureManager().setBounds(feature, i, feature.getUpperBound());
    }
    
    public void setUpperBound(int i) {
        controller.getStructuralFeatureManager().setBounds(feature, feature.getLowerBound(), i);
    }
}
