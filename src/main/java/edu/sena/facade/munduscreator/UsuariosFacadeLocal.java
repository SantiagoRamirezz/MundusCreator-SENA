/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sr992
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();

    public boolean asignaRol(int id_usu, int id_rol);

    public Usuarios validarUsuario(String correoIn, String claveIn);

    public List<Usuarios> leerTodos();

    public List<String> getAllCorreos();

    public Usuarios recovery(String correo);

    public boolean asignaCurso(int id_usu, int id_cur);
    
}
