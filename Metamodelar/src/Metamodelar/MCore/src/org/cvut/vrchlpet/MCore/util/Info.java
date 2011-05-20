

package org.cvut.vrchlpet.MCore.util;

import org.cvut.vrchlpet.MCore.model.IModelBuilder;
import org.cvut.vrchlpet.MCore.model.MetamodelBuilder;
import org.cvut.vrchlpet.MCore.model.IModelInfo;
import org.cvut.vrchlpet.MCore.model.MetamodelInfo;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.core.MData;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.cvut.vrchlpet.MCore.visualization.BackgroundColor;
import org.cvut.vrchlpet.MCore.visualization.MBorder;
import org.cvut.vrchlpet.MCore.visualization.ElementLabel;
import org.cvut.vrchlpet.MCore.visualization.Layout;
import org.cvut.vrchlpet.MCore.visualization.ui.ElementUI;

/**
 *
 * Trida pouzita pro testovaci ucely
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Info {


    public static void showMsgDialog(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }


    public static void printInfo(Model model) {

        String separator = "======================================================================";

        System.out.println(separator);

        System.out.println("Model: " + model.getNameSpace());
        System.out.println("Elements:");
        for ( Element el : model.getElements()) {
            System.out.println(el.toString());
        }

        System.out.println("");
        System.out.println("Relations:");
        for ( Relation rel : model.getRelations()) {
            System.out.println(rel.toString());
        }

        System.out.println(separator);
    }

    public static IMModel createRandomModel() {
        IModelBuilder builder = new MetamodelBuilder();
        IModelInfo info = new MetamodelInfo();
        IMModel model = new MModel(builder, info);

        model.getModel().setNameSpace("My testing model");





        Element e1 = builder.createElement("E1");
        Element e2 = builder.createElement("E2");
        Element e3 = builder.createElement("E3");
        Element e4 = builder.createElement("E4");
        Element e5 = builder.createElement("E5");
        Element e6 = builder.createElement("E6");
        Element e7 = builder.createElement("E7");

        ElementUI eui = new ElementUI(e1);
        //BackgroundImage im = new BackgroundImage("D:\\download\\comic.jpg");
        BackgroundColor col = new BackgroundColor(Color.red);
        MBorder bor = new MBorder();
        bor.setResizable(true);
        bor.setVisible(true);
        eui.getVisualization().setBorder(bor);
        //eui.getVisualization().setBackgroundImage(im);
        eui.getVisualization().setBackgroundColor(col);
        ElementLabel l1 = new ElementLabel();
        l1.setText("left");
        l1.getLabelPosition().setLayout(Layout.left);
        ElementLabel l2 = new ElementLabel();
        l2.getLabelPosition().setAbsolute(false);
        l2.setText("absolute 100 150");
        l2.getLabelPosition().setAbsolute(true);
        l2.getLabelPosition().setX(100);
        l2.getLabelPosition().setY(150);
        ElementLabel l3 = new ElementLabel();
        l3.setText("right");
        l3.getLabelPosition().setLayout(Layout.right);
        ElementLabel l4 = new ElementLabel();
        l4.setText("top");
        l4.getLabelPosition().setLayout(Layout.top);
        ElementLabel l5 = new ElementLabel();
        l5.setText("buttom");
        l5.getLabelPosition().setLayout(Layout.buttom);
        ElementLabel l6 = new ElementLabel();
        l6.setText("center");
        l6.getLabelPosition().setLayout(Layout.center);
        ElementUI eui2 = new ElementUI(e2);
        eui2.getVisualization().getLabels().add(l1);
        eui2.getVisualization().getLabels().add(l2);
        eui2.getVisualization().getLabels().add(l3);
        eui2.getVisualization().getLabels().add(l4);
        eui2.getVisualization().getLabels().add(l5);
        eui2.getVisualization().getLabels().add(l6);
        ElementUI eui3 = new ElementUI(e3);
        //BackgroundImage bi = new BackgroundImage("C:\\Users\\Vrchli\\Documents\\batikLogo.svg");
        //eui3.getVisualization().setBackgroundImage(bi);




        Attribute at1e1 = builder.createAttribute(e1, "a1");
        at1e1.setName("My super String");
        Property p1at1e1 = builder.createProperty(at1e1, "p1-string", MData.STRING);
        p1at1e1.setValue("test string");
        Attribute at2e1 = builder.createAttribute(e1, "a2");
        at2e1.setName("chooser");
        Property p1at2e1 = builder.createProperty(at2e1, "p2-boolean", MData.BOOLEAN);
        p1at2e1.setValue(true);






        Relation generalization = builder.createRelation("Generalization");
        Relation association = builder.createRelation("Association");
        Relation defaultRel = builder.createRelation("DefaultRel");
        defaultRel.setContainer(true);
        builder.setSuperType(e2, e1);
        builder.createConnection(e2, e3, defaultRel);
        builder.createConnection(e4, e4, association);
        builder.createConnection(e2, e2, defaultRel);
        builder.createConnection(e3, e1, association);
        builder.createConnection(e1, e3, association);
        builder.createConnection(e3, e2, defaultRel);
        builder.setSuperType(e5, e2);
        builder.createConnection(e5, e3, defaultRel);
        builder.createConnection(e3, e5, defaultRel);
        builder.createConnection(e5, e2, defaultRel);
        builder.createConnection(e2, e5, defaultRel);
        builder.createConnection(e1, e6, association);
        builder.createConnection(e1, e7, association);
        builder.createConnection(e1, e7, defaultRel);
        builder.createConnection(e6, e1, defaultRel);
        builder.createConnection(e6, e4, defaultRel);
        return model;
    }
}
