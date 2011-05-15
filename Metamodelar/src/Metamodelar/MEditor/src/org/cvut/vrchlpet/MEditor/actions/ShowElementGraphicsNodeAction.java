/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.visualization.ui.VisualLibraryPainter;
import org.cvut.vrchlpet.MEditor.util.SceneSupport;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ShowElementGraphicsNodeAction extends AbstractAction{

    private Element element;

    public ShowElementGraphicsNodeAction(Element element) {
        this.element = element;
        putValue (NAME, "show graphics");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Scene scene = new Scene();
        scene.getActions().addAction(ActionFactory.createCenteredZoomAction(1.1));
        scene.getActions().addAction(ActionFactory.createPanAction());
        LayerWidget layer = new LayerWidget (scene);
        scene.addChild (layer);
        VisualLibraryPainter p = new VisualLibraryPainter(scene);
        Widget w = (Widget)element.getUi().paint(p);
        layer.addChild(w);
        SceneSupport.show(scene);
    }


}