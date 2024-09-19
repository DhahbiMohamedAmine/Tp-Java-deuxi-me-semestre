
package gestionStage;

public class Stage {
    private int numStage;
    private String spécialite;
    private double noteStage;

    public Stage(int numStage, String spécialite, double noteStage) {
        this.numStage = numStage;
        this.spécialite = spécialite;
        this.noteStage = noteStage;
    }

    @Override
    public String toString() {
        return "Stage{" + "numStage=" + numStage + ", sp\u00e9cialite=" + spécialite + ", noteStage=" + noteStage + '}';
    }

    public double getNoteStage() {
        return noteStage;
    }

    public int getNumStage() {
        return numStage;
    }

    public double HashCode(){
        return this.noteStage;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stage other = (Stage) obj;
        if (this.numStage != other.numStage) {
            return false;
        }
        return true;
    }
    


}
