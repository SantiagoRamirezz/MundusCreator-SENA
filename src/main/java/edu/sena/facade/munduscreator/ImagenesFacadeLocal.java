/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Imagenes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sr992
 */
@Local
public interface ImagenesFacadeLocal {

    void create(Imagenes imagenes);

    void edit(Imagenes imagenes);

    void remove(Imagenes imagenes);

    Imagenes find(Object id);

    List<Imagenes> findAll();

    List<Imagenes> findRange(int[] range);

    int count();

    public List<Imagenes> leerImagenes();
    
}
