/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Multimedia;
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
public class MultimediaFacade extends AbstractFacade<Multimedia> implements MultimediaFacadeLocal {

    @PersistenceContext(unitName = "MundusCreatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MultimediaFacade() {
        super(Multimedia.class);
    }
    

    @Override
    public boolean asignarImagenMultimedia(int id_mul, int id_img) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_multimedia_imagen (fk_mul_id, fk_img_id) VALUES (?,?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_mul);
            // tome el segundo ? y lo cambia por id_rol
            q.setParameter(2, id_img);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean asignarVideoMultimedia(int id_mul, int id_vid) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_multimedia_video (fk_mul_id, fk_vid_id) VALUES (?,?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_mul);
            // tome el segundo ? y lo cambia por id_rol
            q.setParameter(2, id_vid);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
     
    @Override
     public List<Multimedia> leerMultimedia(){
        em.getEntityManagerFactory().getCache().evictAll();
        Query q = em.createQuery("SELECT u FROM Multimedia u");
        return q.getResultList();         
    }
}
