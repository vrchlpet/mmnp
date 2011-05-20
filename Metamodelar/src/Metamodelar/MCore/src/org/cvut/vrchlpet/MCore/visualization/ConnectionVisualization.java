

package org.cvut.vrchlpet.MCore.visualization;

import java.util.ArrayList;

/**
 *
 * Manager vizualizace cary mezi dvema elementy
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ConnectionVisualization  {

    public static final ArrowShape DEFAULT__ARROW_SHAPE = ArrowShape.NONE;

    private ArrayList<ConnectionLabel> labels;

    private ArrowShape referenceSourceArrow;
    private ArrowShape referenceTargetArrow;

    public ConnectionVisualization() {
        this.labels = new ArrayList<ConnectionLabel>();
        this.referenceSourceArrow = DEFAULT__ARROW_SHAPE;
        this.referenceTargetArrow = DEFAULT__ARROW_SHAPE;
    }


    public void addLabel(ConnectionLabel label) {
        this.labels.add(label);
    }

    public void removeLabel(ConnectionLabel label) {
        this.labels.remove(label);
    }

    public ArrayList<ConnectionLabel> getLabels() {
        return this.labels;
    }



    /**
     * @return the referenceSourceArrow
     */
    public ArrowShape getReferenceSourceArrow() {
        return referenceSourceArrow;
    }

    /**
     * @param referenceSourceArrow the referenceSourceArrow to set
     */
    public void setReferenceSourceArrow(ArrowShape referenceSourceArrow) {
        this.referenceSourceArrow = referenceSourceArrow;
    }

    /**
     * @return the referenceTargetArrow
     */
    public ArrowShape getReferenceTargetArrow() {
        return referenceTargetArrow;
    }

    /**
     * @param referenceTargetArrow the referenceTargetArrow to set
     */
    public void setReferenceTargetArrow(ArrowShape referenceTargetArrow) {
        this.referenceTargetArrow = referenceTargetArrow;
    }
}
