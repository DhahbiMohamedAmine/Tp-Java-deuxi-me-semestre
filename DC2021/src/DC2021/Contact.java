
package DC2021;


public class Contact implements Comparable<Contact>{
    private int codeContact;
    private String nom;
    private int numTel;

    public Contact(int codeContact, String nom, int numTel) {
        this.codeContact = codeContact;
        this.nom = nom;
        this.numTel = numTel;
    }
    public String getNom() {
        return nom;
    }
    public int getNumTel() {
        return numTel;
    }
    @Override
    public String toString() {
        return "Contact{" + "codeContact=" + codeContact + ", nom=" + nom + ", numTel=" + numTel + '}';
    }
    @Override
    public int compareTo(Contact c) {
        if(this.numTel > c.numTel){
            return 1;
        }
        else if(this.numTel < c.numTel){
            return -1;
        }
        return 0;
    }
}
