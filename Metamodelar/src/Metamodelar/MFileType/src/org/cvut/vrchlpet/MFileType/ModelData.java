/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MFileType;

import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.util.Serializer;
import org.openide.nodes.Node.Cookie;
/**
 *
 * Trida, ktera je vyuzita pri nahrani metamodelu z vnejsi pameti.
 * po nahrani je vracena instance metamodelu.
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return this.model;
    }

}
