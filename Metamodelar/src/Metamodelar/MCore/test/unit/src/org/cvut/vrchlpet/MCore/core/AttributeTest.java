
package org.cvut.vrchlpet.MCore.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test atributu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeTest {
    
    public AttributeTest() {
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
     * Test of createProperty method, of class Attribute.
     */
    @Test
    public void testCreateProperty() {
        Element el = new Element();
        Attribute at = el.createAttribute("atName");
        String propName = "propName";
        Property prop = at.createProperty(MData.COLOR, propName);
        
        assertNotNull(prop);
        assertEquals(prop, at.getProperties().get(0));
        assertEquals(prop.getName(), propName);
        
        int maxi = 1000;
        for ( int i = 0; i < 1000; i++) {
            assertNotNull(at.createProperty(MData.COLOR, propName + "i"));
        }
        
        assertTrue(at.getProperties().size() == maxi +1);
        
    }
}
