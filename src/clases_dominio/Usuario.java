/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_dominio;

/**
 *
 * @author estre
 */
public class Usuario {

    private String email;
    private boolean supervisor;

    public void setSupervisor(boolean supervisor) {
        this.supervisor = supervisor;
    }

    public boolean esSupervisor() {
        return supervisor;

    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }
}
