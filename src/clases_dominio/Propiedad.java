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

    private Instalacion instalaciones[];
    

    public void buscarLecturasAControlar() {
    }

    public void controlarLectura(Date fechaDesde, Date fechaHasta) {
        Instalacion instal = this.buscarInstalacionEnPeriodo(fechaDesde,fechaHasta);
        
        instal.controlarLectura(fechaDesde, fechaHasta);
    }

    public boolean verificarConsumoEscaso() {
        return true;
    }

    public boolean verificarConsumoMenorAEsperado() {
        return true;
    }
    
    public Instalacion buscarInstalacionEnPeriodo(Date fechaDesde, Date fechaHasta) {
        for (Instalacion inst: instalaciones){
            if (inst.esInstalacionEnPeriodo(fechaDesde, fechaHasta)){
                return inst;
            }
        }
        return null;
    }
}
