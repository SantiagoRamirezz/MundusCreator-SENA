/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Videos;
import edu.sena.facade.munduscreator.VideosFacadeLocal;
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
@Named(value = "videosSession")
@SessionScoped
public class VideosSession implements Serializable {
    @EJB
    VideosFacadeLocal vfl;
    private Videos vidCre = new Videos();
    private Videos vidRem = new Videos();
    private Videos vidExt = new Videos();
    /**
     * Creates a new instance of VideosSession
     */
    public VideosSession() {
    }
    
     public void crearVideo(){
        try {
        vfl.create(vidCre);
        vidCre = new Videos();
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Video Subido',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide el video',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
    }
     
     public List<Videos> leerVideos(){
        return vfl.leerVideos();
    }
    
   
    
    public void encontrarVideo(Videos vi) throws IOException{
        this.vidExt = vi;
     FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatosVideo.xhtml");
    }
    
    
    
   
    
     public void eliminarVideo() throws IOException{ 
         try {
        vfl.remove(vidExt);
        FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Video Subido',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Intente nuevamente',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
    }
     
     public void editarVideo() {
        try {
            vfl.edit(vidExt);

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

    public Videos getVidCre() {
        return vidCre;
    }

    public void setVidCre(Videos vidCre) {
        this.vidCre = vidCre;
    }

    public Videos getVidRem() {
        return vidRem;
    }

    public void setVidRem(Videos vidRem) {
        this.vidRem = vidRem;
    }

    public Videos getVidExt() {
        return vidExt;
    }

    public void setVidExt(Videos vidExt) {
        this.vidExt = vidExt;
    }
    
    
}
