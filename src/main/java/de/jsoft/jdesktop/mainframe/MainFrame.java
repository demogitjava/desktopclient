/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.mainframe;

import javax.swing.*;

/**
 *
 * @author hoscho
 */
public class MainFrame extends javax.swing.JFrame implements iMainFrame
{

    /**
     * Creates new form MainFrame
     */
    public MainFrame()
    {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JDesktopPane jDesktopPane1 = new javax.swing.JDesktopPane();
    // End of variables declaration//GEN-END:variables

    public void setMenuBar(JMenuBar bar)
    {

        de.jsoft.jdesktop.menu.iWindowsMenus iWindowsMenus = new de.jsoft.jdesktop.menu.iWindowsMenus() {
            @Override
            public JMenuBar setMenu() {
                return null;
            }

            @Override
            public JToolBar setJToolbar() {
                return null;
            }
        };


       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}
