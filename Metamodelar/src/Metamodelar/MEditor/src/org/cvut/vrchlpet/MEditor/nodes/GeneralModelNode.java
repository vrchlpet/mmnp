
package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.Image;
import org.cvut.vrchlpet.MEditor.IMasterEditorManager;
import org.openide.util.ImageUtilities;
import org.openide.util.lookup.Lookups;

/**
 *
 * Trida predstavujici skutecny uzel Model (koren stromu)
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class GeneralModelNode extends MAbstractNode{

    public static final String DEFAULT_ABSTRACT_MODEL_NODE_NAME = "model";

    public GeneralModelNode(IMasterEditorManager manager) {
        super(new ModelChildren(manager.getController().getMModel(), manager.getController()),
                Lookups.singleton(manager.getController().getMModel()),manager.getController());
        setDisplayName(DEFAULT_ABSTRACT_MODEL_NODE_NAME);
    }

    @Override
    protected Image getIcon() {
        return ImageUtilities.loadImage("org/cvut/vrchlpet/MEditor/icons/generalModelIco.png");
    }

    
}
