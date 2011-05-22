
package org.cvut.vrchlpet.MEditor.util;

import java.util.ArrayList;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.StructuralFeature;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;

/**
 *
 * Tovarna na property polozky v propery dokovacim okne pro StructuralFeature objekty (atributy a property)
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFeatureSheetFactory {
    
    
    public static Sheet getSheet(StructuralFeature sf, 
            IMasterController controller, 
            ArrayList<PropertySupport.Reflection<? extends Object>> properties,
            String setName) {
        
        
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        set.setName(setName);
        
            
        ProxyStructuralFeature sfa = new ProxyStructuralFeature(sf, controller);
            
            try {
                PropertySupport.Reflection<Boolean> editProp = 
                        new PropertySupport.Reflection<Boolean>(sfa, 
                        boolean.class, "editable");
                set.put(editProp);
                editProp.setName("editable");
                
                PropertySupport.Reflection<Integer> lowerProp = 
                        new PropertySupport.Reflection<Integer>(sfa, 
                        int.class, "lowerBound");
                set.put(lowerProp);
                lowerProp.setName("lower bound");
                
                PropertySupport.Reflection<Integer> upperProp = 
                        new PropertySupport.Reflection<Integer>(sfa, 
                        int.class, "upperBound");
                set.put(upperProp);
                upperProp.setName("upper bound");
                
                
                if ( properties != null)
                    for ( PropertySupport.Reflection<? extends Object> psr : properties) {
                        set.put(psr);
                    }
                
            } catch (NoSuchMethodException ex) {
                Exceptions.printStackTrace(ex);
            }
            
            
        sheet.put(set);
        return sheet;
    }
    
}
