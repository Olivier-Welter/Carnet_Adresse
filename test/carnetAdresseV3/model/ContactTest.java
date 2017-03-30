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
 * @author Kévin
 */
public class ContactTest {
    
    public ContactTest() {
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
     * Test of getNom method, of class Contact.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Contact instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMssgErreur method, of class Contact.
     */
    @Test
    public void testGetMssgErreur() {
        System.out.println("getMssgErreur");
        Contact instance = null;
        String expResult = "";
        String result = instance.getMssgErreur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of infosCorrectes method, of class Contact.
     */
    @Test
    public void testInfosCorrectes() {
        System.out.println("infosCorrectes");
        Contact instance = null;
        Boolean expResult = null;
        Boolean result = instance.infosCorrectes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enregistrerContact method, of class Contact.
     */
    @Test
    public void testEnregistrerContact() {
        System.out.println("enregistrerContact");
        Contact instance = null;
        instance.enregistrerContact();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lectureFichierContact method, of class Contact.
     */
    @Test
    public void testLectureFichierContact() {
        System.out.println("lectureFichierContact");
        ArrayList<ArrayList> expResult = null;
        ArrayList<ArrayList> result = Contact.lectureFichierContact();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ecritureFichierContact method, of class Contact.
     */
    @Test
    public void testEcritureFichierContact() {
        System.out.println("ecritureFichierContact");
        ArrayList arrayEcriture = null;
        Contact instance = null;
        instance.ecritureFichierContact(arrayEcriture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
