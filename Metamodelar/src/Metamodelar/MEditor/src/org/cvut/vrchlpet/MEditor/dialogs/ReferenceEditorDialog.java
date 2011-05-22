
package org.cvut.vrchlpet.MEditor.dialogs;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Reference;

/**
 *
 * Dialog pro editaci reference
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceEditorDialog extends MAbstractDialog{

    public static final String TITLE = "Reference editor";
    private ReferenceEditorPanel panel;



    public ReferenceEditorDialog(IMasterController controller, Reference reference) {
        super(TITLE);
        panel = new ReferenceEditorPanel(this, controller, reference);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.close();
                ReferenceEditorDialog.this.dispose();
            }
        });
        init();
    }

    private void init() {
        
        setContent(panel);
    }

}
