/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.sena.service.munduscreator;

import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ander
 */
public class MailService {

    private Properties prop;
    private Session session;
    private MimeMessage mimeMessage;

    public MailService() {
        prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.user", "munduscreatorof@gmail.com");
        prop.put("mail.smtp.password", "ecxbplocvskzkowd");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");
        session = Session.getDefaultInstance(prop);
        session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mimeMessage = new MimeMessage(session);
    }

    public void sendMessageMasivo(String encabezado, String asunto, String message, List<String> sendTo) throws MessagingException {
        if (mimeMessage != null) {
            //el correo desde donde lo mandamos
            mimeMessage.setFrom(new InternetAddress(prop.getProperty("mail.smtp.user")));
            String correos = "";
            for (String correo : sendTo) {
                correos = correos + correo + ",";
            }
            mimeMessage.addRecipients(Message.RecipientType.TO, correos);
            mimeMessage.setSubject(asunto);
            MimeBodyPart body = new MimeBodyPart();
            //mensaje y tipo de mensaje
            String htmlcode = " <header style='display:flex; background-color:black; padding: 30px;"
                    + "    align-items: center;'>"
                    + "    <div style='margin: auto;'>"
                    + "        <img style='width: 100px; ' src='https://i.ibb.co/TBkWjBy/Logo2.jpg' alt='Logo2' border='0'>"
                    + "    </div>"
                    + "</header>"
                    + "<div"
                    + "    style='padding: 70px 20px 70px 20px; text-align: center; background-color: antiquewhite; margin: 0px 100px 0px 100px;'>"
                    + "    "
                    + "    <h1>" + encabezado + "</h1>"
                    + "    <p>" + message + "</p>"
                    + "    "
                    + ""
                    + "</div>"
                    + " <footer>"
                    + "<div style=' background-color:black; padding: 30px; color: white;'>"
                    + "    <div>"
                    + "        <p>Contactanos</p><br>"
                    + "        <ul>"
                    + "            <li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "        </ul>"
                    + "    </div>"
                    + "    <div style='text-align: end;'>"
                    + "        <p>Copyright 2022 ©</p>"
                    + "    </div>"
                    + "</div>"
                    + "</footer>";
            body.setContent(htmlcode, "text/html; charset=utf-8");
            Multipart multiPart = new MimeMultipart();
            //cargamos el cuerpo del mensaje
            multiPart.addBodyPart(body);
            mimeMessage.setContent(multiPart);
            //enviamos el correo
            Transport.send(mimeMessage, prop.getProperty("mail.smtp.user"), prop.getProperty("mail.smtp.password"));
        }
    }

    public void sendMessage(String message, String sendTo, String asunto) throws AddressException, MessagingException {
        if (mimeMessage != null) {
            //el correo desde donde lo mandamos
            mimeMessage.setFrom(new InternetAddress(prop.getProperty("mail.smtp.user")));
            //el correo a quien lo enviamos
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            mimeMessage.setSubject(asunto);
            MimeBodyPart body = new MimeBodyPart();
            //mensaje y tipo de mensaje
            String htmlcode = "<header style='display:flex; background-color:black; padding: 30px;"
                    + "    align-items: center;'>"
                    + "    <div style='margin: auto;'>"
                    + "        <img style='width: 100px; ' src='https://i.ibb.co/TBkWjBy/Logo2.jpg' alt='Logo2' border='0'>"
                    + "    </div>"
                    + "</header>"
                    + "<div"
                    + "    style='padding: 70px 20px 70px 20px; text-align: center; background-color: antiquewhite; margin: 0px 100px 0px 100px;'>"
                    + "    "
                    + "  "
                    + "    <p>" + message + "</p>"
                    + "    "
                    + ""
                    + "</div>"
                    + " <footer>"
                    + "<div style=' background-color:black; padding: 30px; color: white;'>"
                    + "    <div>"
                    + "        <p>Contactanos</p><br>"
                    + "        <ul>"
                    + "            <li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "        </ul>"
                    + "    </div>"
                    + "    <div style='text-align: end;'>"
                    + "        <p>Copyright 2022 ©</p>"
                    + "    </div>"
                    + "</div>"
                    + "</footer>";
            body.setContent(htmlcode, "text/html; charset=utf-8");
            Multipart multiPart = new MimeMultipart();
            //cargamos el cuerpo del mensaje
            multiPart.addBodyPart(body);
            mimeMessage.setContent(multiPart);
            //enviamos el correo
            Transport.send(mimeMessage, prop.getProperty("mail.smtp.user"), prop.getProperty("mail.smtp.password"));
        }
    }

