/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresseV2;

/**
 *
 * @author Olivier
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Olivier
 */

public class FormulaireSaisie extends Application {
    
    
    @Override
    public void start(Stage Stage) {
        
        // Grille conteneur
        GridPane grille = new GridPane(); // Nouvelle grille
        grille.setPadding(new Insets(10, 10, 10, 10)); // Marge intérieure
        grille.setVgap(10); // Hauteur ligne
        grille.setHgap(20); // Largeur colonne
        
        // Input Text -> Nom
        final TextField contactNom = new TextField(); // Nouveau champ
        contactNom.setPromptText("Nom"); // Texte du champ
        contactNom.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(contactNom, 0, 0); // Position colonne 0, ligne 0
        grille.getChildren().add(contactNom); // Ajout du champ à la grille
        
        // Input Text -> Prénom
        final TextField contactPrenom = new TextField(); // Nouveau champ
        contactPrenom.setPromptText("Prénom"); // Texte du champ
        contactPrenom.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(contactPrenom, 0, 1); // Position colonne 0, ligne 1
        grille.getChildren().add(contactPrenom); // Ajout du champ à la grille
        
         // Input Text -> Téléphone Fixe
        final TextField contactFixePhone = new TextField(); // Nouveau champ
        contactFixePhone.setPromptText("Téléphone Fixe"); // Texte du champ
        contactFixePhone.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(contactFixePhone, 0, 2); // Position colonne 0, ligne 2
        grille.getChildren().add(contactFixePhone); // Ajout du champ à la grille
        
         // Input Text -> Téléphone Portable
        final TextField contactMobilePhone = new TextField(); // Nouveau champ
        contactMobilePhone.setPromptText("Téléphone Portable"); // Texte du champ
        contactMobilePhone.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(contactMobilePhone, 0, 3); // Position colonne 0, ligne 3
        grille.getChildren().add(contactMobilePhone); // Ajout du champ à la grille
        
          // Input Text -> Mail perso
        final TextField contactMailPerso = new TextField(); // Nouveau champ
        contactMailPerso.setPromptText("Mail Perso"); // Texte du champ
        contactMailPerso.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(contactMailPerso, 0, 4); // Position colonne 0, ligne 4
        grille.getChildren().add(contactMailPerso); // Ajout du champ à la grille
        
        // Input Text -> Mail Pro
        final TextField contactMailPro = new TextField(); // Nouveau champ
        contactMailPro.setPromptText("Mail Pro"); // Texte du champ
        contactMailPro.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(contactMailPro, 0, 5); // Position colonne 0, ligne 5
        grille.getChildren().add(contactMailPro); // Ajout du champ à la grille
        
         // Input Text -> Adresse
        final TextField contactAdresse = new TextField(); // Nouveau champ
        contactAdresse.setPromptText("Adresse"); // Texte du champ
        contactAdresse.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(contactAdresse, 0, 6); // Position colonne 0, ligne 6
        grille.getChildren().add(contactAdresse); // Ajout du champ à la grille
        
        
        // Bouton -> Rechercher un contact
        Button btnAjout = new Button("Ajouter le contact"); // Nouveau bouton
        GridPane.setColumnSpan(btnAjout, 5); // Largeur du bouton
        GridPane.setConstraints(btnAjout, 1, 0); // Position colonne 1, ligne 0
        grille.getChildren().add(btnAjout); // Ajout du bouton à la grille
  
        
        // Label -> Contacts à afficher
        final Label labelContact = new Label(); // Nouveau label
        GridPane.setConstraints(labelContact, 1, 3); // Position colonne 1, ligne 3
        GridPane.setColumnSpan(labelContact, 5); // Largeur du label
        grille.getChildren().add(labelContact); // Ajout du label à la grille
        
        // Label -> Messages d'erreur
        final Label labelErreur = new Label(); // Nouveau label
        GridPane.setConstraints(labelErreur, 1, 2); // Position colonne 1, ligne 2
        GridPane.setColumnSpan(labelErreur, 5); // Largeur du label
        grille.getChildren().add(labelErreur); // Ajout du label à la grille
        
              
        // Evènement CLICK 
        btnAjout.setOnAction((ActionEvent e) -> {
            // Si les champs sont renseignés
            if ((contactNom.getText() != null && !contactPrenom.getText().isEmpty()))
            {
                // RECHERCHER UN CONTACT
                Contact leContact= new Contact(contactNom.getText(),contactPrenom.getText(),contactFixePhone.getText(),contactMobilePhone.getText(),contactMailPro.getText(),contactMailPerso.getText(),contactAdresse.getText());
                leContact.enregistrement();
                labelErreur.setText("Ajout du contact avec succés.");
            }
            else
            {
                labelErreur.setText("Merci de renseigner les champs obligatoires.");
            }
        });
        
  
        //Scene
        Scene sceneFormulaire = new Scene(grille, 520, 280); // Nouvelle scène contenant la grille créée, largeur, hauteur
        Stage.setTitle("Formulaire de saisie"); // Titre fenêtre principale
        Stage.setScene(sceneFormulaire); // Choix de la scène à afficher dans la fenêtre principale
        Stage.show(); // Affichage fenêtre principale
        
        
      
        
        
    }
}

