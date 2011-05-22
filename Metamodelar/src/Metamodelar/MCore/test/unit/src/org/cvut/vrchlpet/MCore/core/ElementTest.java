
package org.cvut.vrchlpet.MCore.core;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Test elementu
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementTest {
    
    public ElementTest() {
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
     * Test of createAttribute method, of class Element.
     */
    @Test
    public void testCreateAttribute() {
        Element el = new Element();
        String s = "atName";
        Attribute at = el.createAttribute(s);
        assertEquals(at, el.getAttributes().get(0));
        assertEquals(at.getName(), s);
        assertEquals(at.getElement(), el);
        
        int maxi = 1000;
        for ( int i = 0; i < maxi; i++) {
            assertNotNull(el.createAttribute("" + i));
        }
        
        assertTrue(el.getAttributes().size() == maxi + 1);
    }


    /**
     * Test of isDerivedFrom method, of class Element.
     */
    @Test
    public void testIsDerivedFrom() {
        Element e1 = new Element();
        Element e2 = new Element();
        Element e3 = new Element();
        Element e4 = new Element();
        Element e5 = new Element();
        Element e6 = new Element();
        
        e2.setSuperElement(e1);
        e3.setSuperElement(e2);
        e4.setSuperElement(e2);
        e6.setSuperElement(e4);
        
        
        assertTrue(e1.isDerivedFrom(e1));
        assertFalse(e1.isDerivedFrom(e2));
        assertFalse(e1.isDerivedFrom(e3));
        assertFalse(e1.isDerivedFrom(e4));
        assertFalse(e1.isDerivedFrom(e5));
        assertFalse(e1.isDerivedFrom(e6));
        
        assertTrue(e2.isDerivedFrom(e1));
        assertTrue(e2.isDerivedFrom(e2));
        assertFalse(e2.isDerivedFrom(e3));
        assertFalse(e2.isDerivedFrom(e4));
        assertFalse(e2.isDerivedFrom(e5));
        assertFalse(e2.isDerivedFrom(e6));
        
        assertTrue(e3.isDerivedFrom(e1));
        assertTrue(e3.isDerivedFrom(e2));
        assertTrue(e3.isDerivedFrom(e3));
        assertFalse(e3.isDerivedFrom(e4));
        assertFalse(e3.isDerivedFrom(e5));
        assertFalse(e3.isDerivedFrom(e6));
        
        assertTrue(e4.isDerivedFrom(e1));
        assertTrue(e4.isDerivedFrom(e2));
        assertFalse(e4.isDerivedFrom(e3));
        assertTrue(e4.isDerivedFrom(e4));
        assertFalse(e4.isDerivedFrom(e5));
        assertFalse(e4.isDerivedFrom(e6));
        
        assertFalse(e5.isDerivedFrom(e1));
        assertFalse(e5.isDerivedFrom(e2));
        assertFalse(e5.isDerivedFrom(e3));
        assertFalse(e5.isDerivedFrom(e4));
        assertTrue(e5.isDerivedFrom(e5));
        assertFalse(e5.isDerivedFrom(e6));
        
        assertTrue(e6.isDerivedFrom(e1));
        assertTrue(e6.isDerivedFrom(e2));
        assertFalse(e6.isDerivedFrom(e3));
        assertTrue(e6.isDerivedFrom(e4));
        assertFalse(e6.isDerivedFrom(e5));
        assertTrue(e6.isDerivedFrom(e6));
    }

    /**
     * Test of getAllSuperElements method, of class Element.
     */
    @Test
    public void testGetAllSuperElements() {
        
        Element e1 = new Element();
        Element e2 = new Element();
        Element e3 = new Element();
        Element e4 = new Element();
        Element e5 = new Element();
        Element e6 = new Element();
        
        e2.setSuperElement(e1);
        e3.setSuperElement(e2);
        e4.setSuperElement(e2);
        e6.setSuperElement(e4);
        
        
        ArrayList<Element> el;
        el = e1.getAllSuperElements();
        assertFalse(el.contains(e2));
        assertFalse(el.contains(e3));
        assertFalse(el.contains(e4));
        assertFalse(el.contains(e5));
        assertFalse(el.contains(e6));
        
        assertTrue(el.isEmpty());
        
        el = e2.getAllSuperElements();
        assertTrue(el.contains(e1));
        assertFalse(el.contains(e3));
        assertFalse(el.contains(e4));
        assertFalse(el.contains(e5));
        assertFalse(el.contains(e6));
        
        el = e3.getAllSuperElements();
        assertTrue(el.contains(e1));
        assertTrue(el.contains(e2));
        assertFalse(el.contains(e4));
        assertFalse(el.contains(e5));
        assertFalse(el.contains(e6));
        
        el = e4.getAllSuperElements();
        assertTrue(el.contains(e1));
        assertTrue(el.contains(e2));
        assertFalse(el.contains(e3));
        assertFalse(el.contains(e5));
        assertFalse(el.contains(e6));
        
        el = e5.getAllSuperElements();
        assertFalse(el.contains(e1));
        assertFalse(el.contains(e3));
        assertFalse(el.contains(e4));
        assertFalse(el.contains(e5));
        assertFalse(el.contains(e6));
        
        el = e6.getAllSuperElements();
        assertTrue(el.contains(e1));
        assertTrue(el.contains(e2));
        assertFalse(el.contains(e3));
        assertTrue(el.contains(e4));
        assertFalse(el.contains(e5));
    }

}
