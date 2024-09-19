package ex5td1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class StockCommande {

    private int codeStockage;
    private String ville;
    private TreeSet<Commande> listeCommande;

    public StockCommande(int codeStockage, String ville) {
        this.codeStockage = codeStockage;
        this.ville = ville;
        this.listeCommande = new TreeSet<Commande>();
    }

    public void ajouterComm(Commande c) {
        this.listeCommande.add(c);
    }
    
    public LinkedList<Produit> chercherProduit(int numc) {
        Commande c;
        Iterator<Commande> it = this.listeCommande.iterator();
        while (it.hasNext()) {
            c = it.next();
            if (c.getCodeCom() == numc) {
                return c.getListeProd();
            }
        }
        return null;
    }

    public LinkedList<Produit> chercherExtratProduit(int numc) {
        LinkedList<Produit> l = this.chercherProduit(numc);
        for (Produit p : l) {
            if (p.getTypeProduit() == TypeProduit.Normal) {
                l.remove(p);
            }
        }
        return l;
    }
    public int getCodeStockage() {
        return codeStockage;
    }

}
