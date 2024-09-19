package pharmacie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import gestion.Utilsateur;
import gestion.Patient;
import DAO.DaoUser;
import DAO.DaoPatient;
import DAO.DaoMeds;
import DAO.DaoOrd;
import DAO.DaoOrdenanceDetails;
import gestion.Med;
import gestion.OrdenanceDetails;
import java.io.IOException;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import pharmacie.FXMLDocumentController;


public class main {
    enum Sexe{
    M,F
}
enum Type{
    normal,spécial
}

    @FXML
    private Button addMed;

    @FXML
    private Button addPatient;

    @FXML
    private Button addUser;

    @FXML
    private TextField adresseField;

    @FXML
    private TableColumn<Patient, String> adresseP;

    @FXML
    private Button clear;

    @FXML
    private Button clear1;

    @FXML
    private Button clearMed;

    @FXML
    private TableColumn<Med, String> compoMed;

    @FXML
    private TextField compsition;

    @FXML
    private TableColumn<Patient, String> dateP;

    @FXML
    private DatePicker datedenaissance;

    @FXML
    private Button deleteMed;

    @FXML
    private Button deletePatient;

    @FXML
    private Button deleteUser;

    @FXML
    private TableColumn<Med, String> denoMed;

    @FXML
    private TextField denomination;

    @FXML
    private TextField dosage;

    @FXML
    private TableColumn<Med, String> dosageMed;

    @FXML
    private TextField forme;

    @FXML
    private TableColumn<Med, String> formeMed;

    @FXML
    private TextField idMed;

    @FXML
    private TextField idUsers;

    @FXML
    private TextField idUsers1;

    @FXML
    private TextField loginField;

    @FXML
    private TableView<Med> medTable;

    @FXML
    private TableColumn<Utilsateur, String> nom;

    @FXML
    private TextField nomField;

    @FXML
    private TableColumn<Patient, String> nomP;

    @FXML
    private TextField nompField;

    @FXML
    private TextField passwordField;

    @FXML
    private AnchorPane patientPanel;

    @FXML
    private AnchorPane medPanel;

    @FXML
    private TableView<Patient> patientTable;

    @FXML
    private TextField phoneField;

    @FXML
    private TableColumn<Utilsateur, String> prenom;

    @FXML
    private TextField prenomField;

    @FXML
    private TableColumn<Patient, String> prenomP;

    @FXML
    private TextField prenompField;

    @FXML
    private TextField prix;

    @FXML
    private TableColumn<Med, String> prixMed;

    @FXML
    private TableColumn<Utilsateur, String> profil;

    @FXML
    private TextField profilField;

    @FXML
    private Button history;

    @FXML
    private  ChoiceBox<Sexe>  sexeField;

    @FXML
    private TableColumn<Patient, String> sexeP;

    @FXML
    private Button showMed;

    @FXML
    private Button showPatient;

    @FXML
    private Button showUser;

    @FXML
    private TableColumn<Patient, String> telephoneP;

    @FXML
    private  ChoiceBox<Type>  type;

    @FXML
    private TableColumn<Med, String> typeMed;

    @FXML
    private Button updateMed;

    @FXML
    private Button updatePatient;

    @FXML
    private Button updateUser;

    @FXML
    private AnchorPane userPanel;

    @FXML
    private TableView<Utilsateur> userTable;

    @FXML
    void updateM(ActionEvent event) {
        Med m = new Med(
                Integer.parseInt(idMed.getText()),
                denomination.getText(),
                compsition.getText(),
                forme.getText(),
                dosage.getText(),
                Integer.parseInt(prix.getText()),
                type.getValue().toString());
        DaoMeds.modifier(m);
        this.clearFieldsM(event);
        ObservableList<Med> meds = FXCollections.observableArrayList(DaoMeds.lister());
        medTable.setItems(meds);
    }

    @FXML
    void addM(ActionEvent event) {
        Med m = new Med(denomination.getText(),
                compsition.getText(),
                forme.getText(),
                dosage.getText(),
                Integer.parseInt(prix.getText()),
                type.getValue().toString());
        DaoMeds.ajouter(m);
        this.clearFieldsM(event);
        ObservableList<Med> meds = FXCollections.observableArrayList(DaoMeds.lister());
        medTable.setItems(meds);
    }

