package carnetAdresseV3.model;

/**
 * @author Olive, Vince & Kéké
 */

public final class Recherche {
    
    private final String recherche;
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
     * @return 
     */
    
    public String getRecherche()
    {
        return recherche;
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
