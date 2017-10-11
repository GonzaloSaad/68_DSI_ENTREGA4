/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu68_dsi_entrega4;

import clases_analisis.GestorControlLectura;

import randomCreator.RandomCreator;

//import clases_dominio.Propiedad;

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
         * generarGestorConInfo() que retorna un gestor con todos los datos
         * necesarios para el CU.
         */
        GestorControlLectura gestor = generarGestorConInfo(1000, 20);

        /**
         * Se da Comienzo al CU.
         */
        gestor.ejecutarControlLectura();

        /**
         * Codigo para mostrar el random de propiedaes.
         *
         * for (Propiedad prop: gestor.getPropiedades()){
         * System.out.println(prop); }
         *
         * Codigo para mostrar la cantidad de lecturas creadas.
         *
         * int sum=0; for (Propiedad prop: gestor.getPropiedades() ){ sum +=
         * prop.cantidadLecturas(); } System.out.println(sum);
         *
         */
        
    }

    public static GestorControlLectura generarGestorConInfo(int props, int periodos) {

        /**
         * Intancia de la clase RandomCreator, que genera los datos necesarios
         * para fabricar el gestor.
         */
        RandomCreator rc = new RandomCreator();

        GestorControlLectura gestor = new GestorControlLectura(); // Se intancia un gestor. 
        gestor.setPeriodos(rc.createPeriodos(periodos)); // Seteo de periodos. 
        gestor.setPropiedades(rc.createPropiedades(props)); // Seteo de propiedades.
        gestor.setUsuarios(rc.createUsuarios()); // Seteo de usuarios. 

        return gestor; // Se retorna el gestor. 
    }
}
