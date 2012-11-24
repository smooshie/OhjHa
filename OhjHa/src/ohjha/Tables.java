/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/** Tarvittavat libraryt.
 *
 * @author Smoosh
 */
public class Tables {
    
    /** DNA-codonien aminohappovastaavuus-taulukko.
     * 
     * @return Hashtable jossa key on kodoni, value on aminohappo.
     */
    public Hashtable DNA() {
        Hashtable aminos = new Hashtable();
        
        aminos.put("CTT","L");
        aminos.put("ATG","M");
        aminos.put("ACA","T");
        aminos.put("ACG","T");
        aminos.put("ATC","I");
        aminos.put("AAC","N");
        aminos.put("ATA","I");
        aminos.put("AGG","R");
        aminos.put("CCT","P");
        aminos.put("ACT","T");
        aminos.put("AGC","S");
        aminos.put("AAG","K");
        aminos.put("AGA","R");
        aminos.put("CAT","H");
        aminos.put("AAT","N");
        aminos.put("ATT","I");
        aminos.put("CTG","L");
        aminos.put("CTA","L");
        aminos.put("CTC","L");
        aminos.put("CAC","H");
        aminos.put("AAA","K");
        aminos.put("CCG","P");
        aminos.put("AGT","S");
        aminos.put("CCA","P");
        aminos.put("CAA","Q");
        aminos.put("CCC","P");
        aminos.put("TAT","Y");
        aminos.put("GGT","G");
        aminos.put("TGT","C");
        aminos.put("CGA","R");
        aminos.put("CAG","Q");
        aminos.put("TCT","S");
        aminos.put("GAT","D");
        aminos.put("CGG","R");
        aminos.put("TTT","F");
        aminos.put("TGC","C");
        aminos.put("GGG","G");
        aminos.put("TAG","Stop");
        aminos.put("GGA","G");
        aminos.put("TAA","Stop");
        aminos.put("GGC","G");
        aminos.put("TAC","Y");
        aminos.put("TTC","F");
        aminos.put("TCG","S");
        aminos.put("TTA","L");
        aminos.put("TTG","L");
        aminos.put("TCC","S");
        aminos.put("ACC","T");
        aminos.put("TCA","S");
        aminos.put("GCA","A");
        aminos.put("GTA","V");
        aminos.put("GCC","A");
        aminos.put("GTC","V");
        aminos.put("GCG","A");
        aminos.put("GTG","V");
        aminos.put("GAG","E");
        aminos.put("GTT","V");
        aminos.put("GCT","A");
        aminos.put("TGA","Stop");
        aminos.put("GAC","D");
        aminos.put("CGT","R");
        aminos.put("TGG","W");
        aminos.put("GAA","E");
        aminos.put("CGC","R");
        
        return aminos;
    }
    
    /** RNA-kodonitaulukko.
     *  @ return RNA-kodonitaulukko.
     */
    public Hashtable RNA() {
        Hashtable rna = new Hashtable();
        
        rna.put("GUC","V");
        rna.put("ACC","T");
        rna.put("GUA","V");
        rna.put("GUG","V");
        rna.put("GUU","V");
        rna.put("AAC","N");
        rna.put("CCU","P");
        rna.put("UAU","Y");
        rna.put("UAG","Stop");
        rna.put("AGC","S");
        rna.put("ACA","T");
        rna.put("CAU","H");
        rna.put("AAU","N");
        rna.put("ACU","T");
        rna.put("CAC","H");
        rna.put("ACG","T");
        rna.put("AGU","S");
        rna.put("CCA","P");
        rna.put("CCG","P");
        rna.put("CCC","P");
        rna.put("GGU","G");
        rna.put("UCU","S");
        rna.put("AUG","M");
        rna.put("UGC","C");
        rna.put("CAG","Q");
        rna.put("GAU","D");
        rna.put("UGG","W");
        rna.put("CGG","R");
        rna.put("UCG","S");
        rna.put("AGG","R");
        rna.put("GGG","G");
        rna.put("UCC","S");
        rna.put("UCA","S");
        rna.put("UAA","Stop");
        rna.put("GGA","G");
        rna.put("UAC","Y");
        rna.put("GAC","D");
        rna.put("UGU","C");
        rna.put("AUA","I");
        rna.put("GCA","A");
        rna.put("AUC","I");
        rna.put("CUU","L");
        rna.put("GGC","G");
        rna.put("GCG","A");
        rna.put("CUG","L");
        rna.put("GAG","E");
        rna.put("AUU","I");
        rna.put("AGA","R");
        rna.put("CUA","L");
        rna.put("GCC","A");
        rna.put("AAA","K");
        rna.put("AAG","K");
        rna.put("CAA","Q");
        rna.put("UUU","F");
        rna.put("CGU","R");
        rna.put("CGC","R");
        rna.put("CGA","R");
        rna.put("GAA","E");
        rna.put("GCU","A");
        rna.put("UUG","L");
        rna.put("CUC","L");
        rna.put("UUA","L");
        rna.put("UGA","Stop");
        rna.put("UUC","F");
        
        return rna;
    }
    
    /** Taulukko, jossa on restriktioentsyymileikkauskohtia ja RE:n nimi.
     * 
     * @return RE-taulukko.
     */
    public HashMap RES() {
        HashMap res = new HashMap();
        res.put("CATATG","NdeI");
        
        return res;
    }
    
    /** Aminohappolyhenteistä koko nimet.
     * 
     * @return Aminohappokokonimi-taulukko.
     */
    public HashMap AminoNames() throws FileNotFoundException {
        HashMap aminoNames = new HashMap();
        
             Scanner scanner = new Scanner(new File("aminoNames.txt")); 
             while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] aminos = line.split("#");
                aminoNames.put(aminos[0], aminos[1]);
                }
              scanner.close();
              
        return aminoNames;
    }
    
     /** Aminohappojen määrä.
     * 
     * @return Aminohappo:määrä-taulukko.
     */
    public HashMap AminoCount() throws FileNotFoundException {
        HashMap aminoCount = new HashMap();
        
             Scanner scanner = new Scanner(new File("aminoNames.txt")); 
             while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] aminos = line.split("#");
                aminoCount.put(aminos[0], 0);
                }
              scanner.close();
              
        return aminoCount;
    }
    
    /** HashMap jossa aminohappojen monoisotooppinen massa.
     * 
     * @return aminohappo(lyhenne):massa-taulukko.
     * @throws FileNotFoundException 
     */
    public HashMap AminoWeight() throws FileNotFoundException {
        HashMap<String, Double> aminoWeight = new HashMap();
        
             Scanner scanner = new Scanner(new File("aminoWeight.txt")); 
             while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] aminos = line.split("#");
                aminoWeight.put(aminos[0], Double.parseDouble(aminos[1]));
                }
              scanner.close();
        return aminoWeight;       
        
    }
    
    public static void main(String[] args) {
        
    }
}
