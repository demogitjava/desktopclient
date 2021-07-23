/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.emails;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import de.jsoft.jdesktop.emails.MailClient;
import java.util.HashMap;
import java.util.Set;
import javax.swing.tree.MutableTreeNode;
import javax.mail.Message;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

import javax.swing.DefaultListModel;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import jiconfont.icons.FontAwesome;
import org.jsoup.Jsoup;

import org.w3c.dom.html.HTMLLabelElement;



/**
 *
 * @author hoscho
 */
public class EmailClient extends javax.swing.JInternalFrame 
{

   
    
    de.jsoft.jdesktop.emails.MailClient  mclient = null;
    protected DefaultMutableTreeNode rootNode;
  
    protected DefaultListModel model;
    
    protected Message message;
    
   
    
    /*
        return value from JTree as Object
    */
    protected Object nodeInfo;
    
    /**
     * Creates new form EmailClient
     */
    public EmailClient() 
    {
   
    
        loadIcons();
        initComponents();
       
        mclient = new MailClient();
        
        mclient.connectToStore();
        mclient.listFolders();
        
          
        /*
        *
        *            JLIST
        *
        */ 
        model = new DefaultListModel();
        jList1 = new JList(model);
        
        /*
        
            JTree
        
        */
        createRootNode(); 
        addStringtoDefaultModel();
        jTree2 = new JTree(rootNode);
        
        
        
       
        /*
        
            Click Event Mouse Listener
            gibt den Eintrag aus JTree zurück (Object)
        */
        jTree2.addTreeSelectionListener(new TreeSelectionListener() 
        {
            public void valueChanged(TreeSelectionEvent e) 
            {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           jTree2.getLastSelectedPathComponent();

                /* if nothing is selected */ 
                if (node == null) return;

                nodeInfo = node.getUserObject(); 
            
                /*
                    liefert HashMap mit Emails für diesen Ordner zurück
                    HashMap --> messagemap  
                */
                mclient.listMessages(nodeInfo);
                
                // messagemap -> HashMap mit Email nach JTree Event z.B. INBOX
                // Java List Model --> model
                int messagesize = mclient.messagemap.size();
               
                model.removeAllElements();
    
                
                Iterator<Entry<Integer, Object>> entries = mclient.messagemap.entrySet().iterator();
                     while (entries.hasNext()) 
                    {
                        Entry<Integer, Object> entry = entries.next();
                       
                        entry.getKey();
                        entry.getValue();
                        
                        Message message = (Message) entry.getValue();
                        try
                        {
                            
                                Integer msnumer = message.getMessageNumber();
                                message.getSubject();      

                                
                                Address[] froms = message.getFrom();
                                String email = froms == null ? null : ((InternetAddress) froms[0]).getAddress().trim();
                              
                                //String value = message.getFrom().toString();
                             
                                String stsubject = message.getSubject().trim();
                                //String mbody = message.getContent().toString();
                                
                               
                                model.addElement(msnumer + "," + "   " + email + "," + "    " + stsubject);
                                
                               
                                
                        } catch(Exception ex)
                        {
                            System.out.print("Fehler" + ex);
                        }
                       
                }
 
            }
        });
       
        
        /*
        
        
            JList1 Listener
            
            message context to JEditorPane
        
        */
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) 
                {             
                   // get MessageBody from Number over 
                   // DefaultList Model   --> model
                   System.out.print("Click Count Test"); 
                   String selectedItem = (String) jList1.getSelectedValue();
                   
                   
                   // Get Message Number from JList
                   // messagemap  ->  get Context String to JEditorPane
                   // display messagecontext
                   String first_word = selectedItem.split(",")[0]; 
                   System.out.print("Das ist die Nummber" + first_word + "\n");
                   
                   Integer messagenumber = Integer.parseInt(first_word) -1;
  
                   Message message = (Message) mclient.messagemap.get(messagenumber);
                   
                    try {
                       
                       
                        jEditorPane2.setText(message.getSubject() + "\n" + "\n" + getTextFromMessage(message));
                        jScrollPane4.getHorizontalScrollBar();
                        jScrollPane4.getVerticalScrollBar();
                    } catch (MessagingException ex) {
                        Logger.getLogger(EmailClient.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(EmailClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                }               
            }
            
        };
        jList1.addMouseListener(mouseListener);
        
        
        
        /*
            repaint JTree and JList
        */
        jScrollPane3.setViewportView(jTree2); 
        jScrollPane1.setViewportView(jList1);
        
        jScrollPane4.setViewportView(jEditorPane2);
        
       
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        rootNode = new DefaultMutableTreeNode("Mail_INBOX");
        jTree2 = new javax.swing.JTree(rootNode);
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jEditorPane2 = new javax.swing.JEditorPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EmailClient - Viewer");
        setDoubleBuffered(true);

        jToolBar1.setRollover(true);

        jButton1.setText("Neue Email");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setText("Email Löschen");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jScrollPane3.setViewportView(jTree2);

        getContentPane().add(jScrollPane3, java.awt.BorderLayout.LINE_START);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setTopComponent(jScrollPane1);

        jScrollPane4.setViewportView(jEditorPane2);

        jSplitPane1.setRightComponent(jScrollPane4);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    
        schreibt den String in den JTree  --->    // INBOX -> Folder --> subfolder
    */
    public void addStringtoDefaultModel()
    {
        for(int i = 0; i < mclient.hash_map.size(); i++)
        {
           String folderstring = mclient.hash_map.get(i);
           //root.add(new DefaultMutableTreeNode(folderstring));
           
            DefaultMutableTreeNode idNode = new DefaultMutableTreeNode(folderstring);
            rootNode.add(idNode);
          
        }     
    }

    public DefaultListModel getModel() {
        return model;
    }

    public void setModel(DefaultListModel model) {
        this.model = model;
    }
    
    
    
    /*
        erstellt Default Ordner für JTree 2
    */
    protected DefaultMutableTreeNode createRootNode()
    {
        rootNode = new DefaultMutableTreeNode("EMail_INBOX");
        return rootNode;
    }
    
    
    public void loadIcons()
    {
        
     
    }
   
    
    private String getTextFromMessage(Message message) throws Exception {
    if (message.isMimeType("text/plain")){
        return message.getContent().toString();
    }else if (message.isMimeType("multipart/*")) {
        String result = "";
        MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i ++){
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")){
                result = result + "\n" + bodyPart.getContent();
                break;  //without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")){
                String html = (String) bodyPart.getContent();
                result = result + "\n" + Jsoup.parse(html).text();

            }
        }
        return result;
    }
    return "";
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane2;
    protected javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public final javax.swing.JScrollPane jScrollPane4 = new javax.swing.JScrollPane();
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    protected javax.swing.JTree jTree2;
    // End of variables declaration//GEN-END:variables
}
