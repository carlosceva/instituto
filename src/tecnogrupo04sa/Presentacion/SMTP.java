/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Presentacion;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author CEVA
 */
public class SMTP {
    
    public Properties props;
    public Authenticator auth;
    public Session session;
    
    public MimeMessage msg;
    
    private class autentificadorSMTP extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(Help.miCorreo, Help.miContraseña);
        }
    }

    public SMTP(String mailReceptor, String asunto, String cuerpo) {
        try {
            props = new Properties();
            props.put("mail.smtp.user", Help.miCorreo);
            props.put("mail.smtp.password", Help.miContraseña);
            props.put("mail.smtp.host", Help.servidorSMTP);
            props.put("mail.smtp.port", Help.puertoEnvio);
            auth = new autentificadorSMTP();
            session = Session.getInstance(props, auth);
            msg = new MimeMessage(session);
            
            /*String htmlContent = "<html><body><table border='1'>" +
                    "<tr><th>Columna 1</th><th>Columna 2</th></tr>" +
                    "<tr><td>Dato 1</td><td>Dato 2</td></tr>" +
                    "<tr><td>Dato 3</td><td>Dato 4</td></tr>" +
                    "</table></body></html>";

            msg.setContent(htmlContent, "text/html");*/
            
            msg.setText(cuerpo);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(Help.miCorreo + Help.dominio));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailReceptor));
            Transport.send(msg);
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
    
    
}
