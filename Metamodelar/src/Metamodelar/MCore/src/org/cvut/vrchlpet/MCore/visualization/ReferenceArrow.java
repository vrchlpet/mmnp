
package org.cvut.vrchlpet.MCore.visualization;

/**
 *
 * Tvar sipky
 *
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceArrow {

    public static final boolean DEFAULT_REVERSED = false;
    public static final ArrowShape DEFAULT_ARROW_SHAPE = ArrowShape.NONE;

    // tvar sipkz
    private ArrowShape arrowShape;

    // orientace sipky
    private boolean reversed;

    public ReferenceArrow() {
        this.arrowShape = DEFAULT_ARROW_SHAPE;
        this.reversed = DEFAULT_REVERSED;

    }

    public ReferenceArrow(ArrowShape arrowShape) {
        this.arrowShape = arrowShape;
    }

    /**
     * @return the arrowShape
     */
    public ArrowShape getArrowShape() {
        return arrowShape;
    }

    /**
     * @param arrowShape the arrowShape to set
     */
    public void setArrowShape(ArrowShape arrowShape) {
        this.arrowShape = arrowShape;
    }

    /**
     * @return the reversed
     */
    public boolean isReversed() {
        return reversed;
    }

    /**
     * @param reversed the reversed to set
     */
    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }
}
