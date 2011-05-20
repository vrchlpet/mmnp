/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization.ui;

/**
 *
 * Obecne rozhrani vykreslovace. Urcene pro ruzne knihovny a framevorky
 * V soucasne dobje jej implementuje pouze knihovna VisualLibrary
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IPainter {
    public Object paint(ElementUI el);
    public Object paint(RelationUI rel);
}
