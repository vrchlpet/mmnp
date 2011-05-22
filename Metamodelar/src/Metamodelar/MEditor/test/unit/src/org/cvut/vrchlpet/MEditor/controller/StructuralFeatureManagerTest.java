
package org.cvut.vrchlpet.MEditor.controller;

import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
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
 * Test structuralFeature manageru
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFeatureManagerTest {
    
    
    private IModelInfo mi;
    private IModelBuilder mb;
    private IMModel mmodel;
    private IMasterController mc;
    
    public StructuralFeatureManagerTest() {
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
     * Test of setBounds method, of class StructuralFeatureManager.
     */
    @Test
    public void testSetBounds() {
        
        String en1 = "eA";
        mc.getModelManager().addElement(en1);
        Element e1 = mc.getMModel().getModelInfo().findElement(en1);
        
        String an = "an";
        Attribute at = mc.getElementManager().createAttribute(e1, an);

        assertTrue(mc.getStructuralFeatureManager().setBounds(at, 0, 0)); // pevne dany pocet vyskytu (low = up)
        assertTrue(mc.getStructuralFeatureManager().setBounds(at, 3, 3)); // pevne dany pocet vyskytu (low = up)
        assertTrue(mc.getStructuralFeatureManager().setBounds(at, 0, 1)); // 0 - n vyskytu (n = 1 pro tento pripad)
        assertFalse(mc.getStructuralFeatureManager().setBounds(at, 1, 0)); // chyba! dolni mez je vetsi nez horni
        assertFalse(mc.getStructuralFeatureManager().setBounds(at, -1, 5)); // chyba! dolni mez < 0, min < max
        assertFalse(mc.getStructuralFeatureManager().setBounds(at, -1, -2)); // chyba! dolni mez < 0, min > max
        assertFalse(mc.getStructuralFeatureManager().setBounds(at, -1, 0)); // chyba! dolni mez < 0, min < max, max = 0
        assertFalse(mc.getStructuralFeatureManager().setBounds(at, -1, -1)); // chyba! dolni mez < 0, min = max = -1
        assertTrue(mc.getStructuralFeatureManager().setBounds(at, 0, -1)); // min = 0, max = neomezene
        assertTrue(mc.getStructuralFeatureManager().setBounds(at, 3, -1)); // min = 3, max = neomezene
        
        
    }
}
