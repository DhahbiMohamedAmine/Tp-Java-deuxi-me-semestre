package ex5td1;

import java.util.LinkedList;

public class test {

    public static void main(String[] args) {
        // Create some products
        Produit produit1 = new Produit(1, TypeProduit.Normal, 10.0f);
        Produit produit2 = new Produit(2, TypeProduit.Extra, 15.0f);
        Produit produit3 = new Produit(3, TypeProduit.Normal, 20.0f);

        // Create some orders and add products to them
        Commande commande1 = new Commande(101);
        commande1.ajoutProduit(produit1);
        commande1.ajoutProduit(produit2);

        Commande commande2 = new Commande(102);
        commande2.ajoutProduit(produit2);
        commande2.ajoutProduit(produit3);

        // Create a storage location and add orders to it
        StockCommande stockage = new StockCommande(1001, "Example City");
        stockage.ajouterComm(commande1);
        stockage.ajouterComm(commande2);

        // Test searching for products in an order
        LinkedList<Produit> produitsCommande1 = stockage.chercherProduit(101);
        System.out.println("Products in order 101:");
        if (produitsCommande1 != null) {
            for (Produit produit : produitsCommande1) {
                System.out.println(produit);
            }
        } else {
            System.out.println("Order not found.");
        }

        // Test searching for 'NORMALE' products in an order
        LinkedList<Produit> normaleProduitsCommande2 = stockage.chercherExtratProduit(102);
        System.out.println("NORMALE products in order 102:");
        if (normaleProduitsCommande2 != null) {
            for (Produit produit : normaleProduitsCommande2) {
                System.out.println(produit);
            }
        } else {
            System.out.println("Order not found.");
        }
    }
}
