

package org.cvut.vrchlpet.MCore.visualization;

/**
 *
 * Ohraniceni elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MBorder {

    public static final boolean DEFAULT_RESIZABLE = false;
    public static final boolean DEFAULT_VISIBLE = true;

    // roztazitelnost
    private boolean resizable;

    // viditelnost
    private boolean visible;
    
    public MBorder() {
        this.resizable = DEFAULT_RESIZABLE;
        this.visible = DEFAULT_VISIBLE;
    }

    public MBorder(boolean visible, boolean resizable) {
        this.visible = visible;
        this.resizable = resizable;
    }

    /**
     * @return the resizable
     */
    public boolean isResizable() {
        return resizable;
    }

    /**
     * @param resizable the resizable to set
     */
    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}
