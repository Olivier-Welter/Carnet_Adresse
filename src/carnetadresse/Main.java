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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void Main(String[] args)
    {
      Application.launch(PageAccueil.class, args);
    }
    
}

        // Exemple liste de contact
        /*
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
        
        */
    


