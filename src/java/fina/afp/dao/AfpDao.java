/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fina.afp.dao;

import fina.dao.ConexionJPA;
import fina.afp.entity.Afp;
import fina.afp.entity.Tipocomision;
import fina.afp.entity.Tipocomisionxafp;
import fina.afp.entity.Tipofondo;
import fina.afp.entity.Tipofondoxafp;
import fina.afp.entity.TipofondoxafpPK;
import fina.dao.BaseDao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Jaime Ambrosio
 */
public class AfpDao implements BaseDao<Afp, Integer> {

    private EntityManager em = null;

    public AfpDao() {
        em = ConexionJPA.getEntityManager();
    }

    @Override
    public void Insertar(Afp entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Actualizar(Afp entity) throws Exception {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void Eliminar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Afp Obtener(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Afp> listar() throws Exception {
        return em.createQuery("FROM Afp A").getResultList();
    }

    public List<Tipofondo> listarTipofondo() {
        return em.createQuery("FROM Tipofondo tf ORDER BY tf.idTIPOFONDO").getResultList();
    }

    public Tipofondoxafp listarTipoFondoXAfp(TipofondoxafpPK pK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Tipofondoxafp> listarTipoFondoXAfp() {
        return em.createQuery("FROM Tipofondoxafp ta").getResultList();
    }

    public void ActualizarFondoXAfp(List<Tipofondoxafp> listTipoFondoXAfp) {
        em.getTransaction().begin();
        for (Tipofondoxafp tipofondoxafp : listTipoFondoXAfp) {
             em.merge(tipofondoxafp);
        }
        em.getTransaction().commit();
    }

    public List<Tipocomision> listarTipocomision() {
         return em.createQuery("FROM Tipocomision tc ORDER BY tc.idTIPOCOMISION").getResultList();
    }

    public List<Tipocomisionxafp> listarTipocomisionxafp() {
        return em.createQuery("FROM Tipocomisionxafp tca").getResultList();
    }

    public void ActualizarComisionesXafp(List<Tipocomisionxafp> listTipocomisionxafp) {
        em.getTransaction().begin();
        for (Tipocomisionxafp tipocomisionxafp : listTipocomisionxafp) {
            em.merge(tipocomisionxafp);
        }
        em.getTransaction().commit();
    }

}
