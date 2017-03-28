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

    import java.io.*;
     
    class Contact implements Serializable {
        String nom, prenom, mobilePhone, fixePhone,mailPerso,mailPro, adresse ;
     
        Contact(String nom, String prenom,String mobilePhone, String fixePhone, String mailPerso, String mailPro, String adresse  ) {
            this.nom = nom ;
            this.prenom = prenom ;
            this.fixePhone = fixePhone;
            this.mobilePhone = mobilePhone;
            this.mailPerso = mailPerso;
            this.mailPro = mailPro;
            this.adresse = adresse;
        }
        @Override
        public String toString() {
          return (nom + " ," + prenom + " ,"+mobilePhone+" ,"+ fixePhone+" ,"+mailPerso+" ,"+mailPro+" ,"+ adresse);
        }
     
        public void main () {
            try {
                // enregistrement            
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream ("E:\\contact.dat"));
                out.writeObject("Sauvegarde d'une personne");
                out.writeObject(new Contact(this.nom, this.prenom, this.fixePhone,this.mobilePhone, this.mailPerso, this.mailPro, this.adresse));
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
        System.out.println("Erreur enregistrée");
                e.printStackTrace ();
            }
        }
    }


