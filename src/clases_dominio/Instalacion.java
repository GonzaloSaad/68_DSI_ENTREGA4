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
    private Medidor medidor;

    public void controlarLectura(Date fechaDesde, Date fechaHasta) {
        this.medidor.controlarLectura(Date fechaDesde, Date fechaHasta);
    }
    
    public boolean esInstalacionEnPeriodo(Date fechaDesde, Date fechaHasta){
        return (fechaInstalacion.after(fechaDesde) && fechaInstalacion.before(fechaHasta));
    }
    
}
