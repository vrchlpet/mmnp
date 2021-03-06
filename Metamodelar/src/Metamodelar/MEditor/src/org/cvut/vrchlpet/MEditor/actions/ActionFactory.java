
package org.cvut.vrchlpet.MEditor.actions;

import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.NamedElement;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MEditor.nodes.MAbstractNode;

/**
 *
 * Trida, ktera slouzi k prirazeni akci k jednotlivym uzlum
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ActionFactory {
    
    
    
    public static void addActions(NamedElement obj, MAbstractNode node) {
        node.addAction( new ChangeNamespaceNodeAction(node.getController(), obj));
        node.addAction( new ChangeDescriptionNodeAction(node.getController(), obj));
    }
    
    public static void addActions(Element el, MAbstractNode node) {
        node.addAction(new ElementPropertyNodeAction(node.getController(), el));
        addActions((NamedElement)el, node);
        node.addAction(new ShowElementGraphicsNodeAction(el));
        node.addAction(new RemoveElementNodeAction(el, node.getController(), true));
        node.addAction(new ElementUIEditorNodeAction(el));
        
    }
    
    public static void addActions(Relation rel, MAbstractNode node) {
        node.addAction(new RelationPropertiesNodeAction(node.getController(), rel));
        addActions((NamedElement)rel, node);
        
        node.addAction(new ShowRelationGraphicsNodeAction(rel));
        node.addAction(new RemoveRelationNodeAction(rel, node.getController()));
        node.addAction(new RelationUIEditorNodeAction(rel));
    }
    
    public static void addActions(Reference ref, MAbstractNode node) {
        node.addAction(new ReferencePropertyNodeAction(node.getController(), ref));
        node.addAction(new RemoveReferenceNodeAction(ref, node.getController()));
        node.addAction(new ShowReferenceGraphicsNodeAction(ref));
    }
    
    public static void addActions(Attribute at, MAbstractNode node) {
        node.addAction(new AttributePropertyNodeAction(node));
        node.addAction(new RemoveAttributeNodeAction(at, node.getController()));
        
    }
    
}