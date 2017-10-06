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
    private Lectura lecturaAControlar;

    public void controlarLectura(Date fechaDesde, Date fechaHasta) {
        this.lecturaAControlar.controlarLectura(prop);
    }

    public Lectura[] getLecturas() {
        return lecturas;
    }

    public void setLecturas(Lectura lecturas) {
        this.lecturas = lecturas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
