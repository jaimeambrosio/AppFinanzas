/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finanzas.pruebas;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jaime Ambrosio
 */
public class NewClass {

    public static void main(String[] args) {
        Integer[] diasDelMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Calendar ini = new GregorianCalendar(2016, Calendar.JUNE, 30);
        Calendar fin = new GregorianCalendar(2017, Calendar.JUNE, 30);
        int mes = Calendar.JUNE;

        while (ini.getTimeInMillis() <= fin.getTimeInMillis()) {
            System.out.println(ini.getTime().toLocaleString() + "   -  " + ini.getTimeInMillis());
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
        }
        System.out.println(fin.getTimeInMillis());
        System.out.println(ini.get(Calendar.YEAR));
    }

}
