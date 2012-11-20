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

/** Main(). Avaa GUI:n.
 * @action muuttuja syntyy, kun komentorivistä luetaan -do. etc... 
 * @author Smoosh
 */

public class OhjHa {
   
/** Alustaa GUI, avaa GUI..
* 
*/   
   public static void main(String[] args) {
      
       GUI gui = new GUI();
       gui.setVisible(true);
   }
}
