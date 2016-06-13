/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.afp.dao;

import fina.usuario.dao.UsuarioDao;

/**
 *
 * @author Jaime Ambrosio
 */
public class test {
    
    public static void main(String[] args) {
        UsuarioDao dao=new  UsuarioDao();
        try {
            UsuarioDao dao2=new  UsuarioDao();
            for (Object o : dao.listarTipousuario()) {
                System.out.println(o);
            }
            for (Object o : dao2.listarTipousuario()) {
                System.out.println(o);
            }
            
        } catch (Exception e) {
        }
    }
    
}
