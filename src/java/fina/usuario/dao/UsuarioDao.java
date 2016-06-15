/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.usuario.dao;

import fina.afp.dao.ConexionJPA;
import fina.dao.BaseDao;
import fina.usuario.entity.Tipousuario;
import fina.usuario.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jaime Ambrosio
 */
public class UsuarioDao implements BaseDao<Usuario, Integer> {

    private EntityManager em = null;

    public UsuarioDao() {
        em = ConexionJPA.getEntityManager();
    }

    @Override
    public void Insertar(Usuario entity) throws Exception {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void Actualizar(Usuario entity) throws Exception {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void Eliminar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario Obtener(Integer id) throws Exception {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Tipousuario> listarTipousuario() throws Exception {
        return em.createQuery("FROM Tipousuario t").getResultList();
    }

    public Usuario validarIngreso(String username, String contrasenia) {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND u.contrasenia = :contrasenia");
        query.setParameter("username", username);
        query.setParameter("contrasenia", contrasenia);
        return !query.getResultList().isEmpty() ? (Usuario) query.getSingleResult() : null;
    }

    public Tipousuario getTipousuarioById(String id) {
        return em.find(Tipousuario.class, Integer.valueOf(id));
    }

}
