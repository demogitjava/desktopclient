/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.kundenstamm;

import java.util.List;
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
     public void addDatatoTable(List<Artikelstamm> selectedcustomitems, JTable jTable1)
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
        
         jTable1.setModel(model);
    }
    
}
