/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import org.cvut.vrchlpet.MEditor.IMasterEditorManager;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class GeneralModelNode extends MAbstractNode{

    public static final String DEFAULT_ABSTRACT_MODEL_NODE_NAME = "model";

    public GeneralModelNode(IMasterEditorManager manager) {
        super(new ModelChildren(manager.getModel(), manager.getController()),
                Lookups.singleton(manager.getModel()),manager.getController());
        setDisplayName(DEFAULT_ABSTRACT_MODEL_NODE_NAME);
    }

    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/generalModelIco.png");
    }

    
}
