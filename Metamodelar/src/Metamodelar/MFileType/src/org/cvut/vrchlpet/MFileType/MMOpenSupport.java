/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MFileType;

import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MController.MasterController;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.cvut.vrchlpet.MEditor.IMasterEditorManager;
import org.cvut.vrchlpet.MEditor.MEditorTopComponent;
import org.cvut.vrchlpet.MEditor.MasterEditorManager;
import org.openide.cookies.CloseCookie;
import org.openide.cookies.OpenCookie;
import org.openide.loaders.OpenSupport;
import org.openide.windows.CloneableTopComponent;
import org.openide.windows.TopComponent;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
class MMOpenSupport extends OpenSupport implements OpenCookie, CloseCookie {

    
    private TopComponent topComp;
    
    public MMOpenSupport(MMDataObject.Entry entry) {
        super(entry);
    }

    @Override
    protected CloneableTopComponent createCloneableTopComponent() {
        MMDataObject dobj = (MMDataObject) entry.getDataObject();
        
        IMModel model = (dobj.getCookie(ModelData.class)).getMetamodel();
        IMasterController controller = new MasterController(model);
        IMasterEditorManager editorManager = new MasterEditorManager(model, controller);
        editorManager.getTopComponent().setDisplayName(dobj.getName());
        topComp = (CloneableTopComponent)editorManager.getTopComponent();
        
        return (CloneableTopComponent)topComp;
    }
    
    public TopComponent getTopComponent() {
        return this.topComp;
    }

}
