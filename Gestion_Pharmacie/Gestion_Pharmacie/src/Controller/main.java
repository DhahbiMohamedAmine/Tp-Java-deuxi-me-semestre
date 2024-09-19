package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Classes.Utilsateur;
import Classes.Patient;
import DAO.DaoUser;
import DAO.DaoPatient;
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



public class main {




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
    private TableColumn<Patient, String> dateP;

    @FXML
    private DatePicker datedenaissance;


    @FXML
    private Button deletePatient;

    @FXML
    private Button deleteUser;

    @FXML
    private TextField idUsers;

    @FXML
    private TextField idUsers1;

    @FXML
    private TextField loginField;

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
    private TableColumn<Utilsateur, String> profil;

    @FXML
    private TextField profilField;

    @FXML
    private Button showPatient;

    @FXML
    private Button showUser;

    @FXML
    private TableColumn<Patient, String> telephoneP;

    @FXML
    private Button updatePatient;

    @FXML
    private Button updateUser;

    @FXML
    private AnchorPane userPanel;

    @FXML
    private TableView<Utilsateur> userTable;






    @FXML
    void showM(ActionEvent event) {
        userPanel.setVisible(false);
        patientPanel.setVisible(false);
        
    }



    @FXML
    void showP(ActionEvent event) {
        patientPanel.setVisible(true);
        userPanel.setVisible(false);
        
    }

    @FXML
    void showU(ActionEvent event) {
        userPanel.setVisible(true);
        patientPanel.setVisible(false);
       
    }

    @FXML
    void addP(ActionEvent event) {
        String nom = nompField.getText();
        String prenom = prenompField.getText(); 
        String adresse = adresseField.getText();
        int telephone = Integer.parseInt(phoneField.getText());
        Date dateDeNaissance = java.sql.Date.valueOf(datedenaissance.getValue());

        Patient p = new Patient(0,nom, prenom, dateDeNaissance,adresse, telephone);
        DaoPatient.ajouter(p);
        this.clearFieldsP(event);
        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);

    }

    @FXML
    void clearFieldsP(ActionEvent event) {
        nompField.clear();
        prenompField.clear();
        adresseField.clear();
        phoneField.clear();
        idUsers1.clear();
        datedenaissance.setValue(null);
    }

    @FXML
    void recherce(ActionEvent event) {
        idUsers.getText();
    }

    @FXML
    void updateP(ActionEvent event) {
        LocalDate localDate = datedenaissance.getValue();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Patient p = new Patient(
                Integer.parseInt(idUsers1.getText()),
                nompField.getText(),
                prenompField.getText(), date,
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
        adresseP.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        telephoneP.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        userTable.getSelectionModel().selectedItemProperty().addListener(this::handleUserSelection);
        patientTable.getSelectionModel().selectedItemProperty().addListener(this::handlePatientSelection);
        
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
            adresseField.setText(newValue.getAdresse());
            phoneField.setText(String.valueOf(newValue.getTelephone()));
            idUsers1.setText(String.valueOf(newValue.getId_Patient()));
        }
    }

}
