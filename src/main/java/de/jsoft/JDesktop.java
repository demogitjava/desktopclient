/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft;


import de.jsoft.jdesktop.mainframe.MainFrame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpHeaders;

@SpringBootApplication
@ComponentScan(basePackages = "de.jsoft")
public class JDesktop 
{
    
    public static MainFrame mframe;
    public static RestTemplate rtemp;
    
    public static String baseUrl;
    public static JDesktopPane jdeskpane;

    public static int lgglobal;
   
    
    public JDesktop()
    {

    }
    
    public static Integer setLgtoPanel(int indexlanguage)
    {
       
        lgglobal = 0;
        lgglobal = indexlanguage;
        return lgglobal;
    }
    
    
    public static void main(String[] args)
    {


       
        /*
        
            Look and Feel 
            Einstellung auf Nimbus als default
        
        */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDesktop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JDesktop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JDesktop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JDesktop.class.getName()).log(Level.SEVERE, null, ex);
        }
        






        baseUrl = "http://localhost:8443/";

        JDesktop jdesk = new JDesktop();
        rtemp = new RestTemplate();


        mframe = new MainFrame();

        jdeskpane = MainFrame.jDesktopPane1;

        /*
            inizialisiere Klassen für DeskopPane
        */
        Object size = (Object) MainFrame.jDesktopPane1.getSize();


        de.jsoft.jdesktop.login.NewJInternalFrame loginframe = new de.jsoft.jdesktop.login.NewJInternalFrame();
        loginframe.setVisible(true);

        jdeskpane.add(loginframe);

        mframe.add(jdeskpane);



        mframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mframe.setVisible(true);
        // mframe.pack();




    }
    
}
