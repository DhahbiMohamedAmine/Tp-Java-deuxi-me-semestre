package gestionStage;

import java.util.HashSet;
import java.util.Iterator;

public class ServiceStage {
    private String nomService;
    private HashSet<Stage> lesStages = new HashSet<>();

    public ServiceStage(String nomService) {
        this.nomService = nomService;
    }

    public void ajouterStage(Stage s) {
        this.lesStages.add(s);
    }

    public double chercherNote(int numStage) {
        Iterator<Stage> it = this.lesStages.iterator();
        while (it.hasNext()) {
            Stage stage = it.next();
            if (stage.getNumStage() == numStage) {
                return stage.getNoteStage();
            }
        }
        return -1;
    }

    public boolean modifierStage(Stage s) {
        Iterator<Stage> it = this.lesStages.iterator();
        while (it.hasNext()) {
            Stage stage = it.next();
            if (stage.getNumStage() == s.getNumStage()) {
                it.remove(); 
                this.lesStages.add(s); 
                return true;
            }
        }
        return false;
    }

    public void listerStage() {
        for (Stage s : this.lesStages) {
            System.out.println(s.toString());
        }
    }
}
