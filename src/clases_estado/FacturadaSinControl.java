/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_estado;

import clases_dominio.Lectura;
import clases_dominio.Propiedad;

/**
 *
 * @author Gonzalo
 */
public class FacturadaSinControl extends Estado {

    @Override
    public void controlarLectura(Lectura lectura, boolean requiereRevision) {
        System.out.println("--------------------------------------------- Verificacion"); // ------------------- Printing
        System.out.println(lectura); // ------------------- Printing
        Estado estadoProximo;
        if (requiereRevision){
            estadoProximo = new PendienteDeRevision();
            System.out.println("Requiere revision.");// ------------------- Printing
        }
        else{
            estadoProximo = new ControladaFacturada();
            System.out.println("No requiere revision."); // ------------------- Printing
        }
        
        lectura.setEstado(estadoProximo); 
        System.out.println(lectura);// ------------------- Printing
        
    }

    @Override
    public boolean esFacturada() {
        return true;
    }

}
