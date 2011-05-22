
package org.cvut.vrchlpet.MEditor.controller;

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
 * Test manageru metaobjektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetaObjectManagerTest {
    
    private IModelInfo mi;
    private IModelBuilder mb;
    private IMModel mmodel;
    private IMasterController mc;
    
    
    public MetaObjectManagerTest() {
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
     * Test of changeNamespace method, of class MetaObjectManager.
     */
    @Test
    public void testChangeNamespace() {
        String ns1 = "namespace1";
        String ns2 = "namespace2";
        String ns3 = "namespace3";
        String ns4 = "namespace4";
        
        
        mc.getModelManager().addElement(ns1);
        Element el1 = mc.getMModel().getModelInfo().findElement(ns1);
        
        mc.getModelManager().addElement(ns2);
        Element el2 = mc.getMModel().getModelInfo().findElement(ns2);
        
        mc.getRelationManager().createRelation(ns3);
        Relation rel1 = mc.getMModel().getModelInfo().findRelation(ns3);
        
        mc.getRelationManager().createRelation(ns4);
        Relation rel2 = mc.getMModel().getModelInfo().findRelation(ns4);
        
        assertFalse(mc.getMetaObjectManager().changeNamespace(el1, ns2));
        assertFalse(mc.getMetaObjectManager().changeNamespace(el1, ns3));
        assertFalse(mc.getMetaObjectManager().changeNamespace(el1, ns4));
        assertFalse(mc.getMetaObjectManager().changeNamespace(el1, ""));
        assertFalse(mc.getMetaObjectManager().changeNamespace(el1, " "));
        assertTrue(mc.getMetaObjectManager().changeNamespace(el1, "  aa"));
        assertTrue(mc.getMetaObjectManager().changeNamespace(el1, "aa  "));
        assertTrue(mc.getMetaObjectManager().changeNamespace(el1, "  aa  "));
        
        assertTrue(mc.getMetaObjectManager().changeNamespace(rel2, ns1));
        assertFalse(mc.getMetaObjectManager().changeNamespace(rel2, ns2));
        assertFalse(mc.getMetaObjectManager().changeNamespace(rel2, ns3));
        assertFalse(mc.getMetaObjectManager().changeNamespace(rel2, ""));
        assertFalse(mc.getMetaObjectManager().changeNamespace(rel2, " "));
        assertTrue(mc.getMetaObjectManager().changeNamespace(rel2, "  bb"));
        assertTrue(mc.getMetaObjectManager().changeNamespace(rel2, "bb  "));
        assertTrue(mc.getMetaObjectManager().changeNamespace(rel2, "  bb  "));
    }

}
