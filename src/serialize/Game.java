/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialize;

import java.io.Serializable;


public class Game implements Serializable{

  private String nom, style;

  private double prix;

    

  public Game(String nom, String style, double prix) {

    this.nom = nom;

    this.style = style;

    this.prix = prix;

  }

    

  @Override
  public String toString(){

    return "Nom du jeu : " + this.nom + "\nStyle de jeu : " + this.style + "\n Prix du jeu : " + this.prix + "\n";

  } 

}