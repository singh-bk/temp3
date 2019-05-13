package com.gmail.www;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class GMailReader extends javax.mail.Authenticator{

	private String mailhost = "imap.gmail.com";
    private Session session;
    private Store store;

    public GMailReader(String user, String password) {

        Properties props = System.getProperties();
        if (props == null){
         System.out.println("Properties are null !!");
        }else{
        props.setProperty("mail.store.protocol", "imaps");            

        System.out.println("Transport: "+props.getProperty("mail.transport.protocol"));
        System.out.println("Store: "+props.getProperty("mail.store.protocol"));
        System.out.println("Host: "+props.getProperty("mail.imap.host"));
        System.out.println("Authentication: "+props.getProperty("mail.imap.auth"));
        System.out.println(props.getProperty("mail.imap.port"));
        }
    try {
        session = Session.getDefaultInstance(props, null);
        store = session.getStore("imaps");
        store.connect(mailhost, user, password);
        System.out.println("Store: "+store.toString());
    } catch (NoSuchProviderException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (MessagingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    
    public synchronized Message[] readMail() throws Exception { 
        try { 
            Folder folder = store.getFolder("Inbox"); 
            folder.open(Folder.READ_ONLY);

            /* TODO to rework
            Message[] msgs = folder.getMessages(1, 10);
            FetchProfile fp = new FetchProfile(); 
            fp.add(FetchProfile.Item.ENVELOPE); 
            folder.fetch(msgs, fp);
            */
            Message[] msgs = folder.getMessages();
            return msgs; 
        } catch (Exception ex) { 
            System.out.println("readMail"+ex.getMessage()); 
            return null; 
        } 
    } 
}
