package de.jgsoftware;

import de.jgsoftware.jdesktop.mainframe.MainFrame;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;


public interface iJDesktop
{

   
    
   MainFrame mframe = null;
   RestTemplate rtemp = null;

   String baseUrl = null;
   JDesktopPane jdeskpane = null;

   int lgglobal = Integer.parseInt(null);
   boolean userislogedin = false;
   
   public static String logedinusername = null;
}
