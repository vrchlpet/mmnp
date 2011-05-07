/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MFileType;

import java.io.IOException;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.openide.nodes.Node.Cookie;
import org.openide.util.Exceptions;
/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelData implements Cookie{
    private IMModel model = null;
    private String path;

    public ModelData(String path) {
        this.path = path;
    }

    public IMModel getMetamodel() {
        if ( model == null)
            try {
            model = model = Serializer.createSerializer().deserialize(path);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return this.model;
    }

}
