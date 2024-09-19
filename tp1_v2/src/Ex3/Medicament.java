
package Ex3;

public class Medicament {
    private int ref;
    private String libelle;

    public Medicament(int ref, String libelle) {
        this.ref = ref;
        this.libelle = libelle;
    }
    
    
    @Override
    public int hashCode() {
        return this.ref;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof Medicament){
           Medicament m=(Medicament) obj;
           return m.ref==this.ref && m.libelle.equals(this.libelle);
       }
       return false;
    }

    @Override
    public String toString() {
        return "medicament{" + "ref=" + ref + ", libelle=" + libelle + '}';
    }
    
}