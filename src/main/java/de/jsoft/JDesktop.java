
package de.jsoft;


import de.jsoft.jdesktop.mainframe.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import javax.swing.UIManager.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpHeaders;


//@ComponentScan(basePackages = "de.jsoft")
public class JDesktop implements iJDesktop
{
    
    public static MainFrame mframe;
    public static RestTemplate rtemp;
    
    public static String baseUrl;
    public static JDesktopPane jdeskpane;

    public static int lgglobal;
    public static boolean userislogedin = false;

    @Autowired
    iJDesktop iJDesktop;
    
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
            setup to Nimbus
        
        */


        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e)
        {
            System.out.print("LookAndFeel Error Nimbus !");
        }

       
        baseUrl = "http://localhost:8443/";
       
        JDesktop jdesk = new JDesktop();
        rtemp = new RestTemplate();


        mframe = new MainFrame();

        jdeskpane = MainFrame.jDesktopPane1;

        /*
            inizialisiere Klassen fÃ¼r DeskopPane
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
