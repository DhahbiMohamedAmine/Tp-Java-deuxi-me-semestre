/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamad
 */
class Primeur extends Article implements VendableParKilogramme {
    private double stock;

    public Primeur(double stock, double prixAchat, double prixVente, String nom, String fournisseur) {
        super(prixAchat, prixVente, nom, fournisseur);
        this.stock = stock;
    }

    

    public void remplirStock(double quantite) {
        stock += quantite;
    }

    @Override
    public double vendre(double quantite) {
        stock -= quantite;
        return quantite * prixVente;
    }

    @Override
    public void decrire() {
        super.decrire();
        System.out.println("Stock: " + stock + " kg");
    }
}

