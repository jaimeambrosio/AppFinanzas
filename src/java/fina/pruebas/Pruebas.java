/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.pruebas;

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
        Double sueldo = 3400.0;
        Double aportatacion = 0.09;
        Double rentabilidad = 0.005497;
        Double saldo = 0.0;
        Double saldoInicial = 0.0;
        Calendar ini = new GregorianCalendar(2016, Calendar.MAY, 30);
        Calendar fin = new GregorianCalendar(2016 + 21, Calendar.MAY, 30);
        
        int cont = 0;
        while (ini.getTimeInMillis() < fin.getTimeInMillis()) {
            
            saldo = saldoInicial + saldo + (saldo * rentabilidad) + (sueldo * aportatacion);
            ini.add(Calendar.MONTH, 1);
            System.out.println(ini.getTime().toLocaleString() + "  ==> " + saldo);
            saldoInicial = 0.0;
            ++cont;
        }
        System.out.println("Saldo final bbb: " + saldo);
        System.out.println(cont);

    }

}
