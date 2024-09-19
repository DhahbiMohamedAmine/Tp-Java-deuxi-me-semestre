/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionStage;

/**
 *
 * @author hamad
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stage s1=new Stage(15,"DSI",16.5);
        Stage s2=new Stage(19,"SYSEMB",18.87);
        ServiceStage si = new ServiceStage("Si");
        si.ajouterStage(s1);
        si.ajouterStage(s2);
        si.listerStage();
    }
    
}
