/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.pruebas;

import fina.entity.Mensaje;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.json.JSONObject;

/**
 *
 * @author Jaime Ambrosio
 */
public class Pruebas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mensaje m = new Mensaje(true, Mensaje.ADVERTENCIA, "sdfsdfsdf");
        JSONObject j = new JSONObject(m);
        System.out.println(j.toString());
    }

}
