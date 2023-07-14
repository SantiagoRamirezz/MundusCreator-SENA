/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Multimedia;
import edu.sena.facade.munduscreator.MultimediaFacadeLocal;
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
@Named(value = "multimediaSession")
@SessionScoped
public class MultimediaSession implements Serializable {
    @EJB
    MultimediaFacadeLocal mfl;
    private Multimedia mulCre = new Multimedia();
    private Multimedia mulExt = new Multimedia();
    private Multimedia mulRem = new Multimedia();

    private int idIma;
    private int idVid;
    /**
     * Creates a new instance of MultimediaSession
     */
    public MultimediaSession() {
    }
     public void crearMultimedia(){
        try {
        mfl.create(mulCre);
        mfl.asignarImagenMultimedia(mulCre.getPkMulId(), idIma);
        mfl.asignarVideoMultimedia(mulCre.getPkMulId(), idVid);
        mulCre = new Multimedia();
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Multimedia Guardada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide los campos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
    }
    
    public List<Multimedia> leerMultimedia(){
        return mfl.leerMultimedia();
    }
    
    
    
    public void encontrarMiltimedia(Multimedia mu) throws IOException{
        this.mulExt= mu;
        FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatosMultimedia.xhtml");
    }

    
    public void eliminarMultimedia() throws IOException {
        try {
        mfl.remove(mulExt);
        FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Multimedia Eliminada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide los campos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
    }
    
    public void editarMultimedia() {
        try {
            mfl.edit(mulExt);
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
    
    
    public void añadirImagen() {
        try {
            mfl.asignarImagenMultimedia(mulExt.getPkMulId(), idIma);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Imagen subida',"
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
    
      public void añadirVideo() {
        try {
            mfl.asignarVideoMultimedia(mulExt.getPkMulId(), idVid);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Video subido',"
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
    
    
    
    
    
    
    public Multimedia getMulCre() {
        return mulCre;
    }

    public void setMulCre(Multimedia mulCre) {
        this.mulCre = mulCre;
    }

    public int getIdIma() {
        return idIma;
    }

    public void setIdIma(int idIma) {
        this.idIma = idIma;
    }

    public int getIdVid() {
        return idVid;
    }

    public void setIdVid(int idVid) {
        this.idVid = idVid;
    }

    public Multimedia getMulExt() {
        return mulExt;
    }

    public void setMulExt(Multimedia mulExt) {
        this.mulExt = mulExt;
    }

    public Multimedia getMulRem() {
        return mulRem;
    }

    public void setMulRem(Multimedia mulRem) {
        this.mulRem = mulRem;
    }
}