    @FXML
    void deleteM(ActionEvent event) {
        DaoMeds.supprimer(Integer.parseInt(idMed.getText()));
        this.clearFieldsM(event);
        ObservableList<Med> meds = FXCollections.observableArrayList(DaoMeds.lister());
        medTable.setItems(meds);
    }

    @FXML
    void showM(ActionEvent event) {
        userPanel.setVisible(false);
        patientPanel.setVisible(false);
        medPanel.setVisible(true);
    }

    @FXML
    void clearFieldsM(ActionEvent event) {
        denomination.clear();
        compsition.clear();
        forme.clear();
        dosage.clear();
        prix.clear();
        type.setValue(null);
    }

    @FXML
    void showP(ActionEvent event) {
        patientPanel.setVisible(true);
        userPanel.setVisible(false);
        medPanel.setVisible(false);
    }

    @FXML
    void showU(ActionEvent event) {
        userPanel.setVisible(true);
        patientPanel.setVisible(false);
        medPanel.setVisible(false);
    }

    @FXML
    void addP(ActionEvent event) {
        String nom = nompField.getText();
        String prenom = prenompField.getText();
        String sexe = sexeField.getValue().toString();
        String adresse = adresseField.getText();
        int telephone = Integer.parseInt(phoneField.getText());
        Date dateDeNaissance = java.sql.Date.valueOf(datedenaissance.getValue());

        Patient p = new Patient(nom, prenom, dateDeNaissance, sexe, adresse, telephone);

        DaoPatient.ajouter(p);
        this.clearFieldsP(event);
        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);

    }

    @FXML
    void clearFieldsP(ActionEvent event) {
        nompField.clear();
        prenompField.clear();
        sexeField.setValue(null);
        adresseField.clear();
        phoneField.clear();
        idUsers1.clear();
        datedenaissance.setValue(null);
    }

 @FXML
