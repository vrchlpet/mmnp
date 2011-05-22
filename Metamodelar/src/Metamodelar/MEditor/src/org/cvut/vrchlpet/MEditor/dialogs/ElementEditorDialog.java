
package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Element;

/**
 *
 * Dialog pro editaci elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementEditorDialog extends MAbstractDialog{

    public static final String TITLE = "Element editor";
    private ElementEditorPanel panel;


    public ElementEditorDialog(IMasterController controller, Element element) {
        super(TITLE);
        this.panel = new ElementEditorPanel(controller, element, this);

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
