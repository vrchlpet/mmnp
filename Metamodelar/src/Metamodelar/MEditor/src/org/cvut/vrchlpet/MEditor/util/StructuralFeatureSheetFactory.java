/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.util;

import java.util.ArrayList;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.StructuralFeature;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFeatureSheetFactory {
    
    
    public static Sheet getSheet(StructuralFeature sf, 
            IMasterController controller, 
            ArrayList<PropertySupport.Reflection> properties) {
        
        
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        set.setName("set");
        
            
        StructuralFeatureAdapter sfa = new StructuralFeatureAdapter(sf, controller);
            
            try {
                PropertySupport.Reflection editProp = 
                        new PropertySupport.Reflection(sfa, 
                        boolean.class, "editable");
                set.put(editProp);
                editProp.setName("editable");
                
                PropertySupport.Reflection lowerProp = 
                        new PropertySupport.Reflection(sfa, 
                        int.class, "lowerBound");
                set.put(lowerProp);
                lowerProp.setName("lower bound");
                
                PropertySupport.Reflection upperProp = 
                        new PropertySupport.Reflection(sfa, 
                        int.class, "upperBound");
                set.put(upperProp);
                upperProp.setName("upper bound");
                
                
                if ( properties != null)
                    for ( PropertySupport.Reflection psr : properties) {
                        set.put(psr);
                    }
                
            } catch (NoSuchMethodException ex) {
                Exceptions.printStackTrace(ex);
            }
            
            
        sheet.put(set);
        return sheet;
    }
    
}
