
package problem;

import java.util.Date;

enum TResultat {

    validé,
    nonValidé
}


public class Soutenance {
  private int codeSoutenance;
  private Date dateSoutenance;
  private TResultat resultat;
  private float noteSoutenance;
  private Etudiant2èmeAnnée Etudiant;

    public Soutenance(int codeSoutenance, Date dateSoutenance, TResultat resultat, float noteSoutenance, Etudiant2èmeAnnée Etudiant) {
        this.codeSoutenance = codeSoutenance;
        this.dateSoutenance = dateSoutenance;
        this.resultat = resultat;
        this.noteSoutenance = noteSoutenance;
        this.Etudiant = Etudiant;
    }

    public TResultat getResultat() {
        return resultat;
    }

    public float getNoteSoutenance() {
        return noteSoutenance;
    }

    public Etudiant2èmeAnnée getEtudiant() {
        return Etudiant;
    }

    @Override
    public String toString() {
        return "Soutenance{" + "codeSoutenance=" + codeSoutenance + ", dateSoutenance=" + dateSoutenance + ", resultat=" + resultat + ", noteSoutenance=" + noteSoutenance + ", Etudiant=" + Etudiant + '}';
    }
  
  
}
