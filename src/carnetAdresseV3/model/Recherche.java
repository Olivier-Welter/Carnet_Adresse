package carnetAdresseV3.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DreamTeam
 */
public final class Recherche {

    private final String recherche;
    private ArrayList<ArrayList> listRecherche;
    private String mssgErreur = null;

    /**
     * Constructeur recherche la chaîne passée en paramètre
     * @param recherche chaîne à chercher
     * @param listInfos tableau où chercher
     */
    public Recherche(String recherche, ArrayList listInfos) {
        this.recherche = recherche;
        if (rechercheCorrecte()) {
            rechercheContact(listInfos);
        }
    }

    /**
     * Retoune la liste résultant de la recherche
     * @return tableau résultat
     */
    public ArrayList getListRecherche() {
        return listRecherche;
    }

    /**
     * Retoune la chaîne recherchée
     * @return chaîne recherchée
     */
    public String getRecherche() {
        return recherche;
    }

    /**
     * Retoune le message d'erreur s'il y en a un
     * @return mssg erreur
     */
    public String getMssgErreur() {
        return mssgErreur;
    }

    /**
     * Vérifie si la recherche n'est pas vide
     * @return false si elle l'est
     */
    public Boolean rechercheCorrecte()
    {
        Boolean reponse = false;
        
        if ((recherche != null && !recherche.isEmpty())) reponse = true;
        else mssgErreur = "";

        return reponse;
    }

    /**
     * Fonction Recherche
     * @param listInfos contient la liste où chercher la chaîne "recherche"
     */
    public void rechercheContact(ArrayList<ArrayList> listInfos)
    {
        // Initialisation liste résultat
        listRecherche = new ArrayList();
        // Boucle de parcours de notre liste 
        for (ArrayList<String> ligne:listInfos) {
            // Affectation des valeurs pour la recherche sans sensibilité à la casse
            Pattern pattern = Pattern.compile(recherche,Pattern.CASE_INSENSITIVE);
            // Comparaison avec le nom et prénom
            Matcher matcher1 = pattern.matcher(ligne.get(0));
            Matcher matcher2 = pattern.matcher(ligne.get(1));
            // Si correspondance, ajout dans la liste 
            if (matcher1.find() || matcher2.find())
            {
                listRecherche.add(ligne);
            }
        }
        // Si pas de résultat : 
        if (listRecherche.isEmpty()) mssgErreur = "Pas de résultat pour cette recherche !";
    }
}
