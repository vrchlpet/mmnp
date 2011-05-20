

package org.cvut.vrchlpet.MCore.visualization;

/**
 *
 * Popisek elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementLabel extends Label{


    // pozice popisku elementu
    private Position position;

    
    public ElementLabel() {
        this.position = new Position();
        this.position.setAbsolute(false);
        this.position.setLayout(Layout.center);
    }


    /**
     * @return the labelPosition
     */
    public Position getLabelPosition() {
        return position;
    }

    /**
     * @param labelPosition the labelPosition to set
     */
    public void setLabelPosition(Position labelPosition) {
        this.position = labelPosition;
    }

}
