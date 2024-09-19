/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamad
 */

    interface VendableParKilogramme {
    double vendre(double quantite);
}

interface VendableParPiece {
    double vendre(int quantite);
}

interface SusceptibleDeterVenduEnSolde {
    void lancerSolde(double pourcentage);
    void terminerSolde(double pourcentage);
}

interface Descriptible {
    void decrire();
}

interface RendementCalculable {
    double calculerRendement();
}

