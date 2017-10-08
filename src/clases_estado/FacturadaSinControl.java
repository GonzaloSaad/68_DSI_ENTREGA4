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
    public int controlarLectura(Lectura lectura, boolean requiereRevision) {
        System.out.println("--------------------------------------------- Cambio de Estado"); // ------------------- Printing
        System.out.println(lectura); // ------------------- Printing
        Estado estadoProximo;
        if (requiereRevision) {
            estadoProximo = new PendienteDeRevision();

        } else {
            estadoProximo = new ControladaFacturada();

        }

        lectura.setEstado(estadoProximo);
        System.out.println(lectura);// ------------------- Printing
        return estadoProximo.getCodigo();
    }

    @Override
    public boolean esFacturada() {
        return true;
    }

}
