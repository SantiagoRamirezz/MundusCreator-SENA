/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Usuarios;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "MundusCreatorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public boolean asignaRol(int id_usu, int id_rol) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_usuario_rol (fk_usu_id, fk_rol_id) VALUES (?,?)");
            // tome el primer ? y lo cambia por id_usu
            q.setParameter(1, id_usu);
            // tome el segundo ? y lo cambia por id_rol
            q.setParameter(2, id_rol);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuarios validarUsuario(String correoIn, String claveIn) {
        try {
            Query qt = em.createQuery("SELECT u FROM Usuarios u WHERE u.usuCorreo = :d1 AND u.usuContrasenha = :d2");
            qt.setParameter("d1", correoIn);
            qt.setParameter("d2", claveIn);
            return (Usuarios) qt.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuarios> leerTodos() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query q = em.createQuery("SELECT u FROM Usuarios u");
        return q.getResultList();
    }

    @Override
    public List<String> getAllCorreos() {
        Query query = em.createQuery("SELECT u.usuCorreo FROM Usuarios u");
        return (List<String>) query.getResultList();
    }

    @Override
    public Usuarios recovery(String correo) {
        try {
            Query qt = em.createQuery("SELECT u FROM Usuarios u WHERE u.usuCorreo = :d1");
            qt.setParameter("d1", correo);
            return (Usuarios) qt.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
     public boolean asignaCurso(int id_usu, int id_cur) {
        try {
            Query q = em.createNativeQuery("INSERT INTO tbl_cursos_usuarios (fk_usu_id, fk_cur_id) VALUES (?,?)");
            q.setParameter(1, id_usu);
            q.setParameter(2, id_cur);
            q.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    

    

}
