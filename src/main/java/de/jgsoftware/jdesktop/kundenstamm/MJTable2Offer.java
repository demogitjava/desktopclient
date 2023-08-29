/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.jdesktop.kundenstamm;

/**
 *
 * @author hoscho
 */
public class MJTable2Offer 
{
    private Long artikelnummer;
    private String artbezeichnung;
    private Double vkpries;
    private Integer anzahl;

    public Long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(Long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getArtbezeichnung() {
        return artbezeichnung;
    }

    public void setArtbezeichnung(String artbezeichnung) {
        this.artbezeichnung = artbezeichnung;
    }

    public Double getVkpries() {
        return vkpries;
    }

    public void setVkpries(Double vkpries) {
        this.vkpries = vkpries;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }
    
    
}
