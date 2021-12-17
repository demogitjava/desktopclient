package de.jsoft.jdesktop.login;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public interface iNewJInternalFrame
{
    public void setTexttoComponents();
    public HttpHeaders setHeaders(String authStringEnc);

    public static HttpHeaders headers = null;
    public static HttpEntity<String> httpentity = null;

    public static HttpHeaders header = null;
    public static RestTemplateBuilder restTemplateBuilder = null;

    String stlabel1 = null;
    String stlabel2 = null;
    String stlabel3 = null;
}
