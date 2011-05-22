
package org.cvut.vrchlpet.MCore.model;

import org.cvut.vrchlpet.MCore.core.Model;
import java.util.ArrayList;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test metamodel info komponenty
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetamodelInfoTest {

    
    private IModelInfo mi;
    private IModelBuilder mb;
    private IMModel mmodel;
    private Model model;
    
    public MetamodelInfoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        mi = new MetamodelInfo();
        mb = new MetamodelBuilder();
        mmodel = new MModel(mb, mi);
        model = mmodel.getModel();
    }

    @After
    public void tearDown() {
        model = null;
        mmodel = null;
        mb = null;
        mi = null;
    }

    /**
     * Test of isNameSpaceInUse method, of class MetamodelInfo.
     */
    @Test
    public void testIsNameSpaceInUse() {
        String a = "A", b = "B";
        assertFalse(mi.isNameSpaceInUse(a));
        assertFalse(mi.isNameSpaceInUse(b));
        assertFalse(mi.isNameSpaceInUse("c"));
        assertFalse(mi.isNameSpaceInUse(""));
        assertFalse(mi.isNameSpaceInUse(" "));


        Element el = new Element(model);
        el.setNameSpace(a);
        Relation rel = new Relation();
        rel.setNameSpace(b);

        model.getElements().add(el);
        model.getRelations().add(rel);

        assertTrue(mi.isNameSpaceInUse(a));
        assertTrue(mi.isNameSpaceInUse(b));
        assertFalse(mi.isNameSpaceInUse("c"));
        assertFalse(mi.isNameSpaceInUse(""));
        assertFalse(mi.isNameSpaceInUse(" "));
    }

    /**
     * Test of getAvailableElements method, of class MetamodelInfo.
     */
    @Test
    public void testGetAvailableElements() {
        
        ArrayList<Element> els = mi.getAvailableElements();
        assertTrue(els.size() == 0);
        
        Element el1 = new Element(model);
        Element el2 = new Element(model);
        String s1 = "A", s2 = "B";
        el1.setNameSpace(s1);
        el2.setNameSpace(s2);
        model.getElements().add(el1);
        model.getElements().add(el2);
        
        els = mi.getAvailableElements();
        assertTrue(els.size() == 2);
        
        assertEquals(els.get(0), el1);
        assertEquals(els.get(1), el2);
    }


    /**
     * Test of getAvailableRelations method, of class MetamodelInfo.
     */
    @Test
    public void testGetAvailableRelations() {
        ArrayList<Relation> rels = mi.getAvailableRelations();
        assertTrue(rels.size() == 0);
        
        Relation r1 = new Relation();
        Relation r2 = new Relation();
        String s1 = "A", s2 = "B";
        r1.setNameSpace(s1);
        r2.setNameSpace(s2);
        model.getRelations().add(r1);
        model.getRelations().add(r2);
        
        rels = mi.getAvailableRelations();
        assertTrue(rels.size() == 2);
        
        assertEquals(rels.get(0), r1);
        assertEquals(rels.get(1), r2);
    }

    /**
     * Test of findElement method, of class MetamodelInfo.
     */
    @Test
    public void testFindElement() {
        Element el1 = new Element(model);
        Element el2 = new Element(model);
        String s1 = "A", s2 = "B";
        el1.setNameSpace(s1);
        el2.setNameSpace(s2);
        
        assertNotSame(mi.findElement(s1), el1);
        assertNotSame(mi.findElement(s2), el2);
        assertNotSame(mi.findElement(""), el1);
        assertNotSame(mi.findElement("C"), el1);
        
        
        
        model.getElements().add(el1);
        model.getElements().add(el2);
        
        assertEquals(el1, mi.findElement(s1));
        assertEquals(el2, mi.findElement(s2));
        assertNotSame(mi.findElement(s2), el1);
        assertNotSame(mi.findElement(""), el1);
        assertNotSame(mi.findElement("C"), el1);
    }

    /**
     * Test of findRelation method, of class MetamodelInfo.
     */
    @Test
    public void testFindRelation() {
        Relation rel1 = new Relation();
        Relation rel2 = new Relation();
        String s1 = "A", s2 = "B";
        rel1.setNameSpace(s1);
        rel2.setNameSpace(s2);
        
        assertNotSame(mi.findRelation(s1), rel1);
        assertNotSame(mi.findRelation(s2), rel2);
        assertNotSame(mi.findRelation(""), rel1);
        assertNotSame(mi.findRelation("C"), rel1);
        
        
        
        model.getRelations().add(rel1);
        model.getRelations().add(rel2);
        
        assertEquals(rel1, mi.findRelation(s1));
        assertEquals(rel2, mi.findRelation(s2));
        assertNotSame(mi.findRelation(s2), rel1);
        assertNotSame(mi.findRelation(""), rel1);
        assertNotSame(mi.findRelation("C"), rel1);
    }

    /**
     * Test of findAttribute method, of class MetamodelInfo.
     */
    @Test
    public void testFindAttribute() {
        Element el = new Element(model);
        String s1 = "A", s2 = "B";
        Attribute at1 = new Attribute(el);
        Attribute at2 = new Attribute(el);
        at1.setName(s1);
        at2.setName(s2);
        
        assertNotSame(at1, mi.findAttribute(el, s1));
        assertNotSame(at2, mi.findAttribute(el, s2));
        assertNotSame(at2, mi.findAttribute(el, ""));
        
        el.getAttributes().add(at1);
        el.getAttributes().add(at2);
        
        
        
        assertEquals(at1, mi.findAttribute(el, s1));
        assertEquals(at2, mi.findAttribute(el, s2));
        assertNotSame(at1, mi.findAttribute(el, s2));
        assertNotSame(at2, mi.findAttribute(el, s1));
        assertNotSame(at2, mi.findAttribute(el, ""));
    }

    /**
     * Test of findProperty method, of class MetamodelInfo.
     */
    @Test
    public void testFindProperty() {
        Element el = new Element(model);
        String s1 = "A", s2 = "B";
        Attribute at = new Attribute(el);
        Property p1 = new Property();
        Property p2 = new Property();
        p1.setName(s1);
        p2.setName(s2);
        
        assertNotSame(p1, mi.findProperty(at, s1));
        assertNotSame(p1, mi.findProperty(at, s2));
        assertNotSame(p2, mi.findProperty(at, ""));
        
        at.getProperties().add(p1);
        at.getProperties().add(p2);
        
        
        
        assertEquals(p1, mi.findProperty(at, s1));
        assertEquals(p2, mi.findProperty(at, s2));
        assertNotSame(p1, mi.findProperty(at, s2));
        assertNotSame(p2, mi.findProperty(at, s1));
        assertNotSame(p2, mi.findProperty(at, ""));
        
    }

}