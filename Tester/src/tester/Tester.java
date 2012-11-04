/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;
import static org.kohsuke.args4j.ExampleMode.ALL;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.BooleanOptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Smoosh
 */
public class Tester {

   @Option(name="-d", usage="Search for DNA sequence from EMBL.")
   private String host;

   @Option(name="-p", usage="Search for protein name from swissprot.")
   private int port = 80;

   @Option(name="-do", usage="Perform action.")
   private int tfjse = 80;
   
   public void setHost(String h){ this.host = h; }
   public void setPort(int p){ this.port = p; }

   public static void main(String[] args) {

       Tester t = new Tester();
       t.run(args);
   }


   public void run(String[] args) {

       CmdLineParser parser = new CmdLineParser(this);
       try {
           parser.parseArgument(args);

           //do whatever ...
           System.out.println("Testing host " + host + " on port " + port);
           
           switch() {
               case JAS:
                   asjda = new lueRivi(string);
                   break;
               case AIS:
                   
           }

       } catch (CmdLineException e) {
         
           System.err.println(e.getMessage());
           System.err.println("\nTester [options...] arguments...");
           parser.printUsage(System.err);
       }
   }
}