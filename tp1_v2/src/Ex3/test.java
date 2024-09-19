
package Ex3;

public class test {

    public static void main(String[] args) {
        Medicament m=new Medicament(1,"panadol");
        Medicament m2=new Medicament(2,"doliprane");
        Medicament m3=new Medicament(3,"gripex");
        
        Patient p=new Patient("Amine");
        
        p.ajoutMedicament(m);
        p.ajoutMedicament(m2);
        p.ajoutMedicament(m3);
        
        
        p.affichePatient();
        
    }}