
package DAO;

import Gestion.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class DAOClient {
    static Connection cn=LaConnexion.seConnecter();
    TreeSet<Client> clv=new TreeSet();
    public static ArrayList<Client> lister(){
        ArrayList<Client> cl=new ArrayList<>();
        
        String requete="select * from client";
        String codeCl;
        String nomCl,adrCl,emailCl;
        Client c;
        try {
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                codeCl=rs.getString(1);
                nomCl=rs.getString(2);
                adrCl=rs.getString(3);
                emailCl=rs.getString(4);
                c=new Client(codeCl,nomCl,adrCl,emailCl);
                cl.add(c);
            }
            System.out.println("Consultation ok");
        }
        catch(SQLException e){
            System.out.println("probleme de consultation");
        }
       return cl;
    }
    public static TreeSet<Client> listerparVille(String ville) throws SQLException {
    TreeSet<Client> clients = new TreeSet<>();
    String requete = "SELECT * FROM client WHERE adresseCli=?";
    
    try {
        PreparedStatement pst = cn.prepareStatement(requete);
        pst.setString(1, ville);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            String code = rs.getString("codecli");
            String nom = rs.getString("nomcli");
            String adresse = rs.getString("adresseCli");
            String email = rs.getString("emailCli");
            Client client = new Client(code, nom, adresse, email);
            clients.add(client);
        }
       
    } catch (SQLException e) {
  
        System.out.println("probleme de lister les ville");
        throw e; 
    }
    
    return clients;
}
    
public static Client chercher(String codeClient) throws SQLException {
    String requete = "SELECT * FROM client WHERE codecli='" + codeClient + "'";
    Client client = null;
    
    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(requete);

        if (rs.next()) {
            String code = rs.getString("codecli");
            String nom = rs.getString("nomcli");
            String adresse = rs.getString("adresseCli");
            String email = rs.getString("emailCli");
            client = new Client(code, nom, adresse, email);
        }
    } catch (SQLException e) {
        System.out.println("probleme de chercher");
        throw e;
    }
    
    return client;
}

public static TreeMap<Integer, Client> trouver(String chaine) throws SQLException {
        TreeMap<Integer, Client> clientsTrouves = new TreeMap<>();
        String requete = "SELECT * FROM client WHERE nomcli LIKE ?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(requete);
            pst.setString(1, chaine + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String code = rs.getString("codecli");
                String nom = rs.getString("nomcli");
                String adresse = rs.getString("adresseCli");
                String email = rs.getString("emailCli");
                Client client = new Client(code, nom, adresse, email);
                
                clientsTrouves.put(Integer.parseInt(code), client);
            }
        } catch (SQLException e) {
            System.out.println("probleme de trouver");
            throw e;
        }
        return clientsTrouves;
    }

    public static boolean ajouter(Client c) {
    try {
        Client clientExistant = chercher(c.getCodeCli());
        if (clientExistant != null) {
            System.out.println("Le client avec le code '" + c.getCodeCli() + "' existe déjà dans la base de données.");
            return false; 
        }
    } catch (SQLException e) {
        System.out.println("Problème lors de la vérification de l'existence du client.");
        return false;
    }
    String requete = "INSERT INTO client (codecli, nomcli, adresseCli, emailCli) VALUES (?, ?, ?, ?)";
    
    try {
        PreparedStatement pst = cn.prepareStatement(requete);
        pst.setString(1, c.getCodeCli());
        pst.setString(2, c.getNomCli());
        pst.setString(3, c.getAdresseCli());
        pst.setString(4, c.getEmailCli());
        
        int a = pst.executeUpdate();
        return a > 0; 
    } catch (SQLException e) {
        System.out.println("Problème lors de l'ajout du client.");
        return false;
    }
}
    public static boolean changerAdresse(Client client, String nouvelleAdresse) {
    String requete = "UPDATE client SET adresseCli = ? WHERE codecli = ?";
    
    try {
        PreparedStatement pst = cn.prepareStatement(requete);
        pst.setString(1, nouvelleAdresse);
        pst.setString(2, client.getCodeCli());
        
        int a = pst.executeUpdate();
        return a > 0; 
    } catch (SQLException e) {
        System.out.println("probleme de changer l'adresse du client");
        return false;
    }
}
    
    public static boolean supprimer(Client client) {
    String requete = "DELETE FROM client WHERE codecli = ?";
    
    try {
        PreparedStatement pst = cn.prepareStatement(requete);
        pst.setString(1, client.getCodeCli());
        
        int a = pst.executeUpdate();
        return a > 0; 
    } catch (SQLException e) {
        System.out.println("probleme de supprimer le client");
        return false;
    }
}
}