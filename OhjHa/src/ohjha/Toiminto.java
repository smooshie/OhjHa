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
    public int count;
    public String target;
    
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
    
    public int Count(String input) {
    
        return count;
    }
}
