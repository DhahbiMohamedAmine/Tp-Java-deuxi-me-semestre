
package Gestion;

public class User {
    private String email;
    private String password;
    private String nomUser;
    private String numtel;

    public User(String email, String password, String nomUser, String numtel) {
        this.email = email;
        this.password = password;
        this.nomUser = nomUser;
        this.numtel = numtel;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNomUser() {
        return nomUser;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", nomUser=" + nomUser + ", numtel=" + numtel + '}';
    }
    
    
}
