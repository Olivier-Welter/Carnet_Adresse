/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetAdresseV3.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    @org.junit.Test
    public void testGetNom() {
        System.out.println("getNom");
        Contact instance = new Contact("Nouveau", "Contact", "", "", "", "", "");
        String expResult = "Nouveau";
        String result = instance.getNom();
        assertEquals(expResult, result);
        removeLastContact();
    }

    /**
     * Test of getMssgErreur method, of class Contact.
     */
    @org.junit.Test
    public void testGetMssgErreur() {
        System.out.println("getMssgErreur");
        Contact instance = new Contact("", "", "", "", "", "", "");
        String expResult = "Il a pas de nom ce ptit coquinou ?!";
        String result = instance.getMssgErreur();
        assertEquals(expResult, result);
        instance = new Contact("TestAvecNom", "", "", "", "", "", "");
        expResult = "Grande folle ! Pas de prénom, pas de contact !";
        result = instance.getMssgErreur();
        assertEquals(expResult, result);
    }

    /**
     * Test of infosCorrectes method, of class Contact.
     */
    @org.junit.Test
    public void testInfosCorrectes() {
        System.out.println("infosCorrectes");
        Contact instance = new Contact("", "", "", "", "", "", "");
        Boolean expResult = false;
        Boolean result = instance.infosCorrectes();
        assertEquals(expResult, result);
        instance = new Contact("TestAvecNom", "", "", "", "", "", "");
        expResult = false;
        result = instance.infosCorrectes();
        assertEquals(expResult, result);
        instance = new Contact("TestAvecNom", "EtPrénom", "", "", "", "", "");
        expResult = true;
        result = instance.infosCorrectes();
        assertEquals(expResult, result);
        removeLastContact();
    }

    /**
     * Test of enregistrerContact method, of class Contact.
     */
    @org.junit.Test
    public void testEnregistrerContact() {
        System.out.println("enregistrerContact");
        Contact instance = new Contact("Enregistement", "Contact", "", "", "", "", "");
        instance.enregistrerContact();
        removeLastContact();
        removeLastContact();
    }

    /**
     * Test of lectureFichierContact method, of class Contact.
     */
    @org.junit.Test
    public void testLectureFichierContact() {
        System.out.println("lectureFichierContact");
        ArrayList expResult = new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("contact.dat");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            expResult = new ArrayList((ArrayList) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
        }
        ArrayList<ArrayList> result = Contact.lectureFichierContact();
        assertEquals(expResult, result);
    }

    /**
     * Test of ecritureFichierContact method, of class Contact.
     */
    @org.junit.Test
    public void testEcritureFichierContact() {
        System.out.println("ecritureFichierContact");
        ArrayList arrayEcriture = Contact.lectureFichierContact();
        try {
            // Ouverture fichier en écriture
            FileOutputStream fileOut = new FileOutputStream("contact.dat");
            // Sérialisation du fichier
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Remplace le contenu du fichier par celui du tableau
            out.writeObject(arrayEcriture);
            // Arrêt de la sérialisation
            System.out.println("Test écriture ok");
            out.close();
            // Fermeture du fichier en écriture
            fileOut.close();
        } catch (FileNotFoundException e) {
            System.out.println("Une erreur est survenue lors de l'écriture du fichier contact");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de l'écriture du fichier contact");
        }
    }

    public void removeLastContact() {
// Initialisation du tableau
        ArrayList listInfos;
// Récupération du contenu du fichier
        listInfos = Contact.lectureFichierContact();
// Suppression de la dernière ligne enregistrée
        listInfos.remove(listInfos.size() - 1);
// Enregistrement modification
        try {
// Ouverture fichier en écriture
            FileOutputStream fileOut = new FileOutputStream("contact.dat");
// Sérialisation du fichier
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
// Remplace le contenu du fichier par celui du tableau
            out.writeObject(listInfos);
// Arrêt de la sérialisation
            out.close();
// Fermeture du fichier en écriture
            fileOut.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
