/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

public class Cordonnes{
    private String tel;
    private String adr;

    public Cordonnes(String tel, String adr) {
        this.tel = tel;
        this.adr = adr;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setAdr(String adr) {
        this.adr = adr;
    }
    public String getTel() {
        return tel;
    }
    public String getAdr() {
        return adr;
    }

    @Override
    public String toString() {
        return "Cordonnes{" + "tel=" + tel + ", adr=" + adr + '}';
    }

}
