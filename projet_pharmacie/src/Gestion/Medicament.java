
package Gestion;
enum typemed{
normal,
special
}
public class Medicament {
    private int codemed;
    private String nomMed;
    private double prixMed;
    private typemed type;

    public Medicament(int codemed, String nomMed, double prixMed, typemed type) {
        this.codemed = codemed;
        this.nomMed = nomMed;
        this.prixMed = prixMed;
        this.type = type;
    }

    public int getCodemed() {
        return codemed;
    }

    public String getNomMed() {
        return nomMed;
    }

    public double getPrixMed() {
        return prixMed;
    }

    public typemed getType() {
        return type;
    }

    public void setCodemed(int codemed) {
        this.codemed = codemed;
    }

    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    public void setPrixMed(double prixMed) {
        this.prixMed = prixMed;
    }

    public void setType(typemed type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Medicament{" + "codemed=" + codemed + ", nomMed=" + nomMed + ", prixMed=" + prixMed + ", type=" + type + '}';
    }
    
    
}
