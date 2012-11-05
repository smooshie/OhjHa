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

/** args4j:n komentojen alustaminen.
 * @action muuttuja syntyy, kun komentorivistä luetaan -do. etc... 
 * @author Smoosh
 */

public class OhjHa {
   /**
    * -do -> action esim: -do rc, -do cn, ... , -do cod
    */
   @Option(name="-do", usage="Perform action.")
   private String action;
   
   /**
    * -i -> input esim: -i aaacacacac, -i testi.txt
    */
   @Option(name="-i", usage="Input string or filename.")
   private String input;
   
   /**
    * -p Hakee proteiinin...
    */
   @Option(name="-p", usage="Search for protein name from Swissprot.")
   private String prot;
   
   /*
    * -d Hakee proteiinin Ensemblistä.
    */
   @Option(name="-d", usage="Search for gene name from Ensembl-Human database.")
   private String dna;
   
   /*
    * Ouput tiedoston nimi. Jos ei määritelty, ohjelma printtaa tuloksen
    */
   @Option(name="-o", usage="Outputfile name. If no output is specified, result is printed.")
   private String output;
   
   @Option(name="-help", usage="Print commands.")
   private boolean help;
   
   private String tulos;
   private String filename;
   
   /** -do:ta seuraava toimintokäsky asetus.
    *  @param action toimintokäsky, esim "rc".
    */
   public void setAction(String action){ this.action = action; }
   
   /** -i:tä seuraava input string tai tiedostonimi asetus.
    * @param input string/tiedostonimi.
    */
   public void setInput(String input) {this.input = input;}
   
   /** -o:ta seuraava output-tiedostonimen asetus.
    * @param output tiedostonimi.
    */
   public void setOutput(String output) {this.output = output;}

   
/** Scanner lukee käyttäjän inputin. Antaa käyttäjän syöttämän komentorivin Komentoriville().
* 
*/   
   public static void main(String[] args) {
      
       OhjHa hieno = new OhjHa();
       Scanner reader = new Scanner(System.in);
       
       System.out.println("Fancy Biology Program!\nUse -i to input directly or insert filename. Use -do to perform actions. Use -o to specify output file, if not specified results are printed.");
       System.out.print("Input commands: ");
       
       String userInput = reader.nextLine();
       String[] komennot = userInput.split(" ");
       hieno.Komentorivi(komennot);
   }

/** Alustetaan muut oliot ja komentoriviparseri.
*  Parsetaan kaikki tarvittavat muuttujat.
*/   
   public void Komentorivi(String[] komennot) {
              
       CmdLineParser parser = new CmdLineParser(this);
       Toiminto toiminto = new Toiminto();
       FileHandling tiedosto = new FileHandling();
       
       try {
           parser.parseArgument(komennot);
           
           /**Luetaan target muuttujaan tiedostosta, jos -i on tiedostonimi.
            * 
            */
           if (input.contains(".fasta") == true || input.contains(".txt") == true) {
               filename = input;
               input = tiedosto.ReadFrom(input);
           }

           /** Switch-caset ohjaavat haluttuun -do actioniin!
            * 
            */
           switch (action) {
               case "rc": System.out.println("Performing reverse compliment."); //* Testi //*
                   tulos = toiminto.ReverseCompliment(input);
                   break;
                   
               case "cn": System.out.println("Performing count nucleotides.");
                   tulos = toiminto.CountNucleotides(input);
                   break;
               
               case "cod": System.out.println("Making codons.");
                   tulos = toiminto.MakeCodons(input);
                   break;
               case "clean": System.out.println("Cleaning file.");
                   tulos = tiedosto.Clean(filename);
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
