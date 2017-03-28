/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresse;

/**
 *
 * @author Olivier
package com.ldnr.niv2.java.pilefile;


import com.ldnr.niv2.java.pilefile.PileObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
public class PileObjectDemo {
    public static void main(String args[]) {
        
        PileObject p = new PileObject(10);
        //Pile<Integer> p = new Pile<Integer>(10);
        //Pile<Indien> p = new Pile<Indien>(30);
        
        p.setVerbose();
        p.empiler("Bonjour");
        System.out.println("Valeur dépilée : " + p.depiler());
        p.empiler("Au revoir");
        p.empiler("A bientôt");
        System.out.println("Valeur dépilée : " + p.depiler());
                p.empiler(12);

        
    }    
}