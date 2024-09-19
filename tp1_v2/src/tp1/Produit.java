
package tp1;

public class Produit implements Comparable <Produit>{
    private int refProduit;
    private String libelleProduit;
    private float prixlibelle;

    public Produit(int refProduit, String libelleProduit, float prixlibelle) {
        this.refProduit = refProduit;
        this.libelleProduit = libelleProduit;
        this.prixlibelle = prixlibelle;
    }

    @Override
    public String toString() {
        return "Produit{" + "refProduit=" + refProduit + ", libelleProduit=" + libelleProduit + ", prixlibelle=" + prixlibelle + '}';
    }
    public void afficher(){System.out.println(this.toString());}

    @Override
    public int compareTo(Produit o) {
        if(this.prixlibelle < o.prixlibelle){return 1;
    }
        else if (this.prixlibelle > o.prixlibelle){return -1;
    }
        else {return 0; }}
}
