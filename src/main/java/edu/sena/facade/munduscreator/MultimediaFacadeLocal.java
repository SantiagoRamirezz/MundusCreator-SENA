/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Multimedia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sr992
 */
@Local
public interface MultimediaFacadeLocal {

    void create(Multimedia multimedia);

    void edit(Multimedia multimedia);

    void remove(Multimedia multimedia);

    Multimedia find(Object id);

    List<Multimedia> findAll();

    List<Multimedia> findRange(int[] range);

    int count();

    public boolean asignarVideoMultimedia(int id_mul, int id_vid);

    public boolean asignarImagenMultimedia(int id_mul, int id_img);

    public List<Multimedia> leerMultimedia();
    
}
