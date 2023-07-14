/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import edu.sena.facade.munduscreator.CursosFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.PF;

/**
 *
 * @author sr992
 */
@Named(value = "cursoSession")
@SessionScoped
public class CursoSession implements Serializable {

    @EJB
    CursosFacadeLocal cfl;
    private Cursos curCre = new Cursos();
    private Cursos curExt = new Cursos();
    private int idMul;
    private int idPap;
    public CursoSession() {

    }

    @PostConstruct
    public void init() {
        curCre = new Cursos();
    }

    public void crearCurso() {
        try {
            cfl.create(curCre);
            cfl.aignarMulPap(idMul, idPap, curCre.getPkCurId());
            curCre = new Cursos();
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Curso Creado ',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (NumberFormatException e) {
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

    public List<Cursos> listarCurso() {
        return cfl.leerCursos();
    }

    public void encontrarCurso(Cursos cu) throws IOException {
        this.curExt = cu;
        FacesContext.getCurrentInstance().getExternalContext().redirect("EditarCurso.xhtml");
    }

    public void editarCurso() {
        try {
            cfl.edit(curExt);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Curso Actualizado ',"
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

    public void eliminarCurso() {
        try {
            cfl.edit(curExt);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Curso Actualizado ',"
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

    public Cursos getCurCre() {
        return curCre;
    }

    public void setCurCre(Cursos curCre) {
        this.curCre = curCre;
    }

    public Cursos getCurExt() {
        return curExt;
    }

    public void setCurExt(Cursos curExt) {
        this.curExt = curExt;
    }

    public int getIdMul() {
        return idMul;
    }

    public void setIdMul(int idMul) {
        this.idMul = idMul;
    }

    public int getIdPap() {
        return idPap;
    }

    public void setIdPap(int idPap) {
        this.idPap = idPap;
    }

    
    

   

    

 

}
