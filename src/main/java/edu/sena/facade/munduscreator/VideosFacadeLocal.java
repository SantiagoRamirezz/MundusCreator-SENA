/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.munduscreator;

import edu.sena.entity.munduscreator.Videos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sr992
 */
@Local
public interface VideosFacadeLocal {

    void create(Videos videos);

    void edit(Videos videos);

    void remove(Videos videos);

    Videos find(Object id);

    List<Videos> findAll();

    List<Videos> findRange(int[] range);

    int count();

    public List<Videos> leerVideos();

    
}
