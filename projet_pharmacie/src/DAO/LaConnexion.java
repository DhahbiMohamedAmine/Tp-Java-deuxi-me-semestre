/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaConnexion {

    private static Connection con;
    private static String user="root";
    private static String passWord="";

    public static Connection seConnecter() {
    if (con == null)// pas de connexion
    {
        try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdgestion", user,
        passWord);
        System.out.println("connexion établie");

        } catch (SQLException ex) {
        System.out.println("bd non trouvée ou problème d&#39;identification " + ex.getMessage());
        }
        }
        return con;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
