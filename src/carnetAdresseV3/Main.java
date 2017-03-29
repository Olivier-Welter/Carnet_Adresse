package carnetAdresseV3;

import carnetAdresseV3.model.Contact;
import carnetAdresseV3.model.Recherche;
import carnetAdresseV3.model.TableItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Olive, Vince & Kéké
 */
public class Main extends Application {

    private Stage currentStage;
    static private boolean showTable = false;
    private final ObservableList<TableItem> tableContent = FXCollections.observableArrayList();

    @FXML
    private Label labelErreur;
    @FXML
    private TextArea contactAdresse;
    @FXML
    private TableView<TableItem> table;
    @FXML
    private TableColumn<TableItem, String> tableNom;
    @FXML
    private TableColumn<TableItem, String> tablePrenom;
    @FXML
    private TableColumn<TableItem, String> tablePhone;
    @FXML
    private TableColumn<TableItem, String> tableAdresse;
    @FXML
    private TableColumn<TableItem, String> tableMail;
    @FXML
    private TextField contactRecherche, contactNom, contactPrenom, contactFixePhone, contactMobilePhone, contactMailPro, contactMailPerso;

    /**
     * Démarrage de l'interface graphique
     *
     * @throws java.io.IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        currentStage = primaryStage;
        currentStage.setTitle("L'annuaire des libertins toulousains");
        changePage("view/AccueilView.fxml");
    }

    /**
     * Affiche la page dont la vue est passée en paramètre
     *
     * @fxml
     */
    private void changePage(String fxml) throws IOException {
        showTable = fxml.equals("view/AccueilView.fxml");
        // Récupère le contenu du fichier fxml
        Parent content = FXMLLoader.load(getClass().getResource(fxml));
        // Incorpore celui-ci dans une nouvelle scène, et remplace la scène actuelle par la nouvelle
        currentStage.setScene(new Scene(content));
        // Met à jour la fenêtre
        currentStage.show();

    }

    @FXML
    protected void initialize() throws IOException {
        if (showTable) {
            listeInfos(Contact.lectureFichierContact());
            
            contactRecherche.textProperty().addListener((ObservableValue<? extends String> recherche, String oldStr, String newStr) ->
            {
                try
                {
                    actionRecherche(recherche.getValue());
                }
                catch (IOException ex) {}
            });
            
        }
    }

    /**
     * Liste les infos sur la page d'accueil
     */
    private void listeInfos(ArrayList<ArrayList> listInfos) throws IOException {
        tableContent.clear();
        tableNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tablePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tablePhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tableAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        tableMail.setCellValueFactory(new PropertyValueFactory<>("mail"));

        for (ArrayList<String> ligne : listInfos) {
            tableContent.add(new TableItem(ligne.get(0), ligne.get(1), ligne.get(2), ligne.get(3), ligne.get(4)));
        }
        table.setItems(tableContent);
    }


    
    /**
     * Bouton RECHERCHE
     *
     * @param event
     */
    private void actionRecherche(String recherche) throws IOException {
        // Instancie Recherche avec la chaîne contenue dans le champ de saisie de recherche
        Recherche currentRecherche = new Recherche(recherche, Contact.lectureFichierContact());
        if (currentRecherche.getMssgErreur() != null) {
            // Affichage de l'erreur
            labelErreur.setText(currentRecherche.getMssgErreur());
            // Si recherche est vide, affichage de la liste complète
            if (contactRecherche.getText().equals("")) {
                listeInfos(Contact.lectureFichierContact());
            } else {
                // Sinon aucun affichage
                tableContent.clear();
            }
        } else {
            labelErreur.setText("Recherche de " + currentRecherche.getRecherche());
            listeInfos(currentRecherche.getListRecherche());
        }
    }

    /**
     * Bouton AJOUTER CONTACT
     *
     * @param event
     */
    @FXML
    private void actionBoutonContact(ActionEvent event) throws IOException {
        // Récupère la fenêtre où le bouton a été cliqué puis change de page
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changePage("view/ContactView.fxml");
    }

    /**
     * Bouton ENREGISTRER
     *
     * @param event
     */
    @FXML
    private void actionBoutonEnregistrer(ActionEvent event) throws IOException {
        // Instancie Contact avec la chaîne contenue dans le champ de saisie du nom
        Contact currentContact = new Contact(contactNom.getText(), contactPrenom.getText(), contactFixePhone.getText(), contactMobilePhone.getText(), contactMailPro.getText(), contactMailPerso.getText(), contactAdresse.getText());
        if (currentContact.getMssgErreur() != null) {
            labelErreur.setText(currentContact.getMssgErreur());
        } else {
            labelErreur.setText("Contact " + currentContact.getNom() + " enregistré !");
            contactNom.clear();
            contactPrenom.clear();
            contactFixePhone.clear();
            contactMobilePhone.clear(); 
            contactFixePhone.clear();
            contactMailPro.clear();
            contactMailPerso.clear();
            contactAdresse.clear();
			
        }
    }

    /**
     * Bouton RETOUR
     *
     * @param event
     */
    @FXML
    private void actionBoutonRetour(ActionEvent event) throws IOException {
        // Récupère la fenêtre où le bouton a été cliqué puis change de page
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changePage("view/AccueilView.fxml");
    }

    /**
     * Le main lance la méthode start avec Application.launch()
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
