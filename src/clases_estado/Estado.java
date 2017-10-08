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
    private int codigo;

    public Estado() {
        this.setNombre(this.getClass().getSimpleName());
    }

    public void crearFactura(Lectura lectura) {
        /**
         * Implementacion Trivial*
         */
    }

    public int controlarLectura(Lectura lectura, boolean requiereRevision) {
        /**
         * Implementacion Trivial*
         */
        return -1;
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

    public boolean esPendienteDeRevision() {
        return false;
    }

    public boolean esControladaFacturada() {
        return false;
    }

    public boolean esFacturadaSinControl() {
        return false;
    }

    public boolean esParaEvaluar() {
        return false;
    }

    public boolean esCorregida() {
        return false;
    }

    public boolean esCorregidaFacturada() {
        return false;
    }

    public boolean esRefacturada() {
        return false;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Estado{" + "nombre=" + nombre + '}';
    }
}
