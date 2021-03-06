/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;

import java.io.FileNotFoundException;
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
public class ToimintoTest {
    Toiminto toiminto; 
    
    public ToimintoTest() {
    }
    
    @Before
    public void setUp() {
       toiminto = new Toiminto();
    }
    
    @Test
    public void ReverseComp() {
        assertEquals("GTGT", toiminto.ReverseCompliment("ACAC"));
    }
    
    @Test
    public void ReverseCompLowerCase() {
        assertEquals("GTGT", toiminto.ReverseCompliment("acac"));
    }   
    
    @Test
    public void CodonsTriplets() {
        assertEquals("aaa ccc ttt ", toiminto.MakeCodons("aaacccttt"));
    }
    
    @Test
    public void UnevenCodons() {
        assertEquals("aaa ccc t ", toiminto.MakeCodons("aaaccct"));
    }
    
    @Test
    public void CountNucl() {    
        assertEquals("A's : " + 1 + " C's : " + 1 + " G's : " + 1 + " T's :" + 1 + "\nIn total: " + 4 + " nucleotides long.\nGC% is " + 50.0 +"%.",toiminto.CountNucleotides("atcg"));
    }
    
     @Test
     public void ProteinConversion() {
         assertEquals("KKK", toiminto.ProteinConversion("AAAAAAAAA"));
     }
    
     @Test
     public void ProteinConversionLowercase() {
         assertEquals("KKK", toiminto.ProteinConversion("aaaaaaaaa"));
     }
     
     @Test
     public void TwoProteins() {
         assertEquals("KKKStop\nKKK", toiminto.ProteinConversion("aaaaaaaaatgaaaaaaaaaa"));
     }
     
     @Test
     public void ProteinConversionJustStop() {
         assertEquals("Stop\n", toiminto.ProteinConversion("tga"));
     }
     
     @Test
     public void MakeRNA() {
         assertEquals("GUUA", toiminto.MakeRNA("GTTA"));
     }
     
     @Test
     public void MakeRNALowercase() {
         assertEquals("GUUA", toiminto.MakeRNA("gtta"));
     }
     
      @Test
      public void FindRESite1() {
         assertEquals("Found : \nNdeI at index(s) : 3\n", toiminto.FindRESite("AAACATATGAAA"));          
      }
      
      @Test
      public void FindRESite1LowerCase() {
         assertEquals("Found : \nNdeI at index(s) : 3\n", toiminto.FindRESite("aaacatatgaaa"));          
      }
     
      @Test
      public void FindNoRESite() {
         assertEquals("Found : \nNo RES sites.", toiminto.FindRESite("aaaaaa"));          
      }
      
      @Test
      public void CountAAs() throws FileNotFoundException {
         assertEquals("Lysine (K) :3\n\nIn total : 3 amino acids.", toiminto.CountProteins("KKK"));                   
      }
      
      @Test
      public void CountAAsLowerCase() throws FileNotFoundException {
         assertEquals("Lysine (K) :3\n\nIn total : 3 amino acids.", toiminto.CountProteins("kkk"));                   
      }
      
      @Test
      public void NoAAsInCount() throws FileNotFoundException {
          assertEquals("\nIn total : 0 amino acids.", toiminto.CountProteins("X"));    
      }
      
      @Test
      public void ProteinMassOne() throws FileNotFoundException {
          assertEquals("Monoisotopic mass is: 71.03711", toiminto.ProteinMass("A"));
      }
      
      @Test
      public void ProteinMassOneLowercase() throws FileNotFoundException {
          assertEquals("Monoisotopic mass is: 71.03711", toiminto.ProteinMass("a"));
      }
      
      @Test
      public void ProteinMassNotAProtein() throws FileNotFoundException {
          assertEquals("Monoisotopic mass is: 0.0", toiminto.ProteinMass("X"));
      }
      
      @Test
      public void FindOnce() {
          assertEquals("Found AB at index: 0-2\n", toiminto.Find("ABCD", "AB"));
      }
      
      @Test
      public void FindNone() {
          assertEquals("Did not find occurrence of CC", toiminto.Find("ABCD", "CC"));
      }
      
      @Test
      public void FindTwo() {
          assertEquals("Found CC at index: 0-2\nFound CC at index: 1-3\n", toiminto.Find("CCCC", "CC"));
      }
      
      @Test
      public void Compare() {
          assertEquals("C for A at index 3\n\nTotal differences : 1", toiminto.Compare("CCCC", "CCCA"));
      }
      
      @Test
      public void CompareShorter() {
          assertEquals("C for A at index 2\n\nComparable is 1 characters shorted than input.\n\nTotal differences : 2", toiminto.Compare("CCCC", "CCA"));
      }
      
      @Test
      public void CompareSame() {
          assertEquals("No difference.", toiminto.Compare("AAAA", "AAAA"));
      }
      
}
