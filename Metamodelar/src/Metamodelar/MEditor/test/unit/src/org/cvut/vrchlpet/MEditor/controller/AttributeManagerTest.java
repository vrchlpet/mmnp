
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
 * Test attribute manageru
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeManagerTest {
    
    private IModelInfo mi;
    private IModelBuilder mb;
    private IMModel mmodel;
    private IMasterController mc;
    
    
    public AttributeManagerTest() {
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
     * Test of changeName method, of class AttributeManager.
     */
    @Test
    public void testChangeName() {
        String elName = "el";
        mc.getModelManager().addElement(elName);
        Element el = mc.getMModel().getModelInfo().findElement(elName);
        String atName1 = "at1";
        String atName2 = "at2";
        Attribute at1 = mc.getElementManager().createAttribute(el, atName1);
        mc.getElementManager().createAttribute(el, atName2);
        
        assertFalse(mc.getAttributeManager().changeName(at1, atName2));
        assertTrue(mc.getAttributeManager().changeName(at1, "someOtherName"));
        assertFalse(mc.getAttributeManager().changeName(at1, ""));
        assertFalse(mc.getAttributeManager().changeName(at1, " "));
        assertTrue(mc.getAttributeManager().changeName(at1, "  aa"));
        assertTrue(mc.getAttributeManager().changeName(at1, "dd  "));
        assertTrue(mc.getAttributeManager().changeName(at1, "  dd  "));
    }

}
