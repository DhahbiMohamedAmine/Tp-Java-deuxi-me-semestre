
package DC2021;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class AppareilTéléphonique {
    private int codeAppareil;
    private int numTelAppareil;
    private LinkedList <Contact> Repertoire = new LinkedList();
    private HashMap <Integer,Appel> Journal = new HashMap();

    public AppareilTéléphonique(int codeAppareil, int numTelAppareil) {
        this.codeAppareil = codeAppareil;
        this.numTelAppareil = numTelAppareil;
    }
    
    public void enregistrer(Contact c){
        if(!this.Repertoire.contains(c)){
            this.Repertoire.add(c);
        }
    }
    public void enregistrer(int dateEnSeconde, Appel a){
        this.Journal.put(dateEnSeconde, a);
    }
    public Contact consulter(int numtel) throws ContactInexistant {
    Iterator<Contact> it = this.Repertoire.iterator();
    while (it.hasNext()) {
        Contact c = it.next();
        if (c.getNumTel() == numtel) {
            return c;
        }
    }
    throw new ContactInexistant("Contact inexistant");
}
    
    public TreeSet <Contact> Consulter(String motClé){
        TreeSet <Contact> t=new TreeSet();
        Iterator<Contact> it=this.Repertoire.iterator();
        while(it.hasNext()){
            Contact c=it.next();
            if(c.getNom().equals(motClé)){
                t.add(c);
            }
        }
        return t;
    }
    
    public double coutAppels(Date d1, Date d2) {
        double coutTotal = 0;

        for (Appel appel : this.Journal.values()) {
            Date dateAppel = appel.getDateAppel();

            if (dateAppel.after(d1) && dateAppel.before(d2)) {
                coutTotal += appel.calculCout();
            }
        }
        return coutTotal;
    }
}
/*public Contact consulter(int numtel) throws ContactInexistant {
        for (Contact c : this.Repertoire) {
            if (c.getNumTel() == numtel) {
                return c;
            }
        }
        throw new ContactInexistant("Contact inexistant");
    }*/