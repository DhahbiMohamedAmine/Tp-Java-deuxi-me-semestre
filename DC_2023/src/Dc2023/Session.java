
package Dc2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Session {
    private int codeSession;
    private Date dateSession;
    private TreeMap <Etudiant2emeAnne, Soutenance> lesSoutenances = new TreeMap();

    public Session(int codeSession, Date dateSession) {
        this.codeSession = codeSession;
        this.dateSession = dateSession;
    }
    
    public void ajouterSoutenance(Soutenance s){
        Etudiant2emeAnne e=s.getEtudiant();
        this.lesSoutenances.put(e, s);
    }
    public void modifierResultat(Soutenance s){
        if(this.lesSoutenances.containsKey(s.getEtudiant())){
            this.lesSoutenances.put(s.getEtudiant(), s);
        }
    }
    public Soutenance avoirResultat(int matricule){
        Soutenance s=null;
        for (Map.Entry<Etudiant2emeAnne, Soutenance> entry:this.lesSoutenances.entrySet()){
            if(entry.getKey().getMatricule()== matricule){
                s=entry.getValue();
            }
        }
        return s;
    }
    
    public ArrayList<Soutenance> lesSoutenancesValidees(){
        ArrayList<Soutenance> v=new ArrayList();
        Iterator <Soutenance> it =this.lesSoutenances.values().iterator();
        while(it.hasNext()){
            Soutenance s=it.next();
            if(s.getResultat()==TResultat.validé){
                v.add(s);
            }
        }
        return v;
    }
    public void afficherMeilleurSoutenanceValidées(){
        ArrayList<Soutenance> res=this.lesSoutenancesValidees();
        Collections.sort(res);
        System.out.println("Meilleure soutenance est"+res.get(res.size()-1).toString());
        
    }
    
}