    public void sendMessageRegister(String sendTo, String nombre, String apellido) throws AddressException, MessagingException {
        if (mimeMessage != null) {
            //el correo desde donde lo mandamos
            mimeMessage.setFrom(new InternetAddress(prop.getProperty("mail.smtp.user")));
            //el correo a quien lo enviamos
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            mimeMessage.setSubject("BIENVENIDO A MUNDUS CREATOR!!!!");
            MimeBodyPart body = new MimeBodyPart();
            //mensaje y tipo de mensaje

            String htmlcode = "<header style='display:flex; background-color:black; padding: 30px;"
                    + "    align-items: center;'>"
                    + "    <div style='margin: auto;'>"
                    + "        <img style='width: 100px; ' src='https://i.ibb.co/TBkWjBy/Logo2.jpg' alt='Logo2' border='0'>"
                    + "    </div>"
                    + "</header>"
                    + "<div"
                    + "    style='padding: 70px 20px 70px 20px; text-align: center; background-color: antiquewhite; margin: 0px 100px 0px 100px;'>"
                    + "    <h1>¡Bienvinid@ a Mundus Creator!</h1>"
                    + "    <p>Felicidades por la creacion exitosa de tu cuenta</p>"
                    + "    <p>" + nombre + " " + apellido + "</p>"
                    + "    <p>¡Tenemos cursos esperando por ti!</p>"
                    + "    <p>Sumergete en esta red de conocimiento junto a nosotros.</p>"
                    + "</div>"
                    + " <footer>"
                    + "<div style=' background-color:black; padding: 30px; color: white;'>"
                    + "    <div>"
                    + "        <p>Contactanos</p><br>"
                    + "        <ul>"
                    + "            <li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "        </ul>"
                    + "    </div>"
                    + "    <div style='text-align: end;'>"
                    + "        <p>Copyright 2022 ©</p>"
                    + "    </div>"
                    + "</div>"
                    + "</footer>";
            body.setContent(htmlcode, "text/html; charset=utf-8");
            Multipart multiPart = new MimeMultipart();
            //cargamos el cuerpo del mensaje
            multiPart.addBodyPart(body);
            mimeMessage.setContent(multiPart);
            //enviamos el correo
            Transport.send(mimeMessage, prop.getProperty("mail.smtp.user"), prop.getProperty("mail.smtp.password"));
        }
    }

    public void sendMessageRecovery(String sendTo, String contrasenha) throws AddressException, MessagingException {
        if (mimeMessage != null) {
            //el correo desde donde lo mandamos
            mimeMessage.setFrom(new InternetAddress(prop.getProperty("mail.smtp.user")));
            //el correo a quien lo enviamos
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
            mimeMessage.setSubject("¿Has olvidado tu contraseña?");
            MimeBodyPart body = new MimeBodyPart();
            //mensaje y tipo de mensaje
            String htmlcode = "<header style='display:flex; background-color:black; padding: 30px;"
                    + "    align-items: center;'>"
                    + "    <div style='margin: auto;'>"
                    + "        <img style='width: 100px; ' src='https://i.ibb.co/TBkWjBy/Logo2.jpg' alt='Logo2' border='0'>"
                    + "    </div>"
                    + "</header>"
                    + "<div"
                    + "    style='padding: 70px 20px 70px 20px; text-align: center; background-color: antiquewhite; margin: 0px 100px 0px 100px;'>"
                    + "    <h1>¿Has olvidado tu contraseña?</h1>"
                    + "    <p>Tu contraseña es:</p>"
                    + "    <p>" + contrasenha + "</p>"
                    + "</div>"
                    + " <footer>"
                    + "<div style=' background-color:black; padding: 30px; color: white;'>"
                    + "    <div>"
                    + "        <p>Contactanos</p><br>"
                    + "        <ul>"
                    + "            <li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "<li>3138956954</li>"
                    + "        </ul>"
                    + "    </div>"
                    + "    <div style='text-align: end;'>"
                    + "        <p>Copyright 2022 ©</p>"
                    + "    </div>"
                    + "</div>"
                    + "</footer>";
            body.setContent(htmlcode + contrasenha, "text/html; charset=utf-8");
            Multipart multiPart = new MimeMultipart();
            //cargamos el cuerpo del mensaje
            multiPart.addBodyPart(body);
            mimeMessage.setContent(multiPart);
            //enviamos el correo
            Transport.send(mimeMessage, prop.getProperty("mail.smtp.user"), prop.getProperty("mail.smtp.password"));
        }
    }

}
