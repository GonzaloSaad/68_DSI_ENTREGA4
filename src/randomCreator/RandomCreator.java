/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomCreator;

import clases_dominio.*;
import clases_estado.*;
import java.util.Random;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author estre
 */
public class RandomCreator {

    private Instalacion[] createInstalaciones(Date dateFrom, int cant, double initialRead) {
        Instalacion inst[] = new Instalacion[cant];
        int months = monthDiffToDate(dateFrom);

        return null;
    }

    public Lectura[] createLecturas(Date dateFrom, int cant, double initialRead) {
        Lectura lec[] = new Lectura[cant];
        double reads[] = randomDoubleVector(initialRead, cant);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFrom);

        for (int i = 0; i < cant; i++) {
            Lectura nLec = new Lectura();
            nLec.setFechaHoraLectura(cal.getTime());
            nLec.setValorLectura(reads[i]);
            if (i < cant - 1) {
                nLec.setEstado(new ControladaFacturada());
            } else {
                nLec.setEstado(randomState());
            }

            lec[i] = nLec;
            cal.add(Calendar.DATE, 1);
        }

        return lec;

    }

    private int randomInt(int minimum, int maximum, int multiplier) {
        Random random = new Random();
        return minimum + random.nextInt(maximum-minimum) * multiplier;
    }

    private Estado randomState() {
        Estado est = null;
        int num = randomInt(1, 4, 1);
        switch (num) {
            case 1:
                est = new Creada();
                break;
            case 2:
                est = new ControladaSinFacturar();
                break;
            case 3:
                est = new FacturadaSinControl();
                break;
            case 4:
                est = new ControladaFacturada();
                break;

        }
        return est;
    }

    private double[] randomDoubleVector(double initialValue, int cant) {
        double vec[] = new double[cant];
        double value = initialValue;

        for (int i = 0; i < cant; i++) {
            vec[i] = value;
            value += 25 * randomInt(0, 20, 1);
        }
        return vec;
    }

    private int monthDiff(Date endDate, Date startDate) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth;
    }

    private int monthDiffToDate(Date startDate) {
        return monthDiff(Calendar.getInstance().getTime(), startDate);
    }

    public int[] distributeSumInCant(int sum, int cant) {
        int[] vec = new int[cant];
        
        int tot = sum;
        int top;
        int num;
        for (int i = 0; i < cant; i++) {
            if (i < cant - 1) {
                top = (int)(tot * randomInt(0,5,1)/10);
                num = randomInt(3,top,1);   
                tot = tot - num;
            }
            else{
                num = sum - tot;
            }
            vec[i]=num;
        }
        return vec;
    }
}
