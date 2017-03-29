package carnetAdresseV3.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author Olive, Vince & Kéké
 */

public final class Contact implements Serializable {

    //private String nom, prenom, mobilePhone, fixePhone, mailPerso, mailPro, adresse;
    private ArrayList<String> infosContact ;
    private String mssgErreur = null;

    /**
     * Constructeur contact
     * @param nom
     * @param prenom
     * @param mobilePhone
     * @param fixePhone
     * @param mailPerso
     * @param mailPro
     * @param adresse
     */
    public Contact(String nom, String prenom, String mobilePhone, String fixePhone, String mailPerso, String mailPro, String adresse)
    {
        infosContact = new ArrayList(Arrays.asList(nom,prenom,mobilePhone,fixePhone,mailPerso,mailPro,adresse));
        if (infosCorrectes()) enregistrerContact();
    }
    
    /**
     * Retoune le nom du contact
     * @return 
     */
    public String getNom()
    {
        return infosContact.get(0);
    }

    /**
     * Retoune le message d'erreur s'il y en a un
     * @return 
     */
    public String getMssgErreur()
    {
        return mssgErreur;
    }

    /**
     * Vérifie si la recherche n'est pas vide
     * @return 
     */
    public Boolean infosCorrectes()
    {
        if (infosContact.get(0) == null || infosContact.get(0).isEmpty()) mssgErreur = "Il a pas de nom ce gros enculé ?!";
        else if (infosContact.get(1) == null || infosContact.get(1).isEmpty()) mssgErreur = "PD que tu es ! Pas de prénom, pas de contact !";

        return (mssgErreur == null);
    }

    /**
     * Enregistrer
     */
    public void enregistrerContact()
    {
        // Initialisation du tableau
        ArrayList listInfos = new ArrayList();
        
        // Teste si le fichier existe
        File file = new File("contact.dat");
        if(file.exists()) System.out.println("\n" + file.getAbsolutePath() + " existe déjà\n");
        else System.out.println("\nCréation de " + file.getAbsolutePath() + "\n");

        listInfos = lectureFichierContact();
        
        // Ajout des infos à enregistrer dans le tableau
        listInfos.add(infosContact);
        
        ecritureFichierContact(listInfos);
        
        System.out.println("\nEnregistrement terminé avec succès\n");
    }
    
    /**
    * Lecture du fichier contact.dat
    * @return 
    */
    public ArrayList lectureFichierContact()
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
        catch (FileNotFoundException e) { mssgErreur = "Une erreur est survenue lors de la lecture du fichier contact"; }
        catch (IOException | ClassNotFoundException e) { mssgErreur = "Une erreur est survenue lors de la lecture du fichier contact"; }
        
        return arrayLecture;
    }
    
    /**
    * Ecriture du fichier contact.dat
    * @param arrayEcriture 
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
