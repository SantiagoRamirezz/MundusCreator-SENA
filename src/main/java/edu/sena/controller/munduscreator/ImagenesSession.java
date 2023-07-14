/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Imagenes;
import edu.sena.facade.munduscreator.ImagenesFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.PF;

/**
 *
 * @author Aprendiz
 */
@Named(value = "imagenesSession")
@SessionScoped
public class ImagenesSession implements Serializable {
 @EJB
    ImagenesFacadeLocal ifl;
    private Imagenes imaCre = new Imagenes();
    private Imagenes imaRem = new Imagenes();
    private Imagenes imaExt = new Imagenes();
    
    /**
     * Creates a new instance of ImagenesSession
     */
    public ImagenesSession() {
    }
    
    public void crearImagen(){
        try {
        ifl.create(imaCre);
        imaCre = new Imagenes();
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Imagen Subida',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide la Imagen',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
        return;
    }
    
    
    public List<Imagenes> leerImagen(){
        return ifl.leerImagenes();
    }
    
    public void encontrarImagen(Imagenes im) throws IOException{
      this.imaExt = im;
    FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatosImagen.xhtml");
    }
   
    public void eliminarImagen() throws IOException{ 
        try {
            ifl.remove(imaExt);
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Imagen Eliminada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Intente Nuevamente',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
       
    }
    
    public void editarImagen() {
        try {
            ifl.edit(imaExt);

            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Actualizado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Intente Nuevamente',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public Imagenes getImaCre() {
        return imaCre;
    }

    public void setImaCre(Imagenes imaCre) {
        this.imaCre = imaCre;
    }

    public Imagenes getImaRem() {
        return imaRem;
    }

    public void setImaRem(Imagenes imaRem) {
        this.imaRem = imaRem;
    }

    public Imagenes getImaExt() {
        return imaExt;
    }

    public void setImaExt(Imagenes imaExt) {
        this.imaExt = imaExt;
    }
    
    
}
