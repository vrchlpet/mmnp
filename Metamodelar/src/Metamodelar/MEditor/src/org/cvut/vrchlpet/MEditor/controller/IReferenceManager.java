
package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.ReferenceableObject;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * Rozhrani manageru reference
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IReferenceManager {



    public boolean setRelatoin(Reference reference, Relation relation);
    public boolean setBounds(Reference ref, int low, int up);
    public void setVisible(Reference reference, boolean visible);
    public boolean setSource(Reference reference, boolean source);
}
