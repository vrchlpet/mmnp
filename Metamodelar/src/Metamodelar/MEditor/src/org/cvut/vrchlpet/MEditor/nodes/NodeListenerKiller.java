/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MCore.util.IPropertyChangeObservable;
import org.openide.nodes.NodeEvent;
import org.openide.nodes.NodeListener;
import org.openide.nodes.NodeMemberEvent;
import org.openide.nodes.NodeReorderEvent;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class NodeListenerKiller implements NodeListener{

    private IPropertyChangeObservable pco;
    private PropertyChangeListener propList;

    public NodeListenerKiller(IPropertyChangeObservable pco,
            PropertyChangeListener propList) {
        this.pco = pco;
        this.propList = propList;
    }



    @Override
    public void childrenAdded(NodeMemberEvent nme) {
        System.out.println();
    }

    @Override
    public void childrenRemoved(NodeMemberEvent nme) {
        System.out.println();
    }

    @Override
    public void childrenReordered(NodeReorderEvent nre) {
        System.out.println();
    }

    @Override
    public void nodeDestroyed(NodeEvent ne) {
        pco.removePropertyChangeListener(propList);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println();
    }



}
