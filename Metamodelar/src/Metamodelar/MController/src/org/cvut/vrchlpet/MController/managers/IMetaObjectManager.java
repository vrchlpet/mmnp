/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MController.managers;

import org.cvut.vrchlpet.MCore.core.MetaObject;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMetaObjectManager {
    public boolean changeNamespace(MetaObject obj, String namespace);
    public boolean changeDescriptio(MetaObject obj, String description);
}
