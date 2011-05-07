/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.util;

import org.cvut.vrchlpet.MController.IMasterController;
import org.cvut.vrchlpet.MCore.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceAdapter {


    

    private Reference reference;
    private IMasterController controller;


    public ReferenceAdapter(Reference reference, IMasterController controller) {
        this.reference = reference;
        this.controller = controller;
    }

    /**
     * @return the lowerBound
     */
    public int getLowerBound() {
        return reference.getLowerBound();
    }

    /**
     * @param lowerBound the lowerBound to set
     */
    public void setLowerBound(int lowerBound) {
        controller.getReferenceManger().setBounds(reference, lowerBound, reference.getUpperBound());
    }

    /**
     * @return the upperBound
     */
    public int getUpperBound() {
        return reference.getUpperBound();
    }

    /**
     * @param upperBound the upperBound to set
     */
    public void setUpperBound(int upperBound) {
        controller.getReferenceManger().setBounds(reference, reference.getLowerBound(), upperBound);
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return reference.isVisible();
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        controller.getReferenceManger().setVisible(reference, visible);
    }

    /**
     * @return the source
     */
    public boolean isSource() {
        return reference.isSource();
    }

    /**
     * @param source the source to set
     */
    public void setSource(boolean source) {
        controller.getReferenceManger().setSource(reference, source);
    }




}
