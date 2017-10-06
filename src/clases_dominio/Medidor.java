/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_dominio;

/**
 *
 * @author Gonzalo
 */
import java.util.Date;

public class Medidor {

    private Lectura lecturas[];
    private int numero;
    

    public Lectura[] getLecturas() {
        return lecturas;
    }
    
    public void setLecturas(Lectura lecturas[]) {
        this.lecturas = lecturas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void controlarLectura(Date fechaDesde, Date fechaHasta) {
        Lectura lecAControlar;
        Lectura lecAnterior;
        Lectura lecAnteriorAnterior;
        
        
        for (int i = 0;i<lecturas.length;i++){
            if (lecturas[i].esDePeriodo(fechaDesde, fechaHasta)){
                lecAControlar = lecturas[i];
                lecAnterior = lecturas[i-1];
                lecAnteriorAnterior = lecturas[i-2];
                break;
            }
         
        }
        
        double consumoPrevio;
        
    }
}
