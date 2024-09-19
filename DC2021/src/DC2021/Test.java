
package DC2021;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        AppareilTéléphonique A1=new AppareilTéléphonique(1,25369741);
        Contact c1=new Contact(1,"Salah",25369741);
        A1.enregistrer(c1);
        Date date = new Date(120, 4, 5);
        AppelEmis Ap=new AppelEmis(2,date,5,58963147);
        A1.enregistrer(date.getSeconds(), Ap);
       try {
            Contact contactConsulte = A1.consulter(55328963);
            System.out.println("Contact consulté : " + contactConsulte);
        } catch (ContactInexistant e) {
            System.out.println(e.getMessage());
        }
    }
    
}
