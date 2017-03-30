/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetAdresseV3.model;

import java.util.ArrayList;
import java.util.Arrays;
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
        // Chaîne à rechercher
        String recherche = "to";
        // Tableau où effectuer la recherche
        ArrayList infosContact = new ArrayList(Arrays.asList("toto","tata","","",""));
        ArrayList listContact = new ArrayList();
        listContact.add(infosContact);
        // Tableau attendu en résultat
        ArrayList expResult = new ArrayList();
        expResult.add(Arrays.asList("toto","tata","","",""));
        // Test nouvelle instance + appel méthode
        Recherche instance = new Recherche(recherche, listContact);
        ArrayList result = instance.getListRecherche();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
    }

    /**
     * Test of getRecherche method, of class Recherche.
     */
    @Test
    public void testGetRecherche() {
        System.out.println("getRecherche");
        // Chaîne à rechercher
        String recherche = "to";
        // Tableau où effectuer la recherche
        ArrayList infosContact = new ArrayList(Arrays.asList("toto","tata","","",""));
        ArrayList listContact = new ArrayList();
        listContact.add(infosContact);
        // Tableau attendu en résultat
        String expResult = "to";
        // Test nouvelle instance + appel méthode
        Recherche instance = new Recherche(recherche, listContact);
        String result = instance.getRecherche();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
    }

    /**
     * Test of getMssgErreur method, of class Recherche.
     */
    @Test
    public void testGetMssgErreur() {
        System.out.println("getMssgErreur");
        // Chaîne à rechercher
        String recherche = "to";
        // Tableau où effectuer la recherche
        ArrayList infosContact = new ArrayList(Arrays.asList("toto","tata","","",""));
        ArrayList listContact = new ArrayList();
        listContact.add(infosContact);
        // Tableau attendu en résultat
        String expResult = null;
        // Test nouvelle instance + appel méthode
        Recherche instance = new Recherche(recherche, listContact);
        String result = instance.getMssgErreur();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
        // Chaîne à rechercher
        recherche = "";
        // Tableau attendu en résultat
        expResult = "";
        // Test nouvelle instance + appel méthode
        instance = new Recherche(recherche, listContact);
        result = instance.getMssgErreur();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
        // Chaîne à rechercher
        recherche = "tu";
        // Tableau attendu en résultat
        expResult = "Pas de résultat pour cette recherche !";
        // Test nouvelle instance + appel méthode
        instance = new Recherche(recherche, listContact);
        result = instance.getMssgErreur();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
    }

    /**
     * Test of rechercheCorrecte method, of class Recherche.
     */
    @Test
    public void testRechercheCorrecte() {
        System.out.println("rechercheCorrecte");
        // Chaîne à rechercher
        String recherche = "to";
        // Tableau où effectuer la recherche
        ArrayList infosContact = new ArrayList(Arrays.asList("toto","tata","","",""));
        ArrayList listContact = new ArrayList();
        listContact.add(infosContact);
        // Tableau attendu en résultat
        Boolean expResult = true;
        // Test nouvelle instance + appel méthode
        Recherche instance = new Recherche(recherche, listContact);
        Boolean result = instance.rechercheCorrecte();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
        // Chaîne à rechercher
        recherche = "";
        // Tableau attendu en résultat
        expResult = false;
        // Test nouvelle instance + appel méthode
        instance = new Recherche(recherche, listContact);
        result = instance.rechercheCorrecte();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
    }

    /**
     * Test of rechercheContact method, of class Recherche.
     */
    @Test
    public void testRechercheContact() {
        // Chaîne à rechercher
        String recherche = "to";
        // Tableau où effectuer la recherche
        ArrayList infosContact = new ArrayList(Arrays.asList("toto","tata","","",""));
        ArrayList listContact = new ArrayList();
        listContact.add(infosContact);
        // Tableau attendu en résultat
        ArrayList expResult = new ArrayList();
        expResult.add(Arrays.asList("toto","tata","","",""));
        // Test nouvelle instance + appel méthode
        Recherche instance = new Recherche(recherche, listContact);
        ArrayList result = instance.getListRecherche();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
        // Chaîne à rechercher
        recherche = "ta";
        // Test nouvelle instance + appel méthode
        instance = new Recherche(recherche, listContact);
        result = instance.getListRecherche();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
        // Chaîne à rechercher
        recherche = "tu";
        // Tableau attendu en résultat
        expResult = new ArrayList();
        // Test nouvelle instance + appel méthode
        instance = new Recherche(recherche, listContact);
        result = instance.getListRecherche();
        // Comparaison résultat attendus/obtenus
        assertEquals(expResult, result);
    }
    
}
