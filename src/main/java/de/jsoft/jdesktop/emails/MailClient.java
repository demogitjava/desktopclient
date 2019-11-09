/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.emails;

import com.sun.mail.imap.IMAPFolder;
import javax.mail.*;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

import javax.mail.internet.MimeMultipart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author hoscho
 */
public class MailClient 
{
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
    
    
    public MailClient()
    {
      
    }
   
    public Object connectToStore()
    {
        try {
            Properties props = System.getProperties();
            
            // Mail-Server properties: Session verlangt die Informationen über Host, User, Passwd etc.
            props.setProperty("mail.imaps.host", "imap.gmx.net");
            props.setProperty("mail.imaps.user", "jgsoftwares@gmx.net");
            props.setProperty("mail.imaps.password", "mvpr52k1");
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

  
   
    
    
    
    
}

	