/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_dominio;

/**
 *
 * @author Gonzalo
 */
public class Instalacion {

    private Medidor medidor;

    public void controlarLectura(Propiedad prop) {
        this.medidor.controlarLectura(prop);
    }

}
