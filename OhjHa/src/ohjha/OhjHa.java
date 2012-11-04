/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 *
 * @author Smoosh
 */
public class OhjHa {
    
   @Option(name="-do", usage="Perform action.")
   private String action;
   
   @Option(name="-i", usage="Input string or filename.")
   private String input;
   
   @Option(name="-p", usage="Search for protein name from Swissprot.")
   private String prot;
   
   @Option(name="-d", usage="Search for gene name from EMBL.")
   private String dna;
   
   @Option(name="-o", usage="Outputfile name. If no output is specified, result is printed.")
   private String output;
   
   @Option(name="-help", usage="Print commands.")
   private boolean help;
   
   public void setAction(String action){ this.action = action; }
   public void setInput(String input) {this.input = input;}
   public void setOutput(String output) {this.output = output;}

   public static void main(String[] args) {
       
       OhjHa hieno = new OhjHa();
       hieno.Komentorivi(args);
   }

   public void Komentorivi(String[] args) {
       
       CmdLineParser parser = new CmdLineParser(this);
       Toiminto toiminto = new Toiminto();
       FileHandling tiedosto = new FileHandling();
       
       try {
           parser.parseArgument(args);
           
           //* Luetaan target muuttujaan tiedostosta, jos -i on tiedostonimi.
           
           if (input.contains(".fasta") == true || input.contains(".txt") == true) {
               input = tiedosto.ReadFrom(input);
           }

           //* Suoritetaan pyydetty toiminto -do. //*

           switch (action) {
               case "rc": 
                   System.out.println("Performing reverse compliment."); //* Testi //*
                   String rc = toiminto.ReverseCompliment(input);
                   tiedosto.Printable(rc, output);
                   break;
                   
               case "cn": System.out.println("Performing count nucleotides!");
                    String count = toiminto.CountNucleotides(input);
                    tiedosto.Printable(count, output);
                    break;
           }
          
           
       } catch (CmdLineException e) {
         
           System.err.println(e.getMessage());
           System.err.println("\nTester [options...] arguments...");
           parser.printUsage(System.err);
       }
   }
}
