package ex5td1;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

public class Commande implements Comparable<Commande> {
    private int codeCom;
    private HashSet<Produit> listeProd;
    private Date datecomd;

    public Commande(int codeCom) {
        this.codeCom = codeCom;
        this.listeProd = new HashSet<Produit>();
        this.datecomd = new Date();
    }

    public void ajoutProduit(Produit p) {
        this.listeProd.add(p);
    }

    public boolean equals(Object o) {
        Commande c = (Commande) o;
        if (c.codeCom == this.codeCom) {
            return true;
        } else {
            return false;
        }
    }

    public LinkedList<Produit> getListeProd() {
        return new LinkedList<Produit>(this.listeProd);
    }

    public int getCodeCom() {
        return codeCom;
    }

    @Override
    public int compareTo(Commande c) {
        if (this.codeCom > c.codeCom) {
            return 1;
        }
        if (this.codeCom < c.codeCom) {
            return -1;
        }
        return 0;
    }
}
