package pharmacie;

import DAO.DaoMeds;
import DAO.DaoOrd;
import DAO.DaoOrdenanceDetails;
import gestion.Med;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedicationsViewController {
    private int id;
    private int Refid;
    private int Medid;
    
    @FXML
    private TableView<Med> medTable;

    @FXML
    private TableColumn<Med, String> denoMed;

    @FXML
    private TableColumn<Med, String> compoMed;

    @FXML
    private TableColumn<Med, String> formeMed;

    @FXML
    private TableColumn<Med, String> dosageMed;

    @FXML
    private TableColumn<Med, Float> prixMed;

    @FXML
    private TableColumn<Med, String> typeMed;
    
    @FXML
    private Button showMedicationsButton;
    
    @FXML
    private Button addMedicationButton;
    
    @FXML
    private ListView<String> medicationListView;

    public void setMeds(ObservableList<Med> medList, int id) {
        medTable.setItems(medList);
        this.id = id;
    }

    @FXML
    public void initialize() {
        showMedicationsButton.setOnAction(event -> showMedications());
        addMedicationButton.setOnAction(event -> handleAddMedication());
        
        medicationListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle medication selection
            handleMedicationSelection(newValue);
        });
        
        denoMed.setCellValueFactory(new PropertyValueFactory<>("denomination"));
        compoMed.setCellValueFactory(new PropertyValueFactory<>("composition"));
        formeMed.setCellValueFactory(new PropertyValueFactory<>("formePharmaceutique"));
        dosageMed.setCellValueFactory(new PropertyValueFactory<>("dosage"));
        prixMed.setCellValueFactory(new PropertyValueFactory<>("prix"));
        typeMed.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        // Load medications initially
        showMedications();
    }

    // Method to handle the "Show Medications" button click
    private void showMedications() {
        List<Med> medications = DaoMeds.getIdByDenomination();

        ObservableList<String> medicationDenominations = FXCollections.observableArrayList();
        for (Med medication : medications) {
            medicationDenominations.add(medication.getDenomination());
        }

        medicationListView.setItems(medicationDenominations);
    }

    // Method to handle the "Add Medication" button click
    private void handleAddMedication() {
         int result = DaoOrdenanceDetails.ajouterWithRef(this.Refid, this.Medid);
         if(result==-1){
             result=DaoOrd.ajouter(this.id);
             if(result==0){
             this.Refid = DaoOrd.getRefIdByUserId(this.id);
                 System.out.println(Refid);
             DaoOrdenanceDetails.ajouterWithRef(this.Refid, this.Medid);}
         }
         this.refreshMedTable(this.Medid);

    }

    // Method to handle selecting a medication from the list
    private void handleMedicationSelection(String selectedMedicationDenomination) {
        int userId = id; // Get the user ID from your application
        this.Refid = DaoOrd.getRefIdByUserId(userId);
        this.Medid = DaoMeds.getIdByDenomination(selectedMedicationDenomination);
    }
    
    // Method to refresh the medication table data
    private void refreshMedTable(int medId) {
    Med med = DaoMeds.fetchMedById(medId);
    medTable.getItems().add(med);
}

}