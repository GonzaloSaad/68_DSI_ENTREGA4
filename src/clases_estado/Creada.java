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
public class Creada extends Estado {

    @Override
    public void crearFactura(Lectura lectura) {
        // Acciones para crear la factura de la lectura. 
    }

    @Override
    public int controlarLectura(Lectura lectura, boolean requiereRevision) {

        /**
         * Implementacion del PATRON STATE.
         *
         * Dado que es el estado Creada, verifica si requiereRevision, si es
         * asi, crea un estado nuevo PendienteDeRevision() si no, crea un estado
         * ControladaSinFacturar(). Se setea el nuevo estado a la lectura.
         *
         * Retorna un CODIGO del estado, que es la forma en la que se decidio
         * hacer el resumen.
         */
        System.out.println("--------------------------------------------- Cambio de Estado"); // ------------------- Printing
        System.out.println(lectura); // ------------------- Printing
        Estado estadoProximo;
        if (requiereRevision) {
            estadoProximo = new PendienteDeRevision();

        } else {
            estadoProximo = new ControladaSinFacturar();

        }

        lectura.setEstado(estadoProximo);
        System.out.println(lectura); // ------------------- Printing
        return estadoProximo.getCodigo();
    }

    @Override
    public boolean esCreada() {
        return true;
    }

}
