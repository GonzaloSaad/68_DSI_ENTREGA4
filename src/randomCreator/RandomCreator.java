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
    
    public Propiedad[] createPropiedades(int cant){
        Propiedad[] prop = new Propiedad[cant];
        Calendar cal;
        
        int months;
        int inst;
        Propiedad nProp;
        for (int i=0;i<cant;i++){
            cal=Calendar.getInstance();
            months=randomInt(30,50,1);
            cal.add(Calendar.MONTH, -(months));
            inst = randomInt(3,months/5,1);
            
            nProp=new Propiedad();
            nProp.setNroIdentificacionCatastral(randomInt(100,100*cant,1));
            nProp.setInstalaciones(createInstalaciones(cal.getTime(),inst));
            prop[i]=nProp;
            
            
        }
        return prop;
    }
    
    public Instalacion[] createInstalaciones(Date dateFrom, int cant) {
        Instalacion insts[] = new Instalacion[cant];
        int months = monthDiffToDate(dateFrom);
        int lecPInst[] = distributeSumInCant(months, cant);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFrom);

        double acRead = randomInt(1, 10, 1) * 500;
        int lecs;
        for (int i = 0; i < cant; i++) {

            lecs = lecPInst[i] - 1;

            Lectura iLec = new Lectura();
            iLec.setEstado(new Creada());
            iLec.setFechaHoraLectura(cal.getTime());
            iLec.setValorLectura(acRead);

            Instalacion inst = new Instalacion();
            inst.setFechaInstalacion(cal.getTime());
            inst.setLecturaInicial(iLec);

            cal.add(Calendar.DATE, randomInt(15, 30, 1));
            acRead += 25 * randomInt(0, 20, 1);

            Medidor med = new Medidor();
            med.setNumero(randomInt(0, 1000, 1));
            med.setLecturas(createLecturas(cal, lecs, acRead, i == cant - 1));

            inst.setMedidor(med);
            cal.setTime(med.getUltimaLectura().getFechaHoraLectura());
            cal.add(Calendar.DATE, randomInt(1, 10, 1));

            if (i < cant - 1) {
                inst.setFechaRetiro(dateFrom);
            }
            insts[i] = inst;

        }

        return insts;
    }

    private Lectura[] createLecturas(Calendar cal, int cant, double initialRead, boolean last) {
        Lectura lec[] = new Lectura[cant];
        double reads[] = randomDoubleVector(initialRead, cant);

        for (int i = 0; i < cant; i++) {
            Lectura nLec = new Lectura();
            nLec.setFechaHoraLectura(cal.getTime());
            nLec.setValorLectura(reads[i]);
            if (i < cant - 1 || !last) {
                nLec.setEstado(new ControladaFacturada());
            } else {
                nLec.setEstado(randomState());
            }

            lec[i] = nLec;
            cal.add(Calendar.DATE, randomInt(30, 40, 1));
        }

        return lec;

    }

    private int randomInt(int minimum, int maximum, int multiplier) {
        Random random = new Random();
        return minimum + random.nextInt(maximum - minimum) * multiplier;
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
            value += randomInt(15, 20, 1) * randomInt(0, 20, 1);
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
        int num;
        int lim = (int) sum / (cant - 1);
        for (int i = 0; i < cant; i++) {

            if (i < cant - 1) {
                num = randomInt(4, lim, 1);
                tot -= num;
            } else {
                num = sum - tot;
            }
            vec[i] = num;
        }
        return vec;
    }
}
