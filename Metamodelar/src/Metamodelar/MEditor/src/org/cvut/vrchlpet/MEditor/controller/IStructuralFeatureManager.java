
package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.StructuralFeature;

/**
 *
 * Rozhrani manageru structuralFeatures
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IStructuralFeatureManager {
    
    public void setEditable(StructuralFeature f, boolean editable);
    public boolean setBounds(StructuralFeature f, int low, int up);
}
