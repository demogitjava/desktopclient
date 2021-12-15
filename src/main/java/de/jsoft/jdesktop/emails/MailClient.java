/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.emails;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.MimeMultipart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import java.util.Properties;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author hoscho
 */
public class MailClient implements iMailClient
{
    
    
    @Autowired
    private JavaMailSender emailSender;
    
    Store store;
    Session session;
    String stfolder;
    HashMap<Integer, String> hash_map;
    HashMap<Integer, String> hash_messages;
    
    
    HashMap <Integer, Object> messagemap;
   
    Message[] messages;
    
    protected Message message;
    
    MimeMultipart mimeMultipart;
    EmailClient eclient = null;
    
    Properties props;
    
    String username;
    String password;
    String host;
    
    JavaMailSenderImpl mailSender;
    
    public MailClient()
    {
      username = "jgsoftwares@gmx.net";
      password = "mvpr52k1";
      host = "imap.gmx.net";
      props = new Properties();
    }
   
    public Store connectToStore()
    {
        try {
            props = System.getProperties();
            
            // Mail-Server properties: Session verlangt die Informationen über Host, User, Passwd etc.
            props.setProperty("mail.imaps.host", host);
            props.setProperty("mail.imaps.user", username);
            props.setProperty("mail.imaps.password", password);
            props.setProperty("mail.imaps.auth", "true");
            props.setProperty("mail.imaps.starttls.enable", "true");
            props.setProperty("mail.imaps.socketFactory.port", "993");
            props.setProperty("mail.imaps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.imaps.socketFactory.fallback", "false");
            
         
            
            session = Session.getDefaultInstance(props, null);
            store = session.getStore("imaps");
            try {
                store.connect("imap.gmx.net", "jgsoftwares@gmx.net", "mvpr52k1");
            } catch (MessagingException ex) {
                Logger.getLogger(MailClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(MailClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return store;
    }
    
    
    /*
    
    
        Speichert die Einträge in der JTree -> (String) stfolder
    
    */
    
    public HashMap listFolders()
    { 
        hash_map = new HashMap<Integer, String>();
        try {
            Folder folder = store.getDefaultFolder();
            Folder[] folders = folder.list();
            System.out.println("Select a folder");
            for (int i = 0; i < folders.length; i++) 
            {
                System.out.println("\t" + (String) folders[i].getName());
                stfolder = (String) folders[i].getName();
                hash_map.put(i, stfolder);
            
            }  
        } catch (MessagingException ex) {
            Logger.getLogger(MailClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hash_map;
    }
    
    /**
     *
     *  HashMap mit Emails
     *  
     *  Object nodeInfo -> return String from Folder
     * 
     *  
     */
    public HashMap listMessages(Object nodeInfo)
    {
        
     
        messagemap = new HashMap();
        
        
        try {
            Folder emailFolder = store.getFolder("" + nodeInfo);
            emailFolder.open(Folder.READ_WRITE);
            /*
                return Folder from IMAP Server
            */
            messages = emailFolder.getMessages();
            /*
            
                resive Messages from Server
                
            */
            for(int i = 0; i < messages.length; i++)
            {
               // String result = null;
               message = messages[i];
              
               message.getSubject();
               message.getFrom();
               message.getContentType();
               message.getFlags();
               message.getMessageNumber();
               message.getReceivedDate();
               message.getReplyTo();
              
			
               messagemap.put(i, message);
              
            }
            
            
        } catch (MessagingException ex) {
            Logger.getLogger(MailClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messagemap; 
    }
    
   
    
    public void searchMessage()
    {
        
    }

    public void sendEmail()
    {
        
        connectToStore();
        try
        {
               Folder emailFolder = store.getFolder("OUTBOX");
               emailFolder.open(Folder.READ_WRITE);
               
               
               messages = emailFolder.getMessages();
               
               
              
                message = new MimeMessage(session);
                message.setFrom( new InternetAddress( "jgsoftwares@gmx.net" ) );
                message.addRecipient( Message.RecipientType.TO, new InternetAddress( "jgeist@gmx.net" ) );
                message.setSubject("dsafd");
                message.setText("dsfsd");
                
                
                String foldername = emailFolder.getName();
             
                emailFolder.appendMessages(new Message[]{message});
               
        } catch(Exception e)
        {
            System.out.print("Fehler " +e);
        }
    }
}