
package DC2021;

import java.util.Date;

public class AppelReçue extends Appel{

    public AppelReçue(int codeAppel, Date dateAppel, double duree, int numTelAppel) {
        super(codeAppel, dateAppel, duree, numTelAppel);
    }

    @Override
    public double calculCout() {
        return 0;
    }
}
