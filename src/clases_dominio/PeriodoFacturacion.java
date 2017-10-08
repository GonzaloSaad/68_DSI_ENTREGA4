/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_dominio;
import java.util.Date;
/**
 *
 * @author Gonzalo
 */
public class PeriodoFacturacion {
    private Date fechaDesde;
    private Date fechaHasta;
    private String nombrePeriodo;

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }
    
    public boolean esPeriodoDeFecha(Date fecha){
        return (this.fechaDesde.before(fecha) && this.fechaHasta.after(fecha));
    }

    @Override
    public String toString() {
        return "PeriodoFacturacion{" 
                + "\n\tfechaDesde=" + fechaDesde 
                + "\n\tfechaHasta=" + fechaHasta + '}';
    }
    
    
    
}
