
package DAO;

import Gestion.Client;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestDao {
    public static void main(String args[]) throws SQLException{
    ArrayList<Client> col=DAOClient.lister();
    System.out.println(col.toString());
    TreeSet<Client> col2=DAOClient.listerparVille("Sidi Hssine");
    System.out.println(col2.toString());
    Client col3 = DAOClient.chercher("3");
    System.out.println(col3.toString());
    TreeMap<Integer, Client> col4 = DAOClient.trouver("dhahbi");
    System.out.println(col4.toString());
    Client cl1 = new Client("123", "Amine", "sidi hssine", "Amine@gmail.com");
     Client cl2 = new Client("1", "harboun", "mourouj", "basas@gmail.com");
    boolean ajout = DAOClient.ajouter(cl1);
    boolean ajout1 = DAOClient.ajouter(cl2);
    if (ajout) {
        System.out.println("Client ajouté avec succès à la base de données.");
    } else {
        System.out.println("Échec lors de l'ajout du client à la base de données.");
    }
    
    String nouvelleAdresse = "ben da7a";
    boolean modificationReussie = DAOClient.changerAdresse(cl1, nouvelleAdresse);

    if (modificationReussie) {
        System.out.println("Adresse du client mise à jour avec succès dans la base de données.");
    } else {
        System.out.println("Échec lors de la mise à jour de l'adresse du client dans la base de données.");
    }
    
     boolean suppression = DAOClient.supprimer(cl1);

    if (suppression) {
        System.out.println("Client supprimé avec succès de la base de données.");
    } else {
        System.out.println("Échec lors de la suppression du client de la base de données.");
    }
}
}