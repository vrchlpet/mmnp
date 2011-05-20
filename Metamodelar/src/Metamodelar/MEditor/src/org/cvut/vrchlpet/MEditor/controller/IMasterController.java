package org.cvut.vrchlpet.MEditor.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



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

    public String getModelPath();
}
