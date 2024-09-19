
package Dc2023;

import java.util.Date;

enum TResultat{
        validé,
        nonvalidé
    }

public class Soutenance implements Comparable<Soutenance>{
    private int codeSoutenance;
    private Date dateSoutenance;
    private TResultat resultat;
    private double noteSoutenance;
    private Etudiant2emeAnne etudiant;
    
    @Override
    public int compareTo(Soutenance s) {
        if(this.noteSoutenance > s.noteSoutenance)
        {
            return 1;
        }
        else if(this.noteSoutenance < s.noteSoutenance)
        {
            return -1;
        }
        return 0;
    }

    public Soutenance(int codeSoutenance, Date dateSoutenance, TResultat resultat, double noteSoutenance, Etudiant2emeAnne etudiant) {
        this.codeSoutenance = codeSoutenance;
        this.dateSoutenance = dateSoutenance;
        this.resultat = resultat;
        this.noteSoutenance = noteSoutenance;
        this.etudiant = etudiant;
    }

    public TResultat getResultat() {
        return resultat;
    }

    public double getNoteSoutenance() {
        return noteSoutenance;
    }

    public Etudiant2emeAnne getEtudiant() {
        return etudiant;
    }

    @Override
    public String toString() {
        return "Soutenance{" + "codeSoutenance=" + codeSoutenance + ", dateSoutenance=" + dateSoutenance + ", resultat=" + resultat + ", noteSoutenance=" + noteSoutenance + ", etudiant=" + etudiant + '}';
    }
}
