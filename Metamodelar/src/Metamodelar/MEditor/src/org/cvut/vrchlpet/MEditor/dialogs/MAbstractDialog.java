/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.openide.windows.WindowManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class MAbstractDialog extends JDialog{

    static {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        dimension = toolkit.getScreenSize();

    }


    private static Dimension dimension;


    public MAbstractDialog(String title) {
        super(WindowManager.getDefault().getMainWindow(), true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                MAbstractDialog.this.dispose();
            }
        });

        this.setTitle(title);
        this.setLayout(new BorderLayout());
    }


    protected void setContent(JPanel panel) {
        this.add(panel, BorderLayout.CENTER);
        this.pack();

        double x = dimension.getWidth()/2 - this.getWidth()/2;
        double y = dimension.getHeight()/2 - this.getHeight()/2;

        this.setLocation((int)x, (int)y);

        this.setVisible(true);
    }
}
