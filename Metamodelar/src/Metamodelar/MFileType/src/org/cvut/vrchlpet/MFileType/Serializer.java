package org.cvut.vrchlpet.MFileType;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.MetaObject;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.core.StructuralFeature;
import org.cvut.vrchlpet.MCore.datacore.MData;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.cvut.vrchlpet.MCore.util.IModelBuilder;
import org.cvut.vrchlpet.MCore.util.MetamodelBuilder;
import org.cvut.vrchlpet.MCore.util.MetamodelInfo;
import org.cvut.vrchlpet.MCore.visualization.ArrowShape;
import org.cvut.vrchlpet.MCore.visualization.BackgroundColor;
import org.cvut.vrchlpet.MCore.visualization.BackgroundImage;
import org.cvut.vrchlpet.MCore.visualization.ConnectionLabel;
import org.cvut.vrchlpet.MCore.visualization.ConnectionLabelPosition;
import org.cvut.vrchlpet.MCore.visualization.ElementLabel;
import org.cvut.vrchlpet.MCore.visualization.Layout;
import org.cvut.vrchlpet.MCore.visualization.LineStyle;
import org.cvut.vrchlpet.MCore.visualization.MBorder;
import org.cvut.vrchlpet.MCore.visualization.ui.ElementUI;
import org.cvut.vrchlpet.MCore.visualization.ui.ImageLoader;
import org.cvut.vrchlpet.MCore.visualization.ui.RelationUI;
import org.openide.util.Exceptions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Serializer {

    private static Serializer instance = null;
    private static final String IMG_DIR = "images";
    private static final String METAMODEL_DATA = "metamodel.data";

    private Serializer() {
    }

    public static Serializer createSerializer() {
        if (instance == null) {
            instance = new Serializer();
        }

        return Serializer.instance;
    }

    
    private ZipInputStream getInputStream(String path, String name) throws FileNotFoundException, IOException {
        File f = new File(path);
        FileInputStream fis = new FileInputStream(f);
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.getName().equals(name)) {
                return zis;
            }
        }
        return null;
    }
    
    public IMModel deserialize(String path) throws IOException {

        
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setValidating(false);

        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = dbf.newDocumentBuilder();
            InputStream is = getInputStream(path, METAMODEL_DATA);
            document = builder.parse(is);
            is.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        IMModel model = new MModel(new MetamodelBuilder(), new MetamodelInfo());
        IModelBuilder b = model.getBuilder();
        model.getModel().setNameSpace(((Element)document.getElementsByTagName("model").item(0)).getAttribute("nameSpace"));
        model.getModel().setDescription(((Element)document.getElementsByTagName("model").item(0)).getAttribute("description"));

        /* relations */
        NodeList relations = document.getElementsByTagName("relation");
        for (int i = 0; i < relations.getLength(); i++) {
            Node node = relations.item(i);
            if (node instanceof Element) {
                Element eR = (Element) node;
                Relation rel = b.createRelation(eR.getAttribute("nameSpace"));
                rel.setDescription(eR.getAttribute("description"));
                rel.setSymmetric(eR.getAttribute("symetric").equals("true")?true:false);
                rel.setContainer(eR.getAttribute("container").equals("true")?true:false);
                
                /* ui */
                NodeList ui = eR.getElementsByTagName("ui");
                RelationUI rui = (RelationUI) rel.getUi();
                if (ui.item(0) != null) {
                    Element eui = (Element) ui.item(0);
                    Element lineStyle = (Element) eui.getElementsByTagName("lineStyle").item(0);
                    rui.getVisualization().setLineStyle(LineStyle.valueOf(lineStyle.getAttribute("style")));
                    Element arrowShape = (Element) eui.getElementsByTagName("arrowShape").item(0);
                    rui.getVisualization().setReferenceSourceArrow(ArrowShape.valueOf(arrowShape.getAttribute("source")));
                    rui.getVisualization().setReferenceTargetArrow(ArrowShape.valueOf(arrowShape.getAttribute("target")));
                }

                NodeList elabels = eR.getElementsByTagName("label");
                if (elabels != null && elabels.getLength() > 0) {
                    ArrayList<ConnectionLabel> labels = rui.getVisualization().getLabels();
                    for (int j = 0; j < elabels.getLength(); j++) {
                        Element elabel = (Element) elabels.item(j);
                        ConnectionLabel label = new ConnectionLabel();
                        label.setEditable(elabel.getAttribute("editable").equals("true") ? true : false);
                        label.setMovable(elabel.getAttribute("movable").equals("true") ? true : false);
                        label.setText(elabel.getAttribute("text"));
                        label.setConnectionLabelPosition(ConnectionLabelPosition.valueOf(elabel.getAttribute("labelPosition")));
                        labels.add(label);
                    }
                }

            }
        } /* relations */


        NodeList elements = document.getElementsByTagName("element");
        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                org.cvut.vrchlpet.MCore.core.Element el = b.createElement(element.getAttribute("nameSpace"));
                el.setDescription(element.getAttribute("description"));


                /* ui */
                NodeList ui = element.getElementsByTagName("ui");
                if (ui.item(0) != null) {
                    ElementUI eui = (ElementUI) el.getUi();
                    Element eeui = (Element) ui.item(0);
                    Element eborder = (Element) eeui.getElementsByTagName("border").item(0);
                    if (eborder != null) {
                        MBorder bor = new MBorder();
                        bor.setVisible(eborder.getAttribute("visible").equals("true") ? true : false);
                        bor.setResizable(eborder.getAttribute("resizable").equals("true") ? true : false);
                        eui.getVisualization().setBorder(bor);
                    }
                    Element ebackgroudcolor = (Element) eeui.getElementsByTagName("backgroundColor").item(0);
                    if (ebackgroudcolor != null) {
                        int red = Integer.parseInt(ebackgroudcolor.getAttribute("red"));
                        int green = Integer.parseInt(ebackgroudcolor.getAttribute("green"));
                        int blue = Integer.parseInt(ebackgroudcolor.getAttribute("blue"));
                        BackgroundColor bc = new BackgroundColor(new Color(red, green, blue));
                        eui.getVisualization().setBackgroundColor(bc);
                    }
                    NodeList images = document.getElementsByTagName("image");
                    for (int j = 0; j < images.getLength(); j++) {
                        Element eimage = (Element) images.item(j);
                        if (eimage.getAttribute("elementId").equals(el.getNameSpace())) {
                            InputStream is = getInputStream(path, eimage.getAttribute("img"));
                            BufferedImage img = ImageLoader.loadImage(is);
                            BackgroundImage bi = new BackgroundImage();
                            bi.setImage(img);
                            eui.getVisualization().setBackgroundImage(bi);
                            is.close();
                        }
                    }
                    NodeList elabels = element.getElementsByTagName("label");
                    if (elabels != null && elabels.getLength() > 0) {
                        ArrayList<ElementLabel> labels = eui.getVisualization().getLabels();
                        for (int j = 0; j < elabels.getLength(); j++) {
                            Element elabel = (Element) elabels.item(j);
                            ElementLabel label = new ElementLabel();
                            label.setEditable(elabel.getAttribute("editable").equals("true") ? true : false);
                            label.setMovable(elabel.getAttribute("movable").equals("true") ? true : false);
                            label.setText(elabel.getAttribute("text"));
                            label.getLabelPosition().setX(Integer.parseInt(elabel.getAttribute("x")));
                            label.getLabelPosition().setY(Integer.parseInt(elabel.getAttribute("y")));
                            label.getLabelPosition().setAbsolute(elabel.getAttribute("absolute").equals("true") ? true : false);
                            label.getLabelPosition().setLayout(Layout.valueOf(elabel.getAttribute("layout")));
                            labels.add(label);
                        }
                    }
                }


                /* attributes */
                NodeList attributes = element.getElementsByTagName("attribute");
                for (int e = 0; e < attributes.getLength(); e++) {
                    Node nodeA = attributes.item(e);
                    if (nodeA instanceof Element) {
                        Element eA = (Element) nodeA;
                        Attribute a = b.createAttribute(el, eA.getAttribute("name"));
                        a.setLowerBound(Integer.parseInt(eA.getAttribute("lowerBound")));
                        a.setUpperBound(Integer.parseInt(eA.getAttribute("upperBound")));
                        a.setName(eA.getAttribute("name"));
                        a.setEditable(eA.getAttribute("editable").equals("true") ? true : false);
                        NodeList properties = eA.getElementsByTagName("property");
                        for (int j = 0; j < properties.getLength(); j++) {
                            Node nodeP = properties.item(j);
                            if (nodeP instanceof Element) {
                                Element eP = (Element) nodeP;
                                String name = eP.getAttribute("name");
                                String dat = eP.getAttribute("type");
                                MData data = MData.getType(dat);
                                Property p = b.createProperty(a, name, data);
                                p.setLowerBound(Integer.parseInt(eP.getAttribute("lowerBound")));
                                p.setUpperBound(Integer.parseInt(eP.getAttribute("upperBound")));
                                p.setName(eP.getAttribute("name"));
                                NodeList value = eP.getElementsByTagName("value");
                                Element eV = (Element) value.item(0);
                                switch (p.getmData()) {
                                    case BOOLEAN:
                                        p.setValue(eV.getAttribute("value").equals("true") ? true : false);
                                        break;
                                    case CHARACTER:
                                        p.setValue(eV.getAttribute("value").charAt(0));
                                        break;
                                    case COLOR:
                                        int r = Integer.parseInt(eV.getAttribute("red"));
                                        int g = Integer.parseInt(eV.getAttribute("green"));
                                        int bl = Integer.parseInt(eV.getAttribute("blue"));
                                        p.setValue(new Color(r, g, bl));
                                        break;
                                    case DATE:
                                        p.setValue(new Date(Long.parseLong(eV.getAttribute("value"))));
                                        break;
                                    case DOUBLE:
                                        p.setValue(Double.parseDouble(eV.getAttribute("value")));
                                        break;
                                    case INTEGER:
                                        p.setValue(Integer.parseInt(eV.getAttribute("value")));
                                        break;
                                    case STRING:
                                        p.setValue(eV.getAttribute("value"));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                } /* attributes */




            }
        }

        Map<Integer, Reference> refs = new HashMap<Integer, Reference>();
        for (int i = 0; i < elements.getLength(); i++) {
            Node node = elements.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;


                org.cvut.vrchlpet.MCore.core.Element el = model.getModelInfo().findElement(element.getAttribute("nameSpace"));



                NodeList references = element.getElementsByTagName("reference");
                if (el != null) {
                    String superT = element.getAttribute("superType");
                    if (!superT.equals("null")) {
                        el.setSuperElement(model.getModelInfo().findElement(superT));
                    }
                    /* references */
                    x:
                    for (int e = 0; e < references.getLength(); e++) {
                        Node nodeR = references.item(e);
                        if (nodeR instanceof Element) {
                            Element eR = (Element) nodeR;
                            org.cvut.vrchlpet.MCore.core.Element elTarget = model.getModelInfo().findElement(eR.getAttribute("referenceType"));
                            Relation rel = model.getModelInfo().findRelation(eR.getAttribute("relation"));


                            if (refs.containsKey(Integer.parseInt(eR.getAttribute("id")))) {
                                Reference r = refs.get(Integer.parseInt(eR.getAttribute("id")));
                                r.getOpposite().setLowerBound(Integer.parseInt(eR.getAttribute("lowerBound")));
                                r.getOpposite().setUpperBound(Integer.parseInt(eR.getAttribute("upperBound")));
                                continue x;
                            }


                            Reference ref = null;
                            ref = b.createConnection(el, elTarget, rel);
                            ref.setLowerBound(Integer.parseInt(eR.getAttribute("lowerBound")));
                            ref.setUpperBound(Integer.parseInt(eR.getAttribute("upperBound")));
                            ref.setSource(eR.getAttribute("source").equals("true")?true:false);
                            refs.put(Integer.parseInt(eR.getAttribute("oppositeId")), ref);
                        }
                    }/* references */
                }
            }
        }





        //return Info.createRandomModel();
        return model;
    }

    public void serialize(IMModel model, String path) throws FileNotFoundException {

        FileOutputStream dest = new FileOutputStream(path);
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
        
        
        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element root = doc.createElement("model");
            doc.appendChild(root);
            appendMetaObjectData(model.getModel(), root);

            Element elements = doc.createElement("elements");
            root.appendChild(elements);
            Element relations = doc.createElement("relations");
            root.appendChild(relations);
            Element images = doc.createElement("images");
            root.appendChild(images);

            
            
            for (org.cvut.vrchlpet.MCore.core.Element el : model.getModel().getElements()) {
                elements.appendChild(createElement(doc, el, out, path));
            }


            for (Relation rel : model.getModel().getRelations()) {
                relations.appendChild(createRelation(doc, rel));
            }

            TransformerFactory tf = TransformerFactory.newInstance();


            Transformer writer = tf.newTransformer();


            writer.setOutputProperty(OutputKeys.ENCODING, "windows-1250");

            ZipEntry ze = new ZipEntry(METAMODEL_DATA);
            out.putNextEntry(ze);
            writer.transform(new DOMSource(doc), new StreamResult(out));
            out.flush();
            out.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Element createRelation(Document doc, Relation r) {
        Element rel = doc.createElement("relation");
        appendMetaObjectData(r, rel);
        rel.setAttribute("symetric", "" + r.isSymmetric());
        rel.setAttribute("container", "" + r.isContainer());

        RelationUI rui = (RelationUI) r.getUi();
        if (rui != null) {
            Element eui = doc.createElement("ui");
            rel.appendChild(eui);
            ArrayList<ConnectionLabel> labels = rui.getVisualization().getLabels();
            if (labels != null && labels.size() > 0) {
                Element elabels = doc.createElement("labels");
                eui.appendChild(elabels);
                for (ConnectionLabel l : labels) {
                    Element elabel = doc.createElement("label");
                    elabels.appendChild(elabel);
                    elabel.setAttribute("movable", "" + l.isMovable());
                    elabel.setAttribute("editable", "" + l.isEditable());
                    elabel.setAttribute("text", "" + l.getText());
                    elabel.setAttribute("labelPosition", l.getConnectionLabelPosition().toString());
                }
            }
            Element eLineStile = doc.createElement("lineStyle");
            eui.appendChild(eLineStile);
            eLineStile.setAttribute("style", rui.getVisualization().getLineStyle().toString());
            Element eArrowShape = doc.createElement("arrowShape");
            eui.appendChild(eArrowShape);
            eArrowShape.setAttribute("source", rui.getVisualization().getReferenceSourceArrow().toString());
            eArrowShape.setAttribute("target", rui.getVisualization().getReferenceTargetArrow().toString());
        }




        return rel;
    }

    private Element createElement(Document doc,
            org.cvut.vrchlpet.MCore.core.Element element, ZipOutputStream zos, String path) throws IOException {

        Element e = doc.createElement("element");
        appendMetaObjectData(element, e);
        e.setAttribute("superType", element.getSuperElement() != null ? element.getSuperElement().getNameSpace() : "null");
        e.setAttribute("model", element.getModel().getNameSpace());
        Element atts = doc.createElement("attributes");
        e.appendChild(atts);
        for (Attribute at : element.getAttributes()) {
            atts.appendChild(createAttribute(doc, at));
        }
        Element references = doc.createElement("references");
        e.appendChild(references);
        for (Reference ref : element.getReferences()) {
            references.appendChild(createReference(doc, ref));
        }

        ElementUI eui = (ElementUI) element.getUi();
        if (eui != null) {
            Element eeui = doc.createElement("ui");
            e.appendChild(eeui);
            BackgroundImage bi = eui.getVisualization().getBackgroundImage();
            if (bi != null) {
                
                String name = bi.getImgName();
                if ( !name.startsWith(element.getNameSpace()));
                    name = element.getNameSpace() + "_" + bi.getImgName();
                
                bi.setImgName(name);
                    
                ZipEntry ze = new ZipEntry(name);
                zos.putNextEntry(ze);
                ImageIO.write(bi.getImage(), "jpg", zos);
                
                NodeList images = doc.getElementsByTagName("images");
                Element eimage = doc.createElement("image");
                ((Element) images.item(0)).appendChild(eimage);
                eimage.setAttribute("elementId", element.getNameSpace());
                eimage.setAttribute("img", bi.getImgName());
                eimage.setAttribute("name", bi.getImgName());
            }
            BackgroundColor bc = eui.getVisualization().getBackgroundColor();
            if (bc != null) {
                Element backgroundColor = doc.createElement("backgroundColor");
                eeui.appendChild(backgroundColor);
                backgroundColor.setAttribute("red", "" + bc.getColor().getRed());
                backgroundColor.setAttribute("green", "" + bc.getColor().getGreen());
                backgroundColor.setAttribute("blue", "" + bc.getColor().getBlue());
            }
            MBorder border = eui.getVisualization().getBorder();
            if (border != null) {
                Element eborder = doc.createElement("border");
                eeui.appendChild(eborder);
                eborder.setAttribute("visible", "" + border.isVisible());
                eborder.setAttribute("resizable", "" + border.isResizable());
            }
            ArrayList<ElementLabel> labels = eui.getVisualization().getLabels();
            if (labels != null && labels.size() > 0) {
                Element elabels = doc.createElement("labels");
                eeui.appendChild(elabels);
                for (ElementLabel l : labels) {
                    Element elabel = doc.createElement("label");
                    elabels.appendChild(elabel);
                    elabel.setAttribute("movable", "" + l.isMovable());
                    elabel.setAttribute("editable", "" + l.isEditable());
                    elabel.setAttribute("text", "" + l.getText());
                    elabel.setAttribute("x", "" + l.getLabelPosition().getX());
                    elabel.setAttribute("y", "" + l.getLabelPosition().getY());
                    elabel.setAttribute("absolute", "" + l.getLabelPosition().isAbsolute());
                    elabel.setAttribute("layout", "" + l.getLabelPosition().getLayout().toString());
                }
            }
        }


        return e;
    }

    private Element createReference(Document doc, Reference ref) {
        Element reference = doc.createElement("reference");
        reference.setAttribute("id", "" + ref.getId());
        reference.setAttribute("lowerBound", "" + ref.getLowerBound());
        reference.setAttribute("upperBound", "" + ref.getUpperBound());
        reference.setAttribute("visible", "" + ref.isVisible());
        reference.setAttribute("source", "" + ref.isSource());
        reference.setAttribute("referenceType", ref.getReferenceType().getNameSpace());
        reference.setAttribute("owner", ref.getOwner().getNameSpace());
        reference.setAttribute("relation", ref.getRelation().getNameSpace());
        reference.setAttribute("oppositeId", "" + ref.getOpposite().getId());
        return reference;
    }

    private Element createAttribute(Document doc, Attribute at) {
        Element e = doc.createElement("attribute");
        appendStructuralFeatureData(at, e);
        Element element = doc.createElement("elementOwner");
        e.appendChild(element);
        Text el = doc.createTextNode(at.getElement().getNameSpace());
        element.appendChild(el);
        Element properties = doc.createElement("properties");
        e.appendChild(properties);
        for (Property p : at.getProperties()) {
            properties.appendChild(createProperty(doc, p));
        }
        return e;
    }

    private void appendStructuralFeatureData(StructuralFeature sf, Element e) {
        e.setAttribute("name", sf.getName());
        e.setAttribute("lowerBound", "" + sf.getLowerBound());
        e.setAttribute("upperBound", "" + sf.getUpperBound());
        e.setAttribute("editable", "" + sf.isEditable());
    }

    private Element createProperty(Document doc, Property prop) {
        Element e = doc.createElement("property");
        appendStructuralFeatureData(prop, e);
        e.setAttribute("type", prop.getmData().toString());

        Element value = doc.createElement("value");
        e.appendChild(value);
        switch (prop.getmData()) {
            case BOOLEAN:
                value.setAttribute("value", "" + (Boolean) prop.getValue());
                break;
            case CHARACTER:
                value.setAttribute("value", "" + (Character) prop.getValue());
                break;
            case COLOR:
                value.setAttribute("red", "" + ((Color) prop.getValue()).getRed());
                value.setAttribute("green", "" + ((Color) prop.getValue()).getBlue());
                value.setAttribute("blue", "" + ((Color) prop.getValue()).getGreen());
                break;
            case DATE:
                value.setAttribute("value", "" + ((Date) prop.getValue()).getTime());
                break;
            case DOUBLE:
                value.setAttribute("value", "" + ((Double) prop.getValue()));
                break;
            case INTEGER:
                value.setAttribute("value", "" + ((Integer) prop.getValue()));
                break;
            case STRING:
                value.setAttribute("value", (String) prop.getValue());
                break;
            default:
                break;
        }
        return e;
    }

    private void appendMetaObjectData(MetaObject obj, Element el) {
        el.setAttribute("nameSpace", obj.getNameSpace());
        el.setAttribute("description", obj.getDescription());
    }
}











































/*package org.cvut.vrchlpet.MSerializer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.util.Info;


public class Serializer {

    private static Serializer instance = null;

    private Serializer() {
    }

    public static Serializer createSerializer() {
        if (instance == null) {
            instance = new Serializer();
        }

        return Serializer.instance;
    }

    public IMModel deserialize(String path) {
        return Info.createRandomModel();
        try {
            
            XStream xstream2 = new XStream(new DomDriver());
            String xml2 = "";
            System.out.println(xml2);
            FileReader fr = new FileReader(new File(path));
            int ch = 0;
            while ((ch = fr.read()) != -1) {
                xml2 += (char)ch;
            }
            
            return (IMModel)xstream2.fromXML(xml2);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return Info.createRandomModel();
    }

    public void serialize(IMModel model, String path) {
            XStream xstream = new XStream();
            String xml = xstream.toXML(model);
            System.out.println(xml);
            FileOutputStream os = null;
        try {
            os = new FileOutputStream(path);
            try {
                os.write(xml.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(Serializer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

    
}
*/