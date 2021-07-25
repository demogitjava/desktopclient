/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jsoft.jdesktop.config;

import de.jsoft.JDesktop;
import static de.jsoft.JDesktop.mframe;
import de.jsoft.jdesktop.login.NewJInternalFrame;
import io.netty.handler.codec.Headers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hoscho
 */

@Configuration
public class LoginProvider 
{
 
    public static CloseableHttpClient client;
    
   
    
    public LoginProvider()
    {
        
        
    }
    
    
    public void logintoServer(String stuser, String stpassword)
    {
        try {
            CredentialsProvider provider = new BasicCredentialsProvider();
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(stuser, stpassword);
            provider.setCredentials(AuthScope.ANY, credentials);
            
            client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
            
            HttpResponse response = client.execute(
                    new HttpPost(de.jsoft.JDesktop.baseUrl + "login"));
            
            
            int statusCode = response.getStatusLine().getStatusCode();
            
            System.out.print("status code is" + statusCode + "\n");
            
            
             HttpResponse response1 = client.execute(
                    new HttpGet(de.jsoft.JDesktop.baseUrl + "getUserData"));
              int statusCode1 = response1.getStatusLine().getStatusCode();
              if(statusCode1 == 200)
              {
                  System.out.print("login sucess" + "\n");
                 
                // close Login JInternalFrame
                
                de.jsoft.jdesktop.login.NewJInternalFrame loginframe = new de.jsoft.jdesktop.login.NewJInternalFrame();
                JDesktop.jdeskpane.removeAll();
             
                // get customer JInternalPanel   
                de.jsoft.jdesktop.kundenstamm.Kundenstramm kdstamm = new de.jsoft.jdesktop.kundenstamm.Kundenstramm();
                kdstamm.setVisible(true);
                kdstamm.setMaximizable(true);
                kdstamm.pack();
                
                
                /*
                    load default Window menu 
                    if User successful loginid
                */
                de.jsoft.jdesktop.menu.WindowsMenu wmenu = new de.jsoft.jdesktop.menu.WindowsMenu();
                mframe.setJMenuBar(wmenu.setMenu());
               
                JDesktop.jdeskpane.add(kdstamm);
                
                
              }
              else
              {
                  System.out.print("login failed");
                  // username and password are wrong
              }
            assertThat(statusCode, equalTo(HttpStatus.SC_OK));
        } catch (IOException ex) {
            Logger.getLogger(LoginProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CloseableHttpClient getClient() {
        return client;
    }
    
    /*
    public void addRestTemplateHeader(String authStringEnc)
    {
        
          List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
          interceptors.add(new HttpHeaderInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
          interceptors.add(new HttpHeaderInterceptor("Authorization", "Basic " + authStringEnc));
          
          de.jsoft.JDesktop.rtemp.setInterceptors(interceptors);
        
    
    }
*/
    
    
   
    
    
}
