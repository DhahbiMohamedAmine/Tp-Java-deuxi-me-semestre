package Comptabilte;

public class Facture implements Comparable {
    private int num;
    private double montantHorsTaxe;
    private double TVA;

    public Facture(int num, double montantHorsTaxe, double TVA) {
        this.num = num;
        this.montantHorsTaxe = montantHorsTaxe;
        this.TVA = TVA;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMontantHorsTaxe() {
        return montantHorsTaxe;
    }

    public void setMontantHorsTaxe(double montantHorsTaxe) {
        this.montantHorsTaxe = montantHorsTaxe;
    }

    public double getTVA() {
        return TVA;
    }

    public void setTVA(double TVA) {
        this.TVA = TVA;
    }

    @Override
    public String toString() {
        return "Facture{" + "num=" + num + ", montantHorsTaxe=" + montantHorsTaxe + ", TVA=" + TVA + '}';
    }
    
    public double calculMontant(){
        return this.montantHorsTaxe*(this.TVA+100)/100;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Facture)
        {
            Facture f=(Facture)o;
            if(this.calculMontant() > f.calculMontant()){
            return 1;
        }
        else if(this.calculMontant() < f.calculMontant()){
            return -1;
        }
        }
        return 0;
    }
}
