

package org.cvut.vrchlpet.MCore.visualization;

/**
 *
 * Trida reprezentuje obecnou informaci o pozici
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Position {


    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final boolean DEFAULT_ABSOLUTE = false;
    public static final Layout DEFAULT_LAYOUT = Layout.center;


    private int x;
    private int y;
    
    // indikace, zda se jedna o absolutni pozici
    private boolean absolute;

    // pokud je parameter absolute = false, pak se bere v uvahu Layout
    private Layout layout;


    public Position() {
        this.x = DEFAULT_X;
        this.y = DEFAULT_Y;
        this.absolute = DEFAULT_ABSOLUTE;
        this.layout = DEFAULT_LAYOUT;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the absolute
     */
    public boolean isAbsolute() {
        return absolute;
    }

    /**
     * @param absolute the absolute to set
     */
    public void setAbsolute(boolean absolute) {
        this.absolute = absolute;
    }

    /**
     * @return the layout
     */
    public Layout getLayout() {
        return layout;
    }

    /**
     * @param layout the layout to set
     */
    public void setLayout(Layout layout) {
        this.layout = layout;
    }



}
