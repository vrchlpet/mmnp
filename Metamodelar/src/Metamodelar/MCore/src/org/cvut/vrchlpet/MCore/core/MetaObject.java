

package org.cvut.vrchlpet.MCore.core;


import org.cvut.vrchlpet.MCore.util.Notifyer;
import org.cvut.vrchlpet.MCore.visualization.ui.CommonMetaObjectUI;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class MetaObject extends Notifyer{

    public static final String NAMESPACE_CHANGED = "ns_ch";
    public static final String DESCRIPTION_CHANGED = "des_ch";


    protected String nameSpace;
    protected String description;

    public static final String DEFAULT_NAMESPACE = "empty namespace";
    public static final String DEFAULT_DESCRIPTION = "empty description";

    protected CommonMetaObjectUI ui;

    public MetaObject() {
        this.nameSpace = DEFAULT_NAMESPACE;
        this.description = DEFAULT_DESCRIPTION;
    }

    public MetaObject(String namseSpace, String description) {
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
