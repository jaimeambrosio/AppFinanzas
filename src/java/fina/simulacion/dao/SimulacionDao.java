/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.simulacion.dao;

import fina.afp.entity.Tipofondoxafp;
import fina.dao.BaseDao;
import fina.dao.ConexionJPA;
import fina.simulacion.entity.Simulacion;
import fina.simulacion.entity.Simulacionhito;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jaime Ambrosio
 */
public class SimulacionDao implements BaseDao<Simulacion, Integer> {

    private EntityManager em = null;

    public SimulacionDao() {
        em = ConexionJPA.getEntityManager();
    }

    @Override
    public void Insertar(Simulacion entity) throws Exception {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void Actualizar(Simulacion entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Simulacion Obtener(Integer id) throws Exception {
        return em.find(Simulacion.class, id);
    }

    @Override
    public List<Simulacion> listar() throws Exception {
        return em.createQuery("FROM Simulacion U").getResultList();
    }

    public void InsertarHitos(List<Simulacionhito> listSimulacionhito) {
        em.getTransaction().begin();
        for (Simulacionhito simulacionhito : listSimulacionhito) {
            em.merge(simulacionhito);
        }
        em.getTransaction().commit();
    }

    public List<Simulacionhito> listarSimulacionhito(Simulacion simulacion) {
        Query query = em.createQuery("SELECT sh FROM Simulacionhito sh WHERE sh.idSIMULACION = :idSIMULACION ORDER BY sh.fecha ASC");
        query.setParameter("idSIMULACION", simulacion);
        return query.getResultList();
    }

}
