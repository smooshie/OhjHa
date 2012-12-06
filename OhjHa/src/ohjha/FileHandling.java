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
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Kaikki tiedostojen käsittelyyn liittyvät metodit.
 * @author Smoosh
 */
public class FileHandling {
    
/** Lukee tiedostosta.
* @param filename Käyttäjän antama tiedostonimi.
* @return Tiedoston sisältö stringinä.
*/
    public String ReadFrom(String filename) {

        String read = "";
        try {
             Scanner scanner = new Scanner(new File(filename)); 
               while (scanner.hasNextLine() ) {
                    read += scanner.nextLine();
                }
              scanner.close();
         }
         catch (FileNotFoundException e) {
              return("Filename does not exist");
         }
     return read;
    }
    
/** Kirjoittaa käyttäjän määrittämään tiedostoon.
* @param output Käyttäjän määrittämä tiedostonimi.
* @param data Muokattu tieto.
*/    
    public void WriteTo(String output, String data) {

        try {
        PrintWriter filer = new PrintWriter(new FileWriter(output));
        filer.print(data);
        filer.close();
        } catch (IOException e) {
            System.out.println("Error in copying to file!");
        }
    }
    
/** Puhdistaa txt-tiedostosta rivit, jotka eivät ole biologista seknvenssiä. Tämä rivi sisältää sekvenssin nimen ja muita tietoja. Se lähetetään palautettavaksi Nimi() metodille.
* @param input tiedostonimi.
* @param cleaned puhdistettu tiedosto stringinä.
*/    
    public String[] Clean(String input) {
        String name = "";
        String cleaned = "";
        String[] returnable = new String[2];
        try {
             Scanner cleaner = new Scanner(new File(input)); 
             while (cleaner.hasNextLine() ) {
                   String line = cleaner.nextLine();
                   if (line.startsWith(">")) {
                       name = Name(line);
                       continue;
                   } else {
                       cleaned += line; }
             }
             cleaner.close();
         }
         
         catch (FileNotFoundException e) {
             returnable[0] = "Filename does not exist";
             return returnable;
         }
        
         returnable[0] = cleaned;
         returnable[1] = name;
         
         return returnable;
    }
    
    /** Poistaa nimirivistä ensimmäisen kirjaimen ja palauttaa.
     * 
     * @param namestring
     * @return 
     */
    public String Name(String namestring) {
        return namestring.substring(1);
    }

    public static void main(String[] args) {
        
    }
}

