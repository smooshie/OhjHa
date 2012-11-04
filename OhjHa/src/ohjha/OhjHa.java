/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.util.Scanner;

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
   
   public String tulos;
   public void setAction(String action){ this.action = action; }
   public void setInput(String input) {this.input = input;}
   public void setOutput(String output) {this.output = output;}

   public static void main(String[] args) {
       
       OhjHa hieno = new OhjHa();
       Scanner reader = new Scanner(System.in);
       
       System.out.println("Fancy Biology Program!\nUse -i to input directly or insert filename. Use -do to perform actions. Use -o to specify output file, if not specified results are printed.");
       System.out.print("Input command: ");
       
       String user = reader.nextLine();
       String[] komennot = user.split(" ");
       hieno.Komentorivi(komennot);
   }

   public void Komentorivi(String[] komennot) {
       
       CmdLineParser parser = new CmdLineParser(this);
       Toiminto toiminto = new Toiminto();
       FileHandling tiedosto = new FileHandling();
       
       try {
           parser.parseArgument(komennot);
           
           //* Luetaan target muuttujaan tiedostosta, jos -i on tiedostonimi.
           
           if (input.contains(".fasta") == true || input.contains(".txt") == true) {
               input = tiedosto.ReadFrom(input);
           }

           //* Suoritetaan pyydetty toiminto -do. //*

           switch (action) {
               case "rc": System.out.println("Performing reverse compliment."); //* Testi //*
                   tulos = toiminto.ReverseCompliment(input);
                   break;
                   
               case "cn": System.out.println("Performing count nucleotides.");
                   tulos = toiminto.CountNucleotides(input);
                   break;
               
               case "cod": System.out.println("Making codons!");
                   tulos = toiminto.MakeCodons(input);
                   break;
           }
           
           tiedosto.Printable(tulos, output);
           
       } catch (CmdLineException e) {
         
           System.err.println(e.getMessage());
           System.err.println("\nTester [options...] arguments...");
           parser.printUsage(System.err);
       }
   }
}
