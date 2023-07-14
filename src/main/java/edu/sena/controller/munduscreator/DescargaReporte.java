/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.sena.controller.munduscreator;

import edu.sena.facade.munduscreator.UsuariosFacade;
import edu.sena.facade.munduscreator.UsuariosFacadeLocal;
import edu.sena.service.munduscreator.ReportServices;
import edu.sena.service.munduscreator.ReportUserDataSource;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *para poder descargar el reporte
 * tiene un scope tipo request para que solo exista durante la sesión
 * @author davidleon
 */
@Named(value = "descargaReporte")
@RequestScoped
public class DescargaReporte {
    
    //llamamos el facade, la entidad en la base de datos
    //la inyectamos para que traiga todos los datos en la variable y podamos acceder al CRUD
    @EJB //hace referencia al Enterprise JavaBeans
   UsuariosFacadeLocal usuariosFacade;
    private ReportServices reportServices = new ReportServices();

    /**
     * Creates a new instance of DescargaReporte
     */
    public DescargaReporte() {
    }
    
    public void download(){
        
        try {
            JasperPrint JP = reportServices.reporteUsuarios(new ReportUserDataSource(usuariosFacade.findAll()));
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
            //response es igual a un cast(convertir un objeto a HttpServletResponse)
            //FacesContext clase que ayuda a traer la configuración del servidor de JSF
            //getResponse obtener la respuesta del servidor
            response.addHeader("Content-disposition", "attachment; filename=Reporte_Usuarios.pdf");
            //Content-disposition para decirle a la respuesta que se le da al usuario que se va a descargar un archivo
            //attachment de esta manera sabe que se va a hacer una descarga porque tiene un adjunto
            
            //vamos a escribir el archivo en el response
            ServletOutputStream sos = response.getOutputStream();//para que escriba los bits que generan el archivo, en la respuesta al usuario
            JasperExportManager.exportReportToPdfStream(JP, sos);
            sos.flush();//flush para escribir en la respuesta del usuario
            sos.close();//cierra la conexión de esfribir datos en la memeoria.  siempre usarla para que no consuma memoria del servidor
            FacesContext.getCurrentInstance().responseComplete();//para que sepa que la petición ha terminado
            
        } catch (JRException e) {
            e.printStackTrace();
            
        } catch (IOException e){
            e.printStackTrace();
        }
        
        
    }
    
}
