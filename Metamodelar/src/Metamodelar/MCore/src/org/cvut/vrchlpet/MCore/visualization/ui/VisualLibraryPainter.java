

package org.cvut.vrchlpet.MCore.visualization.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import org.cvut.vrchlpet.MCore.visualization.BackgroundColor;
import org.cvut.vrchlpet.MCore.visualization.BackgroundImage;
import org.cvut.vrchlpet.MCore.visualization.ElementLabel;
import org.cvut.vrchlpet.MCore.visualization.MBorder;
import org.cvut.vrchlpet.MCore.visualization.ElementVisualization;
import org.netbeans.api.visual.action.TextFieldInplaceEditor;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.layout.Layout;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.ImageWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.cvut.vrchlpet.MCore.visualization.ConnectionLabel;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * Implementace vykreslovace pomoci Visual library
 *
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class VisualLibraryPainter implements IPainter{

    private Scene scene;

    public VisualLibraryPainter(Scene scene) {
        this.scene = scene;
    }




    // kresli elementy
    @Override
    public Widget paint(ElementUI el) {
        MWidget w = new MWidget(scene);
        w.setLayout(LayoutFactory.createOverlayLayout());
        w.setCheckClipping(true);
        ElementVisualization ev = el.getVisualization();

        // barva pozadi
        BackgroundColor col = ev.getBackgroundColor();
        if ( col != null) {
            w.setOpaque (true);
            w.setBackground(col.getColor());
        }

        // ohraniceni
        MBorder bor = ev.getBorder();
        if ( bor != null) {
            if ( bor.isVisible()) {
                if ( bor.isResizable()) {
                    w.setBorder(BorderFactory.createResizeBorder(8));
                    w.getActions().addAction (ActionFactory.createResizeAction());
                } else {
                    w.setBorder(BorderFactory.createLineBorder(2));
                }
            }
        }


        // obrazek elementu
        BackgroundImage im = ev.getBackgroundImage();
        if ( im != null) {
            ImageWidget iw = null;
            iw = new ImageWidget(w.getScene(), im.getImage());
            w.addWidget(iw, LayoutFactory.createVerticalFlowLayout(LayoutFactory.SerialAlignment.CENTER, 0));
        } else {
            w.setPreferredSize(new Dimension(100, 100));
        }

        w.getActions().addAction(ActionFactory.createMoveAction());

        
        // vzkresleni vsech popisku
        for ( ElementLabel l : ev.getLabels()) {
            LabelWidget lw = new LabelWidget(scene, l.getText());
            lw.getActions().addAction(ActionFactory.createInplaceEditorAction (new RenameEditor ()));
            if ( l.getLabelPosition().isAbsolute()) {
                lw.setPreferredLocation(new Point(l.getLabelPosition().getX(), l.getLabelPosition().getY()));
                w.addWidget(lw, LayoutFactory.createAbsoluteLayout());
            } else {

                // nastaveni pozice popisku
                switch(l.getLabelPosition().getLayout()) {
                    case buttom:
                        lw.setOrientation(LabelWidget.Orientation.NORMAL);
                        lw.setAlignment(LabelWidget.Alignment.CENTER);
                        lw.setVerticalAlignment(LabelWidget.VerticalAlignment.BOTTOM);
                        break;
                    case center:
                        lw.setOrientation(LabelWidget.Orientation.NORMAL);
                        lw.setAlignment(LabelWidget.Alignment.CENTER);
                        lw.setVerticalAlignment(LabelWidget.VerticalAlignment.CENTER);
                        break;
                    case left:
                        lw.setOrientation(LabelWidget.Orientation.NORMAL);
                        lw.setAlignment(LabelWidget.Alignment.LEFT);
                        lw.setVerticalAlignment(LabelWidget.VerticalAlignment.CENTER);
                        break;
                    case right:
                        lw.setOrientation(LabelWidget.Orientation.NORMAL);
                        lw.setAlignment(LabelWidget.Alignment.RIGHT);
                        lw.setVerticalAlignment(LabelWidget.VerticalAlignment.CENTER);
                        break;
                    case top:
                        lw.setOrientation(LabelWidget.Orientation.NORMAL);
                        lw.setAlignment(LabelWidget.Alignment.CENTER);
                        lw.setVerticalAlignment(LabelWidget.VerticalAlignment.BASELINE);
                        break;
                }
                w.addWidget(lw, LayoutFactory.createOverlayLayout());
            }
            
        }
        

        return w;
    }

    // kresli relace - cary mezi elementy
    @Override
    public ConnectionWidget paint(RelationUI rel) {
        ConnectionWidget cw = new ConnectionWidget(scene);
        cw.setSourceAnchorShape (new MyArrow(MAnchorShape.valueOf(rel.getVisualization().getReferenceSourceArrow().toString())));
        cw.setTargetAnchorShape (new MyArrow(MAnchorShape.valueOf(rel.getVisualization().getReferenceTargetArrow().toString())));

        // vykresleni popisku relace
        for ( ConnectionLabel cl : rel.getVisualization().getLabels()) {
            LabelWidget lw = new LabelWidget (scene, cl.getText());
            lw.setOpaque (true);
            
            cw.addChild (lw);

            // nastaveni pozice popisku
            switch (cl.getConnectionLabelPosition()) {
                case center:
                    cw.setConstraint (lw, LayoutFactory.ConnectionWidgetLayoutAlignment.CENTER_RIGHT, 0.5f);
                    break;
                case source:
                    cw.setConstraint (lw, LayoutFactory.ConnectionWidgetLayoutAlignment.TOP_LEFT, -10);
                    break;
                case target:
                    cw.setConstraint (lw, LayoutFactory.ConnectionWidgetLayoutAlignment.TOP_RIGHT, 10);
                    break;
            }
            if ( cl.isEditable()) {
                lw.getActions().addAction(ActionFactory.createInplaceEditorAction (new RenameEditor ()));
            }
            if ( cl.isMovable()) {
                lw.getActions ().addAction (ActionFactory.createMoveAction ());
            }
        }
        return cw;
    }


    // Univerzalni widget reprezentujici element
    private class MWidget extends Widget {


        public MWidget(Scene scene) {
            super(scene);
        }

        // kazdy potomek je ulozen do vlastni vrstvy - kvuli poloze jednotlivych obrazku, popisku atd...
        public void addWidget(Widget widget, Layout layout) {
            LayerWidget lw = new LayerWidget(getScene());
            addChild(lw);
            lw.setLayout(layout);
            lw.addChild(widget);
        }
    }

    // editor pro prejmenovani popisku "inplace" technologii
    private static class RenameEditor implements TextFieldInplaceEditor {

        @Override
        public boolean isEnabled (Widget widget) {
            return true;
        }

        @Override
        public String getText (Widget widget) {
            return ((LabelWidget) widget).getLabel ();
        }

        @Override
        public void setText (Widget widget, String text) {
            ((LabelWidget) widget).setLabel (text);
        }
    }

    // trida se stara o vykreslovani sipek
    private class MyArrow implements AnchorShape {

        private MAnchorShape shape;
        
        public MyArrow(MAnchorShape shape) {
            this.shape = shape;
        }
        
        @Override
        public boolean isLineOriented() {
            return true;
        }

        @Override
        public int getRadius() {
            return shape.getRadius();
        }

        @Override
        public double getCutDistance() {
            return shape.getCutDistance();
        }

        @Override
        public void paint(Graphics2D gd, boolean bln) {
            shape.paint(gd);
        }

    }

    
}

