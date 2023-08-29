/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.jdesktop.emails;

import javax.mail.Store;
import java.util.HashMap;



public interface iMailClient
{
    public Store connectToStore();
    public HashMap listFolders();
    public HashMap listMessages(Object nodeInfo);
    public void searchMessage();
    public void sendEmail();
}
