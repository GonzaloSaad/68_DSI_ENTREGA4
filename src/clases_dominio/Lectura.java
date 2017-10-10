/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_dominio;

import clases_estado.Estado;
import java.util.Date;

/**
 *
 * @author Gonzalo
 */
public class Lectura {

    private Date fechaHoraLectura;
    private double valorLectura;
    private double valorCorregido;
    private double valorEstimado;
    private Estado estado;

    public void crearFactura() {
        this.estado.crearFactura(this);
    }

    public int controlarLectura(boolean requiereRevision) {
        /**
         * Le pasa el mismo mensaje al estado (PATRON STATE) y adems se pasa a
         * si mismo por parametro.
         */

        return this.estado.controlarLectura(this, requiereRevision);
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

    public boolean esDePeriodo(Date fechaDesde, Date fechaHasta) {
        return (this.fechaHoraLectura.after(fechaDesde) && this.fechaHoraLectura.before(fechaHasta));
    }

    /*
        Siguen metodos de set/get y toString.
     */
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaHoraLectura() {
        return fechaHoraLectura;
    }

    public void setFechaHoraLectura(Date fechaHoraLectura) {
        this.fechaHoraLectura = fechaHoraLectura;
    }

    public double getValorLectura() {
        return valorLectura;
    }

    public void setValorLectura(double valorLectura) {
        this.valorLectura = valorLectura;
    }

    public double getValorCorregido() {
        return valorCorregido;
    }

    public void setValorCorregido(double valorCorregido) {
        this.valorCorregido = valorCorregido;
    }

    public double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    @Override
    public String toString() {
        return "Lectura{" + "fechaHoraLectura=" + fechaHoraLectura + ", valorLectura=" + valorLectura + ", estado=" + estado + '}';
    }

}
