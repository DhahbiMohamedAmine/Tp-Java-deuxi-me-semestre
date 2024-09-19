
package Ex1;

public class Produit implements Comparable{
    private int refProduit;
    private String libelleProduit;
    private double prixProduit;

    public Produit(int refProduit, String libelleProduit, double prixProduit) {
        this.refProduit = refProduit;
        this.libelleProduit = libelleProduit;
        this.prixProduit = prixProduit;
    }

    public int getRefProduit() {
        return refProduit;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setRefProduit(int refProduit) {
        this.refProduit = refProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }
    @Override
    public int compareTo(Object o) {
        Produit p;
        if(o instanceof Produit){
            p=(Produit) o;
            if(this.prixProduit> p.prixProduit)
        {
            return 1;
        }
            else if(this.prixProduit < p.prixProduit)
        {
            return -1;
        }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Produit{" + "refProduit=" + refProduit + ", libelleProduit=" + libelleProduit + ", prixProduit=" + prixProduit + '}';
    }
    public void afficherProduit(){
        System.out.println(this.toString());
    }

    
}
