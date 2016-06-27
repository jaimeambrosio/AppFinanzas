/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.dao;

import fina.usuario.dao.UsuarioDao;
import fina.usuario.entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.json.JSONObject;

/**
 *
 * @author Jaime Ambrosio
 */
public class test {

    public static void main(String[] args) {
        EntityManager em = ConexionJPA.getEntityManager();
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND u.contrasenia = :contrasenia");
        query.setParameter("username", "admin");
        query.setParameter("contrasenia", "admin");
        System.out.println(!query.getResultList().isEmpty() ? (Usuario)query.getSingleResult() : null);
    }

}
