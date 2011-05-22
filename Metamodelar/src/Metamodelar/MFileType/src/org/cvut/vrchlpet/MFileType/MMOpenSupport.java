
package org.cvut.vrchlpet.MFileType;

import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MEditor.IMasterEditorManager;
import org.cvut.vrchlpet.MEditor.MasterEditorManager;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MEditor.controller.MasterController;
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
        if ( model == null) {
            JOptionPane.showMessageDialog(null, "Unexpected exception has occured during load process.");
            return null;
        }



        IMasterController controller = new MasterController(model, dobj.getPrimaryFile().getPath());
        IMasterEditorManager editorManager = new MasterEditorManager(controller);
        editorManager.getTopComponent().setDisplayName(dobj.getName());
        topComp = (CloneableTopComponent)editorManager.getTopComponent();
        
        return (CloneableTopComponent)topComp;
    }
    
    public TopComponent getTopComponent() {
        return this.topComp;
    }

}
