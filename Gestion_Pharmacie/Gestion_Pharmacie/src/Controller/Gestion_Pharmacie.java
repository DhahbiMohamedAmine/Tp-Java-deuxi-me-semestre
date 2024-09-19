/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author TOP
 */
public class Gestion_Pharmacie extends Application {
    
   @Override    
    public void start(Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Document.fxml"));
    Parent root = loader.load();
    stage.setScene(new Scene(root)); 
    stage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}
