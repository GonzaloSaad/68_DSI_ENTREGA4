/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_dominio;

import clases_estado.Estado;

/**
 *
 * @author Gonzalo
 */
public class Lectura {

    private Estado estado;

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void crearFactura() {
        this.estado.crearFactura(this);
    }

    public void controlarLectura(Propiedad prop) {
        this.estado.controlarLectura(this, prop);
    }

    public void corregirLectura() {
        this.estado.corregirLectura(this);
    }

    public void registrarMotivoDeNoCorreccion() {
        this.estado.registrarMotivoDeNoCorreccion(this);
    }

    public void evaluarLectura() {
        this.estado.evaluarLectura(this);
    }

    public boolean esCreada() {
        return this.estado.esCreada();
    }

    public boolean esFacturada() {
        return this.estado.esFacturada();
    }

}
