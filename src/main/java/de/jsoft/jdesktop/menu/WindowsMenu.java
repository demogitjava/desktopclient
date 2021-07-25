/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.menu;

import static de.jsoft.JDesktop.mframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author hoscho
 */
public class WindowsMenu 
{
    
    public JMenuBar bar;
    
    
    public JMenuBar setMenu()
    {
         
          bar = new JMenuBar(); //Constructing JMenuBar
          JMenu menu = new JMenu("File"); //Constructing JMenu name "File"
          JMenuItem exitapplication = new JMenuItem("Exit"); //Constructing JMenuItem with "Add New Data" label
          exitapplication .addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
          });
          
          menu.add(exitapplication); //Adding JMenuItem in the JMenu
          bar.add(menu); //Adding JMenu in the JMenuBar
     
         
        return bar;
       
    }
    
}
