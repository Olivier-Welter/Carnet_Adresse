package carnetAdresseV3.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Olive, Vince & Kéké
 */
public class TableItem {
    
  private final SimpleStringProperty nom,prenom,phone,adresse,mail;

  public TableItem(String nom,String prenom,String phone,String adresse,String mail)
  {
    this.nom = new SimpleStringProperty(nom);
    this.prenom = new SimpleStringProperty(prenom);
    this.phone = new SimpleStringProperty(phone);
    this.adresse = new SimpleStringProperty(adresse);
    this.mail = new SimpleStringProperty(mail);
  }
  
  
  public String getNom()
  {
    return nom.get();
  }
  
  public void setNom(String nom)
  {
    this.nom.set(nom);
  }
  
  public String getPrenom()
  {
    return prenom.get();
  }
  
  public void setPrenom(String prenom)
  {
    this.prenom.set(prenom);
  }
  
  public String getPhone()
  {
    return phone.get();
  }
  
  public void setPhone(String phone)
  {
    this.phone.set(phone);
  }
  
  public String getAdresse()
  {
    return adresse.get();
  }
  
  public void setAdresse(String adresse)
  {
    this.adresse.set(adresse);
  }
  
  public String getMail()
  {
    return mail.get();
  }
  
  public void setMail(String mail)
  {
    this.mail.set(mail);
  }
  
}