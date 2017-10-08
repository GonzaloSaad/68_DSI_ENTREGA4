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
        int[] contadorEstados;
        for (Propiedad prop : this.propiedades) {
            prop.controlarLectura(periodoActual.getFechaDesde(), periodoActual.getFechaHasta());
        }
    }

    private void generarResumen() {
    }

    private void obtenerEmailSupervisores() {
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < usuarios.length;i++){
            if (usuarios[i].esSupervisor()){
                if (i!=0){
                    str.append(",");
                }
                str.append(usuarios[i].getEmail());
            }
        }
        this.emailsSupervisores=str.toString();
    }

    private void enviarResumen() {
        InterfazServidorMail mail = new InterfazServidorMail();
        mail.enviarCorreo(emailsSupervisores, resumen);
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
