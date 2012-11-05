/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Smoosh
 */
public class FileHandling {
    /** Kaikki tiedostojen käsittelyyn liittyvät metodit.
     * 
     */
    
    public String ReadFrom(String filename) {
        /** Lukee tiedostosta.
         * @param filename Käyttäjän antama tiedostonimi.
         * @return Tiedoston sisältö stringinä.
         */
        String read = "";
        
        try {
             Scanner scanner = new Scanner(new File(filename)); 
               while (scanner.hasNextLine() ) {
                    read += scanner.nextLine();
                }
              scanner.close();
         }
         catch (FileNotFoundException e) {
              System.out.println("Filename does not exist");
         }
        
     return read;
    }
    
    public void WriteTo(String output, String data) {
        /** Kirjoittaa käyttäjän määrittämään tiedostoon.
         * @param output Käyttäjän määrittämä tiedostonimi.
         * @param data Muokattu tieto.
         */
        
        try {
        PrintWriter filer = new PrintWriter(new FileWriter(output));
        filer.print(data);
        filer.close();
        System.out.println("Saved to " + output);
        
        } catch (IOException e) {
            System.out.println("Error in copying to file!");
        }
    }
    
    public void Printable(String input, String output) {
        /** Määrittää pitääkö tulostaa vai tallentaa tiedostoon.
         * @param input Muokattu tieto.
         * @param output Jos tyhjä, printtaa. Jos sisältää nimen, ohjaa WriteTo() kirjoitettavaksi.
         */
        if (output == null) {
            System.out.println(input);
        } else {
            WriteTo(output, input);
        }
    }
    
    public String Clean(String input) {
        /** Puhdistaa esim. .fasta tiedostosta rivit, jotka eivät ole biologista seknvenssiä.
         * @param input tiedostonimi.
         */
        String cleaned = "";
        try {
             Scanner cleaner = new Scanner(new File(input)); 
             while (cleaner.hasNextLine() ) {
                   String line = cleaner.nextLine();
                   if (line.startsWith(">")) {
                       System.out.println("Removed line starting with >");
                   } else {
                       cleaned += line; }
             }
             cleaner.close();
         }
         catch (FileNotFoundException e) {
              System.out.println("Filename does not exist");
         }
         return cleaned;
    }
}

