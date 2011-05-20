/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MCore.visualization.ui;

import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.NamedElement;
import org.cvut.vrchlpet.MCore.visualization.ElementVisualization;



/**
 *
 * UI rozhrani pro elementy
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementUI extends CommonMetaObjectUI{

    // specifikace vizualizace
    private ElementVisualization visualization;

    // prirazeny element
    private Element element;
    
    public ElementUI() {}
    
    public ElementUI(Element el) {
        installUI(el);
        this.visualization = new ElementVisualization();
    }

    // navrhovy vzor Visitor
    // painter je v tomto pripade visitor
    @Override
    public Object paint(IPainter painter) {
        return painter.paint(this);
    }

    /**
     * @return the visualization
     */
    public ElementVisualization getVisualization() {
        return visualization;
    }

    /**
     * @param visualization the visualization to set
     */
    public void setVisualization(ElementVisualization visualization) {
        this.visualization = visualization;
    }

    @Override
    public void installUI(NamedElement obj) {
        if ( obj instanceof Element) {
            this.element = (Element) obj;
            obj.setUi(this);
        } else {
            throw new IllegalArgumentException("Parameter is not instance of Element class." +
                    "\nobj: " + obj.toString());
        }
    }

    @Override
    public void uninstallUI(NamedElement obj) {
        if ( obj instanceof Element)
            if ( obj.getUi() == this) {
                obj.setUi(null);
                this.element = null;
            }
    }

    /**
     * @return the el
     */
    public Element getElement() {
        return element;
    }

    /**
     * @param el the el to set
     */
    protected void setElement(Element el) {
        if ( this.element != null)
            uninstallUI(element);
        installUI(el);
    }
}
