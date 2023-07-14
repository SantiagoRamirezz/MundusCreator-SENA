/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;


import edu.sena.entity.munduscreator.Videos;
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
public class VideosFacade extends AbstractFacade<Videos> implements VideosFacadeLocal {

    @PersistenceContext(unitName = "MundusCreatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VideosFacade() {
        super(Videos.class);
    }
    
    @Override
    public List<Videos> leerVideos(){
        em.getEntityManagerFactory().getCache().evictAll();
        Query q = em.createQuery("SELECT u FROM Videos u");
        return q.getResultList();         
    }
    
    
}
