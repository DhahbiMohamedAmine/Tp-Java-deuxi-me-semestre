/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Gestion.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;
public class DAOPatient {
    static Connection cn=LaConnexion.seConnecter();
    TreeSet<Patient> Tp=new TreeSet();
    public static ArrayList<Patient> lister(){
        ArrayList<Patient> Ap=new ArrayList<>();
        
        String requete="select * from patient";
        String codep;
        String nomp,telp;
        Patient p;
        try {
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                codep=rs.getString(1);
                nomp=rs.getString(2);
                telp=rs.getString(3);
                p=new Patient(codep,nomp,telp);
                Ap.add(p);
            }
            System.out.println("Consultation ok");
        }
        catch(SQLException e){
            System.out.println("probleme de consultation");
        }
       return Ap;
    }
    
    
}
