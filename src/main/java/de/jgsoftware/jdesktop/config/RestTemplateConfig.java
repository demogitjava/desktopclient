package de.jgsoftware.jdesktop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hoscho
 */
@Configuration
public class RestTemplateConfig 
{
    HttpComponentsClientHttpRequestFactory factory = null;
    
    
    @Bean
    public RestTemplate restTemplate() 
    {
        factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(5000);
        
        return new RestTemplate(factory);
    }

    
}
