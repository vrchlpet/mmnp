
package org.cvut.vrchlpet.MEditor.actions;

import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.visualization.ui.VisualLibraryPainter;
import org.cvut.vrchlpet.MEditor.util.SceneSupport;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * Akce uzlu Reference pro zobrazeni grafiky
 *
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ShowReferenceGraphicsNodeAction extends AbstractAction{

    private Reference ref;

    public ShowReferenceGraphicsNodeAction(Reference ref) {
        this.ref = ref;
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
        Element sE = ref.isSource()?(Element)ref.getOwner():(Element)ref.getOpposite().getOwner();
        Element tE = (!ref.isSource())?(Element)ref.getOwner():(Element)ref.getOpposite().getOwner();
        Widget source = (Widget)sE.getUi().paint(p);
        Widget target = (Widget)tE.getUi().paint(p);
        source.setPreferredLocation(new Point(100,100));
        target.setPreferredLocation(new Point(300,100));
        layer.addChild(source);
        layer.addChild(target);
        
        ConnectionWidget cw = (ConnectionWidget)ref.getRelation().getUi().paint(p);
        cw.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
        cw.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
        cLayer.addChild(cw);
        
        
        SceneSupport.show(scene);
    
    }
    
}
