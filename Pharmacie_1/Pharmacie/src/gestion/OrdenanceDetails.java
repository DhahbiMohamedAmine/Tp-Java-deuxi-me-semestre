/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

/**
 *
 * @author user
 */
public class OrdenanceDetails {
    private int idREF;
    private int medId;
    private String medname;

    public OrdenanceDetails(int idREF, int medId) {
        this.idREF = idREF;
        this.medId = medId;
    }

    public OrdenanceDetails(int idREF, int medId, String medname) {
        this.idREF = idREF;
        this.medId = medId;
        this.medname = medname;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    
    public int getIdREF() {
        return idREF;
    }

    public void setIdREF(int idREF) {
        this.idREF = idREF;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    @Override
    public String toString() {
        return "OrdenanceDetails{" + "idREF=" + idREF + ", medId=" + medId + '}';
    }
    
    
}
