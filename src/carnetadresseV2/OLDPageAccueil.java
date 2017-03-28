/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresseV2;

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

public class OLDPageAccueil extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        // Grille conteneur
        GridPane grille = new GridPane(); // Nouvelle grille
        grille.setPadding(new Insets(10, 10, 10, 10)); // Marge intérieure
        grille.setVgap(20); // Hauteur ligne
        grille.setHgap(20); // Largeur colonne
        
        // Input Text -> Rechercher un contact
        final TextField txtRecherche = new TextField(); // Nouveau champ
        txtRecherche.setPromptText("Rechercher un contact"); // Texte du champ
        txtRecherche.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(txtRecherche, 0, 0); // Position colonne 0, ligne 0
        grille.getChildren().add(txtRecherche); // Ajout du champ à la grille
        
        // Bouton -> Rechercher un contact
        Button btnRecherche = new Button("Rechercher"); // Nouveau bouton
        GridPane.setColumnSpan(btnRecherche, 5); // Largeur du bouton
        GridPane.setConstraints(btnRecherche, 1, 0); // Position colonne 1, ligne 0
        grille.getChildren().add(btnRecherche); // Ajout du bouton à la grille
   
        // Bouton -> Ajouter un contact
        Button btnAjout = new Button("Ajouter un contact"); // Nouveau bouton
        GridPane.setConstraints(btnAjout, 10, 10); // Position colonne 5, ligne 5
        GridPane.setColumnSpan(btnAjout, 5); // Largeur du bouton
        grille.getChildren().add(btnAjout); // Ajout du bouton à la grille
        
        // Label -> Contacts à afficher
        final Label labelContact = new Label(); // Nouveau label
        GridPane.setConstraints(labelContact, 0, 10); // Position colonne 0, ligne 10
        GridPane.setColumnSpan(labelContact, 5); // Largeur du label
        grille.getChildren().add(labelContact); // Ajout du label à la grille
        
        // Label -> Messages d'erreur
        final Label labelErreur = new Label(); // Nouveau label
        GridPane.setConstraints(labelErreur, 0, 10); // Position colonne 0, ligne 10
        GridPane.setColumnSpan(labelErreur, 5); // Largeur du label
        grille.getChildren().add(labelErreur); // Ajout du label à la grille
        
        // Evènement CLICK rechercher un contact
        btnRecherche.setOnAction((ActionEvent e) -> {
            // Si le champs de recherche n'est pas vide
            if ((txtRecherche.getText() != null && !txtRecherche.getText().isEmpty()))
            {
                // RECHERCHER UN CONTACT
                labelErreur.setText("Recherche d'un contact");
            }
            else
            {
                labelErreur.setText("Tu n'as rien recherché tête de bite de porc !");
            }
        });
        
        // Evènement CLICK ajouter un contact
        btnAjout.setOnAction((ActionEvent e) -> {
            // RECHERCHER UN CONTACT
            System.out.println("PageAccueil");
            primaryStage.setTitle("Formulaire de saisie"); // Titre fenêtre principale
        });


        //Scene
        Scene scene = new Scene(grille, 520, 280); // Nouvelle scène contenant la grille créée, largeur, hauteur
        primaryStage.setTitle("Carnet Accueil"); // Titre fenêtre principale
        primaryStage.setScene(scene); // Choix de la scène à afficher dans la fenêtre principale
        primaryStage.show(); // Affichage fenêtre principale
        
        
      
        
        
    }
}

