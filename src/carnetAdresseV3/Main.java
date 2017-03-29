package carnetAdresseV3;

import carnetAdresseV3.model.Contact;
import carnetAdresseV3.model.Recherche;
import carnetAdresseV3.model.TableItem;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Olive, Vince & Kéké
 */
public class Main extends Application {

    private Stage currentStage;
    private final ObservableList<TableItem> tableContent = FXCollections.observableArrayList();
    
    @FXML private Label labelErreur;
    @FXML private TextArea contactAdresse;
    @FXML private TableView<TableItem> table;
    @FXML private TableColumn<TableItem, String> tableNom,tablePrenom,tablePhone,tableAdresse,tableMail;
    @FXML private TextField contactRecherche,contactNom,contactPrenom,contactFixePhone,contactMobilePhone,contactMailPro,contactMailPerso;

    
    /**
     * Démarrage de l'interface graphique
     * @throws java.io.IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        currentStage = primaryStage;
        currentStage.setTitle("L'anale des libertins toulousains");
        changePage("view/AccueilView.fxml");
        listeInfos(Contact.lectureFichierContact());
    }

    /**
     * Affiche la page dont la vue est passée en paramètre
     * @fxml
     */
    private void changePage(String fxml) throws IOException
    {
        // Récupère le contenu du fichier fxml
        Parent content = FXMLLoader.load(getClass().getResource(fxml));
        // Incorpore celui-ci dans une nouvelle scène, et remplace la scène actuelle par la nouvelle
        currentStage.setScene(new Scene(content));
        // Met à jour la fenêtre
        currentStage.show();
    }
    
    @FXML
    protected void initialize()
    {
        PropertyValueFactory<TableItem, String> nomProperty = new PropertyValueFactory<>("nom");
        PropertyValueFactory<TableItem, String> prenomProperty = new PropertyValueFactory<>("prenom");
        PropertyValueFactory<TableItem, String> phoneProperty = new PropertyValueFactory<>("phone");
        PropertyValueFactory<TableItem, String> adresseProperty = new PropertyValueFactory<>("adresse");
        PropertyValueFactory<TableItem, String> mailProperty = new PropertyValueFactory<>("mail");
        tableNom.setCellValueFactory(nomProperty);
        tablePrenom.setCellValueFactory(prenomProperty);
        tablePhone.setCellValueFactory(phoneProperty);
        tableAdresse.setCellValueFactory(adresseProperty);
        tableMail.setCellValueFactory(mailProperty);
        ArrayList listInfos = Contact.lectureFichierContact();
        
        for(int i = 0; i < listInfos.size();i++)
        {
            ArrayList ligne = (ArrayList) listInfos.get(i);
            tableContent.add(new TableItem((String) ligne.get(0),(String) ligne.get(1),(String) ligne.get(2),(String) ligne.get(3),(String) ligne.get(4)));
        }
        table.setItems(tableContent);
    }
    
     /**
     * Liste les infos sur la page d'accueil
     */
    private void listeInfos(ArrayList listInfos) throws IOException
    {
        /*
        tableContent.add(new TableItem("Welter","Olivier","05607670752\n6546561644","64 route de ta mère 696969 boulecity","welter.olivier@gmail.com"));
        tableContent.add(new TableItem("Tescari","Vincent","05607670752\n6546561644","64 route de ta mère 696969 boulecity","tescari.vincent@gmail.com\nsexybitchdu31@youporn.com"));
        tableContent.add(new TableItem("Diez","Kévin","05607670752\n6546561644","64 route de ta mère 696969 boulecity","diez.kevin@gmail.com"));
        */
        System.out.println(listInfos);
    }

    
    /**
     * Bouton RECHERCHE
     * @param event
     */
    @FXML
    private void actionBoutonRecherche(ActionEvent event) throws IOException
    {
        // Instancie Recherche avec la chaîne contenue dans le champ de saisie de recherche
        Recherche currentRecherche = new Recherche(contactRecherche.getText(), Contact.lectureFichierContact());
        if(currentRecherche.getMssgErreur() != null) labelErreur.setText(currentRecherche.getMssgErreur());
        else
        {
            labelErreur.setText("Recherche de " + currentRecherche.getRecherche());
            listeInfos(currentRecherche.getListRecherche());
        }
    }
    
    /**
     * Bouton AJOUTER CONTACT
     * @param event
     */
    @FXML
    private void actionBoutonContact(ActionEvent event) throws IOException
    {
        // Récupère la fenêtre où le bouton a été cliqué puis change de page
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changePage("view/ContactView.fxml");
    }
    
    /**
     * Bouton ENREGISTRER
     * @param event
     */
    @FXML
    private void actionBoutonEnregistrer(ActionEvent event) throws IOException
    {
        // Instancie Contact avec la chaîne contenue dans le champ de saisie du nom
        Contact currentContact = new Contact(contactNom.getText(),contactPrenom.getText(),contactFixePhone.getText(),contactMobilePhone.getText(),contactMailPro.getText(),contactMailPerso.getText(),contactAdresse.getText());
        if(currentContact.getMssgErreur() != null) labelErreur.setText(currentContact.getMssgErreur());
        else labelErreur.setText("Contact " + currentContact.getNom() + " enregistré !");
    }
    
    /**
     * Bouton RETOUR
     * @param event
     */
    @FXML
    private void actionBoutonRetour(ActionEvent event) throws IOException
    {
        // Récupère la fenêtre où le bouton a été cliqué puis change de page
        currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changePage("view/AccueilView.fxml");
    }

    
    
    /**
     * Le main lance la méthode start avec Application.launch()
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}