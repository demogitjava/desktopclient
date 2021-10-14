/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.kundenstamm;
import com.google.gson.Gson;
import static de.jsoft.jdesktop.config.LoginProvider.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.peer.LightweightPeer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
//import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import de.jsoft.JDesktop;
import de.jsoft.jdesktop.login.LoginFrame;
import static de.jsoft.jdesktop.login.NewJInternalFrame.headers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.apache.http.impl.client.CloseableHttpClient;
import javax.swing.*;
import org.apache.http.HttpStatus;
import org.springframework.http.HttpHeaders;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import org.krysalis.barcode4j.BarcodeException;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import org.apache.http.impl.client.CloseableHttpClient;
import static org.springframework.shell.table.CellMatchers.row;



//Auskunft Kreditreform url
// https://online.creditreform.de/ssoapplicationweb/jsp/anmeldung/anmeldungNormal.jsf

/**
 *
 * @author hoscho
 */

public class Kundenstramm extends javax.swing.JInternalFrame {


    
    public static List<ClientHttpRequestInterceptor> interceptors;

    public static List<MKundenstamm> searchresult;

    public static List<Artikelstamm> selecteditems;
    
    public static int kdrowcount;
    
    public ActionEvent aevent;
    
    private ResponseEntity<MKundenstamm> newcustomer;
   
    /**
     * Creates new form Kundenstramm
     */
    public Kundenstramm()
    {
        initComponents();
        
        clearTextFieldsblank(); // jTabbedPane1 Kundenstamm 
        loadTextEntitystoPanel();
        
        // load custom items 
        // to jTabbedPane1
        // tab create offers - // Angebote erstellen
        loadcustomselectedItems();
    }
    
    
    private void loadcustomselectedItems()
    {
       HttpEntity<String> requestEntity = new HttpEntity<String>(de.jsoft.jdesktop.login.NewJInternalFrame.header);
        
        ResponseEntity<List<Artikelstamm>> selectedcustomitems = JDesktop.rtemp.exchange(
                de.jsoft.JDesktop.baseUrl + "artikelstamm/getselectedArtikel",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Artikelstamm>>(){});
        
        
        de.jsoft.jdesktop.kundenstamm.DaoKundenstamm dkundstamm = new de.jsoft.jdesktop.kundenstamm.DaoKundenstamm();
        
        dkundstamm.addDatatoTable(selectedcustomitems.getBody(), jTable1);
       
    }
    
