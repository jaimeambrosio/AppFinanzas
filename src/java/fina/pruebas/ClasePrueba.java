/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.pruebas;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author Jaime Ambrosio
 */
public class ClasePrueba {

    public InputStream eee() {
        return getClass().getResourceAsStream("/fina/img/user.png");

    }

}
