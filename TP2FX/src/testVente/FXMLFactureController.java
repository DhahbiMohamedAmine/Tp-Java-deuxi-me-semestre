
package testVente;

import Comptabilte.Facture;
import Comptabilte.Paiment;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class FXMLFactureController implements Initializable {
      Paiment P1;
    
    @FXML
    private TextField txtNumFact;
    @FXML
   

    
    private void afficher(ActionEvent event) {
       String text = txtNumFact.getText();
        int numero = Integer.parseInt(text);
        Facture r = P1.charcherFacture(numero);
        Alert dia = new Alert(Alert.AlertType.INFORMATION, r.toString(), ButtonType.OK);
        dia.setHeaderText("Message");
        dia.setTitle("facture");
        dia.setContentText("Message");
        dia.show();
        //lbl.setText("salut");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        P1 = new Paiment(new Date(2023, 4, 3), Paiment.Type.chèque);
        Facture F1 = new Facture(100, 250.8f, 17.f);
        Facture F2 = new Facture(204, 314.7F, 15.F);
        P1.ajouterFacture(F1);
        P1.ajouterFacture(F2);
    }

}
