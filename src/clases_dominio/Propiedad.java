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

    public void buscarLecturasAControlar() {
    }

    public void controlarLectura(Date fechaDesde, Date fechaHasta) {
        Instalacion instal = this.buscarInstalacionEnPeriodo(fechaDesde, fechaHasta);
        if (instal == null) {
            return;
        }
        instal.controlarLectura(fechaDesde, fechaHasta);
    }

    public boolean verificarConsumoEscaso() {
        return true;
    }

    public boolean verificarConsumoMenorAEsperado() {
        return true;
    }

    public Instalacion buscarInstalacionEnPeriodo(Date fechaDesde, Date fechaHasta) {
        for (Instalacion inst : instalaciones) {
            if (inst.esInstalacionEnPeriodo(fechaDesde, fechaHasta)) {
                return inst;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String aux = "Propiedad{" + "\nnroIdentificacionCatastral=" + nroIdentificacionCatastral;
        StringBuilder str = new StringBuilder();
        for (Instalacion inst : instalaciones) {
            str.append("\n");
            str.append(inst);
        }
        str.append("\n}");
        return str.toString();
    }

}
