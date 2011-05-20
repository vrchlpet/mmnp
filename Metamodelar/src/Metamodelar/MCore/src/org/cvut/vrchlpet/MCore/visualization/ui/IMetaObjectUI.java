

package org.cvut.vrchlpet.MCore.visualization.ui;


import org.cvut.vrchlpet.MCore.core.NamedElement;

/**
 * Obecne rozhrani UI
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMetaObjectUI{

    
    public void installUI(NamedElement obj);
    public void uninstallUI(NamedElement obj);

}
