/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.pruebas;

import fina.usuario.dao.UsuarioDao;
import fina.usuario.entity.Usuario;
import java.io.InputStream;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaime Ambrosio
 */
public class Pruebas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            UsuarioDao dao = new UsuarioDao();
            System.out.println("");
            System.out.println(dao.Obtener(10));

        } catch (Exception ex) {
            Logger.getLogger(Pruebas1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
