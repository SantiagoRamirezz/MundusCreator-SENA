/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.service.munduscreator;

import edu.sena.entity.munduscreator.Usuarios;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * para pasar los datos registrados en la base de datos al usuario
 * @author davidleon
 */
public class ReportUserDataSource implements JRDataSource{
    //creamos un atributo de tipo list para gusrdar objetos de tipo entity
    //le pasamos el entity al que le queremos pasar los datos
    private List<Usuarios> usuarios;
    //indice lo creamos para que vaya pasando al siguiente dato en el campo detail del reporte en jasperreports
    private int indice;
    
    //constructor
    public ReportUserDataSource(List<Usuarios> usuarios){
        this.usuarios = usuarios;
        indice = -1;
        
    }

    @Override
    public boolean next() throws JRException {//si hay más registros por pasar continua de lo contrario false y se detiene.
        indice++;
        return indice < usuarios.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {//método para enviar los datos al reporte - jrf es un parámetro
        Usuarios user = usuarios.get(indice);
        //le decimos que field del jasperreport tome, y por cual campo de nuestra tabla en la BDS, la reemplace
        if (jrf.getName().equals("id")) {
            return  user.getPkUsuId();
            
        }else if (jrf.getName().equals("nombre")){
            return user.getUsuNombre();
            
        }else if (jrf.getName().equals("apellido")){
            return user.getUsuApellido();
            
        }else if (jrf.getName().equals("email")){
            return user.getUsuCorreo();
            
        }else if(jrf.getName().equals("nombreUsu")){
            return user.getUsuNomusu();
        }
        
        return null;
    
    }
    
}
