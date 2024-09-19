package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import gestion.Ordennace;

public class DaoOrd {

    public static List<Ordennace> lister() {
        Connection cn = Conn.seConnecter();
        List<Ordennace> lesOrdenances = new ArrayList<>();
        String req = "SELECT * FROM Ordenance";
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(req);
            while (rs.next()) {
                int id = rs.getInt(1);
                int userId = rs.getInt(2);
                Ordennace o = new Ordennace(id, userId);
                lesOrdenances.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lesOrdenances;
    }

    public static int ajouter(Ordennace o) {
        Connection cn = Conn.seConnecter();
        String req = "INSERT INTO Ordenance (userId) VALUES (?)";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, o.getUserId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return 1;
    }

    public static int modifier(Ordennace o) {
        Connection cn = Conn.seConnecter();
        String req = "UPDATE Ordenance SET userId = ? WHERE id = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, o.getUserId());
            ps.setInt(2, o.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return 1;
    }

    public static int supprimer(int id) {
        Connection cn = Conn.seConnecter();
        String req = "DELETE FROM Ordenance WHERE id = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return 1;
    }
    
    public static List<Integer> getOrdersByUserId(int userId) {
        Connection cn = Conn.seConnecter();
        List<Integer> orderIds = new ArrayList<>();
        String req = "SELECT id FROM Ordenance WHERE userId = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderIds.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return orderIds;
    }
}
