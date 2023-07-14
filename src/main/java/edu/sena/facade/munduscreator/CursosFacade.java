/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sr992
 */
@Stateless
public class CursosFacade extends AbstractFacade<Cursos> implements CursosFacadeLocal {

    @PersistenceContext(unitName = "MundusCreatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursosFacade() {
        super(Cursos.class);
    }
    
    @Override
    public List<Cursos> leerCursos(){
        em.getEntityManagerFactory().getCache().evictAll();
        Query q = em.createQuery("SELECT u FROM Cursos u");
        return q.getResultList();         
    }
    
    public boolean aignarMulPap(int id_mul, int id_pap, int id_cur) {
        try {
            Query q = em.createNativeQuery("UPDATE tbl_cursos SET (fk_mul_id) = (?), (fk_pap_id) = (?) WHERE (pk_cur_id) = (?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_mul);
            q.setParameter(2, id_pap);
            q.setParameter(3, id_cur);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
}