    private void loadTextEntitystoPanel() 
    {
        try {
            Desktoplayout dlayout = new Desktoplayout();
            
            HttpResponse response1 = client.execute(
                    new HttpGet(de.jsoft.JDesktop.baseUrl + "detaillabeldesktopentry/getloginlabel/customerpanel"));
          
            String json = EntityUtils.toString(response1.getEntity()); 
            Gson gson = new Gson(); 
            
            Type desktoplabelentity = new TypeToken<ArrayList<Desktoplayout>>(){}.getType();  
            List<Desktoplayout> customerlistlabels = gson.fromJson(json, desktoplabelentity);
           
            // String frametitle = (String) customerlistlabels.get(0).getDe();
            // 0 = de
            // 1 = fr
            // 2 = uk
            // 3 = esp
            // 4 = it
            // 5 = tr
            //int selectedlanguage = de.jsoft.jdesktop.login.NewJInternalFrame.selectedlanguage;
             Integer selectedlanguage = (int) de.jsoft.JDesktop.lgglobal;
        
        switch(selectedlanguage)
        {
            // german
            case 0:
            {
                setTextGermanEntity(customerlistlabels);
                break;
            }
            // frensh
            case 1:
            {
                setTextFrenshEntity(customerlistlabels);
                break;
                
            }
            
            // english
            case 2:
            {
                setTextEnglishEntity(customerlistlabels);
                break;
            }
            
            // spanish
            case 3:
            {
                setTextSpanishEntity(customerlistlabels);
                break;
            }
            
            // italy
            case 4:
            {
                setTextItalyEntity(customerlistlabels);
                break;
            }
            // türky
            case 5:
            {
                setTextTuerkyEntity(customerlistlabels);
                break;
            }
            default:
                break;
        }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Kundenstramm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField24 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable3);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Kundenpanel  -- Verkauf");

        jToolBar1.setRollover(true);

        jButton1.setText("Email");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.setToolTipText("");

        jPanel1.setPreferredSize(new java.awt.Dimension(745, 515));

        jLabel1.setText("Anschrift");

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jLabel3.setText("Strasse");

        jTextField5.setText("jTextField5");

        jLabel4.setText("PLZ Ort");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jLabel9.setText("Kundenummer");

        jTextField13.setText("jTextField13");
        jTextField13.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField13InputMethodTextChanged(evt);
            }
        });
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jLabel10.setText("Land");

        jTextField14.setText("jTextField14");

        jLabel11.setText("Bankverbindung");

        jTextField15.setText("jTextField15");

        jLabel12.setText("IBAN");

        jLabel13.setText("BLZ");

        jLabel14.setText("Konto-Nr");

        jButton3.setText("Liefer Addresse oder Notizen anlegen");

        jTextField8.setText("jTextField8");

        jTextField9.setText("jTextField9");

        jTextField10.setText("jTextField10");

        jLabel2.setText("Telefon");

        jTextField11.setText("jTextField11");

        jLabel5.setText("Mobil1");

        jTextField12.setText("jTextField12");

        jLabel6.setText("Mobil2");

        jTextField16.setText("jTextField16");

        jLabel7.setText("Sip ");

        jTextField17.setText("jTextField17");

        jLabel8.setText("EMail");

        jTextField18.setText("jTextField18");

        jLabel15.setText("Umsatz ");

        jTextField19.setText("jTextField19");

        jTextField20.setText("jTextField20");

        jTextField21.setText("jTextField21");

        jLabel16.setText("Ansprechpartner");

        jTextField22.setText("jTextField22");

        jButton2.setText("Kreditauskunft abrufen");

        jLabel17.setText("Kreditlimit ");

        jTextField23.setText("jTextField23");

        jButton8.setText("Neu");
        jButton8.setPreferredSize(new java.awt.Dimension(50, 27));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Speichern");
        jButton9.setPreferredSize(new java.awt.Dimension(70, 27));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Löschen");
        jButton10.setPreferredSize(new java.awt.Dimension(70, 27));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Ändern");
        jButton11.setPreferredSize(new java.awt.Dimension(80, 27));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel18.setText("QR Code");

        jButton12.setText("suchen");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jButton12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton12KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton12KeyTyped(evt);
            }
        });

        jButton13.setText("Kunden anzeigen");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel19.setText("Vertreter");

        jTextField25.setText("jTextField25");

        jLabel20.setText("Gebiet");

        jLabel21.setText("jLabel21");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField22)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jTextField17)
                            .addComponent(jTextField16)
                            .addComponent(jTextField12)
                            .addComponent(jTextField11)
                            .addComponent(jTextField19)
                            .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField20)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton3)
                    .addComponent(jButton12)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel19)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kundenstamm", jPanel1);

        jTextField24.setText("jTextField24");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton4.setText("speichern");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jButton5.setText("per mail versenden");

        jButton6.setText("Artikel suchen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("bearbeiten");

        jButton14.setText(">>");
        jButton14.setToolTipText("add to Chart");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("<<");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Angebote erstellen", jPanel2);
        jTabbedPane1.addTab("Lieferscheine & Aufträge", jTabbedPane2);
        jTabbedPane1.addTab("Rechnungen & Mahnwesen", jTabbedPane3);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        de.jsoft.jdesktop.emails.EmailClient emailclient = new de.jsoft.jdesktop.emails.EmailClient();
        emailclient.setVisible(true);
        emailclient.setMaximizable(true);
        emailclient.pack();
        emailclient.moveToFront();
        de.jsoft.JDesktop.jdeskpane.add(emailclient);
        
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
           
     
        // de.jsoft.JDesktop.baseUrl + "/customer/getCustomerbyName/" + jTextField13.getText()
     
        HttpEntity<String> requestEntity = new HttpEntity<String>(de.jsoft.jdesktop.login.NewJInternalFrame.header);
        
        ResponseEntity<List<MKundenstamm>> customerentity = JDesktop.rtemp.exchange(
                de.jsoft.JDesktop.baseUrl + "customer/getCustomerbyName/" + jTextField13.getText(),
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<MKundenstamm>>(){});
    
         
         /*
            
                response from search Field 
                jTextField13 to JTable
         
         */
        
         if(customerentity.getBody().size() == 0)
         {
             System.out.print("0 customer avilable!" + "\n");
             // add Data to Customer Panel
         }
         else
         {
             // more then one customer is there
             // load data to JTable
             
            de.jsoft.jdesktop.kundenstamm.customersearch.JIFrameCustomerSearch customersearchtable = new de.jsoft.jdesktop.kundenstamm.customersearch.JIFrameCustomerSearch();
            customersearchtable.setVisible(true);
            customersearchtable.setMaximizable(true);
            customersearchtable.pack();
            
            searchresult = (List<MKundenstamm>) customerentity.getBody();
            customersearchtable.addDatatoTable(searchresult);

            JDesktop.jdeskpane.add(customersearchtable);
            JDesktop.jdeskpane.setSelectedFrame(customersearchtable);
            
         }
        

    }//GEN-LAST:event_jButton12ActionPerformed

  
    public void updateJTextFields(ActionEvent aevent)
    {
       
        jButton13ActionPerformed(aevent);
    }
    
    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jTextField13ActionPerformed

    public void jTextField13InputMethodTextChanged(java.awt.event.InputMethodEvent ev) {//GEN-FIRST:event_jTextField13InputMethodTextChanged

        

    }//GEN-LAST:event_jTextField13InputMethodTextChanged

    private void jButton12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton12KeyReleased
        // TODO add your handling code here:
        jTextField13.setText(String.valueOf(searchresult.get(kdrowcount).getKundennummer()));
    }//GEN-LAST:event_jButton12KeyReleased

    private void jButton12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton12KeyPressed
        // TODO add your handling code here:
        jTextField13.setText(String.valueOf(searchresult.get(kdrowcount).getKundennummer()));
    }//GEN-LAST:event_jButton12KeyPressed

    private void jButton12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton12KeyTyped
        // TODO add your handling code here:
        jTextField13.setText(String.valueOf(searchresult.get(kdrowcount).getKundennummer()));
    }//GEN-LAST:event_jButton12KeyTyped

    private void jButton13ActionPerformed(java.awt.event.ActionEvent aevent) {//GEN-FIRST:event_jButton13ActionPerformed
     
        // kundennummer
        jTextField13.setText(String.valueOf(searchresult.get(kdrowcount).getKundennummer()));
        
        
        // land
        jTextField14.setText(searchresult.get(kdrowcount).getLand());
        
        
        // verteter
        jTextField25.setText(String.valueOf(searchresult.get(kdrowcount).getVertreter()));
        
        
        // gebiet
        jTextField1.setText(String.valueOf(searchresult.get(kdrowcount).getGebiet()));
        
        // kundenname
        jTextField4.setText(searchresult.get(kdrowcount).getKundenname());
        
        // strasse
        jTextField5.setText(searchresult.get(kdrowcount).getStrasse());
         
        // plz
        jTextField6.setText(String.valueOf(searchresult.get(kdrowcount).getPlz()));
       
         // Ort
         jTextField7.setText(searchresult.get(kdrowcount).getOrt());
            
         // bankverbindung  
         jTextField15.setText(searchresult.get(kdrowcount).getBankverbindung());
         
         // iban
         jTextField18.setText(searchresult.get(kdrowcount).getIban());
         
          // blz
          jTextField19.setText(searchresult.get(kdrowcount).getBlz());
          
          // konto - nummer 
          jTextField10.setText(searchresult.get(kdrowcount).getKonto_Nr());
         
          // kreditlimit
          jTextField23.setText(String.valueOf(searchresult.get(kdrowcount).getKreditlimit()));
          
          // telefon
          jTextField11.setText(searchresult.get(kdrowcount).getTelefon());
          
           // mobil 1
           jTextField12.setText(searchresult.get(kdrowcount).getMobil1());
          
           // mobil 2
           jTextField16.setText(searchresult.get(kdrowcount).getMobil2());
          
           // sip
           jTextField17.setText(searchresult.get(kdrowcount).getSip());
           
           // email 
           jTextField18.setText(searchresult.get(kdrowcount).getEmail());
           
           // ansprechpartner
           jTextField22.setText(searchresult.get(kdrowcount).getAnsprechpartner());
            
           // umsatz
           jTextField19.setText(String.valueOf(searchresult.get(kdrowcount).getUmsatz_Lfd_Jahr()));
           jTextField20.setText(String.valueOf(searchresult.get(kdrowcount).getUmsatz_Jahr_1()));
           jTextField21.setText(String.valueOf(searchresult.get(kdrowcount).getUmsatz_Jahr_2()));  
          
           jLabel21.setText(String.valueOf(searchresult.get(kdrowcount).getId()));

           String barcodeText = String.valueOf(searchresult.get(kdrowcount).getKundennummer());
           generateEAN13BarcodeImage(barcodeText + "0000");

            ImageIcon imgThisImg = new ImageIcon(generateEAN13BarcodeImage(barcodeText + "0000"));

            jLabel18.setIcon(imgThisImg);

          
    }//GEN-LAST:event_jButton13ActionPerformed

    /*
        save data
    */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        MKundenstamm mkdstamm = new MKundenstamm();
         
        mkdstamm.setKundennummer(Long.parseLong(jTextField13.getText()));
        mkdstamm.setVertreter(Integer.parseInt(jTextField25.getText()));  
        mkdstamm.setLand(jTextField14.getText());
        mkdstamm.setGebiet(Integer.parseInt(jTextField1.getText()));
        
        mkdstamm.setName_Anschrift1(jTextField2.getText());
        mkdstamm.setName_Anschrift2(jTextField3.getText());
        
        mkdstamm.setKundenname(jTextField4.getText());
        //mkdstamm.setAnsprechpartner(jTextField4.getText());
        mkdstamm.setStrasse(jTextField5.getText());
        mkdstamm.setPlz(Integer.parseInt(jTextField6.getText()));
        mkdstamm.setOrt(jTextField7.getText());
        mkdstamm.setBankverbindung(jTextField15.getText());
        mkdstamm.setIban(jTextField8.getText());
        mkdstamm.setBlz(jTextField9.getText());
        mkdstamm.setKonto_Nr(jTextField10.getText());
        mkdstamm.setKreditlimit(Double.parseDouble(jTextField23.getText()));
        mkdstamm.setTelefon(jTextField11.getText());
        mkdstamm.setMobil1(jTextField12.getText());
        mkdstamm.setMobil2(jTextField16.getText());
        mkdstamm.setSip(jTextField17.getText());
        mkdstamm.setEmail(jTextField18.getText());
        mkdstamm.setAnsprechpartner(jTextField22.getText());
        
       
     
       HttpEntity entity = new HttpEntity(mkdstamm,de.jsoft.jdesktop.login.NewJInternalFrame.header);    
       ResponseEntity<String> out = JDesktop.rtemp.exchange(JDesktop.baseUrl + "customer/savenewcustomer", HttpMethod.POST, entity, String.class);
      
       System.out.print("body " + entity.getBody() + "\n");
                
        
    }//GEN-LAST:event_jButton9ActionPerformed

    // new customer
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        clearTextFieldsblank();


        MKundenstamm mdkstamm = new MKundenstamm();
        HttpEntity entity = new HttpEntity(mdkstamm,de.jsoft.jdesktop.login.NewJInternalFrame.header);


        //   ResponseEntity<String> newcustomerlist = JDesktop.rtemp.exchange(JDesktop.baseUrl + "customer/newCustomer", HttpMethod.GET, entity, String.class);
        //   newcustomerlist.getBody();

        ResponseEntity<List<MKundenstamm>> newcustomer = JDesktop.rtemp.exchange(
                JDesktop.baseUrl + "customer/newCustomer",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<MKundenstamm>>(){});

        newcustomer.getBody();

        Long newid = (Long) newcustomer.getBody().get(0).getId();
        Long newcustomernumber = (Long) newcustomer.getBody().get(0).getKundennummer();

        jLabel21.setText(String.valueOf(newid));
        jTextField13.setText(String.valueOf(newcustomernumber));

        // .setBackground(Color.LIGHT_GRAY);

        jTextField25.setBackground(Color.LIGHT_GRAY);
        jTextField14.setBackground(Color.LIGHT_GRAY);
        jTextField1.setBackground(Color.LIGHT_GRAY);

        jTextField2.setBackground(Color.LIGHT_GRAY);
        jTextField3.setBackground(Color.LIGHT_GRAY);

        jTextField4.setBackground(Color.LIGHT_GRAY);
        jTextField5.setBackground(Color.LIGHT_GRAY);
        jTextField6.setBackground(Color.LIGHT_GRAY);

        jTextField7.setBackground(Color.LIGHT_GRAY);
        jTextField15.setBackground(Color.LIGHT_GRAY);
        jTextField8.setBackground(Color.LIGHT_GRAY);
        jTextField9.setBackground(Color.LIGHT_GRAY);

        jTextField10.setBackground(Color.LIGHT_GRAY);
        jTextField23.setBackground(Color.LIGHT_GRAY);
        jTextField11.setBackground(Color.LIGHT_GRAY);
        jTextField12.setBackground(Color.LIGHT_GRAY);
        jTextField16.setBackground(Color.LIGHT_GRAY);
        jTextField17.setBackground(Color.LIGHT_GRAY);

        jTextField18.setBackground(Color.LIGHT_GRAY);
        jTextField22.setBackground(Color.LIGHT_GRAY);


        // /getCustomerbyName/newcustomer
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        MKundenstamm mkdstamm = new MKundenstamm();
        
        mkdstamm.setKundennummer(Long.parseLong(jTextField13.getText()));
        mkdstamm.setVertreter(Integer.parseInt(jTextField25.getText()));  
        mkdstamm.setLand(jTextField14.getText());
        mkdstamm.setGebiet(Integer.parseInt(jTextField1.getText()));
        
        mkdstamm.setName_Anschrift1(jTextField2.getText());
        mkdstamm.setName_Anschrift2(jTextField3.getText());
        
        mkdstamm.setKundenname(jTextField4.getText());
        //mkdstamm.setAnsprechpartner(jTextField4.getText());
        mkdstamm.setStrasse(jTextField5.getText());
        mkdstamm.setPlz(Integer.parseInt(jTextField6.getText()));
        mkdstamm.setOrt(jTextField7.getText());
        mkdstamm.setBankverbindung(jTextField15.getText());
        mkdstamm.setIban(jTextField8.getText());
        mkdstamm.setBlz(jTextField9.getText());
        mkdstamm.setKonto_Nr(jTextField10.getText());
        mkdstamm.setKreditlimit(Double.parseDouble(jTextField23.getText()));
        mkdstamm.setTelefon(jTextField11.getText());
        mkdstamm.setMobil1(jTextField12.getText());
        mkdstamm.setMobil2(jTextField16.getText());
        mkdstamm.setSip(jTextField17.getText());
        mkdstamm.setEmail(jTextField18.getText());
        mkdstamm.setAnsprechpartner(jTextField22.getText());
        
        mkdstamm.setId(Long.parseLong(jLabel21.getText()));
     
     
       HttpEntity entity = new HttpEntity(mkdstamm,de.jsoft.jdesktop.login.NewJInternalFrame.header);    
       ResponseEntity<String> out = JDesktop.rtemp.exchange(JDesktop.baseUrl + "customer/updatenewcustomer", HttpMethod.POST, entity, String.class);
      
       System.out.print("body " + entity.getBody() + "\n");
                
    }//GEN-LAST:event_jButton11ActionPerformed

    // delte customer
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        MKundenstamm mkdstamm = new MKundenstamm();
        mkdstamm.setId(Long.parseLong(jLabel21.getText()));
       HttpEntity entity = new HttpEntity(mkdstamm,de.jsoft.jdesktop.login.NewJInternalFrame.header);
       ResponseEntity<String> out = JDesktop.rtemp.exchange(JDesktop.baseUrl + "customer/deletecustomer", HttpMethod.POST, entity, String.class);
      
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        HttpEntity<String> requestEntity = new HttpEntity<String>(de.jsoft.jdesktop.login.NewJInternalFrame.header);
        
        ResponseEntity<List<Artikelstamm>> resposecustomitems = JDesktop.rtemp.exchange(
                de.jsoft.JDesktop.baseUrl + "artikelstamm/getArtikelbyArtikelbezeichnung/" + jTextField24.getText(),
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<Artikelstamm>>(){});
    
           
        List<Artikelstamm> selectedcustomitems = resposecustomitems.getBody();
     
        de.jsoft.jdesktop.kundenstamm.DaoKundenstamm daokdstamm = new de.jsoft.jdesktop.kundenstamm.DaoKundenstamm();
        daokdstamm.addDatatoTable((List<Artikelstamm>) selectedcustomitems, jTable1);
            
       
            
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
       
            jTable1 = (JTable) evt.getSource();
            
            int row = jTable1.getSelectedRow();
            
            
            Artikelstamm artstamm = new Artikelstamm();
            artstamm.setArtikelnummer(Long.parseLong(jTable1.getModel().getValueAt(row, 0).toString()));
            artstamm.setArtikelbezeichnung(jTable1.getModel().getValueAt(row,1).toString());
            artstamm.setVk((double) jTable1.getModel().getValueAt(row,2));
            
            List<Artikelstamm> selectedcustomitems = new ArrayList();
            selectedcustomitems.add(artstamm);
            
            DaoKundenstamm daokdstamm = new DaoKundenstamm();
            daokdstamm.addrowwithdata(selectedcustomitems, jTable2);
        
    }//GEN-LAST:event_jTable1MouseClicked

     
    // add data from jTable1 
    // to JTable2 by button click
    private void jButton14ActionPerformed(java.awt.event.ActionEvent aevent) {//GEN-FIRST:event_jButton14ActionPerformed
     
        // TODO add your handling code here:
       
       
        int row = jTable1.getSelectedRow();
        
         Artikelstamm artstamm = new Artikelstamm();
            artstamm.setArtikelnummer(Long.parseLong(jTable1.getModel().getValueAt(row, 0).toString()));
            artstamm.setArtikelbezeichnung(jTable1.getModel().getValueAt(row,1).toString());
            artstamm.setVk((double) jTable1.getModel().getValueAt(row,2));
            
            List<Artikelstamm> selectedcustomitems = new ArrayList();
            selectedcustomitems.add(artstamm);
            
            DaoKundenstamm daokdstamm = new DaoKundenstamm();
            
            daokdstamm.addrowwithdata(selectedcustomitems, jTable2);
                
        System.out.print("die selected row ist " + row + "\n");
    }//GEN-LAST:event_jButton14ActionPerformed


    private void clearTextFieldsblank()
    {

        // Kundenstamm
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
      
        jTextField25.setText("");
        
        jLabel21.setText("");
        jLabel18.setText("");

        jTextField24.setText("");

    }
    
    private void setTextGermanEntity(List<Desktoplayout> customerlistlabels)
    {
        
        // customerpanel title
        String frametitle = (String) customerlistlabels.get(0).getDe();
        this.setTitle(frametitle);
        
        
        
        /*
        
                Customerpanel
                JTab1 Kundenstamm
        */
        
        // Text JTabbedPane1
        String stcustomertextentity = (String) customerlistlabels.get(1).getDe();
        this.jTabbedPane1.setTitleAt(1, stcustomertextentity);
        
        // id 7  Text jLabel1   
        String stlabel1 = (String) customerlistlabels.get(2).getDe();
        this.jLabel1.setText(stlabel1);
        
        // id 8 Text jLabel3
        String stlabel3 = (String) customerlistlabels.get(3).getDe();
        this.jLabel3.setText(stlabel3);
        
        // id 9 Text jLabel4
        String stlabel4 = (String) customerlistlabels.get(4).getDe();
        this.jLabel4.setText(stlabel4);
        
        // id 10 Text jLabel9
        String stlabel9 = (String) customerlistlabels.get(5).getDe();
        this.jLabel9.setText(stlabel9);
        
        // id 11 Text jLabel10
        String stlabel10 = (String) customerlistlabels.get(6).getDe();
        this.jLabel10.setText(stlabel10);
        
        
        // id 12 Text jLabel11
        String stlabel11 = (String) customerlistlabels.get(7).getDe();
        this.jLabel11.setText(stlabel11);
        
        // id 13 Text jLabel12
        String stlabel12 = (String) customerlistlabels.get(8).getDe();
        this.jLabel12.setText(stlabel12);
        
        // id 14 Text jLabel13
        String stlabel13 = (String) customerlistlabels.get(9).getDe();
        this.jLabel13.setText(stlabel13);
        
        // id 15 Text JLabel14
        String stlabel14 = (String) customerlistlabels.get(10).getDe();
        this.jLabel14.setText(stlabel14);
        
        // id 16 Text jButton3
        String stbutton3 = (String) customerlistlabels.get(11).getDe();
        this.jButton3.setText(stbutton3);
        
        // id 17 Text jLabel2
        String stlabel2 = (String) customerlistlabels.get(12).getDe();
        this.jLabel2.setText(stlabel2);
        
        // id 18 Text jLabel5
        String stlabel5 = (String) customerlistlabels.get(13).getDe();
        this.jLabel5.setText(stlabel5);
        
        // id 19 Text jLabel6
        String stlabel6 = (String) customerlistlabels.get(14).getDe();
        this.jLabel6.setText(stlabel6);
        
        // id 20 Text jLabel7
        String stlabel7 = (String) customerlistlabels.get(15).getDe();
        this.jLabel7.setText(stlabel7);
        
        
        // id 21 Text jLabel8
        String stlabel8 = (String) customerlistlabels.get(16).getDe();
        this.jLabel8.setText(stlabel8);
        
        // id 22 Text jLabel15
        String stlabel15 = (String) customerlistlabels.get(17).getDe();
        this.jLabel15.setText(stlabel15);
        
        
        // id 23 Text jLabel16
        String stlabel16 = (String) customerlistlabels.get(18).getDe();
        this.jLabel16.setText(stlabel16);
        
        // id 24 Text jButton2
        String stbutton2 = (String) customerlistlabels.get(19).getDe();
        this.jButton2.setText(stbutton2);
        
        // id 25 Text jLabel17
        String stlabel17 = (String) customerlistlabels.get(20).getDe();
        this.jLabel17.setText(stlabel17);
        
        // id 26 Text jButton8
        String stbutton8 = (String) customerlistlabels.get(21).getDe();
        this.jButton8.setText(stbutton8);
        
        // id 27 Text jButton9
        String stbutton9 = (String) customerlistlabels.get(22).getDe();
        this.jButton9.setText(stbutton9);
        
        // id 28 Text jButton10
        String stbutton10 = (String) customerlistlabels.get(23).getDe();
        this.jButton10.setText(stbutton10);
        
        // id 29 Text jButton11
        String stbutton11 = (String) customerlistlabels.get(24).getDe();
        this.jButton11.setText(stbutton11);
        
        // id 30 Text jLabel18
        String stlabel18 = (String) customerlistlabels.get(25).getDe();
        this.jLabel18.setText(stlabel18);
        
        // id 36 Text JButton12
        String stbutton12 = (String) customerlistlabels.get(31).getDe();
        this.jButton12.setText(stbutton12);
        
        
        // id 37 Text Verteter
        String stlabel37 = (String) customerlistlabels.get(32).getDe();
        this.jLabel19.setText(stlabel37);
        
        // id 38 Text Gebeit
        String stlabel38 = (String) customerlistlabels.get(33).getDe();
        this.jLabel20.setText(stlabel38);
        
        // id 39 Text Kunden anzeigen
        String stbutton13 = (String) customerlistlabels.get(34).getDe();
        this.jButton13.setText(stbutton13);



        /*

            JTabbedPane1
            Artikel search
       */
        // id 31 Text Angebot erstellen
        String sttabpane = (String) customerlistlabels.get(26).getDe();
        this.jTabbedPane1.setTitleAt(1, sttabpane);



        //  id 34 Text Artikel suchen
        String startsearch = (String) customerlistlabels.get(29).getDe();
        this.jButton6.setText(startsearch);


        // id 35 Text  -- bearbeiten
        String stbearbeiten = (String) customerlistlabels.get(30).getDe();
        this.jButton7.setText(stbearbeiten);

        // id 33 Text  -- per mail versenden
        String stsendperemail = (String) customerlistlabels.get(28).getDe();
        this.jButton5.setText(stsendperemail);

        // id 32 Text -- speichern
        String stspeichern = (String) customerlistlabels.get(27).getDe();
        this.jButton4.setText(stspeichern);

           

    }

    private void setTextSpanishEntity(List<Desktoplayout> customerlistlabels)
    {
        
        // customerpanel title
        String frametitle = (String) customerlistlabels.get(0).getEsp();
        this.setTitle(frametitle);
        
        
        
        /*
        
                Customerpanel
                JTab1 Kundenstamm
        */
        
        // Text JTabbedPane1
        String stcustomertextentity = (String) customerlistlabels.get(1).getEsp();
        this.jTabbedPane1.setTitleAt(0, stcustomertextentity);
        
        // id 7  Text jLabel1   
        String stlabel1 = (String) customerlistlabels.get(2).getEsp();
        this.jLabel1.setText(stlabel1);
        
        // id 8 Text jLabel3
        String stlabel3 = (String) customerlistlabels.get(3).getEsp();
        this.jLabel3.setText(stlabel3);
        
        // id 9 Text jLabel4
        String stlabel4 = (String) customerlistlabels.get(4).getEsp();
        this.jLabel4.setText(stlabel4);
        
        // id 10 Text jLabel9
        String stlabel9 = (String) customerlistlabels.get(5).getEsp();
        this.jLabel9.setText(stlabel9);
        
        // id 11 Text jLabel10
        String stlabel10 = (String) customerlistlabels.get(6).getEsp();
        this.jLabel10.setText(stlabel10);
        
        
        // id 12 Text jLabel11
        String stlabel11 = (String) customerlistlabels.get(7).getEsp();
        this.jLabel11.setText(stlabel11);
        
        // id 13 Text jLabel12
        String stlabel12 = (String) customerlistlabels.get(8).getEsp();
        this.jLabel12.setText(stlabel12);
        
        // id 14 Text jLabel13
        String stlabel13 = (String) customerlistlabels.get(9).getEsp();
        this.jLabel13.setText(stlabel13);
        
        // id 15 Text JLabel14
        String stlabel14 = (String) customerlistlabels.get(10).getEsp();
        this.jLabel14.setText(stlabel14);
        
        // id 16 Text jButton3
        String stbutton3 = (String) customerlistlabels.get(11).getEsp();
        this.jButton3.setText(stbutton3);
        
        // id 17 Text jLabel2
        String stlabel2 = (String) customerlistlabels.get(12).getEsp();
        this.jLabel2.setText(stlabel2);
        
        // id 18 Text jLabel5
        String stlabel5 = (String) customerlistlabels.get(13).getEsp();
        this.jLabel5.setText(stlabel5);
        
        // id 19 Text jLabel6
        String stlabel6 = (String) customerlistlabels.get(14).getEsp();
        this.jLabel6.setText(stlabel6);
        
        // id 20 Text jLabel7
        String stlabel7 = (String) customerlistlabels.get(15).getEsp();
        this.jLabel7.setText(stlabel7);
        
        
        // id 21 Text jLabel8
        String stlabel8 = (String) customerlistlabels.get(16).getEsp();
        this.jLabel8.setText(stlabel8);
        
        // id 22 Text jLabel15
        String stlabel15 = (String) customerlistlabels.get(17).getEsp();
        this.jLabel15.setText(stlabel15);
        
        
        // id 23 Text jLabel16
        String stlabel16 = (String) customerlistlabels.get(18).getEsp();
        this.jLabel16.setText(stlabel16);
        
        // id 24 Text jButton2
        String stbutton2 = (String) customerlistlabels.get(19).getEsp();
        this.jButton2.setText(stbutton2);
        
        // id 25 Text jLabel17
        String stlabel17 = (String) customerlistlabels.get(20).getEsp();
        this.jLabel17.setText(stlabel17);
        
        // id 26 Text jButton8
        String stbutton8 = (String) customerlistlabels.get(21).getEsp();
        this.jButton8.setText(stbutton8);
        
        // id 27 Text jButton9
        String stbutton9 = (String) customerlistlabels.get(22).getEsp();
        this.jButton9.setText(stbutton9);
        
        // id 28 Text jButton10
        String stbutton10 = (String) customerlistlabels.get(23).getEsp();
        this.jButton10.setText(stbutton10);
        
        // id 29 Text jButton11
        String stbutton11 = (String) customerlistlabels.get(24).getEsp();
        this.jButton11.setText(stbutton11);
        
        // id 30 Text jLabel18
        String stlabel18 = (String) customerlistlabels.get(25).getEsp();
        this.jLabel18.setText(stlabel18);
        
        // id 36 Text JButton12
        String stbutton12 = (String) customerlistlabels.get(31).getEsp();
        this.jButton12.setText(stbutton12);
        
        
         // id 37 Text Verteter
        String stlabel37 = (String) customerlistlabels.get(32).getEsp();
        this.jLabel19.setText(stlabel37);
        
        // id 38 Text Gebeit
        String stlabel38 = (String) customerlistlabels.get(33).getEsp();
        this.jLabel20.setText(stlabel38);
        
        // id 39 Text Kunden anzeigen
        String stbutton13 = (String) customerlistlabels.get(34).getEsp();
        this.jButton13.setText(stbutton13);




        /*

            JTabbedPane1
            Artikel search
       */
        // id 31 Text Angebot erstellen
        String sttabpane = (String) customerlistlabels.get(26).getEsp();
        this.jTabbedPane1.setTitleAt(1, sttabpane);



        //  id 34 Text Artikel suchen
        String startsearch = (String) customerlistlabels.get(29).getEsp();
        this.jButton6.setText(startsearch);


        // id 35 Text  -- bearbeiten
        String stbearbeiten = (String) customerlistlabels.get(30).getEsp();
        this.jButton7.setText(stbearbeiten);

        // id 33 Text  -- per mail versenden
        String stsendperemail = (String) customerlistlabels.get(28).getEsp();
        this.jButton5.setText(stsendperemail);

        // id 32 Text -- speichern
        String stspeichern = (String) customerlistlabels.get(27).getEsp();
        this.jButton4.setText(stspeichern);
        


    }
      
    private void setTextFrenshEntity(List<Desktoplayout> customerlistlabels)
    {
        
        // customerpanel title
        String frametitle = (String) customerlistlabels.get(0).getFr();
        this.setTitle(frametitle);
        
        
        
        /*
        
                Customerpanel
                JTab1 Kundenstamm
        */
        
        // Text JTabbedPane1
        String stcustomertextentity = (String) customerlistlabels.get(1).getFr();
        this.jTabbedPane1.setTitleAt(0, stcustomertextentity);
        
        // id 7  Text jLabel1   
        String stlabel1 = (String) customerlistlabels.get(2).getFr();
        this.jLabel1.setText(stlabel1);
        
        // id 8 Text jLabel3
        String stlabel3 = (String) customerlistlabels.get(3).getFr();
        this.jLabel3.setText(stlabel3);
        
        // id 9 Text jLabel4
        String stlabel4 = (String) customerlistlabels.get(4).getFr();
        this.jLabel4.setText(stlabel4);
        
        // id 10 Text jLabel9
        String stlabel9 = (String) customerlistlabels.get(5).getFr();
        this.jLabel9.setText(stlabel9);
        
        // id 11 Text jLabel10
        String stlabel10 = (String) customerlistlabels.get(6).getFr();
        this.jLabel10.setText(stlabel10);
        
        
        // id 12 Text jLabel11
        String stlabel11 = (String) customerlistlabels.get(7).getFr();
        this.jLabel11.setText(stlabel11);
        
        // id 13 Text jLabel12
        String stlabel12 = (String) customerlistlabels.get(8).getFr();
        this.jLabel12.setText(stlabel12);
        
        // id 14 Text jLabel13
        String stlabel13 = (String) customerlistlabels.get(9).getFr();
        this.jLabel13.setText(stlabel13);
        
        // id 15 Text JLabel14
        String stlabel14 = (String) customerlistlabels.get(10).getFr();
        this.jLabel14.setText(stlabel14);
        
        // id 16 Text jButton3
        String stbutton3 = (String) customerlistlabels.get(11).getFr();
        this.jButton3.setText(stbutton3);
        
        // id 17 Text jLabel2
        String stlabel2 = (String) customerlistlabels.get(12).getFr();
        this.jLabel2.setText(stlabel2);
        
        // id 18 Text jLabel5
        String stlabel5 = (String) customerlistlabels.get(13).getFr();
        this.jLabel5.setText(stlabel5);
        
        // id 19 Text jLabel6
        String stlabel6 = (String) customerlistlabels.get(14).getFr();
        this.jLabel6.setText(stlabel6);
        
        // id 20 Text jLabel7
        String stlabel7 = (String) customerlistlabels.get(15).getFr();
        this.jLabel7.setText(stlabel7);
        
        
        // id 21 Text jLabel8
        String stlabel8 = (String) customerlistlabels.get(16).getFr();
        this.jLabel8.setText(stlabel8);
        
        // id 22 Text jLabel15
        String stlabel15 = (String) customerlistlabels.get(17).getFr();
        this.jLabel15.setText(stlabel15);
        
        
        // id 23 Text jLabel16
        String stlabel16 = (String) customerlistlabels.get(18).getFr();
        this.jLabel16.setText(stlabel16);
        
        // id 24 Text jButton2
        String stbutton2 = (String) customerlistlabels.get(19).getFr();
        this.jButton2.setText(stbutton2);
        
        // id 25 Text jLabel17
        String stlabel17 = (String) customerlistlabels.get(20).getFr();
        this.jLabel17.setText(stlabel17);
        
        // id 26 Text jButton8
        String stbutton8 = (String) customerlistlabels.get(21).getFr();
        this.jButton8.setText(stbutton8);
        
        // id 27 Text jButton9
        String stbutton9 = (String) customerlistlabels.get(22).getFr();
        this.jButton9.setText(stbutton9);
        
        // id 28 Text jButton10
        String stbutton10 = (String) customerlistlabels.get(23).getFr();
        this.jButton10.setText(stbutton10);
        
        // id 29 Text jButton11
        String stbutton11 = (String) customerlistlabels.get(24).getFr();
        this.jButton11.setText(stbutton11);
        
        // id 30 Text jLabel18
        String stlabel18 = (String) customerlistlabels.get(25).getFr();
        this.jLabel18.setText(stlabel18);
        
        // id 36 Text JButton12
        String stbutton12 = (String) customerlistlabels.get(31).getFr();
        this.jButton12.setText(stbutton12);
        
          // id 37 Text Verteter
        String stlabel37 = (String) customerlistlabels.get(32).getFr();
        this.jLabel19.setText(stlabel37);
        
        // id 38 Text Gebeit
        String stlabel38 = (String) customerlistlabels.get(33).getFr();
        this.jLabel20.setText(stlabel38);
        
        // id 39 Text Kunden anzeigen
        String stbutton13 = (String) customerlistlabels.get(34).getFr();
        this.jButton13.setText(stbutton13);

        
        
        /*

            JTabbedPane1
            Artikel search
       */
        // id 31 Text Angebot erstellen
        String sttabpane = (String) customerlistlabels.get(26).getFr();
        this.jTabbedPane1.setTitleAt(1, sttabpane);



        //  id 34 Text Artikel suchen
        String startsearch = (String) customerlistlabels.get(29).getFr();
        this.jButton6.setText(startsearch);


        // id 35 Text  -- bearbeiten
        String stbearbeiten = (String) customerlistlabels.get(30).getFr();
        this.jButton7.setText(stbearbeiten);

        // id 33 Text  -- per mail versenden
        String stsendperemail = (String) customerlistlabels.get(28).getFr();
        this.jButton5.setText(stsendperemail);

        // id 32 Text -- speichern
        String stspeichern = (String) customerlistlabels.get(27).getFr();
        this.jButton4.setText(stspeichern);
        


        
        
    }  
        
    private void setTextItalyEntity(List<Desktoplayout> customerlistlabels)
    {
        
        // customerpanel title
        String frametitle = (String) customerlistlabels.get(0).getIt();
        this.setTitle(frametitle);
        
        
        
        /*
        
                Customerpanel
                JTab1 Kundenstamm
        */
        
        // Text JTabbedPane1
        String stcustomertextentity = (String) customerlistlabels.get(1).getIt();
        this.jTabbedPane1.setTitleAt(0, stcustomertextentity);
        
        // id 7  Text jLabel1   
        String stlabel1 = (String) customerlistlabels.get(2).getIt();
        this.jLabel1.setText(stlabel1);
        
        // id 8 Text jLabel3
        String stlabel3 = (String) customerlistlabels.get(3).getIt();
        this.jLabel3.setText(stlabel3);
        
        // id 9 Text jLabel4
        String stlabel4 = (String) customerlistlabels.get(4).getIt();
        this.jLabel4.setText(stlabel4);
        
        // id 10 Text jLabel9
        String stlabel9 = (String) customerlistlabels.get(5).getIt();
        this.jLabel9.setText(stlabel9);
        
        // id 11 Text jLabel10
        String stlabel10 = (String) customerlistlabels.get(6).getIt();
        this.jLabel10.setText(stlabel10);
        
        
        // id 12 Text jLabel11
        String stlabel11 = (String) customerlistlabels.get(7).getIt();
        this.jLabel11.setText(stlabel11);
        
        // id 13 Text jLabel12
        String stlabel12 = (String) customerlistlabels.get(8).getIt();
        this.jLabel12.setText(stlabel12);
        
        // id 14 Text jLabel13
        String stlabel13 = (String) customerlistlabels.get(9).getIt();
        this.jLabel13.setText(stlabel13);
        
        // id 15 Text JLabel14
        String stlabel14 = (String) customerlistlabels.get(10).getIt();
        this.jLabel14.setText(stlabel14);
        
        // id 16 Text jButton3
        String stbutton3 = (String) customerlistlabels.get(11).getIt();
        this.jButton3.setText(stbutton3);
        
        // id 17 Text jLabel2
        String stlabel2 = (String) customerlistlabels.get(12).getIt();
        this.jLabel2.setText(stlabel2);
        
        // id 18 Text jLabel5
        String stlabel5 = (String) customerlistlabels.get(13).getIt();
        this.jLabel5.setText(stlabel5);
        
        // id 19 Text jLabel6
        String stlabel6 = (String) customerlistlabels.get(14).getIt();
        this.jLabel6.setText(stlabel6);
        
        // id 20 Text jLabel7
        String stlabel7 = (String) customerlistlabels.get(15).getIt();
        this.jLabel7.setText(stlabel7);
        
        
        // id 21 Text jLabel8
        String stlabel8 = (String) customerlistlabels.get(16).getIt();
        this.jLabel8.setText(stlabel8);
        
        // id 22 Text jLabel15
        String stlabel15 = (String) customerlistlabels.get(17).getIt();
        this.jLabel15.setText(stlabel15);
        
        
        // id 23 Text jLabel16
        String stlabel16 = (String) customerlistlabels.get(18).getIt();
        this.jLabel16.setText(stlabel16);
        
        // id 24 Text jButton2
        String stbutton2 = (String) customerlistlabels.get(19).getIt();
        this.jButton2.setText(stbutton2);
        
        // id 25 Text jLabel17
        String stlabel17 = (String) customerlistlabels.get(20).getIt();
        this.jLabel17.setText(stlabel17);
        
        // id 26 Text jButton8
        String stbutton8 = (String) customerlistlabels.get(21).getIt();
        this.jButton8.setText(stbutton8);
        
        // id 27 Text jButton9
        String stbutton9 = (String) customerlistlabels.get(22).getIt();
        this.jButton9.setText(stbutton9);
        
        // id 28 Text jButton10
        String stbutton10 = (String) customerlistlabels.get(23).getIt();
        this.jButton10.setText(stbutton10);
        
        // id 29 Text jButton11
        String stbutton11 = (String) customerlistlabels.get(24).getIt();
        this.jButton11.setText(stbutton11);
        
        // id 30 Text jLabel18
        String stlabel18 = (String) customerlistlabels.get(25).getIt();
        this.jLabel18.setText(stlabel18);
        
        // id 36 Text JButton12
        String stbutton12 = (String) customerlistlabels.get(31).getIt();
        this.jButton12.setText(stbutton12);
        
        
              // id 37 Text Verteter
        String stlabel37 = (String) customerlistlabels.get(32).getIt();
        this.jLabel19.setText(stlabel37);
        
        // id 38 Text Gebeit
        String stlabel38 = (String) customerlistlabels.get(33).getIt();
        this.jLabel20.setText(stlabel38);
        
        // id 39 Text Kunden anzeigen
        String stbutton13 = (String) customerlistlabels.get(34).getIt();
        this.jButton13.setText(stbutton13);

        
        /*

            JTabbedPane1
            Artikel search
       */
        // id 31 Text Angebot erstellen
        String sttabpane = (String) customerlistlabels.get(26).getIt();
        this.jTabbedPane1.setTitleAt(1, sttabpane);



        //  id 34 Text Artikel suchen
        String startsearch = (String) customerlistlabels.get(29).getIt();
        this.jButton6.setText(startsearch);


        // id 35 Text  -- bearbeiten
        String stbearbeiten = (String) customerlistlabels.get(30).getIt();
        this.jButton7.setText(stbearbeiten);

        // id 33 Text  -- per mail versenden
        String stsendperemail = (String) customerlistlabels.get(28).getIt();
        this.jButton5.setText(stsendperemail);

        // id 32 Text -- speichern
        String stspeichern = (String) customerlistlabels.get(27).getIt();
        this.jButton4.setText(stspeichern);
        

        
        
    }  
       
    private void setTextTuerkyEntity(List<Desktoplayout> customerlistlabels)
    {
        
        // customerpanel title
        String frametitle = (String) customerlistlabels.get(0).getTr();
        this.setTitle(frametitle);
        
        
        
        /*
        
                Customerpanel
                JTab1 Kundenstamm
        */
        
        // Text JTabbedPane1
        String stcustomertextentity = (String) customerlistlabels.get(1).getTr();
        this.jTabbedPane1.setTitleAt(0, stcustomertextentity);
        
        // id 7  Text jLabel1   
        String stlabel1 = (String) customerlistlabels.get(2).getTr();
        this.jLabel1.setText(stlabel1);
        
        // id 8 Text jLabel3
        String stlabel3 = (String) customerlistlabels.get(3).getTr();
        this.jLabel3.setText(stlabel3);
        
        // id 9 Text jLabel4
        String stlabel4 = (String) customerlistlabels.get(4).getTr();
        this.jLabel4.setText(stlabel4);
        
        // id 10 Text jLabel9
        String stlabel9 = (String) customerlistlabels.get(5).getTr();
        this.jLabel9.setText(stlabel9);
        
        // id 11 Text jLabel10
        String stlabel10 = (String) customerlistlabels.get(6).getTr();
        this.jLabel10.setText(stlabel10);
        
        
        // id 12 Text jLabel11
        String stlabel11 = (String) customerlistlabels.get(7).getTr();
        this.jLabel11.setText(stlabel11);
        
        // id 13 Text jLabel12
        String stlabel12 = (String) customerlistlabels.get(8).getTr();
        this.jLabel12.setText(stlabel12);
        
        // id 14 Text jLabel13
        String stlabel13 = (String) customerlistlabels.get(9).getTr();
        this.jLabel13.setText(stlabel13);
        
        // id 15 Text JLabel14
        String stlabel14 = (String) customerlistlabels.get(10).getTr();
        this.jLabel14.setText(stlabel14);
        
        // id 16 Text jButton3
        String stbutton3 = (String) customerlistlabels.get(11).getTr();
        this.jButton3.setText(stbutton3);
        
        // id 17 Text jLabel2
        String stlabel2 = (String) customerlistlabels.get(12).getTr();
        this.jLabel2.setText(stlabel2);
        
        // id 18 Text jLabel5
        String stlabel5 = (String) customerlistlabels.get(13).getTr();
        this.jLabel5.setText(stlabel5);
        
        // id 19 Text jLabel6
        String stlabel6 = (String) customerlistlabels.get(14).getTr();
        this.jLabel6.setText(stlabel6);
        
        // id 20 Text jLabel7
        String stlabel7 = (String) customerlistlabels.get(15).getTr();
        this.jLabel7.setText(stlabel7);
        
        
        // id 21 Text jLabel8
        String stlabel8 = (String) customerlistlabels.get(16).getTr();
        this.jLabel8.setText(stlabel8);
        
        // id 22 Text jLabel15
        String stlabel15 = (String) customerlistlabels.get(17).getTr();
        this.jLabel15.setText(stlabel15);
        
        
        // id 23 Text jLabel16
        String stlabel16 = (String) customerlistlabels.get(18).getTr();
        this.jLabel16.setText(stlabel16);
        
        // id 24 Text jButton2
        String stbutton2 = (String) customerlistlabels.get(19).getTr();
        this.jButton2.setText(stbutton2);
        
        // id 25 Text jLabel17
        String stlabel17 = (String) customerlistlabels.get(20).getTr();
        this.jLabel17.setText(stlabel17);
        
        // id 26 Text jButton8
        String stbutton8 = (String) customerlistlabels.get(21).getTr();
        this.jButton8.setText(stbutton8);
        
        // id 27 Text jButton9
        String stbutton9 = (String) customerlistlabels.get(22).getTr();
        this.jButton9.setText(stbutton9);
        
        // id 28 Text jButton10
        String stbutton10 = (String) customerlistlabels.get(23).getTr();
        this.jButton10.setText(stbutton10);
        
        // id 29 Text jButton11
        String stbutton11 = (String) customerlistlabels.get(24).getTr();
        this.jButton11.setText(stbutton11);
        
        // id 30 Text jLabel18
        String stlabel18 = (String) customerlistlabels.get(25).getTr();
        this.jLabel18.setText(stlabel18);
        
        // id 36 Text JButton12
        String stbutton12 = (String) customerlistlabels.get(31).getTr();
        this.jButton12.setText(stbutton12);
        
              // id 37 Text Verteter
        String stlabel37 = (String) customerlistlabels.get(32).getTr();
        this.jLabel19.setText(stlabel37);
        
        // id 38 Text Gebeit
        String stlabel38 = (String) customerlistlabels.get(33).getTr();
        this.jLabel20.setText(stlabel38);
        
        // id 39 Text Kunden anzeigen
        String stbutton13 = (String) customerlistlabels.get(34).getTr();
        this.jButton13.setText(stbutton13);


        /*

            JTabbedPane1
            Artikel search
       */
        // id 31 Text Angebot erstellen
        String sttabpane = (String) customerlistlabels.get(26).getTr();
        this.jTabbedPane1.setTitleAt(1, sttabpane);



        //  id 34 Text Artikel suchen
        String startsearch = (String) customerlistlabels.get(29).getTr();
        this.jButton6.setText(startsearch);


        // id 35 Text  -- bearbeiten
        String stbearbeiten = (String) customerlistlabels.get(30).getTr();
        this.jButton7.setText(stbearbeiten);

        // id 33 Text  -- per mail versenden
        String stsendperemail = (String) customerlistlabels.get(28).getTr();
        this.jButton5.setText(stsendperemail);

        // id 32 Text -- speichern
        String stspeichern = (String) customerlistlabels.get(27).getTr();
        this.jButton4.setText(stspeichern);
        
        

        
    }  
            
    private void setTextEnglishEntity(List<Desktoplayout> customerlistlabels)
    {
        
        // customerpanel title
        String frametitle = (String) customerlistlabels.get(0).getUk();
        this.setTitle(frametitle);
        
        
        
        /*
        
                Customerpanel
                JTab1 Kundenstamm
        */
        
        // Text JTabbedPane1
        String stcustomertextentity = (String) customerlistlabels.get(1).getUk();
        this.jTabbedPane1.setTitleAt(0, stcustomertextentity);
        
        // id 7  Text jLabel1   
        String stlabel1 = (String) customerlistlabels.get(2).getUk();
        this.jLabel1.setText(stlabel1);
        
        // id 8 Text jLabel3
        String stlabel3 = (String) customerlistlabels.get(3).getUk();
        this.jLabel3.setText(stlabel3);
        
        // id 9 Text jLabel4
        String stlabel4 = (String) customerlistlabels.get(4).getUk();
        this.jLabel4.setText(stlabel4);
        
        // id 10 Text jLabel9
        String stlabel9 = (String) customerlistlabels.get(5).getUk();
        this.jLabel9.setText(stlabel9);
        
        // id 11 Text jLabel10
        String stlabel10 = (String) customerlistlabels.get(6).getUk();
        this.jLabel10.setText(stlabel10);
        
        
        // id 12 Text jLabel11
        String stlabel11 = (String) customerlistlabels.get(7).getUk();
        this.jLabel11.setText(stlabel11);
        
        // id 13 Text jLabel12
        String stlabel12 = (String) customerlistlabels.get(8).getUk();
        this.jLabel12.setText(stlabel12);
        
        // id 14 Text jLabel13
        String stlabel13 = (String) customerlistlabels.get(9).getUk();
        this.jLabel13.setText(stlabel13);
        
        // id 15 Text JLabel14
        String stlabel14 = (String) customerlistlabels.get(10).getUk();
        this.jLabel14.setText(stlabel14);
        
        // id 16 Text jButton3
        String stbutton3 = (String) customerlistlabels.get(11).getUk();
        this.jButton3.setText(stbutton3);
        
        // id 17 Text jLabel2
        String stlabel2 = (String) customerlistlabels.get(12).getUk();
        this.jLabel2.setText(stlabel2);
        
        // id 18 Text jLabel5
        String stlabel5 = (String) customerlistlabels.get(13).getUk();
        this.jLabel5.setText(stlabel5);
        
        // id 19 Text jLabel6
        String stlabel6 = (String) customerlistlabels.get(14).getUk();
        this.jLabel6.setText(stlabel6);
        
        // id 20 Text jLabel7
        String stlabel7 = (String) customerlistlabels.get(15).getUk();
        this.jLabel7.setText(stlabel7);
        
        
        // id 21 Text jLabel8
        String stlabel8 = (String) customerlistlabels.get(16).getUk();
        this.jLabel8.setText(stlabel8);
        
        // id 22 Text jLabel15
        String stlabel15 = (String) customerlistlabels.get(17).getUk();
        this.jLabel15.setText(stlabel15);
        
        
        // id 23 Text jLabel16
        String stlabel16 = (String) customerlistlabels.get(18).getUk();
        this.jLabel16.setText(stlabel16);
        
        // id 24 Text jButton2
        String stbutton2 = (String) customerlistlabels.get(19).getUk();
        this.jButton2.setText(stbutton2);
        
        // id 25 Text jLabel17
        String stlabel17 = (String) customerlistlabels.get(20).getUk();
        this.jLabel17.setText(stlabel17);
        
        // id 26 Text jButton8
        String stbutton8 = (String) customerlistlabels.get(21).getUk();
        this.jButton8.setText(stbutton8);
        
        // id 27 Text jButton9
        String stbutton9 = (String) customerlistlabels.get(22).getUk();
        this.jButton9.setText(stbutton9);
        
        // id 28 Text jButton10
        String stbutton10 = (String) customerlistlabels.get(23).getUk();
        this.jButton10.setText(stbutton10);
        
        // id 29 Text jButton11
        String stbutton11 = (String) customerlistlabels.get(24).getUk();
        this.jButton11.setText(stbutton11);
        
        // id 30 Text jLabel18
        String stlabel18 = (String) customerlistlabels.get(25).getUk();
        this.jLabel18.setText(stlabel18);
        
        // id 36 Text JButton12
        String stbutton12 = (String) customerlistlabels.get(31).getUk();
        this.jButton12.setText(stbutton12);
        
        
                   // id 37 Text Verteter
        String stlabel37 = (String) customerlistlabels.get(32).getUk();
        this.jLabel19.setText(stlabel37);
        
        // id 38 Text Gebeit
        String stlabel38 = (String) customerlistlabels.get(33).getUk();
        this.jLabel20.setText(stlabel38);
        
        // id 39 Text Kunden anzeigen
        String stbutton13 = (String) customerlistlabels.get(34).getUk();
        this.jButton13.setText(stbutton13);
        

        
        
        /*

            JTabbedPane1
            Artikel search
        */
        // id 31 Text Angebot erstellen
        String sttabpane = (String) customerlistlabels.get(26).getUk();
        this.jTabbedPane1.setTitleAt(1, sttabpane);



        //  id 34 Text Artikel suchen
        String startsearch = (String) customerlistlabels.get(29).getUk();
        this.jButton6.setText(startsearch);


        // id 35 Text  -- bearbeiten
        String stbearbeiten = (String) customerlistlabels.get(30).getUk();
        this.jButton7.setText(stbearbeiten);

        // id 33 Text  -- per mail versenden
        String stsendperemail = (String) customerlistlabels.get(28).getUk();
        this.jButton5.setText(stsendperemail);

        // id 32 Text -- speichern
        String stspeichern = (String) customerlistlabels.get(27).getUk();
        this.jButton4.setText(stspeichern);


    }

    public ActionEvent getAevent() {
        return aevent;
    }

    public void setAevent(ActionEvent aevent) {
        this.aevent = aevent;
    }

    
    
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables


    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField10() {
        return jTextField10;
    }

    public void setjTextField10(JTextField jTextField10) {
        this.jTextField10 = jTextField10;
    }

    public JTextField getjTextField11() {
        return jTextField11;
    }

    public void setjTextField11(JTextField jTextField11) {
        this.jTextField11 = jTextField11;
    }

    public JTextField getjTextField12() {
        return jTextField12;
    }

    public void setjTextField12(JTextField jTextField12) {
        this.jTextField12 = jTextField12;
    }

    public JTextField getjTextField13() {
        return jTextField13;
    }

    public void setjTextField13(JTextField jTextField13) {
        this.jTextField13 = jTextField13;
    }

    public JTextField getjTextField14() {
        return jTextField14;
    }

    public void setjTextField14(JTextField jTextField14) {
        this.jTextField14 = jTextField14;
    }

    public JTextField getjTextField15() {
        return jTextField15;
    }

    public void setjTextField15(JTextField jTextField15) {
        this.jTextField15 = jTextField15;
    }

    public JTextField getjTextField16() {
        return jTextField16;
    }

    public void setjTextField16(JTextField jTextField16) {
        this.jTextField16 = jTextField16;
    }

    public JTextField getjTextField17() {
        return jTextField17;
    }

    public void setjTextField17(JTextField jTextField17) {
        this.jTextField17 = jTextField17;
    }

    public JTextField getjTextField18() {
        return jTextField18;
    }

    public void setjTextField18(JTextField jTextField18) {
        this.jTextField18 = jTextField18;
    }

    public JTextField getjTextField19() {
        return jTextField19;
    }

    public void setjTextField19(JTextField jTextField19) {
        this.jTextField19 = jTextField19;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public JTextField getjTextField20() {
        return jTextField20;
    }

    public void setjTextField20(JTextField jTextField20) {
        this.jTextField20 = jTextField20;
    }

    public JTextField getjTextField21() {
        return jTextField21;
    }

    public void setjTextField21(JTextField jTextField21) {
        this.jTextField21 = jTextField21;
    }

    public JTextField getjTextField22() {
        return jTextField22;
    }

    public void setjTextField22(JTextField jTextField22) {
        this.jTextField22 = jTextField22;
    }

    public JTextField getjTextField23() {
        return jTextField23;
    }

    public void setjTextField23(JTextField jTextField23) {
        this.jTextField23 = jTextField23;
    }

    public JTextField getjTextField24() {
        return jTextField24;
    }

    public void setjTextField24(JTextField jTextField24) {
        this.jTextField24 = jTextField24;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
    }

    public int getKdrowcount()
    {
        return kdrowcount;
    }

    public void setKdrowcount(int kdrowcount)
    {
        Kundenstramm.kdrowcount = kdrowcount;
    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) {
        EAN13Bean barcodeGenerator = new EAN13Bean();
        BitmapCanvasProvider canvas =
                new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

   
}
