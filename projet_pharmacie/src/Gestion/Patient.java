
package Gestion;

public class Patient implements Comparable<Patient>{
    private String codePatient;
    private String nomPatient;
    private String telPatient;

    public Patient(String codePatient, String nomPatient, String telPatient) {
        this.codePatient = codePatient;
        this.nomPatient = nomPatient;
        this.telPatient = telPatient;
    }

    public String getCodePatient() {
        return codePatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getTelPatient() {
        return telPatient;
    }

    public void setCodePatient(String codePatient) {
        this.codePatient = codePatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public void setTelPatient(String telPatient) {
        this.telPatient = telPatient;
    }

    @Override
    public String toString() {
        return "Patient{" + "codePatient=" + codePatient + ", nomPatient=" + nomPatient + ", telPatient=" + telPatient + '}';
    }
    @Override
    public int compareTo(Patient o) {
        return this.codePatient.compareTo(o.codePatient);    
    }
    
}
