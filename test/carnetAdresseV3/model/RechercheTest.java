/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetAdresseV3.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vince
 */
public class RechercheTest {
    
    public RechercheTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListRecherche method, of class Recherche.
     */
    @Test
    public void testGetListRecherche() {
        System.out.println("getListRecherche");
        Recherche instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getListRecherche();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecherche method, of class Recherche.
     */
    @Test
    public void testGetRecherche() {
        System.out.println("getRecherche");
        Recherche instance = null;
        String expResult = "";
        String result = instance.getRecherche();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMssgErreur method, of class Recherche.
     */
    @Test
    public void testGetMssgErreur() {
        System.out.println("getMssgErreur");
        Recherche instance = null;
        String expResult = "";
        String result = instance.getMssgErreur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechercheCorrecte method, of class Recherche.
     */
    @Test
    public void testRechercheCorrecte() {
        System.out.println("rechercheCorrecte");
        Recherche instance = null;
        Boolean expResult = null;
        Boolean result = instance.rechercheCorrecte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rechercheContact method, of class Recherche.
     */
    @Test
    public void testRechercheContact() {
        System.out.println("rechercheContact");
        ArrayList<ArrayList> listInfos = null;
        Recherche instance = null;
        instance.rechercheContact(listInfos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
