
package org.cvut.vrchlpet.MCore.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test modelu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelTest {
    
    public ModelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createElement method, of class Model.
     */
    @Test
    public void testCreateElement() {
        Model model = new Model();
        Element el = model.createElement();
        Element el2 = model.createElement();
        
        assertEquals(el, model.getElements().get(0));
        assertEquals(el2, model.getElements().get(1));
     
        int maxi = 1000;
        for ( int i = 0; i < 1000; i++) {
            assertNotNull(model.createElement());
        }
        
        assertTrue(model.getElements().size() == maxi + 2);
        
    }

    /**
     * Test of createRelation method, of class Model.
     */
    @Test
    public void testCreateRelation() {
        
        Model model = new Model();
        Relation rel1 = model.createRelation();
        Relation rel2 = model.createRelation();
        
        assertEquals(rel1, model.getRelations().get(0));
        assertEquals(rel2, model.getRelations().get(1));
     
        int maxi = 1000;
        for ( int i = 0; i < 1000; i++) {
            assertNotNull(model.createRelation());
        }
        
        assertTrue(model.getRelations().size() == maxi + 2);
    }
}
