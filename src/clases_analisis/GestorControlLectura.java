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
        /**
         * Este metodo tiene toda la logica del gestor, es decir todos los
         * "selfs". Cada uno de estos metodos tiene una actividad concreta.
         *
         * Puede llegar a tener comentada una linea que es
         * [this.enviarResumen();] para que no envie el email, y otra
         * descomentada que es [System.out.println("\n" + resumen);] para que
         * muestre el resumen que deberia enviar por email. Si se descomenta la
         * primera y se comenta la segunda, se envia el email a los
         * supervisores.
         *
         */
        this.obtenerFechaActual();
        this.buscarPeriodoFacturacionActual();
        this.controlarLecturas();
        this.generarResumen();
        System.out.println("\n" + resumen);
        this.obtenerEmailSupervisores();
        //this.enviarResumen();

    }

    private void obtenerFechaActual() {
        /**
         * Metodo 1º del ejecutaControlLectura().
         *
         * Obtiene la fecha en una clase Calendar, y la guarda en una clase tipo
         * Date fechaActual, atributo del gestor.
         */
        this.fechaActual = Calendar.getInstance().getTime();
    }

    private void buscarPeriodoFacturacionActual() {

        /**
         * Metodo 2º del ejecutaControlLectura().
         *
         * Busca entre los periodos de facturacion disponibles, los cuales
         * fueron cargados de manera random en este caso, cual es el periodo que
         * se corresponde con la fechaActual.
         *
         * Le envia el mensaje esPeriodoDeFecha() al periodo de facturacion.
         *
         *
         */
        for (PeriodoFacturacion periodo : this.periodos) {

            if (periodo.esPeriodoDeFecha(this.fechaActual)) {
                this.periodoActual = periodo;
                break;
            }
        }

    }

    private void controlarLecturas() {
        /**
         * Metodo 3º del ejecutaControlLectura().
         *
         * A cada propiedad que tiene como atributo, le envia el mensaje
         * controlarLectura(), ese metodo retorna un int, que permite manejar el
         * resumen, no de la mejor manera pero si la mas facil.
         *
         * Si el controlarLectura() retorna -1 significa que no controlo ninguna
         * lectura, porque no correspondia hacerlo.
         *
         * Modifica el array lecturasPorEstado, sumando a cada posicion +1 por
         * cada estado que corresponda.
         *
         * Retornos. 0 = Pendiente de Revision. 1 = Controlada sin facturar. 2 =
         * Controlada factuada.
         *
         *
         */
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

        /**
         * Metodo 4º del ejecutaControlLectura().
         *
         *
         * En base al array lecturasPorEstado genera un pequeño string con el
         * resumen del control.
         *
         */
        StringBuilder str = new StringBuilder();

        str.append("Control de Lecturas de ").append(fechaActual)
                .append("\nCantidad de lecturas:       ").append(totLecturasControladas)
                .append("\nPendientes de revision:     ").append(lecturasPorEstado[0])
                .append("\nControladas sin Facturar:   ").append(lecturasPorEstado[1])
                .append("\nControladas Facturadas:     ").append(lecturasPorEstado[2]);

        resumen = str.toString();

    }

    private void obtenerEmailSupervisores() {

        /**
         * Metodo 5º del ejecutaControlLectura().
         *
         * Busca entre todos los usuarios disponibles, el mail del supervisor,
         * para enviar el resumen.
         */
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
        /**
         * Metodo 6º del ejecutaControlLectura().
         *
         * Envia el resumen generado a los supervisores, instancia una clase
         * creada por nosotros llamada InterfazServidorMail.
         */

        InterfazServidorMail mail = new InterfazServidorMail();
        System.out.println("Enviando resumen...");
        mail.enviarCorreo(emailsSupervisores, resumen, fechaActual);
    }

    /*
        Siguen metodos get/set.
     */
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
