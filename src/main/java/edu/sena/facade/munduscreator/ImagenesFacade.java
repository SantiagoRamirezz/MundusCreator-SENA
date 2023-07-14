/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Imagenes;
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
public class ImagenesFacade extends AbstractFacade<Imagenes> implements ImagenesFacadeLocal {

    @PersistenceContext(unitName = "MundusCreatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenesFacade() {
        super(Imagenes.class);
    }
    
    @Override
     public List<Imagenes> leerImagenes(){
        em.getEntityManagerFactory().getCache().evictAll();
        Query q = em.createQuery("SELECT u FROM Imagenes u");
        return q.getResultList();         
    }
}
