/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes.actions;

import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.visualization.ui.VisualLibraryPainter;
import org.cvut.vrchlpet.MEditor.util.SceneSupport;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ShowRelationGraphicsNodeAction extends AbstractAction{

    private Relation relation;

    public ShowRelationGraphicsNodeAction(Relation relation) {
        this.relation = relation;
        putValue (NAME, "show graphics");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Scene scene = new Scene();
        LayerWidget layer = new LayerWidget(scene);
        LayerWidget cLayer = new LayerWidget(scene);
        scene.addChild (layer);
        scene.addChild(cLayer);
        VisualLibraryPainter p = new VisualLibraryPainter(scene);

        LabelWidget w1 = new LabelWidget(scene, "SOURCE");
        w1.getActions().addAction(ActionFactory.createMoveAction());
        w1.setBorder(BorderFactory.createLineBorder());
        w1.setPreferredLocation(new Point(100,100));

        LabelWidget w2 = new LabelWidget(scene, "TARGET");
        w2.getActions().addAction(ActionFactory.createMoveAction());
        w2.setBorder(BorderFactory.createLineBorder());
        w2.setPreferredLocation(new Point(250,100));

        layer.addChild(w1);
        layer.addChild(w2);

        ConnectionWidget cw = (ConnectionWidget)relation.getUi().paint(p);
        cw.setSourceAnchor(AnchorFactory.createRectangularAnchor(w1));
        cw.setTargetAnchor(AnchorFactory.createRectangularAnchor(w2));
        cLayer.addChild(cw);

        SceneSupport.show(scene);
    }


}