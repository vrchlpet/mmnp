
package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.model.IMModel;
import org.cvut.vrchlpet.MCore.model.IModelBuilder;
import org.cvut.vrchlpet.MCore.model.IModelInfo;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.cvut.vrchlpet.MCore.model.MetamodelBuilder;
import org.cvut.vrchlpet.MCore.model.MetamodelInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test manageru referenci
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceManagerTest {
    
    private IModelInfo mi;
    private IModelBuilder mb;
    private IMModel mmodel;
    private IMasterController mc;
    
    
    public ReferenceManagerTest() {
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
        mc = new MasterController(mmodel, "");
    }
    
    @After
    public void tearDown() {
        mmodel = null;
        mb = null;
        mi = null;
        mc = null;
    }

    /**
     * Test of setRelatoin method, of class ReferenceManager.
     */
    @Test
    public void testSetRelatoin() {
        Relation rel = new Relation();
        
        String rn1 = "rA";
        mc.getRelationManager().createRelation(rn1);
        Relation rel1 = mc.getMModel().getModelInfo().findRelation(rn1);
        String rn2 = "rb";
        mc.getRelationManager().createRelation(rn2);
        Relation rel2 = mc.getMModel().getModelInfo().findRelation(rn2);
        
        String en1 = "eA", en2 = "eB";
        mc.getModelManager().addElement(en1);
        mc.getModelManager().addElement(en2);
        Element e1 = mc.getMModel().getModelInfo().findElement(en1);
        Element e2 = mc.getMModel().getModelInfo().findElement(en2);
        
        Reference ref = mc.getElementManager().makeConnection(e1, e2, rn1);
        
        assertEquals(ref.getRelation(), rel1);
        assertEquals(ref.getOpposite().getRelation(), rel1);
        
        assertTrue(mc.getReferenceManger().setRelatoin(ref, rel2));
        
        assertEquals(ref.getRelation(), rel2);
        assertEquals(ref.getOpposite().getRelation(), rel2);
        
        
        assertFalse(mc.getReferenceManger().setRelatoin(ref, rel)); // nepovolime nastavit neregistrovanou relaci
        assertNotSame(ref.getRelation(), rel);
        assertNotSame(ref.getOpposite().getRelation(), rel);
        assertEquals(ref.getRelation(), rel2);
        assertEquals(ref.getOpposite().getRelation(), rel2);
    }


    /**
     * Test of setSource method, of class ReferenceManager.
     */
    @Test
    public void testSetSource() {
        String rn1 = "rA";
        mc.getRelationManager().createRelation(rn1);
        mc.getMModel().getModelInfo().findRelation(rn1);
        
        String en1 = "eA", en2 = "eB";
        mc.getModelManager().addElement(en1);
        mc.getModelManager().addElement(en2);
        Element e1 = mc.getMModel().getModelInfo().findElement(en1);
        Element e2 = mc.getMModel().getModelInfo().findElement(en2);
        
        Reference ref = mc.getElementManager().makeConnection(e1, e2, rn1);
        Reference refOpposite = ref.getOpposite();
        
        assertTrue(ref.isSource());
        assertFalse(refOpposite.isSource());
        
        mc.getReferenceManger().setSource(ref, false);
        
        assertFalse(ref.isSource());
        assertTrue(refOpposite.isSource());
        
        mc.getReferenceManger().setSource(ref, false);
        
        assertFalse(ref.isSource());
        assertTrue(refOpposite.isSource());
        
        mc.getReferenceManger().setSource(refOpposite, false);
        
        assertTrue(ref.isSource());
        assertFalse(refOpposite.isSource());
        
    }


    /**
     * Test of setBounds method, of class ReferenceManager.
     */
    @Test
    public void testSetBounds() {
        String rn1 = "rA";
        mc.getRelationManager().createRelation(rn1);
        mc.getMModel().getModelInfo().findRelation(rn1);
        
        String en1 = "eA", en2 = "eB";
        mc.getModelManager().addElement(en1);
        mc.getModelManager().addElement(en2);
        Element e1 = mc.getMModel().getModelInfo().findElement(en1);
        Element e2 = mc.getMModel().getModelInfo().findElement(en2);
        
        Reference ref = mc.getElementManager().makeConnection(e1, e2, rn1);

        assertTrue(mc.getReferenceManger().setBounds(ref, 0, 0)); // pevne dany pocet vyskytu (low = up)
        assertTrue(mc.getReferenceManger().setBounds(ref, 3, 3)); // pevne dany pocet vyskytu (low = up)
        assertTrue(mc.getReferenceManger().setBounds(ref, 0, 1)); // 0 - n vyskytu (n = 1 pro tento pripad)
        assertFalse(mc.getReferenceManger().setBounds(ref, 1, 0)); // chyba! dolni mez je vetsi nez horni
        assertFalse(mc.getReferenceManger().setBounds(ref, -1, 5)); // chyba! dolni mez < 0, min < max
        assertFalse(mc.getReferenceManger().setBounds(ref, -1, -2)); // chyba! dolni mez < 0, min > max
        assertFalse(mc.getReferenceManger().setBounds(ref, -1, 0)); // chyba! dolni mez < 0, min < max, max = 0
        assertFalse(mc.getReferenceManger().setBounds(ref, -1, -1)); // chyba! dolni mez < 0, min = max = -1
        assertTrue(mc.getReferenceManger().setBounds(ref, 0, -1)); // min = 0, max = neomezene
        assertTrue(mc.getReferenceManger().setBounds(ref, 3, -1)); // min = 3, max = neomezene
        
    }
}
