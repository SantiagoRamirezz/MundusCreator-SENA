/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Evaluaciones;
import edu.sena.facade.munduscreator.EvaluacionesFacadeLocal;
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
@Named(value = "evaluacionesSession")
@SessionScoped
public class EvaluacionesSession implements Serializable {
    
    @EJB
    EvaluacionesFacadeLocal efl;
    private Evaluaciones evaCre = new Evaluaciones();
    private Evaluaciones evaExt = new Evaluaciones();
    /**
     * Creates a new instance of EvaluacionesSession
     */
    public EvaluacionesSession() {
    }
    
     public List<Evaluaciones> leerEvaluacion(){
        return efl.findAll();
    }
    
    public void crearEvaluacion(){
        try {
        efl.create(evaCre);
        evaCre = new Evaluaciones();
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Evaluación Subida',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide la Evaluación',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
    }
    
    public void encontrarEvaluacion(Evaluaciones ev) throws IOException{
        this.evaExt=ev;
        FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatosEvaluacion.xhtml");
    }
    
    public void eliminarEvaluacion(){ 
        try {
            efl.remove(evaExt);
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Evaluación Eliminada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (IOException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Error',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
            
        }
        
       
    }
    
    public void editarEvaluacion(){
        try {
            efl.edit(evaExt);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Evaluación Actualizada',"
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


    public Evaluaciones getEvaCre() {
        return evaCre;
    }

    public void setEvaCre(Evaluaciones evaCre) {
        this.evaCre = evaCre;
    }

    public Evaluaciones getEvaExt() {
        return evaExt;
    }

    public void setEvaExt(Evaluaciones evaExt) {
        this.evaExt = evaExt;
    }
    
}
