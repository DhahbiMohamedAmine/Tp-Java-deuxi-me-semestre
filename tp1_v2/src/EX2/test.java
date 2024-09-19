
package EX2;

import java.util.LinkedList;
import java.util.Stack;


public class test {
    public static void main (String[] args){
        Annuaire annuaire = new Annuaire();
        annuaire.ajout("Alice", new Cordonnes("22","adr1"));
        annuaire.ajout("Bob", new Cordonnes("23","adr2"));
        annuaire.ajout("Charlie", new Cordonnes("24","adr3"));
        Cordonnes newCoordBob = new Cordonnes("25","adr4");
        newCoordBob.setTel("123456789");
        newCoordBob.setAdr("123 Rue de la Liberté");
        annuaire.modifCoord("Bob", newCoordBob);
        annuaire.affichCoord("Charlie");
        annuaire.suppression("Alice");
        annuaire.listerNoms();
        annuaire.listerTel();
        annuaire.listerAdr();
        annuaire.affichAnnuaire();
    }
}
