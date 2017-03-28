/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetAdresseV3.model;

/**
 *
 * @author Kévin
 */
public class Recherche {
    
    private String recherche;
    private String mssgErreur = null;
    
    /**
     * Constructeur recherche la chaîne passée en paramètre
     * @param recherche
     */
    
    public Recherche(String recherche)
    {
        this.recherche = recherche;
        if (rechercheCorrecte()) rechercheContact();
    }
    
    /**
     * Retoune la chaîne recherchée
     */
    
    public String getRecherche()
    {
        return recherche;
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
    
    public Boolean rechercheCorrecte()
    {
        Boolean reponse = false;

        if ((recherche != null && !recherche.isEmpty()))
        {
            reponse = true;
        }
        else mssgErreur = "Tu n'as rien recherché sale batard !";
        
        return reponse;
    }
    
    /**
     * Recherche
     */
    
    public void rechercheContact()
    {
        // Fonction recherche contact
    }
    
}
