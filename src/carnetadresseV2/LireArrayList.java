package carnetadresseV2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LireArrayList {

  public static void main(String[] args) {

    //lecture
    ArrayList<String> arraylist= new ArrayList<String>();
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
    for(String o:arraylist)
      System.out.println(o);
  }
}