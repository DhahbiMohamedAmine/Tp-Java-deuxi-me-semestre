
package Dc2022;
enum Type{
    chronique,
    nonchronique
}

public class Maladie {
    private String nomMaladie;
    private Type typemaladie;

    public Maladie(String nomMaladie, Type typemaladie) {
        this.nomMaladie = nomMaladie;
        this.typemaladie = typemaladie;
    }

    public String getNomMaladie() {
        return nomMaladie;
    }

    public Type getTypemaladie() {
        return typemaladie;
    }

    @Override
    public String toString() {
        return "Maladie{" + "nomMaladie=" + nomMaladie + ", typemaladie=" + typemaladie + '}';
    }
    
}

