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
    public void FileDoesNotExistsReadFrom() {
        assertEquals("Filename does not exist", tiedosto.ReadFrom("tuut.txt"));
    }
    
    @Test
    public void FileDoesNotExistClean() {
        String[] cleaned = tiedosto.Clean("tuut.txt");
        assertEquals("Filename does not exist", cleaned[0]);
        assertNull(cleaned[1]);
    }
    
    @Test
    public void NameRemovesFirstCharacter() {
        assertEquals("emoved", tiedosto.Name("Removed"));
    }
    
    @Test
    public void ReadFrom() {
        assertEquals(">AAAACCCGGTAAAA", tiedosto.ReadFrom("testi.txt"));
    }
    
    @Test
    public void CleanFetchesSequence() {
        String[] cleaned = tiedosto.Clean("testi.txt");
        assertEquals("AAAA", cleaned[0]);
    }

    
    @Test
    public void CleanFetchesName() {
       String[] cleaned = tiedosto.Clean("testi.txt");
       assertEquals("AAAACCCGGT", cleaned[1]);
    }
    
    @Test
    public void CleanNoName() {
       String[] cleaned = tiedosto.Clean("noname.txt");
       assertEquals("AAAA", cleaned[0]);
       assertEquals("", cleaned[1]);
    }
  
}
