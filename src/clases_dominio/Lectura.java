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
    private float valorLectura;
    private float valorCorregido;
    private float valorEstimado;
    
    
    
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
    
    public boolean esDePeriodo(Date fechaDesde,Date fechaHasta){
        return (this.fechaHoraLectura.after(fechaDesde) && this.fechaHoraLectura.before(fechaHasta));
    }

    public Date getFechaHoraLectura() {
        return fechaHoraLectura;
    }

    public void setFechaHoraLectura(Date fechaHoraLectura) {
        this.fechaHoraLectura = fechaHoraLectura;
    }

    public float getValorLectura() {
        return valorLectura;
    }

    public void setValorLectura(float valorLectura) {
        this.valorLectura = valorLectura;
    }

    public float getValorCorregido() {
        return valorCorregido;
    }

    public void setValorCorregido(float valorCorregido) {
        this.valorCorregido = valorCorregido;
    }

    public float getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(float valorEstimado) {
        this.valorEstimado = valorEstimado;
    }
            
}
