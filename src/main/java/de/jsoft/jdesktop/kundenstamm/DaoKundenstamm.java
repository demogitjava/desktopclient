/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.kundenstamm;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoscho
 */
public class DaoKundenstamm
{
    
    
    public DefaultTableModel model;
    
    // "Artikelnummer", "Artikelbezeichnung", "VK",
    String artnumber;
    String artbezeichnung;
    Double vk;
    
   
    
    public DaoKundenstamm()
    {
        
    }
    
    
    // JTable 1
    // Create offers
     public void addDatatoTable(List<Artikelstamm> selectedcustomitems, JTable jTable2)
    {
        
       
        model = new DefaultTableModel(
                
      new Object[][]
      {
          
          /*
            {  
                searchuser, searchstrasse, searchplz, searchort 
                
            }, 
*/
           
      },
      new Object[] { "Artikelnummer", "Artikelbezeichnung", "VK", });
        
        
         for(int i = 0; i < selectedcustomitems.size(); i++)
       {
           
              artnumber = String.valueOf(selectedcustomitems.get(i).getArtikelnummer());
              artbezeichnung = selectedcustomitems.get(i).getArtikelbezeichnung();
              
              vk = selectedcustomitems.get(i).getVk();
          
             
            
              //model.addRow(searchuser, searchstrasse, searchplz, searchort);
         
              model.addRow(new Object[]{ artnumber, artbezeichnung, vk});
       }
       
         
        
         jTable2.setModel(model);
    }
    
     
     public void addrowwithdata(List<Artikelstamm> selectedcustomitems, JTable jTable2)
     {
         model = (DefaultTableModel) jTable2.getModel();
         
       
       
         model.addRow(new Object[]
         {
             selectedcustomitems.get(0).getArtikelnummer(),
             selectedcustomitems.get(0).getArtikelbezeichnung(),
             selectedcustomitems.get(0).getVk(),
           
         });
         
        
     }
     
     
     
     
     // Anzahl // jLabel
     public void updateNumberCustomerChart(JTable jTable2, JLabel jLabel22)
     {
      
    
         jLabel22.setText(jTable2.getSize().toString());
        
      
         int rows = jTable2.getRowCount();
         jLabel22.setText(String.valueOf(rows));
         
        
         
          
     }
     
     
     public void removeItemCustomerChart(JTable jTable2, JLabel jLabel22)
     {
         
            Integer selectedRow = jTable2.getSelectedRow();
            
            ((DefaultTableModel) jTable2.getModel()).removeRow(selectedRow);
            updateNumberCustomerChart(jTable2, jLabel22);
     }
     
     
    
}
