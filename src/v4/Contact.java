package v4;

import java.io.*;
import java.util.ArrayList;

class Contact implements Serializable {

    String nom, prenom, mobilePhone, fixePhone, mailPerso, mailPro, adresse;

    Contact(String nom, String prenom, String mobilePhone, String fixePhone, String mailPerso, String mailPro, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.fixePhone = fixePhone;
        this.mobilePhone = mobilePhone;
        this.mailPerso = mailPerso;
        this.mailPro = mailPro;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return (nom + " ," + prenom + " ," + mobilePhone + " ," + fixePhone + " ," + mailPerso + " ," + mailPro + " ," + adresse);
    }

    public void main() {
        
        //Lire
        
         ArrayList<Contact> arraylist= new ArrayList<Contact>();
    try {
      FileInputStream fileIn = new FileInputStream("E:\\contact.dat");
      ObjectInputStream ois = new ObjectInputStream(fileIn);
      arraylist = (ArrayList) ois.readObject();
      ois.close();
      fileIn.close();
     
    } catch (FileNotFoundException e) {
      //e.printStackTrace();
      System.out.println("coucou");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
       e.printStackTrace();
    }

        
            // enregistrement    
          
            arraylist.add(new Contact(this.nom, this.prenom, this.fixePhone, this.mobilePhone, this.mailPerso, this.mailPro, this.adresse));

            try {
                FileOutputStream fileOut = new FileOutputStream("E:\\contact.dat");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(arraylist);
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
