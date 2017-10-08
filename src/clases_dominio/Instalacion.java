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
public class Instalacion {

    private Date fechaInstalacion;
    private Date fechaRetiro;

    public Instalacion() {
        fechaRetiro = null;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }
    private Medidor medidor;
    private Lectura lecturaInicial;

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public Lectura getLecturaInicial() {
        return lecturaInicial;
    }

    public void setLecturaInicial(Lectura lecturaInicial) {
        this.lecturaInicial = lecturaInicial;
    }

    public void controlarLectura(Date fechaDesde, Date fechaHasta) {
        this.medidor.controlarLectura(fechaDesde, fechaHasta);
    }

    public boolean esInstalacionEnPeriodo(Date fechaDesde, Date fechaHasta) {

        if (fechaRetiro != null) {
            return (fechaInstalacion.before(fechaDesde) && fechaInstalacion.after(fechaHasta));
        }

        return fechaInstalacion.before(fechaDesde);
    }

    @Override
    public String toString() {

        return ("\n\tInstalacion{"
                + "\n\tfechaInstalacion=" + fechaInstalacion
                + "\n\tfechaRetiro=" + fechaRetiro
                + "\n\tlecturaInicial=" + lecturaInicial
                + "\n\tmedidor=" + medidor + '}');

    }

}
