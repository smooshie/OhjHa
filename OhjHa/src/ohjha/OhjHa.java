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
   
   @Option(name="-o", usage="Outputfile name.")
   private String output;
   
   public void setAction(String action){ this.action = action; }
   public void setInput(String input) {this.input = input;}
   public void setOutput(String output) {this.output = output;}

   public static void main(String[] args) {

       OhjHa t = new OhjHa();
       t.run(args);
   }


   public void run(String[] args) {
       
       CmdLineParser parser = new CmdLineParser(this);
       Toiminto toiminto = new Toiminto();
       FileHandling tiedosto = new FileHandling();
       
       try {
           parser.parseArgument(args);

           if (output == null) {
               throw new CmdLineException(parser, "No output filename given!");}
           
           //* Testi //*
           System.out.println("Testing input " + input + " on action " + action + " on output " + output);
           
           //* Luetaan target muuttujaan tiedostosta, jos -i on tiedostonimi.
           
           if (input.contains(".fasta") == true || input.contains(".txt") == true) {
               input = tiedosto.ReadFrom(input);
           }

           //* Suoritetaan pyydetty toiminto -do. //*

           switch (action) {
               case "rc": 
                   System.out.println("Performing reverse compliment."); //* Testi //*
                   String rc = toiminto.ReverseCompliment(input);
                   tiedosto.WriteTo(output, rc);
                   System.out.println("RC completed, file name " + output); //* Testi //*
                   break;
                   
               case "pm": System.out.println("Performing protein mass calculation."); break;
           }
          
           
       } catch (CmdLineException e) {
         
           System.err.println(e.getMessage());
           System.err.println("\nTester [options...] arguments...");
           parser.printUsage(System.err);
       }
   }
}
