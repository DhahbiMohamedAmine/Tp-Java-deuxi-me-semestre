/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamad
 */
class Magasin {
    private double depenses;
    private double revenus;
    private Article[] electromenagers;
    private Article[] primeurs;

    public Magasin() {
        this.depenses = 0;
        this.revenus = 0;
        this.electromenagers = new Electromenager[2];
        this.primeurs = new Primeur[2];
    }

    public void descriptionEtatMagasin() {
        System.out.println("Dépenses: " + depenses);
        System.out.println("Revenus: " + revenus);
        for (Article article : electromenagers) {
            if (article != null) article.decrire();
        }
        for (Article article : primeurs) {
            if (article != null) article.decrire();
        }
    }

    public double calculerRendement() {
        return (revenus - depenses) / depenses;
    }

    public void ajouterArticle(Article article, boolean estElectromenager) {
        if (estElectromenager) {
            for (int i = 0; i < electromenagers.length; i++) {
                if (electromenagers[i] == null) {
                    electromenagers[i] = article;
                    depenses += article.prixAchat;
                    return;
                }
            }
        } else {
            for (int i = 0; i < primeurs.length; i++) {
                if (primeurs[i] == null) {
                    primeurs[i] = article;
                    depenses += article.prixAchat;
                    return;
                }
            }
        }
        throw new IllegalStateException("Pas de place pour plus d'articles.");
    }

    public void vendreArticle(Article article, double quantite) {
        if (article instanceof VendableParPiece) {
            revenus += ((VendableParPiece) article).vendre((int) quantite);
        } else if (article instanceof VendableParKilogramme) {
            revenus += ((VendableParKilogramme) article).vendre(quantite);
        }
    }
}
