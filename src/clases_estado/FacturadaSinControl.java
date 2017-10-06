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
    public void controlarLectura(Lectura lectura, boolean requireRevision) {
        
    }

    @Override
    public boolean esFacturada() {
        return true;
    }

}
