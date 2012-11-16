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
    public String output;
    
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
        ohjha = new OhjHa();
        toiminto = new Toiminto();
        filehandling = new FileHandling();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    System.out.println("Hello!");}
    
    @Test
    public void newPrintables() {
        
    }
    
    @Test
    public void PrintablePrints() {
        output = null;
        String input = "Print!";
        filehandling.Printable(input, output);
    }
    
    @Test
    public void PrintableSaves() {
        output = "Test.txt";
        String input = "In file.";
        filehandling.Printable(input, output);        
    }
    
    @Test
    public void ReverseComp() {
        String input = "ACAC";
        output = toiminto.ReverseCompliment(input);
        assertEquals("GTGT", output);
    }
    
    @Test
    public void CodonsTriplets() {
        String input = "aaacccttt";
        output = toiminto.MakeCodons(input);
        assertEquals("aaa ccc ttt ", output);
    }
    
    @Test
    public void UnevenCodons() {
        String input = "aaaccct";
        output = toiminto.MakeCodons(input);
        assertEquals("aaa ccc t ", output); 
    }
    
    @Test
    public void CountNucl() {    
        String input = "atcg";
        output = toiminto.CountNucleotides(input);
        assertEquals("A's : " + 1 + " C's : " + 1 + " G's : " + 1 + " T's :" + 1 + "\nIn total: " + 4 + " nucleotides long.\nGC% is " + 50.0 +"%.",output);
    }
    
     @Test
     public void ProteinConversion() {
         String input = "aaaaaaaaa";
         output = toiminto.ProteinConversion(input);
         assertEquals("KKK", output);
     }
     
     @Test
     public void TwoProteins() {
         String input = "aaaaaaaaatgaaaaaaaaaa";
         output = toiminto.ProteinConversion(input);
         assertEquals("KKKStop\nKKK", output);
     }
     
     @Test
     public void MakeRNA() {
         String input = "GTTA";
         output = toiminto.MakeRNA(input);
         assertEquals("GUUA", output);
     }
     
      @Test
      public void FindRESite() {
          
      }
     
     
}
