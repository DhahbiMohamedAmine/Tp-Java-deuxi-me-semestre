
package problem;

public class Etudiant2èmeAnnée implements Comparable{
    private int matricule;
    private String nomPrenom;

    public Etudiant2èmeAnnée(int matricule, String nomPrenom) {
        this.matricule = matricule;
        this.nomPrenom = nomPrenom;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    @Override
    public String toString() {
        return "Etudiant2èmeAnnée{" + "matricule=" + matricule + ", nomPrenom=" + nomPrenom + '}';
    }
    
    @Override
    public int compareTo(Object o) {
        if(o instanceof Etudiant2èmeAnnée){
            Etudiant2èmeAnnée e=(Etudiant2èmeAnnée)o;
            if(this.matricule>e.matricule){
                return 1;
            }
            else if(this.matricule<e.matricule){
                return -1;
            }
        }
        return 0;
    }
    
    
}
