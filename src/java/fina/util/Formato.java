/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author Jaime Ambrosio
 */
public class Formato {

    static String ceros = ".000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

    public static String formatoDecimal(Double n, int cantDecimales) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        String p = cantDecimales <= 0 ? "" : ceros.substring(0, cantDecimales + 1);
        DecimalFormat formato = new DecimalFormat("###,###" + p, simbolo);

        return formato.format(n);
    }

    public static String formatoDecimal(Double n) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formato = new DecimalFormat("###,###.00", simbolo);

        return formato.format(n);
    }

}
