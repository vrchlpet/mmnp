
package org.cvut.vrchlpet.MEditor.util;

import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.openide.windows.WindowManager;

/**
 *
 * Proxy objekt relace, deleguje udalosti pres controller
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ProxyRelation {
    
    
    
    private Relation relation;
    private IMasterController controller;
    
    
    
    
    
    public ProxyRelation(Relation relation, IMasterController controller) {
        this.relation = relation;
        this.controller = controller;
    }
    
    public boolean isSymmetric() {
        return relation.isSymmetric();
    }
    
    public boolean isContainer() {
        return relation.isContainer();
    }
    
    public void setContainer(boolean b) {
        controller.getRelationManager().setContainer(relation, b);
    }
    
    public void setSymmetric(boolean b) {
        controller.getRelationManager().setSymetric(relation, b);
    }
    
    public String getNameSpace() {
        return relation.getNameSpace();
    }
    
    public void setNameSpace(String s) {
        if ( !controller.getMetaObjectManager().changeNamespace(relation, s))
            JOptionPane.showMessageDialog(WindowManager.getDefault().getMainWindow(), "Bad input data");
    }
    
    public String getDescription() {
        return relation.getDescription();
    }
    
    public void setDescription(String s) {
        controller.getMetaObjectManager().changeDescriptio(relation, s);
    }
    
    
    
    
    
    
}
