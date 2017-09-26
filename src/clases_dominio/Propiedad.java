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
public class Propiedad {

    private Instalacion instalaciones;
    private Instalacion instLecturaAControlar;
    private Instalacion instLecturaAnterior;
    private Instalacion instLecturaAnteriorAnterior;

    public void buscarLecturasAControlar() {
    }

    public void controlarLectura() {
        this.instLecturaAControlar.controlarLectura(this);
    }

    public boolean verificarConsumoEscaso() {
        return true;
    }

    public boolean verificarConsumoMenorAEsperado() {
        return true;
    }

}
