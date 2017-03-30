package carnetAdresseV3.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author DreamTeam
 */
public class TableItem {
    
  private final SimpleStringProperty nom,prenom,phone,adresse,mail;

    /**
     *
     * @param nom nom
     * @param prenom prenom
     * @param phone tel
     * @param adresse adresse
     * @param mail mail
     */
    public TableItem(String nom,String prenom,String phone,String adresse,String mail)
  {
    this.nom = new SimpleStringProperty(nom);
    this.prenom = new SimpleStringProperty(prenom);
    this.phone = new SimpleStringProperty(phone);
    this.adresse = new SimpleStringProperty(adresse);
    this.mail = new SimpleStringProperty(mail);
  }
  
    /**
     *
     * @return nom
     */
    public String getNom()
  {
    return nom.get();
  }
  
    /**
     *
     * @param nom nom
     */
    public void setNom(String nom)
  {
    this.nom.set(nom);
  }
  
    /**
     *
     * @return prenom
     */
    public String getPrenom()
  {
    return prenom.get();
  }
  
    /**
     *
     * @param prenom prenom
     */
    public void setPrenom(String prenom)
  {
    this.prenom.set(prenom);
  }
  
    /**
     *
     * @return phone
     */
    public String getPhone()
  {
    return phone.get();
  }
  
    /**
     *
     * @param phone phone
     */
    public void setPhone(String phone)
  {
    this.phone.set(phone);
  }
  
    /**
     *
     * @return adresse
     */
    public String getAdresse()
  {
    return adresse.get();
  }
  
    /**
     *
     * @param adresse adresse
     */
    public void setAdresse(String adresse)
  {
    this.adresse.set(adresse);
  }
  
    /**
     *
     * @return mail
     */
    public String getMail()
  {
    return mail.get();
  }
  
    /**
     *
     * @param mail mail
     */
    public void setMail(String mail)
  {
    this.mail.set(mail);
  }
  
}