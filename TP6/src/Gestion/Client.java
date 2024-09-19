/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

/**
 *
 * @author nidha
 */
public class Client implements Comparable<Client>{
    private String codeCli;
    private String nomCli;
    private String adresseCli;
    private String emailCli;

    public Client(String codeCli, String nomCli, String adresseCli, String emailCli) {
        this.codeCli = codeCli;
        this.nomCli = nomCli;
        this.adresseCli = adresseCli;
        this.emailCli = emailCli;
    }

    public String getCodeCli() {
        return codeCli;
    }

    public void setCodeCli(String codeCli) {
        this.codeCli = codeCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getAdresseCli() {
        return adresseCli;
    }

    public void setAdresseCli(String adresseCli) {
        this.adresseCli = adresseCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    @Override
    public String toString() {
        return "Client{" + "codeCli=" + codeCli + ", nomCli=" + nomCli + ", adresseCli=" + adresseCli + ", emailCli=" + emailCli + '}';
    }

    @Override
    public int compareTo(Client o) {
        return this.codeCli.compareTo(o.codeCli);    
    }
}