/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers;

import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.ReferenceableObject;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IReferenceManager {



    public void setRelatoin(Reference reference, Relation relation);
    public boolean setBounds(Reference ref, int low, int up);
    public void setVisible(Reference reference, boolean visible);
    public boolean setSource(Reference reference, boolean source);
    public void setOpposite(Reference reference, Reference opposite);
    public void setReferenceType(Reference reference, ReferenceableObject type);
}
