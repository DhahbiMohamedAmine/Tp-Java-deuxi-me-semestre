
package EX2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Annuaire {
    private Map<String, Cordonnes> annuaire;

    public Annuaire() {
        annuaire = new HashMap<>();
    }

    public void ajout(String nom, Cordonnes coord) {
        annuaire.put(nom, coord);
    }
    
    public void affichCoord(String nom) {
        Cordonnes coord = annuaire.get(nom);
        if (coord != null) {
            System.out.println("Coordonnées de " + nom + ":");
            System.out.println("Téléphone: " + coord.getTel());
            System.out.println("Adresse: " + coord.getAdr());
        } else {
            System.out.println("Contact introuvable.");
        }
    }

    public void modifCoord(String nom, Cordonnes newCoord) {
        annuaire.put(nom, newCoord);
    }

    public void suppression(String nom) {
        annuaire.remove(nom);
    }

    public void listerNoms() {
        System.out.println("Liste des noms de contacts:");
        Iterator<String> iterator = annuaire.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void listerTel() {
        System.out.println("Liste des numéros de téléphone disponibles:");
        Iterator<Cordonnes> iterator = annuaire.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTel());
        }
    }

    public void listerAdr() {
        System.out.println("Liste des adresses disponibles:");
        Iterator<Cordonnes> iterator = annuaire.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getAdr());
        }
    }

    public void affichAnnuaire() {
        System.out.println("Affichage de l'annuaire complet:");
        Iterator<Map.Entry<String, Cordonnes>> iterator = annuaire.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cordonnes> entry = iterator.next();
            System.out.println("Nom: " + entry.getKey());
            Cordonnes coord = entry.getValue();
            System.out.println("Téléphone: " + coord.getTel());
            System.out.println("Adresse: " + coord.getAdr());
            System.out.println();
        }
    }
}
