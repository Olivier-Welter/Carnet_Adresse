/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresse;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Kévin
 */
public class CarnetAdresse extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Grille conteneur
        GridPane grid = new GridPane(); // Nouvelle grille
        grid.setPadding(new Insets(10, 10, 10, 10)); // Marge intérieure
        grid.setVgap(20); // Hauteur ligne
        grid.setHgap(20); // Largeur colonne
        
        // Input Text -> Rechercher un contact
        final TextField txtRecherche = new TextField(); // Nouveau champ
        txtRecherche.setPromptText("Rechercher un contact"); // Texte du champ
        txtRecherche.setPrefColumnCount(15); // Largeur du champ
        GridPane.setConstraints(txtRecherche, 0, 0); // Position colonne 0, ligne 0
        grid.getChildren().add(txtRecherche); // Ajout du champ à la grille
        
        // Bouton -> Rechercher un contact
        Button btnRecherche = new Button("Rechercher"); // Nouveau bouton
        GridPane.setColumnSpan(btnRecherche, 5); // Largeur du bouton
        GridPane.setConstraints(btnRecherche, 1, 0); // Position colonne 1, ligne 0
        grid.getChildren().add(btnRecherche); // Ajout du bouton à la grille
   
        // Bouton -> Ajouter un contact
        Button btnAjout = new Button("Ajouter un contact"); // Nouveau bouton
        GridPane.setConstraints(btnAjout, 10, 10); // Position colonne 5, ligne 5
        GridPane.setColumnSpan(btnAjout, 5); // Largeur du bouton
        grid.getChildren().add(btnAjout); // Ajout du bouton à la grille
        
        // Label -> Contacts à afficher
        final Label labelContact = new Label(); // Nouveau label
        GridPane.setConstraints(labelContact, 0, 10); // Position colonne 0, ligne 10
        GridPane.setColumnSpan(labelContact, 5); // Largeur du label
        grid.getChildren().add(labelContact); // Ajout du label à la grille
        
        // Label -> Messages d'erreur
        final Label labelErreur = new Label(); // Nouveau label
        GridPane.setConstraints(labelErreur, 0, 10); // Position colonne 0, ligne 10
        GridPane.setColumnSpan(labelErreur, 5); // Largeur du label
        grid.getChildren().add(labelErreur); // Ajout du label à la grille
        
        // Evènement CLICK rechercher un contact
        btnRecherche.setOnAction(new EventHandler<ActionEvent>()
        {
        @Override
            public void handle(ActionEvent e)
            {   
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
             }
         });
        
        // Evènement CLICK ajouter un contact
        btnAjout.setOnAction(new EventHandler<ActionEvent>()
        {
        @Override
            public void handle(ActionEvent e)
            {
                  // RECHERCHER UN CONTACT
                  labelErreur.setText("Affichage formulaire d'ajout d'un contact");
            }
        });


        
        Scene scene = new Scene(grid, 520, 480); // Nouvelle scène contenant la grille créée, largeur, hauteur
        
        primaryStage.setTitle("Carnet d'adresse"); // Titre fenêtre principale
        primaryStage.setScene(scene); // Choix de la scène à afficher dans la fenêtre principale
        primaryStage.show(); // Affichage fenêtre principale
        
        
        // Exemple liste de contact
        
        ArrayList<String> contact000 = new ArrayList<>();
        contact000.addAll(Arrays.asList("Nom", "Prénom", "Téléphone", "Adresse", "Email"));
        ArrayList<String> contact001 = new ArrayList<>();
        contact000.addAll(Arrays.asList("Welter", "Olivier", "0476464897", "69 Rue Jean de ta mère 31200 Toulouse", "toto@tencule.fr"));
        ArrayList<String> contact002 = new ArrayList<>();
        contact000.addAll(Arrays.asList("Tescari", "Vincent", "0476464897", "69 Rue Jean de ta mère 31200 Toulouse", "toto@tencule.fr"));
        ArrayList<String> contact003 = new ArrayList<>();
        contact000.addAll(Arrays.asList("Diez", "Kévin", "0476464897", "69 Rue Jean de ta mère 31200 Toulouse", "toto@tencule.fr"));
        ArrayList<String> contact004 = new ArrayList<>();
        contact000.addAll(Arrays.asList("Rey", "Antoine", "0476464897", "69 Rue Jean de ta mère 31200 Toulouse", "toto@tencule.fr"));
        
        ArrayList<ArrayList<String>> listContact = new ArrayList(Arrays.asList(contact000, contact001, contact002, contact003, contact004));
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args); 
    }
    
}
