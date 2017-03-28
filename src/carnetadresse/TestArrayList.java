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
import java.util.ArrayList;

 

public class TestArrayList {

 

  public static void main(String[] args) {

         

    ArrayList al = new ArrayList();

    al.add(new Contact("Gomez", "Michel","0652659865", "0523659874","toto@toto.com","tata@tata.com","58 rue des signe - 31 000 Toulouse"));

    al.add("Une chaîne de caractères !");

    al.add(12.20f);

    al.add('d');

                

    for(int i = 0; i < al.size(); i++)

    {

      System.out.println("donnée à l'indice " + i + " = " + al.get(i));

    }               

  }

}