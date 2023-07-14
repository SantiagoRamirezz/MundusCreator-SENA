/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Papeleria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sr992
 */
@Stateless
public class PapeleriaFacade extends AbstractFacade<Papeleria> implements PapeleriaFacadeLocal {

    @PersistenceContext(unitName = "MundusCreatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PapeleriaFacade() {
        super(Papeleria.class);
    }
    
    @Override
     public boolean asignarDocumentoPapeleria(int id_pap, int id_doc) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_papeleria_documento (fk_pap_id, fk_doc_id) VALUES (?,?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_pap);
            // tome el segundo ? y lo cambia por id_rol
            q.setParameter(2, id_doc);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean asignarActividadPapeleria(int id_pap, int id_act) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_papeleria_actividad (fk_pap_id, fk_act_id) VALUES (?,?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_pap);
            // tome el segundo ? y lo cambia por id_rol
            q.setParameter(2, id_act);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean asignarEvaluacionPapeleria(int id_pap, int id_eva) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_papeleria_evaluacion (fk_pap_id, fk_eva_id) VALUES (?,?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_pap);
            // tome el segundo ? y lo cambia por id_rol
            q.setParameter(2, id_eva);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
