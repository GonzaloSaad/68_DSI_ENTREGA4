/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu68_dsi_entrega4;

import clases_analisis.GestorControlLectura;
import clases_dominio.Lectura;
import java.util.Date;
import java.util.Calendar;
import randomCreator.RandomCreator;
import java.util.Random;

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

        GestorControlLectura gestor = new GestorControlLectura();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -5);
        
        Calendar cal2 = Calendar.getInstance();
        
        RandomCreator rc = new RandomCreator();
        
        int cant = 4;
        int[] v = rc.distributeSumInCant(50, cant);
        for(int c: v){
            System.out.println(c);
        }
    }

}
