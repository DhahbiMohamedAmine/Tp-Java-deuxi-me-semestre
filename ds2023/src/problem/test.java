
package problem;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        Etudiant2èmeAnnée e1 = new Etudiant2èmeAnnée(101, "Bahroun Firas");
        Etudiant2èmeAnnée e2 = new Etudiant2èmeAnnée(102, "Ben Ammar Nidhal");
        Etudiant2èmeAnnée e3 = new Etudiant2èmeAnnée(103, "Dhahbi Mohamed Amine");
        Soutenance s1 = new Soutenance(1, new Date(), TResultat.validé, 19f, e1);
        Soutenance s2 = new Soutenance(2, new Date(), TResultat.validé, 18.5f, e2);
        Soutenance s3 = new Soutenance(3, new Date(), TResultat.validé, 18f, e3);
        Session session = new Session("Session1", new Date());
        session.ajouterSoutenance(s1);
        session.ajouterSoutenance(s2);
        session.ajouterSoutenance(s3);
        System.out.println("Liste des soutenances validées :");
        for (Soutenance soutenance : session.lesSoutenancesValidees()) {
            System.out.println(soutenance);
        }
        session.afficherMeilleureSoutenanceValidee();
    }
}