// vycet tvaru sipek, ktere umi VisualLibraryPainter vykreslit
enum MAnchorShape {
    CYRCLE {
        @Override
       public int getRadius() {
           return 0;
       }
        @Override
       public int getCutDistance() {
           return 20;
       }
        @Override
       public void paint(Graphics2D g) {
           g.drawOval(0, -10, 20, 20);
       }
    },
    TRIANGLE {
        @Override
       public int getRadius() {
           return 0;
       }
        @Override
       public int getCutDistance() {
           return 14;
       }
        @Override
       public void paint(Graphics2D g) {
           Polygon p = new Polygon(new int [] {0,14,14}, new int [] {0,-7,7}, 3);
           g.drawPolygon(p);
       }
    },
    FILLTRIANGLE {
        @Override
       public int getRadius() {
           return 0;
       }
        @Override
       public int getCutDistance() {
           return 14;
       }
        @Override
       public void paint(Graphics2D g) {
           Polygon p = new Polygon(new int [] {0,14,14}, new int [] {0,-7,7}, 3);
           
           g.fillPolygon(p);
       }
    },
    DIAMOND {
        @Override
       public int getRadius() {
           return 0;
       }
        @Override
       public int getCutDistance() {
           return 30;
       }
        @Override
       public void paint(Graphics2D g) {
           Polygon p = new Polygon(new int [] {0,15,30,15}, new int [] {0,6,0,-6}, 4);
           
           g.drawPolygon(p);
       }
    },
    FILLDIAMOND{
        @Override
       public int getRadius() {
           return 0;
       }
        @Override
       public int getCutDistance() {
           return 30;
       }
        @Override
       public void paint(Graphics2D g) {
           Polygon p = new Polygon(new int [] {0,15,30,15}, new int [] {0,6,0,-6}, 4);
           
           g.fillPolygon(p);
       }
    },
    SIMPLE{
        @Override
       public int getRadius() {
           return 0;
       }
        @Override
       public int getCutDistance() {
           return 0;
       }
        @Override
       public void paint(Graphics2D g) {
           g.drawLine(0, 0, 14, -7);
           g.drawLine(0, 0, 14, 7);
       }
    },
    NONE{
        @Override
       public int getRadius() {
           return 0;
       }
        @Override
       public int getCutDistance() {
           return 0;
       }
        @Override
       public void paint(Graphics2D g) {
       }
    };
    
    
    
    
    abstract int getRadius();
    abstract int getCutDistance();
    abstract void paint(Graphics2D g);
}
