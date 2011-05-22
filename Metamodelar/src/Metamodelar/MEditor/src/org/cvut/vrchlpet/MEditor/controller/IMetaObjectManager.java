

package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.NamedElement;

/**
 *
 * Rozhrani manageru metaobjektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMetaObjectManager {
    public boolean changeNamespace(NamedElement obj, String namespace);
    public boolean changeDescriptio(NamedElement obj, String description);
}
