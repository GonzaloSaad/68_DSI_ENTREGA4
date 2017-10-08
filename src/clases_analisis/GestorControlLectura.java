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
import clases_dominio.Usuario;
import servidorMailG.InterfazServidorMail;

/**
 *
 * @author Gonzalo
 */
public class GestorControlLectura {

    private Usuario usuarios[];
    private String emailsSupervisores;
    private String resumen;
    private Date fechaActual;
    private PeriodoFacturacion periodos[];
    private PeriodoFacturacion periodoActual;
    private Propiedad propiedades[];
    private int lecturasPorEstado[] = {0, 0, 0};
    private int totLecturasControladas = 0;

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

        int cod;
        for (Propiedad prop : this.propiedades) {
            cod = prop.controlarLectura(periodoActual.getFechaDesde(), periodoActual.getFechaHasta());
            if (cod >= 0) {
                lecturasPorEstado[cod]++;
            }
        }
        for (int i : lecturasPorEstado) {
            totLecturasControladas += i;
        }
    }

    private void generarResumen() {
        StringBuilder str = new StringBuilder();

        str.append("Control de Lecturas de ").append(fechaActual)
                .append("\nCantidad de lecturas: \t").append(totLecturasControladas)
                .append("\nPendientes de revision: \t").append(lecturasPorEstado[0])
                .append("\nControladas sin Facturar: \t").append(lecturasPorEstado[1])
                .append("\nControladas Facturadas: \t").append(lecturasPorEstado[2]);

        resumen = str.toString();

    }

    private void obtenerEmailSupervisores() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].esSupervisor()) {
                if (i != 0) {
                    str.append(",");
                }
                str.append(usuarios[i].getEmail());
            }
        }
        this.emailsSupervisores = str.toString();
    }

    private void enviarResumen() {
        InterfazServidorMail mail = new InterfazServidorMail();
        mail.enviarCorreo(emailsSupervisores, resumen, fechaActual);
    }

    public PeriodoFacturacion[] getPeriodos() {
        return periodos;
    }

    public void setPeriodos(PeriodoFacturacion[] periodos) {
        this.periodos = periodos;
    }

    public Propiedad[] getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Propiedad[] propiedades) {
        this.propiedades = propiedades;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

}
