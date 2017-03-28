/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresse;

/**
 *
 * @author Olivier
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
public class PileObject {

    private Object tab[];
    private int sommet;
    private boolean verbose = false;

    public PileObject(int taille) {
        tab = new Object[taille];
        sommet = -1;
    }

    public void empiler(Object item) {
        if (estPleine()) {
            System.out.println("Plus possible d'empiler, pile pleine.");
        } else {
            tab[++sommet] = item;
            if (verbose) {
                System.out.println(toString());
            }
        }
    }

    public Object depiler() {
        if (estVide()) {
            System.out.println("il n'y a rien à dépiler.");
            return 0;
        } else {
            sommet--;
            if (this.verbose) {
                System.out.println(toString());
            }
            return tab[sommet+1];
        }
    }

    public boolean estVide() {
        return sommet < 0;
    }

    public boolean estPleine() {
        return sommet >= tab.length - 1;
    }

    public String toString() {
        String msg = "Contenu de la pile : ";
        for (int i = 0; i <= sommet; i++) {
            msg += tab[i];
        }
        /*
        for (int k : tab) {
            msg += k;
        }
         */
        msg += " sommet = " + sommet + " taille = " + tab.length;
        return msg;
    }

    public void setVerbose() {
        verbose = true;
    }

    public void unsetVebose() {
        verbose = true;
    }

}

