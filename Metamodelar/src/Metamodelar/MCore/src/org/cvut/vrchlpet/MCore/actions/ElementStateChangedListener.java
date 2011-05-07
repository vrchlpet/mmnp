/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.actions;

import java.beans.PropertyChangeEvent;
import java.util.EventListener;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface ElementStateChangedListener extends EventListener{
    public void elementsStateChanged(PropertyChangeEvent evt);
}
