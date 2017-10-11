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
public class Propiedad {

    private int nroIdentificacionCatastral;
    private Instalacion instalaciones[];

    public int controlarLectura(Date fechaDesde, Date fechaHasta) {

        /**
         * Metodo llamado por el gestor en el control de lecturas. Recibe dos
         * fechas, correspondientes a las del periodo a controlar.
         *
         * Con esas fechas busca la instalacion correspondiente. * a) Si no
         * existe retorna -1 y no prosigue con el control. b) Si existe, le
         * envia el mensaje controlarLectura() con los mismos parametros.
         */
        Instalacion instal = this.buscarInstalacionEnPeriodo(fechaDesde, fechaHasta);
        if (instal == null) {
            return -1;
        }
        return instal.controlarLectura(fechaDesde, fechaHasta);
    }

    public Instalacion buscarInstalacionEnPeriodo(Date fechaDesde, Date fechaHasta) {
        /**
         * Busca la instalaciones del periodo. Si no encuentra retorna null. Si
         * encuentra retorna la instalacion.
         */

        for (Instalacion inst : instalaciones) {
            if (inst.esInstalacionEnPeriodo(fechaDesde, fechaHasta)) {
                return inst;
            }
        }
        return null;
    }

    /*
        Sigue metodos de set/get y toString.
     */
    public int getNroIdentificacionCatastral() {
        return nroIdentificacionCatastral;
    }

    public void setNroIdentificacionCatastral(int nroIdentificacionCatastral) {
        this.nroIdentificacionCatastral = nroIdentificacionCatastral;
    }

    public Instalacion[] getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(Instalacion[] instalaciones) {
        this.instalaciones = instalaciones;
    }

    @Override
    public String toString() {
        String aux = "Propiedad{" + "\nnroIdentificacionCatastral=" + nroIdentificacionCatastral;
        StringBuilder str = new StringBuilder(aux);
        for (Instalacion inst : instalaciones) {
            str.append("\n");
            str.append(inst);
        }
        str.append("\n}");
        return str.toString();
    }

    public int cantidadLecturas() {
        int sum = 0;
        for (Instalacion ins : instalaciones) {
            sum += ins.cantidadLecturas();
        }
        return sum;
    }

}
