
package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Attribute;

/**
 *
 * Dialog pro editovani atributu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeEditorDialog extends MAbstractDialog{

    public static final String TITLE = "Attribute editor";
    private AttributeEditorPanel panel;
    
    public AttributeEditorDialog(IMasterController controller, Attribute attribute) {
        super(TITLE);
        panel = new AttributeEditorPanel(controller, attribute, this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.close();
            }
        });
        init();
    }

    private void init() {
        
        setContent(panel);
    }

}
