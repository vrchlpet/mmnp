package org.cvut.vrchlpet.MController;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import org.cvut.vrchlpet.MController.managers.*;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.model.IMModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMasterController {

    public IMModel getMModel();

    public IElementManager getElementManager();
    public IRelationManager getRelationManager();
    public IReferenceManager getReferenceManger();
    public IAttributeManager getAttributeManager();
    public IPropertyManager getPropertyManager();
    public IModelManager getModelManager();
    public IMetaObjectManager getMetaObjectManager();
    public IStructuralFeatureManager getStructuralFeatureManager();
}
