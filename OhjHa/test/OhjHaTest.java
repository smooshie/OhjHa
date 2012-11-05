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
    FileHandling filehandling;
    
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
        FileHandling filehandling = new FileHandling();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    System.out.println("Hello!");}
    
    @Test
    public void PrintablePrints() {
        String output = null;
        String input = "Print!";
        filehandling.Printable(input, output);
    }
    
    @Test
    public void PrintableSaves() {
        String output = "Test.txt";
        String input = "In file.";
        filehandling.Printable(input, output);        
    }
    
    @Test
    public void ReverseComp() {
        String input = "ACAC";
        String gtgt = toiminto.ReverseCompliment(input);
        assertEquals("GTGT", gtgt);
    }
    
    @Test
    public void CodonsTriplets() {
        String input = "aaacccttt";
        String codons = toiminto.MakeCodons(input);
        assertEquals("aaa ccc ttt", codons);
    }
    
    @Test
    public void UnevenCodons() {
        String input = "aaaccct";
        String codons = toiminto.MakeCodons(input);
        assertEquals("aaa ccc t", codons); 
    }
    
    @Test
    public void CountNucl() {    
        String input = "atcg";
        String output = toiminto.CountNucleotides(input);
        assertEquals("A's : " + 1 + " C's : " + 1 + " G's : " + 1 + " T's :" + 1 + "\nIn total: " + 4 + " nucleotides long.\nGC% is " + 50.0 +"%.",input);
    }
}
