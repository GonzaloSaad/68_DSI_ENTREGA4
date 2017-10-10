/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu68_dsi_entrega4;

import clases_analisis.GestorControlLectura;

import randomCreator.RandomCreator;

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
         * Se crea un GestorControlLectura mediante el metodo
         * generarGestorConInfo() que retorna un gestor con todos
         * los datos necesarios para el CU. 
         */
        GestorControlLectura gestor = generarGestorConInfo(1000, 20); 
        
        /**
         * Se da Comienzo al CU. 
         */
        gestor.ejecutarControlLectura();

    }

    public static GestorControlLectura generarGestorConInfo(int props, int periodos) {

        RandomCreator rc = new RandomCreator();

        GestorControlLectura gestor = new GestorControlLectura();
        gestor.setPeriodos(rc.createPeriodos(periodos));
        gestor.setPropiedades(rc.createPropiedades(props));
        gestor.setUsuarios(rc.createUsuarios());

        return gestor;
    }
}
