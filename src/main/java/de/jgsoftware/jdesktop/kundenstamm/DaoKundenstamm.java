/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.jdesktop.kundenstamm;

import com.google.gson.Gson;
import de.jgsoftware.JDesktop;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static org.jline.keymap.KeyMap.key;
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
    
    Long artikelnummer;
    String artnumber;
    String artbezeichnung;
    Double vk;
    
    Double vkpreis;
    Integer anzahl;
    
    
    List<MJTable2Offer> saveoffer;
    
    List<Buchungsdaten> saveofferhttpentity;

    public HashMap hofferanddeliverynodes;

    public DaoKundenstamm()
    {
        
    }
    
    
    /*
    
        jTabebbed Pane 
        offerpanel
    
    */
    
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
     public void saveofferdata(JTable jTable2, Buchungsdaten bdaten, JLabel jLabel27, JLabel jLabel25)
     {
         model = (DefaultTableModel) jTable2.getModel();
         
         saveofferhttpentity = new ArrayList();
         
       
         
         int rows = jTable2.getRowCount();
         
         for(int i = 0; i < rows; i++)
         {
             Buchungsdaten buchungsdaten = new Buchungsdaten();
             // überprüft ob anzahl eingeben
             Integer anzahl1 = (Integer) this.model.getValueAt(i, 3);
            // if(anzahl1 == null)
            // {
              //   model.setValueAt(1, i, 3);
            // }
             //-----
             buchungsdaten.setKdnummer(bdaten.getKdnummer());
             buchungsdaten.setKdname(bdaten.getKdname());
             artikelnummer = (Long) model.getValueAt(i, 0);
             buchungsdaten.setArtikelnummer(artikelnummer);
        
             
             artbezeichnung = (String) model.getValueAt(i, 1);
           
             
            vkpreis = (Double) model.getValueAt(i, 2);
          
            buchungsdaten.setVk(vkpreis);
                
            anzahl = (Integer) model.getValueAt(i, 3);
        
            // if null then set to 
            if(anzahl == null)
             {
                 model.setValueAt(1, i, 3);
             }
            
            buchungsdaten.setMenge((Integer) model.getValueAt(i, 3));
            
            saveofferhttpentity.add(buchungsdaten);
            
           
             // jTable2
             //bdaten = new Buchungsdaten();
           
             
         }
         
         
         // Template[] list = restTemplate.getForEntity(urlFullTemplates, Template[].class).getBody();
         HttpEntity entity = new HttpEntity(saveofferhttpentity,de.jgsoftware.jdesktop.login.NewJInternalFrame.header);    
         ResponseEntity<List<Buchungsdaten>> responseentitybeleg = JDesktop.rtemp.exchange(JDesktop.baseUrl + "offer/savenewoffer", HttpMethod.POST, entity, new ParameterizedTypeReference<List<Buchungsdaten>>(){});
        
        
         int belegnummer = responseentitybeleg.getBody().get(0).getBeleg();
         jLabel27.setText(String.valueOf(belegnummer));
         
        
         sumtoaloffer(responseentitybeleg, jLabel25);  // double offer total  jLabel25
     }

    public Double sumtoaloffer(ResponseEntity<List<Buchungsdaten>> responseentitybeleg, JLabel jLabel25) 
    {
        Double totaloffer = 0.00;
        
        int listsize = responseentitybeleg.getBody().size();
        
        for(int i = 0; i < listsize; i++)
        {
            int responsemenge = responseentitybeleg.getBody().get(i).getMenge();
            double preisoffer = responseentitybeleg.getBody().get(i).getVk();
            
            double rowdouble = responsemenge * preisoffer;
            totaloffer = totaloffer + rowdouble;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        jLabel25.setText(String.valueOf(df.format(totaloffer)));
        
        
        return totaloffer;
    }
     
     
   
    /*
        
        JTabbedPane 
        deliveri nodes & offer    
        
    */
    public HashMap getofferanddevlicerinodes(List<Buchungsdaten> loffercustomer, JList jList1, HashMap hofferanddeliverynodes)
    {
        /*
            
            create a hashmap 
            for add value with offer number
            saved as keyvalue for access
        
        */
        //hofferanddeliverynodes = null;
        Integer belsize = loffercustomer.size();
        Double newvkp = null;

        for(int i = 0; i < belsize; i++)
        {

            Integer beleg = loffercustomer.get(i).getBeleg();
            Double vkp = loffercustomer.get(i).getVk();          
           
            if(hofferanddeliverynodes.get(beleg) == null)
            {
                 hofferanddeliverynodes.put(beleg, vkp);
            }
            else
            {
                Double hsmapvk = (Double) hofferanddeliverynodes.get(beleg);
                newvkp = hsmapvk + vkp;
                hofferanddeliverynodes.put(beleg, newvkp);    
            }    
        }

        int hashlistsize = hofferanddeliverynodes.size();
       
        // defaultlistofferanddeliverynode.add
        
       
        return hofferanddeliverynodes;
        
    }
    
        
    
}
