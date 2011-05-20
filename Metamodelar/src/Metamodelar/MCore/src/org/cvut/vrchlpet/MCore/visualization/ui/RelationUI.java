/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization.ui;

import org.cvut.vrchlpet.MCore.core.NamedElement;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.visualization.ConnectionVisualization;

/**
 *
 * UI rozhrani pro relace
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class RelationUI extends CommonMetaObjectUI{

    // prirazena relace
    private Relation relation;

    // specifikace visualizace
    private ConnectionVisualization visualization;

    public RelationUI() {}
    
    public RelationUI(Relation rel) {
        installUI(rel);
        this.visualization = new ConnectionVisualization();
    }


    @Override
    public Object paint(IPainter painter) {
        return painter.paint(this);
    }

    /**
     * @return the visualization
     */
    public ConnectionVisualization getVisualization() {
        return visualization;
    }

    /**
     * @param visualization the visualization to set
     */
    public void setVisualization(ConnectionVisualization visualization) {
        this.visualization = visualization;
    }

    @Override
    public void installUI(NamedElement obj) {
        if ( obj instanceof Relation) {
            this.relation = (Relation) obj;
            obj.setUi(this);
        }
    }

    @Override
    public void uninstallUI(NamedElement obj) {
        if ( obj instanceof Relation)
            if ( obj.getUi() == this) {
                obj.setUi(null);
                this.relation = null;
            }
    }

    /**
     * @return the el
     */
    public Relation getRelation() {
        return relation;
    }

    /**
     * @param el the el to set
     */
    protected void setRelation(Relation rel) {
        if ( this.relation != null)
            uninstallUI(relation);
        installUI(rel);
    }

}
