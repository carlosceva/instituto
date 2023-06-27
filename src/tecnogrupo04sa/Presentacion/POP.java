/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecnogrupo04sa.Presentacion;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
/**
 *
 * @author CEVA
 */
public class POP {
    public Properties property;
    public Session session;
    public Store store;
    public Folder inbox;
    public Message[] messages;

    public POP(String miCorreo, String miContraseña, String servidorSMTP) {
        try {
            this.property = new Properties();
            property.setProperty("mail.pop3.host", servidorSMTP);
            property.setProperty("mail.pop3.user", miCorreo);
            property.setProperty("mail.pop3.port", "110");
            property.setProperty("mail.pop3.password", miContraseña);

            this.session = Session.getDefaultInstance(property);
            store = this.session.getStore("pop3");
            store.connect(servidorSMTP, miCorreo, miContraseña);
            this.inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);
            this.messages = inbox.getMessages();
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
    
}
