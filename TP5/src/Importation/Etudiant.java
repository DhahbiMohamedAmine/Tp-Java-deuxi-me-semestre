
package Importation;

public class Etudiant {
    private String nom;
    private String prenom;

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "nom=" + nom + ", prenom=" + prenom + '}';
    }
    
}
