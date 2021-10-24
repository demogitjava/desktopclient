/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.kundenstamm;

import de.jsoft.JDesktop;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

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
    
    List<MJTable2Offer> saveoffer;
    
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
     
     
     
     // get values from jTable2
     // post list to  /offer/savenewoffer
     public void saveofferdata(JTable jTable2, Buchungsdaten bdaten)
     {
         model = (DefaultTableModel) jTable2.getModel();
         
         List<Buchungsdaten> saveoffer = new ArrayList();
         int rows = jTable2.getRowCount();
         
         for(int i = 0; i < rows; i++)
         {
             // überprüft ob anzahl eingeben
             Integer anzahl1 = (Integer) this.model.getValueAt(i, 3);
             if(anzahl1 == null)
             {
                 this.model.setValueAt(1, i, 3);
             }
             //-----
             
             Long artikelnummer = (Long) this.model.getValueAt(i, 0);
             String artbezeichnung = (String) this.model.getValueAt(i, 1);
             Double vkpries = (Double) this.model.getValueAt(i, 2);
             Integer anzahl = (Integer) this.model.getValueAt(i, 3);
             if(anzahl == null)
             {
                 this.model.setValueAt(1, i, 3);
             }
             
            
             
             // jTable2
             //bdaten = new Buchungsdaten();
             bdaten.setArtikelnummer(artikelnummer);
             bdaten.setVk(vkpries);
             bdaten.setMenge(anzahl);
             
       
            
             saveoffer.add(i, bdaten);
             
             
             
         }
         
         HttpEntity entity = new HttpEntity(saveoffer,de.jsoft.jdesktop.login.NewJInternalFrame.header);    
         ResponseEntity<String> out = JDesktop.rtemp.exchange(JDesktop.baseUrl + "offernumber/savenewoffer", HttpMethod.POST, entity, String.class);
      
     
         System.out.print("post offer" + "\n");
       
     }
    
}
