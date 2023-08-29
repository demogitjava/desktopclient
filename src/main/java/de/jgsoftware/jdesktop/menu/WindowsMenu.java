/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.jdesktop.menu;

import de.jgsoftware.JDesktop;
import static de.jgsoftware.JDesktop.mframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 *
 * @author hoscho
 */
public class WindowsMenu implements iWindowsMenus
{
    
    public JMenuBar bar;
   
    public String txusername;
    public int intport;

    String stlaf;

    public WindowsMenu()
    {
        
    }
    
    @Override
    public JMenuBar setMenu()
    {
         
          bar = new JMenuBar(); //Constructing JMenuBar
          JMenu menu = new JMenu("File"); //Constructing JMenu name "File"
          
         
          
          JMenuItem exitapplication = new JMenuItem("Exit"); //Constructing JMenuItem with "Add New Data" label
          exitapplication.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
          });
          
     
        menu.add(exitapplication); //Adding JMenuItem in the JMenu


        /*
                Settings
        */
        JMenu menusettings = new JMenu("Settings");

        JMenuItem setlookandfeelmetal = new JMenuItem("MetalLAF");
        setlookandfeelmetal.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev)
                {
                    stlaf = "Metal";
                    try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                            if ("Metal".equals(info.getName())) {
                                UIManager.setLookAndFeel(info.getClassName());
                                SwingUtilities.updateComponentTreeUI(mframe);
                                break;
                            }
                        }
                    } catch (Exception e) {
                        // If Nimbus is not available, you can set the GUI to another look and feel.
                    }

                }
            });
        menusettings.add(setlookandfeelmetal);


        JMenuItem setlookandfeelwindows = new JMenuItem("WindowsLAF");
        setlookandfeelwindows.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                stlaf = "Windows";
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            SwingUtilities.updateComponentTreeUI(mframe);
                            break;
                        }
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }


            }
        });
        menusettings.add(setlookandfeelwindows);

        JMenuItem setlookandfeelnimbus = new JMenuItem("Nimbus");
        setlookandfeelnimbus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                stlaf = "Nimbus";
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            SwingUtilities.updateComponentTreeUI(mframe);
                            break;
                        }
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }


            }
        });
        menusettings.add(setlookandfeelnimbus);

        bar.add(menu); //Adding JMenu in the JMenuBar
        bar.add(menusettings);


        JPanel panel = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
        JToolBar toolBar = new JToolBar();
        JButton loadcompdata = new JButton("load your company data");
        loadcompdata.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev)
            {
                
                
                String adminuser = de.jgsoftware.JDesktop.logedinusername;
                if(adminuser.equals("admin"))
                {
                      de.jgsoftware.jdesktop.yourcompany.Yourcompany yourcompanyintframe = new de.jgsoftware.jdesktop.yourcompany.Yourcompany();

                      yourcompanyintframe.loadyourcompanydata();
                      yourcompanyintframe.setVisible(true);
                      yourcompanyintframe.pack();
                    
                    try {
                        yourcompanyintframe.setSelected(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(WindowsMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                      JDesktop.jdeskpane.add(yourcompanyintframe);
                    
                }   
                else
                {
                    JLabel label = new JLabel("You have no admin rights to edit user or passwords");
                  
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setVerticalTextPosition(JLabel.BOTTOM);
                    label.setHorizontalTextPosition(JLabel.CENTER);
                    JOptionPane optionpane = new JOptionPane(label, JOptionPane.PLAIN_MESSAGE);
                    
                    
                    JDesktop.jdeskpane.add(optionpane);
                }
                
              

              

            }
        });
        toolBar.add(loadcompdata);

        panel.add(toolBar);
        bar.add(panel);

   
        return bar;
    }


}
