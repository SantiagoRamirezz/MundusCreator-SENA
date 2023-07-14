/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Roles;
import edu.sena.facade.munduscreator.RolesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author santi
 */
@Named(value = "rolSession")
@SessionScoped
public class RolSession implements Serializable {

    /**
     * Creates a new instance of RolSession
     */
    public RolSession() {
    }
    @EJB
    RolesFacadeLocal rfl;
    
    public List<Roles> leerRol(){
        return rfl.findAll();
    }
}
