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

    public void controlarLectura(Date fechaDesde, Date fechaHasta) {
        Lectura lecAControlar = null;
        Lectura lecAnterior = null;
        Lectura lecAnteriorAnterior = null;

        for (int i = 0; i < lecturas.length; i++) {
            if (lecturas[i].esDePeriodo(fechaDesde, fechaHasta)) {
                lecAControlar = lecturas[i];

                if (lecAControlar.esCreada() || lecAControlar.esFacturada()) {
                    lecAnterior = lecturas[i - 1];
                    lecAnteriorAnterior = lecturas[i - 2];
                    break;
                } else {
                    return;
                }

            }

        }
        if (lecAControlar != null) {

            int diasConsumoActual = (int) ((lecAControlar.getFechaHoraLectura().getTime() - lecAnterior.getFechaHoraLectura().getTime()) / (1000 * 60 * 60 * 24));
            int diasConsumoAnterior = (int) ((lecAnterior.getFechaHoraLectura().getTime() - lecAnteriorAnterior.getFechaHoraLectura().getTime()) / (1000 * 60 * 60 * 24));

            double consumo = ((lecAControlar.getValorLectura() - lecAnterior.getValorLectura()) / (diasConsumoActual)) * 30;
            double consumoAnterior = ((lecAnterior.getValorLectura() - lecAnteriorAnterior.getValorLectura()) / diasConsumoAnterior) * 30;

            boolean requiereRevision = (lecAControlar.getValorLectura() - lecAnterior.getValorLectura()) <= 1
                    || Math.abs(consumo - consumoAnterior) < 50;

            lecAControlar.controlarLectura(requiereRevision);

        }
    }

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

    public Lectura getUltimaLectura() {
        return lecturas[lecturas.length - 1];
    }

    @Override
    public String toString() {
        String aux = "Medidor{" + "numero=" + numero + '}';
        StringBuilder str = new StringBuilder(aux);
        for (Lectura lec : lecturas){
            str.append("\n");
            str.append(lec);
                    
        }
        return str.toString();
    }

}
