package de.jsoft.jdesktop.kundenstamm;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.awt.event.ActionEvent;
import java.util.List;

public interface iKundenstamm
{
    public void updateJTextFields(ActionEvent aevent);
    public ActionEvent getAevent();
    public void setAevent(ActionEvent aevent);

    public static List<ClientHttpRequestInterceptor> interceptors = null;
    public static List<MKundenstamm> searchresult = null;
    public static List<Artikelstamm> selecteditems = null;
    public ActionEvent aevent = null;

}
