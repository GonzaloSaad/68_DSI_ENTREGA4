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

    public int controlarLectura(Date fechaDesde, Date fechaHasta) {
        
        /**
         * Metodo llamado desde instalacion en el momento de control de lecturas. 
         * 
         * Busca entre todas las lecturas, aquella que sea del periodo de las 
         * fechas pasadas por parametro.
         *      a)Si encuentra, verifica que sea creada o facturada. 
         *          A)Si es creada o facturada, busca sus dos anteriores. 
         *              1)  Calcula el consumo actual y anterior y crea una 
         *                  variable booleana requiereRevision. 
         *              2)  Se llama al controlar lectura de lectura con 
         *                  el parametro requiereRevision.
         *          B)Si no, retorna -1.
         *      b)Si no encuentra, retorna -1.
         * 
         
         */
        
        
        Lectura lecAControlar = null;
        Lectura lecAnterior = null;
        Lectura lecAnteriorAnterior = null;

        for (int i = 0; i < lecturas.length; i++) {
            if (lecturas[i].esDePeriodo(fechaDesde, fechaHasta)) {
                lecAControlar = lecturas[i];

                if (lecAControlar.esCreada() || lecAControlar.esFacturada()) {
                    lecAnterior = lecturas[i - 1];
                    lecAnteriorAnterior = lecturas[i - 2];
                    System.out.println("\n\n.................................................. Control"); // ------------------- Printing
                    System.out.println(lecAControlar); // ------------------- Printing
                    System.out.println(lecAnterior); // ------------------- Printing
                    System.out.println(lecAnteriorAnterior); // ------------------- Printing
                    break;
                } else {
                    return -1;
                }

            }

        }
        if (lecAControlar != null) {

            double consumo = calcularConsumoNormalizado(lecAControlar, lecAnterior);
            double consumoAnterior = calcularConsumoNormalizado(lecAnterior, lecAnteriorAnterior);

            System.out.println("Consumo actual:\t\t" + consumo); // ------------------- Printing
            System.out.println("Consumo anterior:\t" + consumoAnterior); // ------------------- Printing

            boolean consumoNulo = (lecAControlar.getValorLectura() - lecAnterior.getValorLectura()) <= 1;
            boolean consumoMenorAlEsperado = Math.abs(consumo - consumoAnterior) >= 50;
            boolean requiereRevision = consumoNulo || consumoMenorAlEsperado;

            if (consumoNulo) {
                System.out.println("Consumo nulo: \tSI"); // ------------------- Printing
            } else {
                System.out.println("Consumo nulo: \tNO"); // ------------------- Printing
            }

            if (consumoMenorAlEsperado) {
                System.out.println("Diferencia mayor a la esperada: \t SI"); // ------------------- Printing
            } else {
                System.out.println("Diferencia mayor a la esperada: \t NO"); // ------------------- Printing
            }
            if (requiereRevision) {
                System.out.println("Requiere revision."); // ------------------- Printing
            } else {
                System.out.println("No requiere revision."); // ------------------- Printing
            }
            return lecAControlar.controlarLectura(requiereRevision);

        }
        return -1;
    }

    public Lectura getUltimaLectura() {
        return lecturas[lecturas.length - 1];
    }

    private double calcularConsumoNormalizado(Lectura lec, Lectura lecAnterior) {
        int diasConsumo = getDiasLectura(lec, lecAnterior);
        return ((lec.getValorLectura() - lecAnterior.getValorLectura()) / (diasConsumo)) * 30;
    }
    
    /*
        Siguen metodos de set/get y to String.
    */
    
    private int getDiasLectura(Lectura lec, Lectura lecAnterior) {
        return (int) ((lec.getFechaHoraLectura().getTime() - lecAnterior.getFechaHoraLectura().getTime()) / (1000 * 60 * 60 * 24));
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

    @Override
    public String toString() {
        String aux = "\t\tMedidor{" + "numero=" + numero + '}';
        StringBuilder str = new StringBuilder(aux);
        for (Lectura lec : lecturas) {
            str.append("\n\t\t\t");
            str.append(lec);

        }
        return str.toString();
    }
    
    public int cantidadLecturas(){
        return this.lecturas.length;
    }

}
