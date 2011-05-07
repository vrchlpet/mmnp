/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MController.managers;

import org.cvut.vrchlpet.MCore.core.StructuralFeature;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IStructuralFeatureManager {
    
    public void setEditable(StructuralFeature f, boolean editable);
    public boolean setBounds(StructuralFeature f, int low, int up);
}
