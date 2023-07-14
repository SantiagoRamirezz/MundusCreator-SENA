/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controller.munduscreator;

import edu.sena.entity.munduscreator.Cursos;
import edu.sena.entity.munduscreator.Usuarios;
import edu.sena.facade.munduscreator.UsuariosFacadeLocal;
import edu.sena.service.munduscreator.MailService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import org.primefaces.PF;

@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    private Usuarios UsuReg = new Usuarios();
    private Usuarios UsuLog = new Usuarios();
    private Usuarios UsuExt = new Usuarios();
    private Usuarios UsuInfo = new Usuarios();
    private Cursos curExt = new Cursos();
    private String correoForm;
    private String cooreoSend;
    private String claveForm;
    private String contrasenaCambio;
    private String nuevaContrasena;
    private String repiteContraena;
    private String estado;
    private String Mensaje;
    private String vConstrasenha;
    private String asunto;
    private String encabezado;
    private int rol = 0; 
    private MailService ms = new MailService();
    private List<String> listaTipDoc;

    @EJB
    UsuariosFacadeLocal ufl;

    public UsuarioSession() {
        listaTipDoc = new ArrayList<>();
        listaTipDoc.add("CC");
        listaTipDoc.add("TI");
        listaTipDoc.add("CE");
    }

    public void seleccionarCurso(Cursos cu) throws IOException {
        this.curExt = cu;
        if (UsuLog.getCursosCollection().equals(curExt.getPkCurId())) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Ya tienes asignado este curso',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Curso.xhtml");
        }
    }

    public void seleccionarMiCurso(Cursos cu) throws IOException {
        this.curExt = cu;
        FacesContext.getCurrentInstance().getExternalContext().redirect("Detalles_Curso.xhtml");
    }

    public void elegirCurso() {
        try {
            ufl.asignaCurso(UsuLog.getPkUsuId(), curExt.getPkCurId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
        } catch (IOException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Ya tienes asignado este curso',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }

    }

    public void crearUsuario() {

        try {
            UsuReg.setUsuEstado(Short.parseShort("1"));
            UsuReg.setUsuFoto(String.valueOf("assets/imgU/default.jpg"));
            ufl.create(UsuReg);
            ufl.asignaRol(UsuReg.getPkUsuId(), 1);
            ms.sendMessageRegister(UsuReg.getUsuCorreo(), UsuReg.getUsuNombre(), UsuReg.getUsuApellido());
            ms = new MailService();
            UsuLog = ufl.validarUsuario(UsuReg.getUsuCorreo(), UsuReg.getUsuContrasenha());
            FacesContext fx = FacesContext.getCurrentInstance();
            fx.getExternalContext().redirect("Estudiante/Index.xhtml");
            UsuReg = new Usuarios();
        } catch (Exception e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }

    }

    public void validarUsuario() {
        try {
            UsuLog = ufl.validarUsuario(correoForm, claveForm);
            if (UsuLog == null) {
                PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'warning',"
                        + "  title: 'Correo o Contraseña incorrectos',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
            } else {
                if (UsuLog.getUsuEstado() == Short.parseShort("1")) {
                    FacesContext fx = FacesContext.getCurrentInstance();
                    fx.getExternalContext().redirect("Estudiante/Index.xhtml");
                } else {
                    PF.current().executeScript(
                            "  swal.fire({"
                            + "  position: 'top-center',"
                            + "  icon: 'info',"
                            + "  title: 'Contacte al administrador',"
                            + "  showConfirmButton: false,"
                            + "  timer: 1500"
                            + "  })");

                }
            }
        } catch (IOException | NumberFormatException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public void editarMiPefil() {
        try {
            ufl.edit(UsuLog);

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

    public void editarContrasena() {
        try {
            if (contrasenaCambio == null ? UsuLog.getUsuContrasenha() == null : contrasenaCambio.equals(UsuLog.getUsuContrasenha())) {
                if (nuevaContrasena == null ? repiteContraena == null : nuevaContrasena.equals(repiteContraena)) {
                    UsuLog.setUsuContrasenha(nuevaContrasena);
                    ufl.edit(UsuLog);
                    contrasenaCambio = "";
                    nuevaContrasena = "";
                    repiteContraena = "";
                    PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'success',"
                        + "  title: 'Actualizado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
                }else{
                    PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'error',"
                        + "  title: 'Las contraseñas nuevas no coinciden',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
                }
            } else {
                PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'error',"
                        + "  title: 'La contraseña actual no coincide',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
            }

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

    public void eliminarMiPefil() throws IOException {
        try {
            UsuLog.setUsuEstado(Short.parseShort("2"));
            ufl.edit(UsuLog);
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'warning',"
                    + "  title: 'Cuenta eliminada',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");

        } catch (IOException e) {

            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'Error',"
                    + "  title: 'Valide los campos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");

        }

    }

    public void recuperarContrasenha() {
        try {
            UsuLog = ufl.recovery(cooreoSend);
            if (UsuLog == null) {
                PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'warning',"
                        + "  title: 'Usuario no encontrado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
            } else {
                ms.sendMessageRecovery(cooreoSend, UsuLog.getUsuContrasenha());
                PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'success',"
                        + "  title: 'Correo de recuperación enviado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
                ms = new MailService();
                cooreoSend = "";
            }
        } catch (MessagingException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public List<Usuarios> leerTodos() {
        return ufl.leerTodos();
    }

    public void crearUsuarioAdmin() {
        try {
            if (rol !=0) {
            UsuReg.setUsuEstado(Short.parseShort("1"));
            UsuReg.setUsuFoto(String.valueOf("../assets/imgU/default.jpg"));
            ufl.create(UsuReg);
            ufl.asignaRol(UsuReg.getPkUsuId(), 1);
            ufl.asignaRol(UsuReg.getPkUsuId(), rol);
            ms.sendMessageRegister(UsuReg.getUsuCorreo(), UsuReg.getUsuNombre(), UsuReg.getUsuApellido());
            ms = new MailService();
            UsuReg = new Usuarios();
            rol=0;
            PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'success',"
                        + "  title: 'Usurario Creado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
            }else{
            UsuReg.setUsuEstado(Short.parseShort("1"));
            UsuReg.setUsuFoto(String.valueOf("../assets/imgU/default.jpg"));
            ufl.create(UsuReg);
            ufl.asignaRol(UsuReg.getPkUsuId(), 1);
            ms.sendMessageRegister(UsuReg.getUsuCorreo(), UsuReg.getUsuNombre(), UsuReg.getUsuApellido());
            ms = new MailService();
            UsuReg = new Usuarios();
            rol=0;
            PF.current().executeScript(
                        "  swal.fire({"
                        + "  position: 'top-center',"
                        + "  icon: 'success',"
                        + "  title: 'Usurario Creado',"
                        + "  showConfirmButton: false,"
                        + "  timer: 1500"
                        + "  })");
            }
            
            
        } catch (NumberFormatException | MessagingException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Valide sus datos',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }

    }

    public void encontrarUsuario(Usuarios us) throws IOException {
        this.UsuExt = us;
        FacesContext.getCurrentInstance().getExternalContext().redirect("EditarDatos.xhtml");
    }
    
    public void infoUsuario(Usuarios us) throws IOException {
        this.UsuInfo = us;
        FacesContext.getCurrentInstance().getExternalContext().redirect("InfoUsuario.xhtml");
    }

    public void editarPefilExt() {
        try {
            UsuExt.setUsuEstado(Short.parseShort(estado));
            ufl.edit(UsuExt);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Actualizado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        } catch (NumberFormatException e) {
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


    public void sendMessageMasivo() {
        try {
            //List<String>email=new ArrayList<>();//para 1 usuario
            //email.add(Correo.getUSUCorreo());//para 1 usuario
            //ms.sendMessage(Mensaje,email);//para 1 usuario
            ms.sendMessageMasivo(encabezado, asunto, Mensaje, ufl.getAllCorreos());// para correo masivo
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Correo enviado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
            ms = new MailService();
            Mensaje = "";
            asunto = "";
            encabezado = "";
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Ocurrió un error',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public void sendMessage() {
        try {
            ms.sendMessage(Mensaje, cooreoSend, asunto);
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'success',"
                    + "  title: 'Correo enviado',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
            ms = new MailService();
            cooreoSend = "";
            Mensaje = "";
            asunto = "";
        } catch (MessagingException e) {
            PF.current().executeScript(
                    "  swal.fire({"
                    + "  position: 'top-center',"
                    + "  icon: 'error',"
                    + "  title: 'Ocurrió un error',"
                    + "  showConfirmButton: false,"
                    + "  timer: 1500"
                    + "  })");
        }
    }

    public Usuarios getUsuLog() {
        return UsuLog;
    }

    public void setUsuLog(Usuarios UsuLog) {
        this.UsuLog = UsuLog;
    }

    public String getCorreoForm() {
        return correoForm;
    }

    public void setCorreoForm(String correoForm) {
        this.correoForm = correoForm;
    }

    public String getClaveForm() {
        return claveForm;
    }

    public void setClaveForm(String claveForm) {
        this.claveForm = claveForm;
    }

    public Usuarios getUsuReg() {
        return UsuReg;
    }

    public void setUsuReg(Usuarios UsuReg) {
        this.UsuReg = UsuReg;
    }

    public Usuarios getUsuExt() {
        return UsuExt;
    }

    public void setUsuExt(Usuarios UsuExt) {
        this.UsuExt = UsuExt;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public MailService getMs() {
        return ms;
    }

    public void setMs(MailService ms) {
        this.ms = ms;
    }

    public List<String> getListaTipDoc() {
        return listaTipDoc;
    }

    public void setListaTipDoc(List<String> listaTipDoc) {
        this.listaTipDoc = listaTipDoc;
    }

    public String getvConstrasenha() {
        return vConstrasenha;
    }

    public void setvConstrasenha(String vConstrasenha) {
        this.vConstrasenha = vConstrasenha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCooreoSend() {
        return cooreoSend;
    }

    public void setCooreoSend(String cooreoSend) {
        this.cooreoSend = cooreoSend;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public Cursos getCurExt() {
        return curExt;
    }

    public void setCurExt(Cursos curExt) {
        this.curExt = curExt;
    }

    public String getContrasenaCambio() {
        return contrasenaCambio;
    }

    public void setContrasenaCambio(String contrasenaCambio) {
        this.contrasenaCambio = contrasenaCambio;
    }

    public String getRepiteContraena() {
        return repiteContraena;
    }

    public void setRepiteContraena(String repiteContraena) {
        this.repiteContraena = repiteContraena;
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public Usuarios getUsuInfo() {
        return UsuInfo;
    }

    public void setUsuInfo(Usuarios UsuInfo) {
        this.UsuInfo = UsuInfo;
    }
   


}
