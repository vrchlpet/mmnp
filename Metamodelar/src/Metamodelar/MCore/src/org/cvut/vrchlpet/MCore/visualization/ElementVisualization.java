

package org.cvut.vrchlpet.MCore.visualization;

import java.util.ArrayList;

/**
 *
 * Manager vizualizace elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementVisualization {

    
    private MBorder border;
    private BackgroundColor backgroundColor;
    private BackgroundImage backgroundImage;
    private ArrayList<ElementLabel> labels;


    public ElementVisualization() {
        this.border = null;
        this.backgroundColor = null;
        this.backgroundImage = null;
        this.labels = new ArrayList<ElementLabel>();
    }


    /**
     * @return the border
     */
    public MBorder getBorder() {
        return border;
    }

    /**
     * @param border the border to set
     */
    public void setBorder(MBorder border) {
        this.border = border;
    }

    /**
     * @return the backgroundColor
     */
    public BackgroundColor getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(BackgroundColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the backgroundImage
     */
    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * @param backgroundImage the backgroundImage to set
     */
    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     * @return the labels
     */
    public ArrayList<ElementLabel> getLabels() {
        return labels;
    }

    public void addLabel(ElementLabel label) {
        this.labels.add(label);
    }

    public void removeLabel(ElementLabel label) {
        this.labels.remove(label);
    }

}
