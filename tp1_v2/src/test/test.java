package test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

enum typeProduit {
    Extra, Normal
}

class produit {

    private int codeProduit;
    private typeProduit typeProduit;
    private float prix;

    public produit(int codeProduit, typeProduit typeProduit, float prix) {
        this.codeProduit = codeProduit;
        this.typeProduit = typeProduit;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "codeProduit=" + codeProduit + ", typeProduit="
                + typeProduit + ", prix=" + prix + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof produit) {
            produit p = (produit) o;
            return p.codeProduit == codeProduit && p.typeProduit == typeProduit && p.prix == prix;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codeProduit);
    }

    public int getCodeProduit() {
        return codeProduit;
    }

    public typeProduit getTypeProduit() {
        return typeProduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setCodeProduit(int codeProduit) {
        this.codeProduit = codeProduit;
    }

    public void setTypeProduit(typeProduit typeProduit) {
        this.typeProduit = typeProduit;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

}

class commande implements Comparable<commande> {

    private String codeCommande;
    private TreeSet<produit> lesProduits;
    private Date dateCommande;

    public commande(String codeCommande, Date dateCommande) {
        this.codeCommande = codeCommande;
        this.lesProduits = new TreeSet<>((p1, p2) -> Integer.compare(p1.getCodeProduit(), p2.getCodeProduit()));
        this.dateCommande = dateCommande;
    }

    public void ajouterProduit(produit p) {
        this.lesProduits.add(p);
    }

    public void afficherCommande() {
        System.out.println(this);
    }

    @Override
    public int compareTo(commande o) {
        return this.codeCommande.compareTo(o.codeCommande);
    }

    public String getCodeCommande() {
        return codeCommande;
    }

    public TreeSet<produit> getLesProduits() {
        return lesProduits;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    @Override
    public String toString() {
        return "commande{" + "codeCommande=" + codeCommande + ", lesProduits="
                + lesProduits + ", dateCommande=" + dateCommande + '}';
    }

}

class stockageCommande {

    private int codeStockage;
    private String ville;
    private TreeSet<commande> listeCommande;

    public stockageCommande(int codeStockage, String ville) {
        this.codeStockage = codeStockage;
        this.ville = ville;
        this.listeCommande = new TreeSet<>();
    }

    public void ajouterCommande(commande c) {
        this.listeCommande.add(c);
    }

    public LinkedList<produit> chercherProduit(String num) {
        LinkedList<produit> l = new LinkedList<>();
        Iterator<commande> it = this.listeCommande.iterator();
        while (it.hasNext()) {
            commande c = it.next();
            if (c.getCodeCommande().equals(num)) {
                l = new LinkedList<>(c.getLesProduits());
            }
        }
        return l;
    }

    public LinkedList<produit> chercherExtraProduit(String num) {
        ListIterator<produit> i;
        LinkedList<produit> l = this.chercherProduit(num);
        i = l.listIterator();
        while (i.hasNext()) {
            if (i.next().getTypeProduit() == typeProduit.Normal) {
                i.remove();
            }
        }
        return l;
    }

    @Override
    public String toString() {
        return "StockageCommande{" + "codeStockage=" + codeStockage + ", ville="
                + ville + ", listeCommande=" + listeCommande + '}';
    }

    public void afficher() {
        System.out.print(this);
    }
}

public class test {

    public static void main(String[] args) {
        produit p1 = new produit(55, typeProduit.Extra, 100);
        produit p2 = new produit(2, typeProduit.Extra, 200);
        produit p3 = new produit(100, typeProduit.Normal, 50);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        commande c1 = new commande("c1", new Date());
        commande c2 = new commande("c2", new Date());
        c1.ajouterProduit(p2);
        c1.ajouterProduit(p3);
        c1.ajouterProduit(p1);
        c1.afficherCommande();
        stockageCommande s = new stockageCommande(1, "Tunis");
        s.ajouterCommande(c1);
        s.ajouterCommande(c2);
        s.afficher();
        System.out.print("\n");
        System.out.print(s.chercherProduit("c2"));
        System.out.print("\n");
        System.out.print(s.chercherExtraProduit("c1"));
    }
}
