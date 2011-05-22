
package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.cvut.vrchlpet.MCore.core.Element;

/**
 *
 * Dialog pro editaci grafiky elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementUIEditor extends MAbstractDialog{

    public static final String TITLE = "Element UI editor";

    private ElementUIPanel panel;

    public ElementUIEditor(Element el) {
        super(TITLE);
        this.panel = new ElementUIPanel(el, this);

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
