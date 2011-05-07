/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationUIEditor extends MAbstractDialog{

    public static final String TITLE = "Relation UI editor";

    private RelationUIPanel panel;

    public RelationUIEditor(Relation rel) {
        super(TITLE);
        this.panel = new RelationUIPanel(rel, this);

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
