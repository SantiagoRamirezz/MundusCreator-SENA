/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Papeleria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sr992
 */
@Local
public interface PapeleriaFacadeLocal {

    void create(Papeleria papeleria);

    void edit(Papeleria papeleria);

    void remove(Papeleria papeleria);

    Papeleria find(Object id);

    List<Papeleria> findAll();

    List<Papeleria> findRange(int[] range);

    int count();

    public boolean asignarDocumentoPapeleria(int id_pap, int id_doc);

    public boolean asignarActividadPapeleria(int id_pap, int id_act);

    public boolean asignarEvaluacionPapeleria(int id_pap, int id_eva);
    
}
