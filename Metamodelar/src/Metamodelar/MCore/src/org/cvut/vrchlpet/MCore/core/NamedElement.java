

package org.cvut.vrchlpet.MCore.core;


import org.cvut.vrchlpet.MCore.util.Notifyer;
import org.cvut.vrchlpet.MCore.visualization.ui.CommonMetaObjectUI;

/**
 *
 * Hlavicka meta-objektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class NamedElement extends Notifyer{

    public static final String NAMESPACE_CHANGED = "ns_ch";
    public static final String DESCRIPTION_CHANGED = "des_ch";


    protected String nameSpace;
    protected String description;

    public static final String DEFAULT_NAMESPACE = "empty namespace";
    public static final String DEFAULT_DESCRIPTION = "empty description";

    // graficka reprezentace meta-objektu - bod, kde se spojuje vrsva meta-meta-modelu a vizualizace
    protected CommonMetaObjectUI ui;

    public NamedElement() {
        this.nameSpace = DEFAULT_NAMESPACE;
        this.description = DEFAULT_DESCRIPTION;
    }

    public NamedElement(String namseSpace, String description) {
        this();
        this.nameSpace = namseSpace;
        this.description = description;
    }

    

    /**
     * @return the nameSpace
     */
    public String getNameSpace() {
        return nameSpace;
    }

    /**
     * @param nameSpace the nameSpace to set
     */
    public void setNameSpace(String nameSpace) {
        String old = this.nameSpace;
        this.nameSpace = nameSpace;
        firePropertyChange(NAMESPACE_CHANGED, old, this.nameSpace);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        String old = this.description;
        this.description = description;
        firePropertyChange(DESCRIPTION_CHANGED, old, this.description);
    }

    /**
     * @return the ui
     */
    public CommonMetaObjectUI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(CommonMetaObjectUI ui) {
        this.ui = ui;
    }

}
