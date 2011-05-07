/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.MetaObject;
import org.cvut.vrchlpet.MEditor.dialogs.DialogMessagesManager;
import org.openide.windows.WindowManager;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ChangeNamespaceNodeAction extends AbstractAction{

    private IMasterController controller;
    private MetaObject obj;

    public ChangeNamespaceNodeAction(IMasterController controller, MetaObject obj) {
        this.controller = controller;
        this.obj = obj;
        putValue (NAME, "Change namespace");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = JOptionPane.showInputDialog(WindowManager.getDefault().getMainWindow(), "Type int new namespace");
        if ( s != null) {
            if ( !controller.getMetaObjectManager().changeNamespace(obj, s)) {
                DialogMessagesManager.showErrorDialog("Namespace " + s + " is already used.");
            }
        }
        
        
    }


}