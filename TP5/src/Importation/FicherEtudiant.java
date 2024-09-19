package Importation;

import java.util.TreeSet;

public class FicherEtudiant {
    private String Repertoire;
    private String nomFichier;

    public FicherEtudiant(String Repertoire, String nomFichier) {
        this.Repertoire = Repertoire;
        this.nomFichier = nomFichier;
    }
    public TreeSet<Etudiant> importer(){
        TreeSet<Etudiant> r = new TreeSet();
        return r;
    }
}
