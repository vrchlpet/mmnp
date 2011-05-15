/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.dialogs;

import javax.swing.JOptionPane;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class DialogMessagesManager {


    public static void showErrorDialog(String text) {
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfoDialog(String text) {
        JOptionPane.showMessageDialog(null, text);
    }



}
