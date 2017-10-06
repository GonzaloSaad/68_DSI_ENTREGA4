/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_analisis;

import java.util.Date;
import java.util.Calendar;
import clases_dominio.PeriodoFacturacion;
import clases_dominio.Propiedad;

/**
 *
 * @author Gonzalo
 */
public class GestorControlLectura {

    private Date fechaActual;
    private PeriodoFacturacion periodos[];
    private PeriodoFacturacion periodoActual;
    private Propiedad propiedades[];

    public void ejecutarControlLectura() {
        this.obtenerFechaActual();
        this.buscarPeriodoFacturacionActual();
        this.controlarLecturas();
        this.generarResumen();
        this.obtenerEmailSupervisores();
        this.enviarResumen();

    }

    private void obtenerFechaActual() {
        this.fechaActual = Calendar.getInstance().getTime();
    }

    private void buscarPeriodoFacturacionActual() {

        for (PeriodoFacturacion periodo : this.periodos) {

            if (periodo.esPeriodoDeFecha(this.fechaActual)) {
                this.periodoActual = periodo;
                break;
            }
        }

    }

    private void controlarLecturas() {
        for (Propiedad prop : this.propiedades) {
            
        }
    }
       
    private void generarResumen() {
    }

    private void obtenerEmailSupervisores() {
    }

    private void enviarResumen() {
    }

}
