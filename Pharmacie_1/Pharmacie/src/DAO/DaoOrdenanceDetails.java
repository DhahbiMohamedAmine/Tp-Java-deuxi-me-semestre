package DAO;

import gestion.OrdenanceDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoOrdenanceDetails {

    public static List<OrdenanceDetails> lister() {
        Connection cn = Conn.seConnecter();
        List<OrdenanceDetails> lesOrdenanceDetails = new ArrayList<>();
        String req = "SELECT od.idRef, od.medId, m.Dénomination " +
                     "FROM ordenancedetails od " +
                     "JOIN médicament m ON od.medId = m.ID_médicament";
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(req);
            while (rs.next()) {
                int idRef = rs.getInt(1);
                int medId = rs.getInt(2);
                String denomination = rs.getString(3);
                OrdenanceDetails od = new OrdenanceDetails(idRef, medId, denomination);
                lesOrdenanceDetails.add(od);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lesOrdenanceDetails;
    }

    public static int ajouter(OrdenanceDetails od) {
        Connection cn = Conn.seConnecter();
        String req = "INSERT INTO ordenancedetails (idRef, medId) VALUES (?, ?)";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, od.getIdREF());
            ps.setInt(2, od.getMedId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return 1;
    }

    public static int modifier(OrdenanceDetails od) {
        Connection cn = Conn.seConnecter();
        String req = "UPDATE ordenancedetails SET medId = ? WHERE idRef = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, od.getMedId());
            ps.setInt(1, od.getIdREF());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return 1;
    }

    public static int supprimer(int idRef) {
        Connection cn = Conn.seConnecter();
        String req = "DELETE FROM ordenancedetails WHERE idRef = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, idRef);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return 1;
    }
    public static List<Integer> getMedIdsByOrderIds(List<Integer> orderIds) {
        Connection cn = Conn.seConnecter();
        List<Integer> medIds = new ArrayList<>();
        if (orderIds.isEmpty()) {
            return medIds;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orderIds.size(); i++) {
            sb.append("?");
            if (i < orderIds.size() - 1) {
                sb.append(",");
            }
        }
        String req = "SELECT medId FROM ordenancedetails WHERE idRef IN (" + sb.toString() + ")";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            for (int i = 0; i < orderIds.size(); i++) {
                ps.setInt(i + 1, orderIds.get(i));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                medIds.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return medIds;
    }
 }
