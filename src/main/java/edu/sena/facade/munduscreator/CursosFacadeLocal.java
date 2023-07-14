/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sr992
 */
@Local
public interface CursosFacadeLocal {

    void create(Cursos cursos);

    void edit(Cursos cursos);

    void remove(Cursos cursos);

    Cursos find(Object id);

    List<Cursos> findAll();

    List<Cursos> findRange(int[] range);

    int count();

    public List<Cursos> leerCursos();

    public boolean aignarMulPap(int id_mul, int id_pap, int id_cur);

    
   
    
}
