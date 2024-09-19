
package Ex3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Pharmacie {
    private String nom_Pharmacie;
    private HashMap<String,Patient> patients_Clients;

    public Pharmacie(String nom_Pharmacie) {
        this.nom_Pharmacie = nom_Pharmacie;
        this.patients_Clients=new HashMap();
    }
    public void ajoutPatient(String n,HashSet<Medicament> listeMedicaments){
        String nom=n.toLowerCase();
        Patient p=new Patient(nom,listeMedicaments);
        this.patients_Clients.put(nom, p);
    }
    public boolean ajoutMedicament(String nomPatient,Medicament med){
        boolean ok=false;
        String n=nomPatient.toLowerCase();
        if(this.patients_Clients.containsKey(n)){
            this.patients_Clients.get(n).ajoutMedicament(med);
            ok=true;
        }
        return ok;
    }
    public void affichePatient(String np){
        this.patients_Clients.get(np).affichePatient();
    }
    public void affiche(){
        System.out.println(this.patients_Clients);
    }
    public TreeSet<String> PatientavecMedicament(Medicament med){
         TreeSet<String> patients = new TreeSet<>();
        for (Patient patient : patients_Clients.values()) {
            if (patient.contientMedicament(med)) {
                patients.add(patient.getNom());
            }
        }
        return patients;
        
    }
    public void enleverOrdonnanceVide() {
    Iterator<Map.Entry<String, Patient>> iterator = patients_Clients.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry<String, Patient> entry = iterator.next();
        if (entry.getValue().ordonnanceVide()) {
            iterator.remove();
        }
    }
}

    
}
