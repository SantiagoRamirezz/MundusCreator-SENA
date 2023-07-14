/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Documentos;
import edu.sena.facade.munduscreator.DocumentosFacadeLocal;
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
@Named(value = "documentoSession")
@SessionScoped
public class DocumentoSession implements Serializable {
@EJB
    DocumentosFacadeLocal dfl;
    
    private Documentos docCre = new Documentos();
    private Documentos docExt = new Documentos();
    
    /**
     * Creates a new instance of DocumentoSession
     */
    public DocumentoSession() {
    }
    
    public List<Documentos> leerDocumento(){
        return dfl.findAll();
}
    
     public void crearDocumento(){
        try {
        dfl.create(docCre);
        docCre = new Documentos();
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Documento Subido',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (Exception e) {
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide el Documento',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");    
        }
    }
     
     public void encontrarDocumento(Documentos doc) throws IOException{
         this.docExt = doc;
         FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatosDocumento.xhtml");
     }
     
    public void eliminarDocumento(){ 
        try {
        dfl.remove(docExt);
        FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Documento Eliminado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");      
        } catch (IOException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: error',"
                    + "  title: 'error',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");   
        }
      
    }
    
    public void editarDocumento(){
        try {
        dfl.edit(docExt);
        PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Documento Actualizado',"
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
    
    
    
    public Documentos getDocCre() {
        return docCre;
    }

    public void setDocCre(Documentos docCre) {
        this.docCre = docCre;
    }

    public Documentos getDocExt() {
        return docExt;
    }

    public void setDocExt(Documentos docExt) {
        this.docExt = docExt;
    }
    
    
}
