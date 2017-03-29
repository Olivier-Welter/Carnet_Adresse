package carnetAdresseV3.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Olive, Vince & Kéké
 */
public final class Recherche {

    private final String recherche;
    private ArrayList listRecherche;
    private String mssgErreur = null;

    /**
     * Constructeur recherche la chaîne passée en paramètre
     *
     * @param recherche
     */
    public Recherche(String recherche, ArrayList listInfos) {
        this.recherche = recherche;
        if (rechercheCorrecte()) {
            rechercheContact(listInfos);
        }
    }

    /**
     * Retoune la liste résultant de la recherche
     *
     * @return
     */
    public ArrayList getListRecherche() {
        return listRecherche;
    }

    /**
     * Retoune la chaîne recherchée
     *
     * @return
     */
    public String getRecherche() {
        return recherche;
    }

    /**
     * Retoune le message d'erreur s'il y en a un
     *
     * @return
     */
    public String getMssgErreur() {
        return mssgErreur;
    }

    /**
     * Vérifie si la recherche n'est pas vide
     *
     * @return
     */
    public Boolean rechercheCorrecte() {
        Boolean reponse = false;
        
        if ((recherche != null && !recherche.isEmpty())) {
            reponse = true;
        } else {
            mssgErreur = "Il faut renseigner le champ de recherche !";
        }

        return reponse;
    }

    /**
     * Recherche
     */
    public void rechercheContact(ArrayList listInfos) {
        // Initialisation des données pour la recherche :
        Pattern pattern;
        Matcher matcher;
        // Fonction recherche contact
        // Stocke la liste résultant de la recherche
        listRecherche = new ArrayList();
        int i;
        // Boucle de parcours de notre liste 
        for (i = 0; i < listInfos.size(); i++) {
            ArrayList ligne = (ArrayList) listInfos.get(i);
            // Affectation des valeurs pour la recherche sans sensibilité à la casse
            pattern = Pattern.compile(recherche,Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher((String)ligne.get(0));
            // Comparaison 
            if (matcher.find()) {
                // Si correspondance, ajout dans la liste 
                listRecherche.add(listInfos.get(i));
            }
        }
        // Si pas de résultat : 
        if (listRecherche.isEmpty())
            mssgErreur = "Pas de résultat pour cette recherche !";
    }
}
