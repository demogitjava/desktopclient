
package de.jsoft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.UIManager;

import de.jsoft.jdesktop.mainframe.MainFrame;


//@ComponentScan(basePackages = "de.jsoft")
public class JDesktop implements iJDesktop
{
    
    
   
    
    public static MainFrame mframe;
    public static RestTemplate rtemp;
    
    public static String baseUrl;
    public static JDesktopPane jdeskpane;

    public static int lgglobal;
    public static boolean userislogedin = false;
    
    public static String logedinusername;
   
    
    
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

       
        baseUrl = "http://f4416cf.online-server.cloud:8443/";
       
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
        loginframe.pack();
             
        jdeskpane.add(loginframe);


        mframe.add(jdeskpane);
       
        mframe.setExtendedState(JFrame.MAXIMIZED_BOTH);  
        mframe.setVisible(true);
        // mframe.pack();
    }
    
    
 
    
}
