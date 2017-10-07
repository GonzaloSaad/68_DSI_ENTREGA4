/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_estado;

import clases_dominio.Lectura;

/**
 *
 * @author Gonzalo
 */
public abstract class Estado {

    private String nombre;
    private String ambito;
    private String descripcion;

    public Estado() {
        this.setNombre(this.getClass().getSimpleName());
    }

    
    
    public void crearFactura(Lectura lectura) {
        /**
         * Implementacion Trivial*
         */
    }

    public void controlarLectura(Lectura lectura, boolean requiereRevision) {
        /**
         * Implementacion Trivial*
         */
    }

    public void corregirLectura(Lectura lectura) {
        /**
         * Implementacion Trivial*
         */
    }

    public void registrarMotivoDeNoCorreccion(Lectura lectura) {
        /**
         * Implementacion Trivial*
         */
    }

    public void evaluarLectura(Lectura lectura) {
        /**
         * Implementacion Trivial*
         */
    }

    public boolean esCreada() {
        return false;
    }

    public boolean esFacturada() {
        return false;
    }

    @Override
    public String toString() {
        return "Estado{" + "nombre=" + nombre + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
