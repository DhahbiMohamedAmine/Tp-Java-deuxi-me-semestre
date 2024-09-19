/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comptabilte;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;


public class Paiment {
    
    public enum Type{
    espèce,
    chèque,
    traite
}
    private Date date;
    private Type type;
    private TreeSet<Facture> lesFactures=new TreeSet();

    public Paiment(Date date, Type type) {
        this.date = date;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public TreeSet<Facture> getLesFactures() {
        return lesFactures;
    }

    public void setLesFactures(TreeSet<Facture> lesFactures) {
        this.lesFactures = lesFactures;
    }

    @Override
    public String toString() {
        return "Paiment{" + "date=" + date + ", type=" + type + ", lesFactures=" + lesFactures + '}';
    }
    public Facture charcherFacture(int num){
        Facture r=null;
        Iterator<Facture> it= lesFactures.iterator();
        while(it.hasNext()){
            r=it.next();
            if(r.getNum()==num){
                return r;
            }
        }
        return r;
    }
    public void ajouterFacture(Facture f){
        this.lesFactures.add(f);
    }
}
