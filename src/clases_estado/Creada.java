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
    public void controlarLectura(Lectura lectura,Propiedad propiedad) {
        Estado estado; // Variable del tipo Estado (abstracta).
        Propiedad propActual = propiedad; // Obtener la propiedad de la lectura. 

        // Verificar si se registro Consumo Escaso O (||) Consumo Menor al Esperado.
        if (propActual.verificarConsumoEscaso() || propActual.verificarConsumoMenorAEsperado()) {
            // [requiere control = SI]
            estado = new PendienteDeRevision();

        } else {
            // [requiere control = NO]
            estado = new ControladaSinFacturar();

        }

        lectura.setEstado(estado);
    }

    @Override
    public boolean esCreada() {
        return true;
    }

}
