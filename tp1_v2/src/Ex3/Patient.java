
package Ex3;

import java.util.HashSet;

public class Patient {
    private String nom;
    private HashSet<Medicament> listeMedicament=new HashSet();

    public Patient(String nom, HashSet<Medicament> listeMedicament) {
        this.nom = nom;
        this.listeMedicament = listeMedicament;
    }



    public String getNom() {
        return nom;
    }
    
    public boolean ordonnanceVide(){
        return this.listeMedicament.isEmpty();
    }
    public void ajoutMedicament(Medicament m){
         this.listeMedicament.add(m);
    }
    public boolean contientMedicament(Medicament m){
        return this.listeMedicament.contains(m);
    }

    public void afficheOrdonnance(){
        System.out.println(listeMedicament);
    }
    public void affichePatient(){
        System.out.println("Nom patient : "+this.nom);
        this.afficheOrdonnance();
    }
}
