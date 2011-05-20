/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization.ui;

import org.cvut.vrchlpet.MCore.core.NamedElement;

/**
 *  Rozhrani pro UI meta-objektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class CommonMetaObjectUI implements IPaintable{


    public abstract void installUI(NamedElement obj);


    public abstract void uninstallUI(NamedElement obj);


}
