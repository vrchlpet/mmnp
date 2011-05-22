

package org.cvut.vrchlpet.MCore.model;

import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.MData;
import org.cvut.vrchlpet.MCore.core.Model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test builderu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetamodelBuilderTest {

    private IModelInfo mi;
    private IModelBuilder mb;
    private IMModel mmodel;
    private Model model;

    public MetamodelBuilderTest() {
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
     * test predpoklada, ze ModelInfo funguje spravne (overeno testy...)
     */
    @Test
    public void testCreateElement() {
        String s1 = "A", s2 = "B";
        
        assertTrue(model.getElements().isEmpty());
        assertNull(mi.findElement(s1));
        assertNull(mi.findElement(s2));
        
        Element e1 = mb.createElement(s1);
        Element e2 = mb.createElement(s2);
        
        assertNull(mb.createElement(s1));

        assertTrue(model.getElements().size() == 2);
        assertEquals(e1, mi.findElement(s1));
        assertEquals(e2, mi.findElement(s2));
        assertEquals(s1, mi.findElement(s1).getNameSpace());
        assertEquals(s2, mi.findElement(s2).getNameSpace());
    }

    /**
     * Test of setSuperType method, of class MetamodelBuilder.
     */
    @Test
    public void testSetSuperType() {
        String s1 = "A", s2 = "B";
        Element e1 = mb.createElement(s1);
        Element e2 = mb.createElement(s2);
        
        assertFalse(mb.setSuperType(e1, e1));
        assertTrue(mb.setSuperType(e1, e2));
        assertFalse(mb.setSuperType(e2, e1));
    }
    
    @Test
    public void testSetSuperType2() {
        String s1 = "A", s2 = "B", s3 = "C";
        Element e1 = mb.createElement(s1);
        Element e2 = mb.createElement(s2);
        Element e3 = mb.createElement(s3);
        
        // nasledujici blok testuje ruzne situace a vyhodnocuje, zda se spravne
        // tvori hierarchie dedeni, respektive, zda se nepovoli vytvorit cykly
        assertFalse(mb.setSuperType(e1, e1));
        assertTrue(mb.setSuperType(e2, e1));
        assertTrue(mb.setSuperType(e3, e2));
        assertFalse(mb.setSuperType(e1, e2));
        assertFalse(mb.setSuperType(e1, e3));
        assertFalse(mb.setSuperType(e2, e3));
        assertTrue(mb.setSuperType(e3, e1));
        assertTrue(mb.setSuperType(e2, e1));
        assertFalse(mb.setSuperType(e1, e2));
        assertFalse(mb.setSuperType(e1, e3));
    }

    /**
     * Test of createRelation method, of class MetamodelBuilder.
     */
    @Test
    public void testCreateRelation() {
        String s1 = "A", s2 = "B";
        
        assertTrue(model.getRelations().isEmpty());
        assertNull(mi.findRelation(s1));
        assertNull(mi.findRelation(s2));
        
        Relation rel1 = mb.createRelation(s1);
        Relation rel2 = mb.createRelation(s2);
        
        assertNull(mb.createRelation(s1));

        assertTrue(model.getRelations().size() == 2);
        assertEquals(rel1, mi.findRelation(s1));
        assertEquals(rel2, mi.findRelation(s2));
        assertEquals(s1, mi.findRelation(s1).getNameSpace());
        assertEquals(s2, mi.findRelation(s2).getNameSpace());
    }

    /**
     * Test of createAttribute method, of class MetamodelBuilder.
     */
    @Test
    public void testCreateAttribute() {
        String s1 = "A", s2 = "B";
        Element el = mb.createElement("el");
        
        assertTrue(el.getAttributes().isEmpty());
        assertNull(mi.findAttribute(el, s1));
        assertNull(mi.findAttribute(el, s2));
        
        Attribute at1 = mb.createAttribute(el, s1);
        Attribute at2 = mb.createAttribute(el, s2);
        
        assertTrue(el.getAttributes().size() == 2);
        assertEquals(at1, mi.findAttribute(el, s1));
        assertEquals(at2, mi.findAttribute(el, s2));
        assertEquals(s1, mi.findAttribute(el, s1).getName());
        assertEquals(s2, mi.findAttribute(el, s2).getName());
    }

    /**
     * Test of createProperty method, of class MetamodelBuilder.
     */
    @Test
    public void testCreateProperty() {
        String s1 = "A", s2 = "B";
        Element el = mb.createElement("el");
        Attribute at = mb.createAttribute(el, "at");
        
        assertTrue(at.getProperties().isEmpty());
        assertNull(mi.findProperty(at, s1));
        assertNull(mi.findProperty(at, s2));
        
        Property prop1 = mb.createProperty(at, s1, MData.BOOLEAN);
        Property prop2 = mb.createProperty(at, s2, MData.BOOLEAN);
        
        assertTrue(at.getProperties().size() == 2);
        assertEquals(prop1, mi.findProperty(at, s1));
        assertEquals(prop2, mi.findProperty(at, s2));
        assertEquals(s1, mi.findProperty(at, s1).getName());
        assertEquals(s2, mi.findProperty(at, s2).getName());
    }

    /**
     * Test of createConnection method, of class MetamodelBuilder.
     */
    @Test
    public void testCreateConnection() {
        String s1 = "A", s2 = "B", s3 = "C";
        Element el1 = mb.createElement(s1);
        Element el2 = mb.createElement(s2);
        Relation rel = mb.createRelation(s3);

        Reference ref = mb.createConnection(el1, el2, rel);
        
        assertEquals(ref.getOwner(), el1);
        assertEquals(ref.getReferenceType(), el2);
        assertEquals(ref.getOpposite().getReferenceType(), el1);
        assertEquals(ref.getOpposite().getOwner(), el2);
        assertTrue(ref.isSource());
        assertFalse(ref.getOpposite().isSource());
        
    }

    /**
     * Testuje spravne mazani v hierarchii dedeni, 
     * potomci se mazou spolecne s predkem...
     */
    @Test
    public void testRemoveElement() {
        String s1 = "s1", s2 = "s2", s3 = "s3", s4 = "s4", s5 = "s5", s6 = "s6";
        
        Element e1 = mb.createElement(s1); // koren
        Element e2 = mb.createElement(s2); // potomek e1
        Element e3 = mb.createElement(s3); // potomek e1
        Element e4 = mb.createElement(s4); // potomek e3
        mb.createElement(s5);              // neni potomkem
        Element e6 = mb.createElement(s6); // potomek e3
        
        mb.setSuperType(e2, e1);
        mb.setSuperType(e3, e1);
        mb.setSuperType(e4, e3);
        mb.setSuperType(e6, e3);
        
        mb.removeElement(e6, true);
        assertNull(mi.findElement(s6));
        assertNotNull(mi.findElement(s1));
        assertNotNull(mi.findElement(s2));
        assertNotNull(mi.findElement(s3));
        assertNotNull(mi.findElement(s4));
        assertNotNull(mi.findElement(s5));
        
        
        mb.removeElement(e1, true);
        assertNull(mi.findElement(s1));
        assertNull(mi.findElement(s2));
        assertNull(mi.findElement(s3));
        assertNull(mi.findElement(s4));
        assertNull(mi.findElement(s6));
        
        assertNotNull(mi.findElement(s5));
        
    }

    
    /**
     * Testuje spravne mazani v zavislosti na kompozitnich relaci,
     * casti kontejneru se mazou spolecne s kontejnerem
     * 
     */
    @Test
    public void testRemoveElement2() {
        String s1 = "s1", s2 = "s2", s3 = "s3", s4 = "s4", s5 = "s5", s6 = "s6";
        Relation kom = mb.createRelation("kompozice");
        kom.setContainer(true);
        Element e1 = mb.createElement(s1); // kontejner
        Element e2 = mb.createElement(s2); // cast e1
        Element e3 = mb.createElement(s3); // cast e1 a kontejner
        Element e4 = mb.createElement(s4); // cast e3
        Element e5 = mb.createElement(s5); // kontejner a cast e6 - cyklus             
        Element e6 = mb.createElement(s6); // kontejner a cast e5 - cyklus 
        
        mb.createConnection(e1, e2, kom);
        mb.createConnection(e1, e3, kom);
        mb.createConnection(e3, e4, kom);
        mb.createConnection(e6, e5, kom);
        mb.createConnection(e5, e6, kom);
        
        //smazani e6 smaze i e5
        mb.removeElement(e6, true);
        assertNull(mi.findElement(s6));
        assertNull(mi.findElement(s5));
        assertNotNull(mi.findElement(s2));
        assertNotNull(mi.findElement(s3));
        assertNotNull(mi.findElement(s4));
        assertNotNull(mi.findElement(s1));
        
        //smazani e1 smaze vse ostatni
        mb.removeElement(e1, true);
        assertNull(mi.findElement(s6));
        assertNull(mi.findElement(s5));
        assertNull(mi.findElement(s2));
        assertNull(mi.findElement(s3));
        assertNull(mi.findElement(s4));
        assertNull(mi.findElement(s1));
    }
    
    /**
     * Testuje spravne mazani v zavislosti na kompozitnich relaci,
     * casti kontejneru se mazou spolecne s kontejnerem
     * 
     */
    @Test
    public void testRemoveElement3() {
        String s1 = "s1", s2 = "s2", s3 = "s3", s4 = "s4", s5 = "s5", s6 = "s6";
        Relation kom = mb.createRelation("kompozice");
        kom.setContainer(true);
        Element e1 = mb.createElement(s1); // kontejner
        Element e2 = mb.createElement(s2); // cast e1
        Element e3 = mb.createElement(s3); // cast e1 a kontejner
        Element e4 = mb.createElement(s4); // cast e3
        Element e5 = mb.createElement(s5); // kontejner a cast e6 - cyklus             
        Element e6 = mb.createElement(s6); // kontejner a cast e5 - cyklus 
        
        mb.createConnection(e1, e2, kom);
        mb.createConnection(e1, e3, kom);
        mb.createConnection(e3, e4, kom);
        mb.createConnection(e6, e5, kom);
        mb.createConnection(e5, e6, kom);
        
        //smazani e1 smaze e2, e3 a e4
        mb.removeElement(e1, true);
        assertNull(mi.findElement(s1));
        assertNull(mi.findElement(s2));
        assertNull(mi.findElement(s3));
        assertNull(mi.findElement(s4));
        assertNotNull(mi.findElement(s5));
        assertNotNull(mi.findElement(s6));
    }
    
    
    /**
     * Testuje mazani elementu, ktere maji mezi sebou relace typu kompozice a zaroven
     * se vyskytuji nekde ve strome dedicke hierarchie
     * 
     */
    @Test
    public void testRemoveElement4() {
        String s1 = "s1", s2 = "s2", s3 = "s3", s4 = "s4", s5 = "s5", s6 = "s6";
        Relation kom = mb.createRelation("kompozice");
        kom.setContainer(true);
        Element e1 = mb.createElement(s1); // kontejner
        Element e2 = mb.createElement(s2); // cast e1
        Element e3 = mb.createElement(s3); // cast e1 a kontejner
        Element e4 = mb.createElement(s4); // cast e3
        Element e5 = mb.createElement(s5); // potomek e1             
        Element e6 = mb.createElement(s6); // potomek e4
        
        mb.createConnection(e1, e2, kom);
        mb.createConnection(e1, e3, kom);
        mb.createConnection(e3, e4, kom);
        mb.setSuperType(e5, e1);
        mb.setSuperType(e6, e4);
        
        //smazani e3 smaze e4 (kompozice) a e6 (dedeni)
        mb.removeElement(e3, true);
        assertNotNull(mi.findElement(s1));
        assertNotNull(mi.findElement(s2));
        assertNull(mi.findElement(s3));
        assertNull(mi.findElement(s4));
        assertNotNull(mi.findElement(s5));
        assertNull(mi.findElement(s6));
    }
    
    
    /**
     * Testuje mazani elementu, ktere maji mezi sebou relace typu kompozice a zaroven
     * se vyskytuji nekde ve strome dedicke hierarchie
     * 
     */
    @Test
    public void testRemoveElement5() {
        String s1 = "s1", s2 = "s2", s3 = "s3", s4 = "s4", s5 = "s5", s6 = "s6";
        Relation kom = mb.createRelation("kompozice");
        kom.setContainer(true);
        Element e1 = mb.createElement(s1); // kontejner
        Element e2 = mb.createElement(s2); // cast e1
        Element e3 = mb.createElement(s3); // cast e1 a kontejner
        Element e4 = mb.createElement(s4); // cast e3
        Element e5 = mb.createElement(s5); // potomek e1             
        Element e6 = mb.createElement(s6); // potomek e4
        
        mb.createConnection(e1, e2, kom);
        mb.createConnection(e1, e3, kom);
        mb.createConnection(e3, e4, kom);
        mb.setSuperType(e5, e1);
        mb.setSuperType(e6, e4);
        
        //smazani e1 se smaze vse
        mb.removeElement(e1, true);
        assertNull(mi.findElement(s1));
        assertNull(mi.findElement(s2));
        assertNull(mi.findElement(s3));
        assertNull(mi.findElement(s4));
        assertNull(mi.findElement(s5));
        assertNull(mi.findElement(s6));
    }
    
    /**
     * Testuje smazani relace a zaroven odstraneni csech referenci, ktere 
     * pouzivali danou relaci
     */
    @Test
    public void testRemoveRelation() {
        String s1 = "A", s2 = "B", s3 = "s3", s4 = "s4", s5 = "s5", s6 = "s6";
        
        Relation rel1 = mb.createRelation(s6);
        Relation rel2 = mb.createRelation(s5);
        
        Element el1 = mb.createElement(s1); // ref1 na el2, ref2 na el4
        Element el2 = mb.createElement(s2); // ref1 na el1 , ref1 na el3
        Element el3 = mb.createElement(s3); // ref1 na el2
        Element el4 = mb.createElement(s4); // ref2 na el1
        
        mb.createConnection(el1, el2, rel1);
        mb.createConnection(el2, el3, rel1);
        mb.createConnection(el1, el4, rel2);
        
        assertTrue(el1.getReferences().size() == 2);
        assertTrue(el2.getReferences().size() == 2);
        assertTrue(el3.getReferences().size() == 1);
        assertTrue(el4.getReferences().size() == 1);
        
        
        assertNotNull(mi.findRelation(s6));
        mb.removeRelation(rel1);
        assertNull(mi.findRelation(s6));
        assertNotNull(mi.findRelation(s5));
        
        assertTrue(el1.getReferences().size() == 1);
        assertTrue(el2.getReferences().isEmpty());
        assertTrue(el3.getReferences().isEmpty());
        assertTrue(el4.getReferences().size() == 1);
        
    }

    /**
     * Otestuje, zda se smaze reference, vcetne jejiho protejsku
     */
    @Test
    public void testRemoveReference() {
        String s1 = "A", s2 = "B", s3 = "s3";
        
        Element e1 = mb.createElement(s1);
        Element e2 = mb.createElement(s2);
        Relation rel1 = mb.createRelation(s3);
        
        Reference ref_e1_to_e2 = mb.createConnection(e1, e2, rel1);
        Reference ref_e2_to_e1 = ref_e1_to_e2.getOpposite();
        
        
        assertNotNull(ref_e1_to_e2.getOpposite());
        assertNotNull(ref_e1_to_e2.getReferenceType());
        assertNotNull(ref_e1_to_e2.getOwner());
        assertNotNull(ref_e1_to_e2.getRelation());
        
        assertNotNull(ref_e2_to_e1.getOpposite());
        assertNotNull(ref_e2_to_e1.getReferenceType());
        assertNotNull(ref_e2_to_e1.getOwner());
        assertNotNull(ref_e2_to_e1.getRelation());
        
        assertTrue(e1.getReferences().size() == 1);
        assertTrue(e2.getReferences().size() == 1);
        
        
        assertFalse(mb.removeReference(e1, ref_e2_to_e1));
        assertTrue(mb.removeReference(e1, ref_e1_to_e2));
        
        assertNull(ref_e1_to_e2.getOpposite());
        assertNull(ref_e1_to_e2.getReferenceType());
        assertNull(ref_e1_to_e2.getOwner());
        assertNull(ref_e1_to_e2.getRelation());
        
        assertNull(ref_e2_to_e1.getOpposite());
        assertNull(ref_e2_to_e1.getReferenceType());
        assertNull(ref_e2_to_e1.getOwner());
        assertNull(ref_e2_to_e1.getRelation());
        
        assertTrue(e1.getReferences().isEmpty());
        assertTrue(e2.getReferences().isEmpty());
    }

}