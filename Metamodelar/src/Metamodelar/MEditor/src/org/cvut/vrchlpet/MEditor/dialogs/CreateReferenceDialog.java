/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class CreateReferenceDialog extends MAbstractDialog{

    public static final String TITLE = "Create reference";
    private CreateReferencePanel panel;

    public CreateReferenceDialog(IMasterController controller, String element) {
        super(TITLE);
        panel = new CreateReferencePanel(controller, element, this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CreateReferenceDialog.this.dispose();
            }
        });

        init();
    }

    private void init() {
        
        setContent(panel);
    }

}
