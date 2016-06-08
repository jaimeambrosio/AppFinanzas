/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finanzas.pruebas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Jaime Ambrosio
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Double sueldo = 1000.0;
        Double aportatacion = 0.1;
        Double rentabilidad = 0.001651581;
        rentabilidad=0.02/12;
        Double saldo = 0.0;
        Double saldoInicial = 10.0;
        Calendar ini = new GregorianCalendar(2016, Calendar.MAY, 30);
        Calendar fin = new GregorianCalendar(2016 + 65 - 20, Calendar.MAY, 30);
        
        while (ini.getTimeInMillis() < fin.getTimeInMillis()) {
            saldo = saldoInicial + saldo + saldo * rentabilidad + sueldo * aportatacion;
            ini.add(Calendar.MONTH, 1);
            System.out.println(ini.getTime().toLocaleString() + "  ==> " + saldo);
            saldoInicial = 0.0;
        }
        System.out.println("Saldo final bbb: " + saldo);

    }

}
