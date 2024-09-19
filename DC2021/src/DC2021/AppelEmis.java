
package DC2021;

import java.util.Date;

public class AppelEmis extends Appel{

    public AppelEmis(int codeAppel, Date dateAppel, double duree, int numTelAppel) {
        super(codeAppel, dateAppel, duree, numTelAppel);
    }
    

    @Override
    public double calculCout() {
        return this.duree*50;
    }
    
}
