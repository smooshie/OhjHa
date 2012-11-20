/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.lang.StringIndexOutOfBoundsException;
import java.util.HashMap;
import java.util.Map.Entry;

/**Kaikki toiminnot, joita kutsutaan kun painetaan nappia.
 *
 * @author Smoosh
 */
public class Toiminto {
    Tables taulut = new Tables();
    FileHandling tiedosto = new FileHandling();
    
    
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

/** Löytää restriktionendonukleaasi leikkauskohtia stringistä, vertaamalla taulukkoon jossa on sekä RE-sekvenssi, että sen nimi.
*  @param input DNA-stringi
*  @param output indeksit
*/   
    public String FindRESite(String input) {
        /** Taulukko sisältää restriktioentsyymit.
         */
        HashMap<String, String> res = taulut.RES();
        input = input.toUpperCase();
        String output = "Found : \n";
        
        for(int i=0; i<input.length(); i++) {
            for (Entry<String, String> entry: res.entrySet()) {
                try {
                    if (input.substring(i, i+entry.getKey().length()).equals(entry.getKey())) {
                            output += entry.getValue() + " at index(s) : " +i + "\n"; }
                } catch (StringIndexOutOfBoundsException e) {
                }
            }
        }
        
        if (output.length() == 9) {output += "No RES sites.";}
        return output;
    }
    
    /** Laskee kaikki aminohapot sekvenssissä ja antaa niiden koko nimen.
     * 
     * @param input inputFieldistä
     * @return output Stringi jossa kaikki aminohappojen määrät ja niiden koko nimet.
     * @throws FileNotFoundException 
     */
    public String CountProteins(String input) throws FileNotFoundException {
        /** aminoNames = Koko nimet ja lyhenne, aminoCount = määrä ja lyhenne.
         */
        HashMap<String, String> aminoNames = taulut.AminoNames();
        HashMap<String, Integer> aminoCount = taulut.AminoCount();
        String output = "";
        int total = 0;
        char[] countables = input.toCharArray();
        
        /** Laskee kaikki aminohapot.
         */
        for(char c: countables) {
           if (aminoCount.containsKey(String.valueOf(c))) {
               int summa = aminoCount.get(String.valueOf(c)) + 1;
               aminoCount.put(String.valueOf(c), summa);
           }
        }
        /** Etsii aminohappojen koko nimet ja niiden yht. summan.
         */
        for (Entry<String, Integer> entry: aminoCount.entrySet()) {
            if (aminoNames.containsKey(entry.getKey())) {
                if (entry.getValue() > 0) {
                    output += aminoNames.get(entry.getKey()) + " (" + entry.getKey() + ") :" + entry.getValue() + "\n";
                    total += entry.getValue();
                }
            }
        }
       
        output += "\nIn total : " + total + " amino acids.";
        
        return output;
    }
    
    public static void main(String[] args) {
        
    }
}
