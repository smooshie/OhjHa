/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohjha.FileHandling;
import ohjha.OhjHa;
import ohjha.Toiminto;
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
public class OhjHaTest {
    OhjHa ohjha;
    Toiminto toiminto;
    FileHandling tiedosto;
    
    public OhjHaTest() {   
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        OhjHa ohjha = new OhjHa();
        Toiminto toiminto = new Toiminto();
        FileHandling tiedosto = new FileHandling();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hello() {}
    
    @Test
    public void PrintablePrints() {
        String output = null;
        String input = "Print!";
        tiedosto.Printable(input, output);
    }
    
    @Test
    public void PrintableSaves() {
        String output = "Test.txt";
        String input = "In file.\n>A bad line\nAnother line.";
        tiedosto.Printable(input, output);        
    }
    
    
    
}
