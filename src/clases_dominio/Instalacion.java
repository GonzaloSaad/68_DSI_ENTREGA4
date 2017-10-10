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
    private Medidor medidor;
    private Lectura lecturaInicial;

    public Instalacion() {
        fechaRetiro = null;
    }

    public int controlarLectura(Date fechaDesde, Date fechaHasta) {
        /**
         * Metodo que recibe desde la propiedad en el momento de ejecutar el
         * control de lecturas.
         *
         * Le envia el mensaje controlarLectura() al medidor con los mismos
         * parametros.
         */

        return this.medidor.controlarLectura(fechaDesde, fechaHasta);
    }

    public boolean esInstalacionEnPeriodo(Date fechaDesde, Date fechaHasta) {
        /**
         * Metodo que indica si la Instalacion es de un periodo dado.
         *
         * Si la fecha de retiro no es null: 
         * 1) La fecha de instalacion debe ser menor al a fechaDesde. 
         * 2) La fecha de retiro debe ser mayor a la fechaHasta. 
         *    Es decir, el periodo debe estar contenido entre ambas fechas.
         *
         * Si la fecha de retino es null: 1) La fecha de instalacion debe ser
         * anterior al a fechaDesde.
         */

        if (fechaRetiro != null) {
            return (fechaInstalacion.before(fechaDesde) && fechaRetiro.after(fechaHasta));
        }

        return fechaInstalacion.before(fechaDesde);
    }

    /*
        Siguen metodos de set/get y toString.
     */
    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

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

    @Override
    public String toString() {

        return ("\n\tInstalacion{"
                + "\n\tfechaInstalacion=" + fechaInstalacion
                + "\n\tfechaRetiro=" + fechaRetiro
                + "\n\tlecturaInicial=" + lecturaInicial
                + "\n\tmedidor=" + medidor + '}');

    }

}
