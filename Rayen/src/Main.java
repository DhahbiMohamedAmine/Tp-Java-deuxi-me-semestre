/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamad
 */
public class Main {
    public static void main(String[] args) {
        Magasin magasin = new Magasin();

        Electromenager frigo = new Electromenager(0,200, 300, "Frigo", "Samsung");
        Electromenager laveLinge = new Electromenager(0,150, 250, "Lave-linge", "LG");

        Primeur pomme = new Primeur(0,1, 2, "Pomme", "VergerLocal");
        Primeur banane = new Primeur(0,1.5, 2.5, "Banane", "TropiqueSoleil");

        magasin.ajouterArticle(frigo, true);
        magasin.ajouterArticle(laveLinge, true);

        magasin.ajouterArticle(pomme, false);
        magasin.ajouterArticle(banane, false);

        frigo.remplirStock(10);
        laveLinge.remplirStock(5);

        pomme.remplirStock(100);
        banane.remplirStock(50);

        magasin.vendreArticle(frigo, 2);
        magasin.vendreArticle(pomme, 20);

        magasin.descriptionEtatMagasin();
        System.out.println("Rendement du magasin: " + magasin.calculerRendement());
    }
}
