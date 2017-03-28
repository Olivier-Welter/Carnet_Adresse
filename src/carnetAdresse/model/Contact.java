/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetAdresse.model;

/**
 *
 * @author Kévin
 */
public class Contact {
    
    private String nom;
    private String mssgErreur = null;
    
    /**
     * Constructeur contact
     * @param nom
     */
    
    public Contact(String nom)
    {
        this.nom = nom;
        if (infosCorrectes()) enregistrerContact();
    }
    
    /**
     * Retoune le nom du contact
     */
    
    public String getNom()
    {
        return nom;
    }
    
    /**
     * Retoune le message d'erreur s'il y en a un
     */
    
    public String getMssgErreur()
    {
        return mssgErreur;
    }
    
     /**
     * Vérifie si la recherche n'est pas vide
     */
    
    public Boolean infosCorrectes()
    {
        Boolean reponse = false;

        if ((nom != null && !nom.isEmpty()))
        {
            reponse = true;
        }
        else mssgErreur = "Il a pas de nom ce gros enculé ?!";
        
        return reponse;
    }
    
    /**
     * Enregistrer
     */
    
    public void enregistrerContact()
    {
        // Fonction enregistrer contact
    }
    
}
