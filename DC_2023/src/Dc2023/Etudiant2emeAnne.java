
package Dc2023;

public class Etudiant2emeAnne implements Comparable<Etudiant2emeAnne>{
    private int matricule;
    private String nomPrenom;

    public Etudiant2emeAnne(int matricule, String nomPrenom) {
        this.matricule = matricule;
        this.nomPrenom = nomPrenom;
    }

    public int getMatricule() {
        return matricule;
    }

    @Override
    public String toString() {
        return "Etudiant2emeAnne{" + "matricule=" + matricule + ", nomPrenom=" + nomPrenom + '}';
    }

    @Override
    public int compareTo(Etudiant2emeAnne e) {
        if(this.matricule > e.matricule){
            return 1;
        }
        else if(this.matricule < e.matricule){
            return -1;
        }
        return 0;
    }


    
    
}
