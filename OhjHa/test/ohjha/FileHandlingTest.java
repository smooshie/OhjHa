/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Smoosh
 */
public class FileHandlingTest {
    FileHandling tiedosto;
    
    public FileHandlingTest() {
    }
    
    @Before
    public void setUp() {
        tiedosto = new FileHandling();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ReadFrom() {
        assertEquals(">AAAACCCGGTAAAA", tiedosto.ReadFrom("testi.txt"));
    }
    
    @Test
    public void Clean() {
        assertEquals("AAAA", tiedosto.Clean("testi.txt"));
    }
  
}
