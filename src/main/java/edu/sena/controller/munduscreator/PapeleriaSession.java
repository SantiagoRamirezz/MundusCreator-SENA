/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;


import edu.sena.entity.munduscreator.Papeleria;
import edu.sena.facade.munduscreator.PapeleriaFacadeLocal;
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
@Named(value = "papeleriaSession")
@SessionScoped
public class PapeleriaSession implements Serializable {
    
    private Papeleria papCre = new Papeleria();
    private Papeleria papExt = new Papeleria();
    private int idAct;
    private int idDoc;
    private int idEva;
    
    @EJB
    PapeleriaFacadeLocal pfl;
    /**
     * Creates a new instance of PapeleriaSession
     */
    public PapeleriaSession() {
    }
    
    public List<Papeleria> leerPapeleria(){
        return pfl.findAll();
    }
    
    
    
     public void crearPapeleria(){
        try {
        pfl.create(papCre);
        pfl.asignarActividadPapeleria(papCre.getPkPapId(), idAct);
        pfl.asignarDocumentoPapeleria(papCre.getPkPapId(), idDoc);
        pfl.asignarEvaluacionPapeleria(papCre.getPkPapId(), idEva);
        papCre = new Papeleria();
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Papeleria Creada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide los datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
    }
     
     public void encontrarPapeleria(Papeleria pa) throws IOException{
        this.papExt = pa;
        FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatosPapeleria.xhtml");
    
    }
      
    public void eliminarPapeleria(){ 
        try {
            pfl.remove(papExt);
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Papeleria eliminada',"
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
    
    public void editarPapeleria(){ 
        try {
            pfl.edit(papExt);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Papeleria Actualizada',"
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
    
     public void añadirActividad() {
        try {
            pfl.asignarActividadPapeleria(papExt.getPkPapId(), idAct);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Actividad subida',"
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
    
      public void añadirDocumento() {
        try {
            pfl.asignarDocumentoPapeleria(papExt.getPkPapId(), idDoc);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Documento subido',"
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
      
         public void añadirEvaluacion() {
        try {
            pfl.asignarDocumentoPapeleria(papExt.getPkPapId(), idEva);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Evaluacion subida',"
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
    
    
    
    
       

    public Papeleria getPapCre() {
        return papCre;
    }

    public void setPapCre(Papeleria papCre) {
        this.papCre = papCre;
    }

    public Papeleria getPapExt() {
        return papExt;
    }

    public void setPapExt(Papeleria papExt) {
        this.papExt = papExt;
    }

    public int getIdAct() {
        return idAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public int getIdEva() {
        return idEva;
    }

    public void setIdEva(int idEva) {
        this.idEva = idEva;
    }
        
}
