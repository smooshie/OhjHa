/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;

/**
 *
 * @author Smoosh
 */
public class Toiminto {
    
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
    
    public String CountNucleotides(String input) {
        int A = 0;
        int C = 0;
        int T = 0;
        int G = 0;
        
        char[] countables = input.toCharArray();
        for(char c: countables) {
            if (c == 'A') A++;
            if (c == 'C') C++;
            if (c == 'G') G++;
            if (c == 'T') T++;
        }
        
        int count = A + C + G + T;
        
        return "A: " + A + " C: " + C + " G: " + G + " T :" + T + "\n In total: " + count + " nucleotides long.";
    }
}
