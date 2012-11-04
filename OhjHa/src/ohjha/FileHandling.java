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
    String target;
    
    public String ReadFrom(String file) {
        try {
             Scanner scanner = new Scanner(new File(file)); 
               while (scanner.hasNextLine() ) {
                    target += scanner.nextLine();
                }
              scanner.close();
         }
         catch (FileNotFoundException e) {
              System.out.println("Filename does not exist");
         }
     return target;
    }
    
    public static void WriteTo(String output, String data) {
        try {
            
        File out = new File(output);
        PrintWriter filer = new PrintWriter(new FileWriter(output));
        filer.print(data);
        filer.close();
        System.out.println("Saved to " + output);
        
        } catch (IOException e) {
            System.out.println("Error in copying to file!");
        }
    }
    
    public static void Printable(String input, String output) {
        
        if (output == null) {
            System.out.println(input);
        } else {
            WriteTo(output, input);
        }
    }
}
