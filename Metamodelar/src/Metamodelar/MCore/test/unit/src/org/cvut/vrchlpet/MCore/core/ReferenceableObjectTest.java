
package org.cvut.vrchlpet.MCore.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test referencovatelneho objektu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceableObjectTest {
    
    public ReferenceableObjectTest() {
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
     * Test of createReference method, of class ReferenceableObject.
     */
    @Test
    public void testCreateReference() {
        Element sE = new Element(); // source
        Element tE = new Element(); // target
        Relation rel = new Relation();
        
        Reference ref = sE.createReference(rel, tE);
        
        assertEquals(sE, ref.getOwner());
        assertEquals(tE, ref.getReferenceType());
        assertTrue(ref.isSource());
        assertEquals(rel, ref.getRelation());
        assertEquals(sE.getReferences().get(0), ref);
        
        int maxi = 1000;
        for ( int i = 0; i < maxi; i++) {
            assertNotNull(sE.createReference(rel, tE));
        }
        
        assertTrue(sE.getReferences().size() == maxi + 1);
        
    }
}
