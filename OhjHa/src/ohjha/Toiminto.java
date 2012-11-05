/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;
import java.util.Hashtable;

/**Kaikki -do:n liittyvät action metodit.
 *
 * @author Smoosh
 */

public class Toiminto {
    
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
}
