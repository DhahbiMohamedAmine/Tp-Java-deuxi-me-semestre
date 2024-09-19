
package DC2021;

import java.util.Date;

public abstract class Appel {
    protected int codeAppel;
    protected Date dateAppel;
    protected double duree;
    protected int numTelAppel;

    public Appel(int codeAppel, Date dateAppel, double duree, int numTelAppel) {
        this.codeAppel = codeAppel;
        this.dateAppel = dateAppel;
        this.duree = duree;
        this.numTelAppel = numTelAppel;
    }

    public Date getDateAppel() {
        return dateAppel;
    }

    public int getNumTelAppel() {
        return numTelAppel;
    }
    
    public abstract double calculCout();
}
