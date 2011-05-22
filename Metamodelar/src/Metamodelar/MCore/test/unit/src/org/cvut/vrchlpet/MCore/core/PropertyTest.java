
package org.cvut.vrchlpet.MCore.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test property
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyTest {
    
    public PropertyTest() {
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
     * Test of setMData method, of class Property.
     */
    @Test
    public void testSetMData() {
        
        Property p = new Property();
        
        // nastavime typ boolean
        p.setMData(MData.BOOLEAN);
        assertTrue(p.getmData() == MData.BOOLEAN);
        assertTrue(MData.BOOLEAN.getDataClass().isInstance(p.getValue()));
        
        // nastavime typ color
        p.setMData(MData.COLOR);
        
        // predchozi typ je prepsan
        assertFalse(MData.BOOLEAN.getDataClass().isInstance(p.getValue()));
        assertTrue(p.getmData() == MData.COLOR);
        
        // hodnota zmenila typ
        assertTrue(MData.COLOR.getDataClass().isInstance(p.getValue()));
        
        
        
    }


    /**
     * Test of setValue method, of class Property.
     */
    @Test
    public void testSetValue() {
        
        
        Property p = new Property();
        
        MData boolType = MData.BOOLEAN;
        MData doubleType = MData.DOUBLE;
        
        p.setMData(boolType);
        
        boolean boolVal = true;
        
        p.setValue(boolVal);
        
        double doubleVal = 0.5;
        
        try {
            p.setValue(doubleVal);
            fail("Should not get there");
        } catch (IllegalArgumentException ex) {
            assertTrue(IllegalArgumentException.class.isInstance(ex));
        }
        
        p.setMData(doubleType);
        p.setValue(doubleVal);
        
        try {
            p.setValue(boolVal);
            fail("Should not get there");
        } catch (IllegalArgumentException ex) {
            assertTrue(IllegalArgumentException.class.isInstance(ex));
        }
    }
}
