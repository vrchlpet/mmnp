/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization.ui;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IPainter {
    public Object paint(ElementUI el);
    public Object paint(RelationUI rel);
}
