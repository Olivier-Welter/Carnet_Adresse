package carnetadresseV2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EcrireArrayList {

  public static void main(String[] args) {
     ArrayList al=new ArrayList();
     al.add("hello world");
     al.add("bonjour le monde");
     
     try {
       FileOutputStream fileOut = new FileOutputStream("E:\\contact.dat");
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(al);
       out.close();
       fileOut.close();
       System.out.println("\nSerialisation terminée avec succès...\n");
 
     } catch (FileNotFoundException e) {
       e.printStackTrace();
     } catch (IOException e) {
       e.printStackTrace();
     }
  }
}