void recherce(ActionEvent event) {
    String userIdText = idUsers1.getText();
    if (!userIdText.isEmpty()) {
        try {
            int userId = Integer.parseInt(userIdText);

            // Fetch the order IDs associated with the user
            List<Integer> orderIds = DaoOrd.getOrdersByUserId(userId);

            // Fetch the medication IDs associated with the orders
            List<Integer> medIds = DaoOrdenanceDetails.getMedIdsByOrderIds(orderIds);

            // Retrieve the medications associated with those medication IDs
            List<Med> medsList = DaoMeds.listerByIds(medIds);
            ObservableList<Med> meds = FXCollections.observableArrayList(medsList);

            // Load the new window with a table to display the medications
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicationsView.fxml"));
                Parent root = loader.load();

                // Access the controller and set the medications
                MedicationsViewController controller = loader.getController();
                controller.setMeds(meds);

                // Open the new window
                Stage stage = new Stage();
                stage.setTitle("Medications");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            // Handle the case where the user ID is not a valid integer
            System.err.println("Invalid user ID: " + userIdText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.err.println("User ID is empty");
    }
}




    @FXML
    void updateP(ActionEvent event) {
        LocalDate localDate = datedenaissance.getValue();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Patient p = new Patient(
                Integer.parseInt(idUsers1.getText()),
                nompField.getText(),
                prenomP.getText(),
                date,
                sexeField.getValue().toString(),
                adresseField.getText(),
                Integer.parseInt(phoneField.getText()));
        DaoPatient.modifier(p);
        this.clearFieldsP(event);
        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);
    }

    @FXML
    void deleteP(ActionEvent event) {
        DaoPatient.supprimer(Integer.parseInt(idUsers1.getText()));
        this.clearFieldsP(event);
        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);
    }

    @FXML
    void addU(ActionEvent event) {
        Utilsateur u = new Utilsateur(nomField.getText(),
                prenomField.getText(),
                loginField.getText(),
                passwordField.getText(),
                profilField.getText());
        DaoUser.ajouter(u);
        this.clearFields(event);
        ObservableList<Utilsateur> users = FXCollections.observableArrayList(DaoUser.lister());
        userTable.setItems(users);
    }

    @FXML
    void clearFields(ActionEvent event) {
        loginField.clear();
        nomField.clear();
        passwordField.clear();
        prenomField.clear();
        profilField.clear();
    }

    @FXML
    void deleteU(ActionEvent event) {
        DaoUser.supprimer(Integer.parseInt(idUsers.getText()));
        ObservableList<Utilsateur> users = FXCollections.observableArrayList(DaoUser.lister());
        this.clearFields(event);
        userTable.setItems(users);
    }

    @FXML
    void updateU(ActionEvent event) {
        Utilsateur u = new Utilsateur(Integer.parseInt(idUsers.getText()),
                nomField.getText(),
                prenomField.getText(),
                loginField.getText(),
                passwordField.getText(),
                profilField.getText());
        DaoUser.modifier(u);
        ObservableList<Utilsateur> users = FXCollections.observableArrayList(DaoUser.lister());
        this.clearFields(event);
        userTable.setItems(users);
    }

    @FXML
    private void initialize() {
        ObservableList<Utilsateur> users = FXCollections.observableArrayList(DaoUser.lister());
        userTable.setItems(users);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        profil.setCellValueFactory(new PropertyValueFactory<>("profil"));

        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);
        nomP.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomP.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        dateP.setCellValueFactory(new PropertyValueFactory<>("dateDeNaissance"));
        sexeP.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        adresseP.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        telephoneP.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        sexeField.setItems(FXCollections.observableArrayList(Sexe.M, Sexe.F));

        ObservableList<Med> meds = FXCollections.observableArrayList(DaoMeds.lister());
        medTable.setItems(meds);
        denoMed.setCellValueFactory(new PropertyValueFactory<>("denomination"));
        compoMed.setCellValueFactory(new PropertyValueFactory<>("composition"));
        formeMed.setCellValueFactory(new PropertyValueFactory<>("Forme_pharmaceutique"));
        dosageMed.setCellValueFactory(new PropertyValueFactory<>("Dosage"));
        prixMed.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        typeMed.setCellValueFactory(new PropertyValueFactory<>("Type"));
        type.setItems(FXCollections.observableArrayList(Type.normal, Type.spécial));

        userTable.getSelectionModel().selectedItemProperty().addListener(this::handleUserSelection);
        patientTable.getSelectionModel().selectedItemProperty().addListener(this::handlePatientSelection);
        medTable.getSelectionModel().selectedItemProperty().addListener(this::handleMedsSelection);
    }

    private void handleUserSelection(ObservableValue<? extends Utilsateur> observable, Utilsateur oldValue, Utilsateur newValue) {
        if (newValue != null) {
            loginField.setText(newValue.getLogin());
            nomField.setText(newValue.getNom());
            passwordField.setText(newValue.getMotDePasse());
            prenomField.setText(newValue.getPrenom());
            profilField.setText(newValue.getProfil());
            idUsers.setText(String.valueOf(newValue.getIdUtilisateur()));
        }
    }

    private void handlePatientSelection(ObservableValue<? extends Patient> observable, Patient oldValue, Patient newValue) {
        if (newValue != null) {
            nompField.setText(newValue.getNom());
            prenompField.setText(newValue.getPrenom());
            int year = newValue.getDateDeNaissance().getYear();
            int month = newValue.getDateDeNaissance().getMonth() + 1;
            int day = newValue.getDateDeNaissance().getDate();
            if (year < 1900) {
                year += 1900;
            }
            datedenaissance.setValue(LocalDate.of(year, month, day));
            sexeField.setValue(Sexe.valueOf(newValue.getSexe()));
            adresseField.setText(newValue.getAdresse());
            phoneField.setText(String.valueOf(newValue.getTelephone()));
            idUsers1.setText(String.valueOf(newValue.getId_Patient()));
        }
    }

    private void handleMedsSelection(ObservableValue<? extends Med> observable, Med oldValue, Med newValue) {
        if (newValue != null) {
            denomination.setText(newValue.getDenomination());
            compsition.setText(newValue.getComposition());
            forme.setText(newValue.getForme_Pharmaceutique());
            dosage.setText(newValue.getDosage());
            prix.setText(String.valueOf(newValue.getPrix()));
            type.setValue(Type.valueOf(newValue.getType()));
            idMed.setText(String.valueOf(newValue.getId_Medicament()));

        }
    }

}
