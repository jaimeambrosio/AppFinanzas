/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.pruebas;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jaime Ambrosio
 */
public class NewClass {

    public static void main(String[] args) {
        Double sueldo = 3400.0;
        Double aportatacion = 0.09;
        Double rentabilidad = 0.005497;
        Double saldo = 0.0;
        Double saldoInicial = 1200.0;

        Integer[] diasDelMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Calendar ini = new GregorianCalendar(2016, Calendar.JUNE, 30);
        Calendar fin = new GregorianCalendar(2016 + 21, Calendar.JUNE, 30);
        int mes = Calendar.JUNE;
        int cont = 0;

        while (ini.getTimeInMillis() < fin.getTimeInMillis()) {
            saldo = saldoInicial + saldo + (saldo * rentabilidad) + (sueldo * aportatacion);
            saldoInicial = 0.0;
            ++mes;
            if (mes >= 12) {
                mes = 0;
            }
            int dias = diasDelMes[mes];
            if (mes == 1) {
                int anio = ini.get(Calendar.YEAR);
                if (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0)) {
                    ++dias;
                }
            }
            ini.add(Calendar.DAY_OF_MONTH, dias);
            ++cont;
            System.out.println(ini.getTime().toLocaleString() + "   -  " + ini.getTimeInMillis());
        }
        System.out.println(fin.getTimeInMillis());
        System.out.println("Saldo final bbb: " + saldo);
        System.out.println(cont);
    }

}
