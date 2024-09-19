package DAO;

import gestion.Patient;
import gestion.Med;
import gestion.Ordennace;
import gestion.Utilsateur;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testDAO {
    public static void main(String [] args){
        //*afficher les patient
        ArrayList<Patient> lesPatient = DaoPatient.lister();
        System.out.println("afficher : "+lesPatient.toString());
        ArrayList<Med> lesMeds = DaoMeds.lister();
        System.out.println("afficher : "+lesMeds.toString());
        ArrayList<Utilsateur> lesUsers = DaoUser.lister();
        System.out.println("afficher users: "+lesUsers.toString());
        List<Ordennace> ord = DaoOrd.lister();
        System.out.println("afficher users: "+ord.toString());
        //ajouter
        //Patient p1 = new Patient("P011","firas","bahroun",new Date(2002,04,18),"M","mouroj4",53919770);
        //if(DaoPatient.ajouter(p1)==1){System.out.println("ajouter avec succes");}
        
        //Patient p1 = DaoPatient.lister().get(0); // get the first patient record from the database
        //p1.setAdresse("jerba"); // update the adresse field of the p1 object
        //if(DaoPatient.modifier(p1)==1) System.out.println("updated");
        
        //if(DaoPatient.supprimer("P011")==1)System.out.println("deleted");
    }
}
