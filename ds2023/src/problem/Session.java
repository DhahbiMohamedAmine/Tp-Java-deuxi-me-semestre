
package problem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Session {
    private String codeSession;
    private Date dateSession;
    private TreeMap<Etudiant2èmeAnnée,Soutenance > lesSoutenances=new TreeMap();

    public Session(String codeSession, Date dateSession) {
        this.codeSession = codeSession;
        this.dateSession = dateSession;
    }
    public void ajouterSoutenance(Soutenance s){
        Etudiant2èmeAnnée e= s.getEtudiant();
        this.lesSoutenances.put(e, s);
    }
    public void modifierResultat(Soutenance s){
        if(this.lesSoutenances.containsKey(s.getEtudiant())){
            this.lesSoutenances.put(s.getEtudiant(), s);
        }
    }
    public Soutenance avoirResultat(int matricule){
        Soutenance s=null;
        for(Map.Entry<Etudiant2èmeAnnée ,Soutenance > entry:this.lesSoutenances.entrySet()){
            if(entry.getKey().getMatricule()==matricule){
                s=entry.getValue();
            }
        }
        return s;
    }
    public ArrayList<Soutenance> lesSoutenancesValidees() {
        ArrayList<Soutenance> sv = new ArrayList<>();
        for (Map.Entry<Etudiant2èmeAnnée, Soutenance> entry : this.lesSoutenances.entrySet()) {
            Soutenance soutenance = entry.getValue();
            if (soutenance.getResultat() == TResultat.validé) {
                sv.add(soutenance);
            }
        }
        return sv;
    }
    public void afficherMeilleureSoutenanceValidee() {
        ArrayList<Soutenance> sv = lesSoutenancesValidees();
        if (sv.isEmpty()) {
            System.out.println("Aucune soutenance validée.");
            return;
        }
        Soutenance ms = sv.get(0);
        for (Soutenance soutenance : sv) {
            if (soutenance.getNoteSoutenance() > ms.getNoteSoutenance()) {
                ms = soutenance;
            }
        }
        System.out.println("Meilleure soutenance validée : " + ms);
    }
}
