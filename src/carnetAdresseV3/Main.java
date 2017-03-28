/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetAdresseV3;

import carnetAdresseV3.model.Contact;
import carnetAdresseV3.model.Recherche;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Kévin
 */
public class Main extends Application {

    private Stage currentStage;
    
    @FXML
    private Label labelErreur;
    @FXML
    private TextField txtRecherche;
    @FXML
    private TextField contactNom,contactPrenom,contactFixePhone,contactMobilePhone,contactMailPro,contactMailPerso;
    @FXML
    private TextArea contactAdresse;

    
    /**
     * Démarrage de l'interface graphique
     */
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        currentStage = primaryStage;
        currentStage.setTitle("LE carnet d'adresse by Olive, Vince & Kéké");
        changePage("view/AccueilView.fxml");
    }

    /**
     * Affiche la page dont la vue est passée en paramètre
     */

    private void changePage(String fxml) throws IOException
    {
        // Récupère l'élément parent du fichier fxml
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        // Incorpore celui-ci dans une nouvelle scène, et remplace la scène actuelle par la nouvelle
        currentStage.setScene(new Scene(pane));
        // Met à jour la fenêtre
        currentStage.show();
    }

    
    
    /**
     * Action sur les boutons
     */
    
    @FXML
    private void actionBoutonRecherche(ActionEvent event)
    {
        // Instancie Recherche avec la chaîne contenue dans le champ de saisie de recherche
        Recherche currentRecherche = new Recherche(txtRecherche.getText());
        if(currentRecherche.getMssgErreur() != null) labelErreur.setText(currentRecherche.getMssgErreur());
        else labelErreur.setText("Recherche de " + currentRecherche.getRecherche());
    }
    
    @FXML
    private void actionBoutonContact(ActionEvent event) throws IOException
    {
        // Récupère la fenêtre où le bouton a été cliqué puis change de page
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changePage("view/ContactView.fxml");
    }
    
    @FXML
    private void actionBoutonEnregistrer(ActionEvent event) throws IOException
    {
        // Instancie Contact avec la chaîne contenue dans le champ de saisie du nom
         
        Contact currentContact = new Contact(contactNom.getText(),contactPrenom.getText(),contactFixePhone.getText(),contactMobilePhone.getText(),contactMailPro.getText(),contactMailPerso.getText(),contactAdresse.getText());
        if(currentContact.getMssgErreur() != null) labelErreur.setText(currentContact.getMssgErreur());
        else
        {
            // Récupère la fenêtre où le bouton a été cliqué puis change de page
            currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            changePage("view/AccueilView.fxml");
            // Message de confirmation enregistrement
            labelErreur.setText("Contact " + currentContact.getNom() + " enregistré !");
        }
        
    }
    
    @FXML
    private void actionBoutonAnnuler(ActionEvent event) throws IOException
    {
        // Récupère la fenêtre où le bouton a été cliqué puis change de page
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changePage("view/AccueilView.fxml");
    }

    
    
    /**
     * Le main lance la méthode start avec Application.launch()
     */

    public static void main(String[] args)
    {
        launch(args);
    }
}