package carnetAdresseV3.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author DreamTeam
 */

public final class Contact implements Serializable {

    private ArrayList<String> infosContact ;
    private String mssgErreur = null;

    /**
     * Constructeur contact
     * @param nom nom
     * @param prenom prenom
     * @param mobilePhone mobile
     * @param fixePhone fixe
     * @param mailPerso mail perso
     * @param mailPro mail pro
     * @param adresse adresse
     */
    public Contact(String nom, String prenom, String mobilePhone, String fixePhone, String mailPerso, String mailPro, String adresse)
    {
        infosContact = new ArrayList(Arrays.asList(nom,prenom,mobilePhone,fixePhone,adresse,mailPerso,mailPro));
        if (infosCorrectes()) enregistrerContact();
    }
    
    /**
     * Retoune le nom du contact
     * @return nom
     */
    public String getNom()
    {
        return infosContact.get(0);
    }

    /**
     * Retoune le message d'erreur s'il y en a un
     * @return message d'erreur
     */
    public String getMssgErreur()
    {
        return mssgErreur;
    }

    /**
     * Vérifie si la recherche n'est pas vide
     * @return booléen
     */
    public Boolean infosCorrectes()
    {
        if (infosContact.get(0) == null || infosContact.get(0).isEmpty()) mssgErreur = "Il a pas de nom ce ptit coquinou ?!";
        else if (infosContact.get(1) == null || infosContact.get(1).isEmpty()) mssgErreur = "Grande folle ! Pas de prénom, pas de contact !";

        return (mssgErreur == null);
    }

    /**
     * Enregistrer
     */
    public void enregistrerContact()
    {
        // Initialisation du tableau
        ArrayList listInfos;
        
        // Teste si le fichier existe
        File file = new File("contact.dat");
        if(file.exists()) System.out.println("\n" + file.getAbsolutePath() + " existe déjà");
        else System.out.println("\nCréation de " + file.getAbsolutePath());

        listInfos = lectureFichierContact();
        
        // Ajout des infos à enregistrer dans le tableau
        listInfos.add(infosContact);
        
        ecritureFichierContact(listInfos);
        
        System.out.println("\nEnregistrement terminé avec succès");
    }
    
    /**
     * Lecture du fichier contact.dat
     * @return le contenu du fichier
    */
    public static ArrayList<ArrayList> lectureFichierContact()
    {
        ArrayList arrayLecture = new ArrayList();
        
        try
        {
            // Ouverture du fichier en lecture
            FileInputStream fileIn = new FileInputStream("contact.dat");
            // Désérialisation du fichier
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            // Copie du contenu du fichier dans un tableau
            arrayLecture = new ArrayList((ArrayList) ois.readObject());
            // Arrêt de la désérialisation
            ois.close();
            // Fermeture du fichier en lecture
            fileIn.close();
        }
        catch (IOException | ClassNotFoundException e) {}
        
        return arrayLecture;
    }
    
    /**
     * Ecriture du fichier contact.dat
     * @param arrayEcriture le contenu à écrire
    */
    public void ecritureFichierContact(ArrayList arrayEcriture)
    {
        try
        {
            // Ouverture fichier en écriture
            FileOutputStream fileOut = new FileOutputStream("contact.dat");
            // Sérialisation du fichier
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Remplace le contenu du fichier par celui du tableau
            out.writeObject(arrayEcriture);
            // Arrêt de la sérialisation
            out.close();
            // Fermeture du fichier en écriture
            fileOut.close();
        }
        catch (FileNotFoundException e) { mssgErreur = "Une erreur est survenue lors de l'écriture du fichier contact"; }
        catch (IOException e) { mssgErreur = "Une erreur est survenue lors de l'écriture du fichier contact"; }
    }
    
}
