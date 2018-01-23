/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alek97
 */
public class Admin {
    private int id;
    private String jmbg;
    private String password;

    public Admin() {
    }

    public Admin(int id, String jmbg, String password) {
        this.id = id;
        this.jmbg = jmbg;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", jmbg=" + jmbg + ", password=" + password + '}';
    }
    
    
}
