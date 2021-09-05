/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.login;


import de.jsoft.JDesktop;
import static de.jsoft.JDesktop.mframe;
import static de.jsoft.JDesktop.rtemp;
import de.jsoft.jdesktop.config.LoginProvider;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
//import org.springframework.boot.developertools.remote.client.HttpHeaderInterceptor;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//import sun.misc.BASE64Encoder;
import org.apache.http.impl.client.CloseableHttpClient;
import java.util.Base64;

/**
 *
 * @author hoscho
 *  Login JInternalFrame
 */
@Controller
public class NewJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    //String itemstoComboBox = JDesktop.baseUrl + "/desktoplayout/sprachen";   
    //String texttolabel = JDesktop.baseUrl + "/desktoplayout/logintextentity";
    public static List<ClientHttpRequestInterceptor> interceptors;
    
    public static HttpHeaders headers;
    public static HttpEntity<String> httpentity;

    public static HttpHeaders header;
    public static RestTemplateBuilder restTemplateBuilder;
    
    String stlabel1 = null;
    String stlabel2 = null;
    String stlabel3 = null;
    
    
    public NewJInternalFrame()
    {
       
        
        
        initComponents();
        
        
        
        /*
            Text to JCombo1
        */
        setTexttoComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setResizable(true);
        setName(""); // NOI18N

        jLabel1.setText("jLabel1");

        jTextField1.setText("jTextField1");

        jLabel2.setText("jLabel2");

        jPasswordField1.setText("jPasswordField1");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        DaoLogin dlogin = new DaoLogin();
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jComboBox1ComponentShown(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ihr Logo");

        jLabel4.setText("qr-code");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 357, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
      
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
              
        System.out.print("ComboBox Selected Item");
        
        
        ResponseEntity<List<LoginFrame>> textlabelresponse = JDesktop.rtemp.exchange(
                JDesktop.baseUrl + "/detaillabeldesktopentry/getloginlabel",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LoginFrame>>(){});


        // 0 = de
        // 1 = fr
        // 2 = uk
        // 3 = esp 
        // 4 = it
        // 5 = tr
        
        
     int size = jComboBox1.getItemCount();
        Integer getcomblg = (int) jComboBox1.getSelectedIndex();
        Integer selectedlanguage = (int) getcomblg;
       
        
       
        //  de.jsoft.JDesktop.lgglobal = jComboBox1.getSelectedIndex();
        switch(selectedlanguage)
        {
          
            case 0:
            {
                System.out.print("selected 0 --- German");
               
                // Username
                jLabel1.setText(textlabelresponse.getBody().get(1).getDe());

                // Password
                jLabel2.setText(textlabelresponse.getBody().get(2).getDe());

                // Text to JButton1
                jButton1.setText(textlabelresponse.getBody().get(3).getDe());
                
                break;
            }
            
             case 1:
            {
                System.out.print("selected 1 --- France");
                  // Username
                jLabel1.setText(textlabelresponse.getBody().get(1).getFr());

                 // Password
                jLabel2.setText(textlabelresponse.getBody().get(2).getFr());

                // Text to JButton1
                jButton1.setText(textlabelresponse.getBody().get(3).getFr());
             
                break;
            }
             case 2:
            {
                System.out.print("selected 2 --- English");
                
                  // Username
                jLabel1.setText(textlabelresponse.getBody().get(1).getUk());

                 // Password
                jLabel2.setText(textlabelresponse.getBody().get(2).getUk());

                // Text to JButton1
                jButton1.setText(textlabelresponse.getBody().get(3).getUk());
                
                
                break;
            }
             case 3:
            {
                System.out.print("selected 0 --- Spanisch");
                    // Username
                jLabel1.setText(textlabelresponse.getBody().get(1).getEsp());

                 // Password
                jLabel2.setText(textlabelresponse.getBody().get(2).getEsp());

                // Text to JButton1
                jButton1.setText(textlabelresponse.getBody().get(3).getEsp());
                
                break;
            }
          
              case 4:
            {
                System.out.print("selected 0 --- Italenisch");
                    // Username
                jLabel1.setText(textlabelresponse.getBody().get(1).getIt());

                 // Password
                jLabel2.setText(textlabelresponse.getBody().get(2).getIt());

                // Text to JButton1
                jButton1.setText(textlabelresponse.getBody().get(3).getIt());
                
                break;
            }
          
          
              case 5:
            {
                System.out.print("selected 5 --- Türkisch");
                    // Username
                jLabel1.setText(textlabelresponse.getBody().get(1).getTr());

                 // Password
                jLabel2.setText(textlabelresponse.getBody().get(2).getTr());

                // Text to JButton1
                jButton1.setText(textlabelresponse.getBody().get(3).getTr());
                
                break;
            }
          
            
            default:
            {
                System.out.print("Default is selected");
                break;
            }
        }
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jComboBox1ComponentShown
        // TODO add your handling code here:
        
   
    }//GEN-LAST:event_jComboBox1ComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // TODO add your handling code here:
       Integer selectedlanguage = (int) jComboBox1.getSelectedIndex();
       de.jsoft.JDesktop.setLgtoPanel(selectedlanguage);
       
       
       String stuser = jTextField1.getText();
       char[] stpass = jPasswordField1.getPassword();

       String stpassword = String.valueOf(stpass);
       //headers = new HttpHeaders();

       String authString = stuser + ":" + stpassword;
        
       //String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
       String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
            
       de.jsoft.jdesktop.config.LoginProvider loginprovider = new de.jsoft.jdesktop.config.LoginProvider();   
       setHeaders(authStringEnc);
      
       loginprovider.logintoServer(stuser, stpassword);
        
       
        
      
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(de.jsoft.jdesktop.config.LoginProvider.client);
        
        // "http://localhost:8443/users"
         ResponseEntity<String> response = new RestTemplate(requestFactory).
      exchange(JDesktop.baseUrl + "users", HttpMethod.GET, null, String.class);
        try {


        
       
            if(response.getStatusCodeValue() == 200)
            {
                System.out.print("Loggin is success");
                
                de.jsoft.jdesktop.login.NewJInternalFrame loginframe = new de.jsoft.jdesktop.login.NewJInternalFrame();
                loginframe.dispose();
                
                JDesktop.jdeskpane.removeAll();
                  
                
                
                
                   /*
                    load default Window menu 
                    if User successful loginid
                */
                de.jsoft.jdesktop.menu.WindowsMenu wmenu = new de.jsoft.jdesktop.menu.WindowsMenu();
                mframe.setJMenuBar(wmenu.setMenu());
               
                de.jsoft.jdesktop.kundenstamm.Kundenstramm kdstamm = new de.jsoft.jdesktop.kundenstamm.Kundenstramm();
                kdstamm.setVisible(true);
                kdstamm.setMaximizable(true);
                kdstamm.pack();
                
                
                // user is logedin
                de.jsoft.JDesktop.userislogedin = true;
                
                JDesktop.jdeskpane.add(kdstamm);
                
                
              
                
                
            }
            else if(response.getStatusCodeValue() == 401)
            {
                System.out.print("Username or Password is false");
                jLabel3.setText("Username or Password is false");
            }

        } catch (Exception e)
        {
            System.out.print("Fehler " +e);
        }

  
    }//GEN-LAST:event_jButton1ActionPerformed

    /*     
        add Text to ComboBox1   
    */
    public void setTexttoComponents()
    {
        
      
     ResponseEntity<List<LoginFrame>> textlabelresponse = JDesktop.rtemp.exchange(
                JDesktop.baseUrl + "/detaillabeldesktopentry/getloginlabel",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LoginFrame>>(){});


        jComboBox1.addItem(textlabelresponse.getBody().get(0).getDe());
        jComboBox1.addItem(textlabelresponse.getBody().get(0).getFr());
        jComboBox1.addItem(textlabelresponse.getBody().get(0).getUk());
        jComboBox1.addItem(textlabelresponse.getBody().get(0).getEsp());
        jComboBox1.addItem(textlabelresponse.getBody().get(0).getIt());
        jComboBox1.addItem(textlabelresponse.getBody().get(0).getTr());


        jTextField1.setText("");
        jPasswordField1.setText("");


        // Username
        jLabel1.setText(textlabelresponse.getBody().get(1).getDe());

        // Password
        jLabel2.setText(textlabelresponse.getBody().get(2).getDe());


        // Text to JButton1
        jButton1.setText(textlabelresponse.getBody().get(3).getDe());

    }
    
     public HttpHeaders setHeaders(String authStringEnc)
    { 
       
        header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
     	header.add("Authorization", "Basic " + authStringEnc);
    	return header;
    	//de.jsoft.JDesktop.headers.set("Authorization", "Basic " + authStringEnc);
    }

    public static HttpHeaders getHeaders() {
        return headers;
    }

    public static void setHeaders(HttpHeaders headers) {
        NewJInternalFrame.headers = headers;
    }

   
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
