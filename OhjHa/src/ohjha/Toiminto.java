/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;
import java.util.Hashtable;
import java.lang.StringIndexOutOfBoundsException;
import java.util.HashMap;
import java.util.Map.Entry;

/**Kaikki -do:n liittyvät action metodit.
 *
 * @author Smoosh
 */

public class Toiminto {
    Tables taulut = new Tables();
    FileHandling tiedosto = new FileHandling();
    public String tulos;
    
/** Switch-caset ohjaavat haluttuun -do actioniin!
 * 
 */
    public void Switch(String action, String input, String filename, String output) {
        
          switch (action) {
               case "rc": System.out.println("Performing reverse compliment.");
                   tulos = ReverseCompliment(input);
                   break;
                   
               case "cn": System.out.println("Performing count nucleotides.");
                   tulos = CountNucleotides(input);
                   break;
               
               case "cod": System.out.println("Making codons.");
                   tulos = MakeCodons(input);
                   break;
               case "clean": System.out.println("Cleaning file.");
                   tulos = tiedosto.Clean(filename);
                   break;
               case "pc": System.out.println("Protein conversion.");
                   tulos = ProteinConversion(input);
               case "res": System.out.println("Find Restriction site.");
                   tulos = FindRESite(input);
           }
           
           tiedosto.Printable(tulos, output);
    }
    
/** Tekee käänteiskomplimentin DNA-sekvenssille. )A to T, etc. ja reverse.)
*  @param input Stringi joka sisältää DNA-sekvenssin.
*  @return käänteiskomplimentti.
*/     
    public String ReverseCompliment(String input) {

        StringBuffer buffer = new StringBuffer();
        input = input.toUpperCase();

        for (char nucleotidi: input.toCharArray()) {
            switch (nucleotidi) {
                case 'A': buffer.append('T');   break;
                case 'T': buffer.append('A');   break;
                case 'C': buffer.append('G');   break;
                case 'G': buffer.append('C');   break;
            }
        }
        
        return buffer.reverse().toString();
    }

/** Lukee codoneista proteiinit eri riveille jos Stop-kodoneita löytyy.
*  @param input Stringi joka sisältää DNA-sekvenssin.
*  @param output Stringin jossa proteiinisekvenssi
*  @return output
*/     
    public String ProteinConversion(String input) {
        
        Hashtable aminos = taulut.DNA();
        input = input.toUpperCase();
        String output = "";
        
        for(int i=0; i<input.length(); i+=3) {
            try {
                if (aminos.get(input.substring(i, i+3)) == "Stop") {
                    System.out.println("Stop codon found.");
                    output += aminos.get(input.substring(i, i+3));
                    output += "\n";
                } else {
                    output += aminos.get(input.substring(i, i+3));
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Cannot form a full codon from last nucleotides. Nucleotides ignored.");
            }
        }
        return output;
    }
    
/** Laskee Stringissä olevat nukleotidit ja niihin liittyviä asioita.
*  @param input DNA-sekvenssi stringi.
*  @return Stringinä kaikki lasketut tiedot.
*/    
    public String CountNucleotides(String input) {
        
        int A = 0;
        int C = 0;
        int T = 0;
        int G = 0;
        
        input = input.toUpperCase();
        char[] countables = input.toCharArray();
        for(char c: countables) {
            if (c == 'A') {A++;}
            if (c == 'C') {C++;}
            if (c == 'G') {G++;}
            if (c == 'T') {T++;}
        }
        
        int count = A + C + G + T;
        double gc = (100*(C + G)/count);
        
        return "A's : " + A + " C's : " + C + " G's : " + G + " T's :" + T + "\nIn total: " + count + " nucleotides long.\nGC% is " + gc +"%.";
    }

/** Tekee DNA-stringille kodonirakenteen (välilyönti joka kolmannen nukleotidin jälkeen).
*  @param input DNA-stringi
*  @param codons DNA-stringi codoneilla.
*/
    public String MakeCodons(String input) {

            String codons = "";
            for(int i=0; i<input.length(); i+=3) { {
               if (i+3 < input.length()) {
                    codons += input.substring(i, i+3) + " ";}
               else {
                    codons += input.substring(i, i+(input.length()-i)) + " ";
               }
               }
            }
        return codons;
    }
    
 /** Tekee DNA-stringistä RNA-stringin.
*  @param input DNA-stringi
*  @param output RNA-stringi
*/   
    public String MakeRNA(String input) {
        String rna = "";
        input = input.toUpperCase();
        char[] searchables = input.toCharArray();
        
        for(char c: searchables) {
            if (c == 'T') {rna += "U";}
            else {rna += c;}
        }
        
        return rna;
    }

/** Löytää restriktionendonukleaasi leikkauskohtia stringistä.
*  @param input DNA-stringi
*  @param output indeksit
*/   
    public String FindRESite(String input) {

        HashMap<String, String> res = taulut.RES();
        input = input.toUpperCase();
        String output = "Found : \n";
        
        for(int i=0; i<input.length(); i++) {
            for (Entry<String, String> entry: res.entrySet()) {
                try {
                    if (input.substring(i, i+entry.getKey().length()).equals(entry.getKey())) {
                            output += entry.getValue() + " at site(s) : " + i; }
                } catch (StringIndexOutOfBoundsException e) {
                }
            }
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        
    }
}
