
package Dc2022;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class AgendaMedcine {
    private int codeAgenda;
    private String nomMedcine;
    private HashMap<Integer,Patient> lesRendezVous = new HashMap();

    public AgendaMedcine(int codeAgenda, String nomMedcine) {
        this.codeAgenda = codeAgenda;
        this.nomMedcine = nomMedcine;
    }
    
    public void prendreUnRendezVous(int DateEnSeconde, Patient p){
        this.lesRendezVous.put(DateEnSeconde, p);
    }
    public Patient consulterPatient(int DateEnSeconde) throws PatientInexistant{
        if(this.lesRendezVous.containsKey(DateEnSeconde)){
            return this.lesRendezVous.get(DateEnSeconde);
        }
        else {
            throw new PatientInexistant ("Aucun rendez-vous pour cette date");
        }
    }
    public TreeSet <Patient> getLesPatients(){
        TreeSet <Patient> ps=new TreeSet();
        Iterator <Patient> it= this.lesRendezVous.values().iterator();
        while(it.hasNext()){
            ps.add(it.next());
        }
        return ps;
    }
    public LinkedList<Patient> getLesPatientsChroniques(){
        LinkedList <Patient> ps=new LinkedList();
        Iterator <Patient> it= this.lesRendezVous.values().iterator();
        while(it.hasNext()){
            Patient patient = it.next();
            if (patient.aMaladieChronique()) {
                ps.add(patient);
            }
        }
        return ps;
    }
}
