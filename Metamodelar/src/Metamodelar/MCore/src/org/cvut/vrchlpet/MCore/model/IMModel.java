/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.model;

import java.util.ArrayList;
import java.util.Date;
import org.cvut.vrchlpet.MCore.core.Model;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IMModel {
    public IModelBuilder getBuilder();
    public IModelInfo getModelInfo();
    public void setModelInfo(IModelInfo info);
    public Model getModel();
    public Date getTheCreationDate();
}
