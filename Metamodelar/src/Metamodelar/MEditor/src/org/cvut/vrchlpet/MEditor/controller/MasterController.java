

package org.cvut.vrchlpet.MEditor.controller;


import org.cvut.vrchlpet.MCore.model.IMModel;

/**
 *
 * komponenta Controller z MVC vzoru
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MasterController implements IMasterController{

    private IMModel model;
    private String modelPath;

    public MasterController(IMModel model, String modelPath) {
        this.model = model;
        this.modelPath = modelPath;
    }

    @Override
    public IElementManager getElementManager() {
        return new ElementManager(this);
    }

    @Override
    public IRelationManager getRelationManager() {
        return new RelationManager(this);
    }

    @Override
    public IReferenceManager getReferenceManger() {
        return new ReferenceManager(this);
    }

    @Override
    public IAttributeManager getAttributeManager() {
        return new AttributeManager(this);
    }

    @Override
    public IPropertyManager getPropertyManager() {
        return new PropertyManager(this);
    }

    @Override
    public IModelManager getModelManager() {
        return new ModelManager(this);
    }

    @Override
    public IMModel getMModel() {
        return this.model;
    }

    @Override
    public IMetaObjectManager getMetaObjectManager() {
        return new MetaObjectManager(this);
    }

    @Override
    public IStructuralFeatureManager getStructuralFeatureManager() {
        return new StructuralFeatureManager();
    }

    @Override
    public String getModelPath() {
        return this.modelPath;
    }
}
