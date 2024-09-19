/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5td1;

/**
 *
 * @author hamad
 */
enum TypeProduit {

    Extra,
    Normal
}

public class Produit {

    private int codeProd;
    private TypeProduit typeProduit;
    private float prix;

    public Produit(int codeProd, TypeProduit typeProduit, float prix) {
        this.codeProd = codeProd;
        this.typeProduit = typeProduit;
        this.prix = prix;
    }

    public int getCodeProd() {
        return codeProd;
    }

    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produit) {
            Produit p = (Produit) o;
            if (this.codeProd == p.codeProd) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return codeProd;
    }

    @Override
    public String toString() {
        return codeProd + " " + typeProduit + " " + prix;
    }

}
