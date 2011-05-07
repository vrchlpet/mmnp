

package org.cvut.vrchlpet.MController;

import org.cvut.vrchlpet.MController.managers.IAttributeManager;
import org.cvut.vrchlpet.MController.managers.IElementManager;
import org.cvut.vrchlpet.MController.managers.IMetaObjectManager;
import org.cvut.vrchlpet.MController.managers.IModelManager;
import org.cvut.vrchlpet.MController.managers.IPropertyManager;
import org.cvut.vrchlpet.MController.managers.IReferenceManager;
import org.cvut.vrchlpet.MController.managers.IRelationManager;
import org.cvut.vrchlpet.MController.managers.IStructuralFeatureManager;
import org.cvut.vrchlpet.MController.managers.impl.AttributeManager;
import org.cvut.vrchlpet.MController.managers.impl.ElementManager;
import org.cvut.vrchlpet.MController.managers.impl.MetaObjectManager;
import org.cvut.vrchlpet.MController.managers.impl.ModelManager;
import org.cvut.vrchlpet.MController.managers.impl.PropertyManager;
import org.cvut.vrchlpet.MController.managers.impl.ReferenceManager;
import org.cvut.vrchlpet.MController.managers.impl.RelationManager;
import org.cvut.vrchlpet.MController.managers.impl.StructuralFeatureManager;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.model.IMModel;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MasterController implements IMasterController{

    private IMModel model;

    public MasterController(IMModel model) {
        this.model = model;
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
}
