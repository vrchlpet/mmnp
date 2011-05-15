

package org.cvut.vrchlpet.MCore.core;

import org.cvut.vrchlpet.MCore.visualization.ui.RelationUI;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Relation extends MetaObject{

    public static final boolean DEFAULT_SYMETRIC = false;
    public static final String SYMMETRIC_CHANGED = "symm_ch";
    public static final boolean DEFAULT_CONTAINER = false;
    public static final String CONTAINER_CH = "container_ch";

    private boolean symmetric;

    private boolean container;

    public Relation() {
        this.symmetric = DEFAULT_SYMETRIC;
        RelationUI relationUI = new RelationUI(this);
        this.container = DEFAULT_CONTAINER;
    }


    
    
    
    
    /**
     * @return the container
     */
    public boolean isContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(boolean container) {
        boolean old = this.container;
        this.container = container;
        firePropertyChange(CONTAINER_CH, old, this.container);
    }
    
    
    
    /**
     * @return the invertible
     */
    public boolean isSymmetric() {
        return symmetric;
    }

    /**
     * @param invertible the invertible to set
     */
    public void setSymmetric(boolean symetric) {
        boolean old = this.symmetric;
        this.symmetric = symetric;
        firePropertyChange(SYMMETRIC_CHANGED, old, symetric);
    }

    @Override
    public String toString() {
        String s = "";

        s += getNameSpace() + ", symetric: " + symmetric;

        return s;
    }

}
