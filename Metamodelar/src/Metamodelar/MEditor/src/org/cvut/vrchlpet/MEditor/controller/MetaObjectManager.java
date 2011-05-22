
package org.cvut.vrchlpet.MEditor.controller;


import org.cvut.vrchlpet.MCore.core.NamedElement;

/**
 *
 * Manager metaobjektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetaObjectManager implements IMetaObjectManager{


    private IMasterController controller;

    public MetaObjectManager(IMasterController controller) {
        this.controller = controller;
    }

    @Override
    public boolean changeNamespace(NamedElement obj, String namespace) {
        
        String val = namespace.trim();
        if ( val.length() == 0)
            return false;
        
        if ( controller.getMModel().getModelInfo().isNameSpaceInUse(namespace))
            return false;

        obj.setNameSpace(namespace);

        return true;
    }

    @Override
    public boolean changeDescriptio(NamedElement obj, String description) {
        obj.setDescription(description);
        return true;
    }






}
