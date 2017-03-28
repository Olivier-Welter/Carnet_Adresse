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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

 

public class TestArrayList {

 

  public static void main(String[] args) {

         
      //*****************************
      
      
       try {
                // enregistrement
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream ("E:\\contact.dat"));
                out.writeObject("Sauvegarde de l'ArrayList");
                out.writeObject(new Contact("Gomez", "Michel","0652659865", "0523659874","toto@toto.com","tata@tata.com","58 rue des signe - 31 000 Toulouse"));
                out.close();
                // lecture
                ObjectInputStream in = new ObjectInputStream(new FileInputStream ("E:\\contact.dat"));
                String s = (String) in.readObject();
                System.out.println(s);
                Contact p = (Contact) in.readObject();
                System.out.println(p);
                in.close();
            }
            catch (Exception e) {
                e.printStackTrace ();
            }
      
      //******************************
      
      

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