/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu68_dsi_entrega4;

import clases_analisis.GestorControlLectura;
import clases_dominio.Propiedad;
import clases_dominio.PeriodoFacturacion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import randomCreator.RandomCreator;
import servidorMailG.InterfazServidorMail;

/**
 *
 * @author Gonzalo
 */
public class CU68_DSI_ENTREGA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /**
        GestorControlLectura gestor = generarGestorConInfo(100,20);
        gestor.ejecutarControlLectura();
        **/
        InterfazServidorMail mail = new InterfazServidorMail();
        mail.enviarCorreo("saad.gonzalo.ale@gmail.com,estrellangie19@gmail.com", "Gonzalo");
        
        
        
    }
    
    public static GestorControlLectura generarGestorConInfo(int props,int periodos){
        RandomCreator rc = new RandomCreator();
        
        Propiedad propiedades[] = rc.createPropiedades(props);
        PeriodoFacturacion per[] = rc.createPeriodos(periodos);
        
        GestorControlLectura gestor = new GestorControlLectura();
        gestor.setPeriodos(per);
        gestor.setPropiedades(propiedades);
        
        
        return gestor;
    }
}
