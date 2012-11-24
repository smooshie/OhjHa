package ohjha;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Smoosh
 */
public class OhjHaTest {
    OhjHa ohjha;
    GUI gui;
    
    public String output;
    
    public OhjHaTest() {   
    }
    
    
    @Before
    public void setUp() {
        ohjha = new OhjHa();
        gui = new GUI();
    }

    @Test
        public void hello() {
        System.out.println("Hello!");}
}
