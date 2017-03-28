/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v4;

/**
 *
 * @author Olivier
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class lire {

  public static void main(String[] args) {

    //lecture
    ArrayList<Contact> arraylist= new ArrayList<Contact>();
    try {
      FileInputStream fileIn = new FileInputStream("E:\\contact.dat");
      ObjectInputStream ois = new ObjectInputStream(fileIn);
      arraylist = (ArrayList) ois.readObject();
      ois.close();
      fileIn.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
       e.printStackTrace();
    }

    System.out.println("Lire les données: \n");
    for(Contact o:arraylist)
      System.out.println(o);
  }
}