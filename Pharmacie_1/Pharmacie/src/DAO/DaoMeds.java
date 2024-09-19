package DAO;

import gestion.Med;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoMeds {
    public static ArrayList<Med> lister(){
        Connection cn = Conn.seConnecter();
        ArrayList<Med> lesMeds = new ArrayList<>();
        String req = "select * from médicament";
        int id_Medicament;
        String denomination,composition,forme_Pharmaceutique,dosage,type;
        float prix;
        Med p;
        try{
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(req);
            while(rs.next()){
                id_Medicament = rs.getInt(1);
                denomination=rs.getString(2);
                composition=rs.getString(3);
                forme_Pharmaceutique=rs.getString(4);
                dosage=rs.getString(5);
                prix=rs.getFloat(6);
                type=rs.getString(7);
                p = new Med(id_Medicament,denomination,composition,forme_Pharmaceutique,dosage,prix,type);
                lesMeds.add(p);
            }
        }catch(SQLException ex){
              System.out.println(ex.getMessage());
        }
        return lesMeds;
    }
    
    public static int ajouter(Med p) {
        Connection cn = Conn.seConnecter();
        String req = "insert into médicament ( `Dénomination`, `Composition`, `Forme_pharmaceutique`, `Dosage`, `Prix`, `Type`)  values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, p.getDenomination());
            ps.setString(2, p.getComposition());
            ps.setString(3, p.getForme_Pharmaceutique());
            ps.setString(4, p.getDosage());
            ps.setFloat(5, p.getPrix());
            ps.setString(6, p.getType());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
    
    public static int modifier(Med p) {
        Connection cn = Conn.seConnecter();
        String req = "update médicament set Dénomination =?, Composition =?, Forme_pharmaceutique =?, Dosage =?, Prix =?, Type =? where ID_médicament  =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, p.getDenomination());
            ps.setString(2, p.getComposition());
            ps.setString(3,p.getForme_Pharmaceutique() );
            ps.setString(4, p.getDosage());
            ps.setFloat(5, p.getPrix());
            ps.setString(6, p.getType());
            ps.setInt(7,p.getId_Medicament());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
    
    public static int supprimer(int Id_Medicament) {
        Connection cn = Conn.seConnecter();
        String req = "delete from médicament where ID_médicament  =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, Id_Medicament);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
    
    public static ArrayList<Med> listerByIds(List<Integer> medIds) {
        Connection cn = Conn.seConnecter();
        ArrayList<Med> lesMeds = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < medIds.size(); i++) {
            sb.append("?");
            if (i < medIds.size() - 1) {
                sb.append(",");
            }
        }
        String req = "select * from médicament where ID_médicament in (" + sb.toString() + ")";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            for (int i = 0; i < medIds.size(); i++) {
                ps.setInt(i + 1, medIds.get(i));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_Medicament = rs.getInt(1);
                String denomination = rs.getString(2);
                String composition = rs.getString(3);
                String forme_Pharmaceutique = rs.getString(4);
                String dosage = rs.getString(5);
                float prix = rs.getFloat(6);
                String type = rs.getString(7);
                Med p = new Med(id_Medicament, denomination, composition, forme_Pharmaceutique, dosage, prix, type);
                lesMeds.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lesMeds;
    }
    
      public static List<Med> getIdByDenomination() {
        Connection cn = Conn.seConnecter();
        List<Med> medications = new ArrayList<>();
        String req = "SELECT ID_médicament, Dénomination FROM médicament";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_médicament");
                String denomination = rs.getString("Dénomination");
                medications.add(new Med(id, denomination));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return medications;
    }
      public static int getIdByDenomination(String denomination) {
        Connection cn = Conn.seConnecter();
        int medId = -1; // Initialize with a default value
        String req = "SELECT ID_médicament FROM médicament WHERE Dénomination = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, denomination);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return medId;
    }
      public static Med fetchMedById(int id) {
        Connection cn = Conn.seConnecter();
        Med med = null;
        String req = "SELECT * FROM médicament WHERE ID_médicament = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id_Medicament = rs.getInt(1);
                String denomination = rs.getString(2);
                String composition = rs.getString(3);
                String forme_Pharmaceutique = rs.getString(4);
                String dosage = rs.getString(5);
                float prix = rs.getFloat(6);
                String type = rs.getString(7);
                med = new Med(id_Medicament, denomination, composition, forme_Pharmaceutique, dosage, prix, type);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return med;
    }
}

