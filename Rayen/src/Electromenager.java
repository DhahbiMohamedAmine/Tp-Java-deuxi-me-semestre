/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamad
 */
class Electromenager extends Article implements VendableParPiece, SusceptibleDeterVenduEnSolde {
    private int stock;

    public Electromenager(int stock, double prixAchat, double prixVente, String nom, String fournisseur) {
        super(prixAchat, prixVente, nom, fournisseur);
        this.stock = stock;
    }

    public void remplirStock(int quantite) {
        stock += quantite;
    }

    @Override
    public double vendre(int quantite) {
        stock -= quantite;
        return quantite * prixVente;
    }

    @Override
    public void lancerSolde(double pourcentage) {
        prixVente -= prixVente * (pourcentage / 100);
    }

    @Override
    public void terminerSolde(double pourcentage) {
        prixVente += prixVente * (pourcentage / 100);
    }

    @Override
    public void decrire() {
        super.decrire();
        System.out.println("Stock: " + stock);
    }
}
