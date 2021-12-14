/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.emails;

import java.util.HashMap;
import javax.mail.Store;



public interface iEmailClient 
{
    public Store connectToStore();
    public HashMap listFolders();
    public HashMap listMessages(Object nodeInfo);
    public void searchMessage();
    public void sendEmail();
}
