/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.cvut.vrchlpet.MEditor.controller.IMasterController;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationEditorDialog extends MAbstractDialog{
    
    public static final String TITLE = "Relation editor";
    private RelationEditorPanel panel;


    public RelationEditorDialog(IMasterController controller, Relation relation) {
        super(TITLE);
        this.panel = new RelationEditorPanel(this, controller, relation);

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
