
package Dc2022;

import java.util.LinkedList;
import java.util.ListIterator;

public class Patient implements Comparable<Patient>{
    private int codePatient;
    private String nomPrenom;
    private String numTel;
    private LinkedList lesMaladies = new LinkedList();

    public Patient(int codePatient, String nomPrenom, String numTel) {
        this.codePatient = codePatient;
        this.nomPrenom = nomPrenom;
        this.numTel = numTel;
    }

    
    @Override
    public int compareTo(Patient p) {
        if (this.nomPrenom.equals(p.nomPrenom)){
            return 1;
        }
        else return -1;
    }
    public void ajouterMaladie(Maladie m){
        if(this.lesMaladies.contains(m)){
            System.out.println("Maladie deja existe");
        }
        else
        {
            this.lesMaladies.add(m);
        }
    }
    
    public boolean aMaladieChronique(){
        ListIterator <Maladie> it= this.lesMaladies.listIterator();
        while(it.hasNext()){
            Maladie m=it.next();
            if (m.getTypemaladie() == Type.chronique)
            {
                return true;
            }
            
        }
        return false;
    }
}
