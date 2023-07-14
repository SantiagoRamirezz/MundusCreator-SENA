/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.service.munduscreator;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *para conectarnos al reporte
 * @author davidleon
 */
public class ReportServices {
    //para hacer la conexión usamos el archivo .jasper que se crea en el jaspersoft studio
    //creamos un método con JasperPrint, que va a ser el objeto que se devuelve con los datos ya pintados
    
    public JasperPrint reporteUsuarios (ReportUserDataSource dataSource) throws JRException{
        Map<String, Object> parameters = new HashMap<>();//le vamos a pasar los parámetros que definimos en el jaspersoft studio
        parameters.put("mainTitle", "Reporte de usuarios");
        //conectarnos al reporte
        //Paths.get busca el nombre del archivo que le pasemos (""), obtiene la url(ruta) y se la pasa a fillReport
        JasperPrint jp = JasperFillManager.fillReport(Paths.get("MundusCreatorReport.jasper").toAbsolutePath().toString(), parameters, dataSource);
        //el archivo.jasper se debe copiar dentro de la carpeta del servidor en config ex: /Users/davidleon/server/payara5/glassfish/domains/domain1 que es el domain que está usando el servidor
        return jp;
    }
    
}
