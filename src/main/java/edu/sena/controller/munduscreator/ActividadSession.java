/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Actividades;
import edu.sena.facade.munduscreator.ActividadesFacadeLocal;
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
@Named(value = "actividadSession")
@SessionScoped
public class ActividadSession implements Serializable {

    @EJB
    ActividadesFacadeLocal afl;
    private Actividades actCre = new Actividades();
    private Actividades actExt = new Actividades();

    /**
     * Creates a new instance of ActividadSession
     */
    public ActividadSession() {
    }

    public List<Actividades> leerActividad() {
        return afl.findAll();
    }

    public void crearActividad() {
        try {
            afl.create(actCre);
            actCre = new Actividades();
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
    }

    public void encontrarActividad(Actividades ac) throws IOException {
        this.actExt = ac;
        FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatosActividad.xhtml");
    }

    public void eliminarActividad() {
        try {
            afl.remove(actExt);
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Actividad Eliminada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");

        } catch (IOException e) {
        
        PF.current().executeScript(
                "  swal.fire({"
                + "  position: 'top-center',"
                + "  icon: 'error',"
                + "  title: 'error',"
                + "  showConfirmButton: false,"
                + "  timer: 1500"
                + "  })");
        }
    }

    
    public void editarActividad() {
        try {
         afl.edit(actExt);
        PF.current().executeScript(
                "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'success',"
                        + "  title: 'Actividad Actualizada',"
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

    public Actividades getActCre() {
        return actCre;
    }

    public void setActCre(Actividades actCre) {
        this.actCre = actCre;
    }

    public Actividades getactExt() {
        return actExt;
    }

    public void setactExt(Actividades actExt) {
        this.actExt = actExt;
    }

}
