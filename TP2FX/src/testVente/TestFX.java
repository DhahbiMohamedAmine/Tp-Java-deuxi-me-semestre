package testVente;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

       Parent root = 
    FXMLLoader.load(getClass().getResource("FXMLFacture.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Facturation");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
