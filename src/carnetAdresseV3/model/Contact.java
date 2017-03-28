/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetAdresseV3.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Kévin
 */
public class Contact implements Serializable {

    private String nom, prenom, mobilePhone, fixePhone, mailPerso, mailPro, adresse;
    private String mssgErreur = null;

    /**
     * Constructeur contact
     *
     * @param nom
     */
    public Contact(String nom, String prenom, String mobilePhone, String fixePhone, String mailPerso, String mailPro, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.fixePhone = fixePhone;
        this.mobilePhone = mobilePhone;
        this.mailPerso = mailPerso;
        this.mailPro = mailPro;
        this.adresse = adresse;
        if (infosCorrectes()) {
            enregistrerContact();
        }
    }

    @Override
    public String toString() {
        return (nom + " ," + prenom + " ," + mobilePhone + " ," + fixePhone + " ," + mailPerso + " ," + mailPro + " ," + adresse);
    }

    /**
     * Retoune le nom du contact
     */

    public String getNom() {
        return nom;
    }

    /**
     * Retoune le message d'erreur s'il y en a un
     */
    public String getMssgErreur() {
        return mssgErreur;
    }

    /**
     * Vérifie si la recherche n'est pas vide
     */
    public Boolean infosCorrectes() {
        Boolean reponse = false;

        if ((nom != null && !nom.isEmpty())) {
            reponse = true;
        } else {
            mssgErreur = "Il a pas de nom ce gros enculé ?!";
        }

        return reponse;
    }

    /**
     * Enregistrer
     */
    public void enregistrerContact() {
//Lire
// ArrayList<Contact> arraylist= new ArrayList<Contact>();
        ArrayList<ArrayList> arrayparent = new ArrayList<ArrayList>();
        ArrayList<String> arrayfils = new ArrayList<String>();
        try {
            FileInputStream fileIn = new FileInputStream("E:\\contact.dat");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            arrayparent = (ArrayList) ois.readObject();
            ois.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

// enregistrement 
        arrayfils.addAll(Arrays.asList(this.nom, this.prenom));
        arrayparent.add(arrayfils);

        try {
            FileOutputStream fileOut = new FileOutputStream("E:\\contact.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(arrayparent);
            out.close();
            fileOut.close();
            System.out.println("\nSerialisation terminée avec succès...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
