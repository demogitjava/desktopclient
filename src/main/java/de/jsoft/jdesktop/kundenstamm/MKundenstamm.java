package de.jsoft.jdesktop.kundenstamm;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hoscho
 */

public class MKundenstamm implements Serializable
{



 
    private Long id;

    private Long kundennummer;

    private String kundenname;

    private String land;

    private String name_Anschrift1;

    private String name_Anschrift2;

    private String name_Anschrift3;

    private String name_Anschrift4;

    private String strasse;

    private Integer plz;

    private String ort;

    private String iban;

    private String blz;

    private String konto_Nr;

    private Double kreditlimit;

    private String telefon;

    private String mobil1;

    private String mobil2;

    private String sip;

    private String email;

    private String ansprechpartner;

    private Float umsatz_Lfd_Jahr;

    private Float umsatz_Jahr_1;

    private Float umsatz_Jahr_2;

    private Date timestamp;

    private int gebiet;

    private int vertreter;

    private String bankverbindung;



    public MKundenstamm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(Long kundennummer) {
        this.kundennummer = kundennummer;
    }


    
   

    public int getGebiet() {
        return gebiet;
    }

    public void setGebiet(int gebiet) {
        this.gebiet = gebiet;
    }

    public int getVertreter() {
        return vertreter;
    }

    public void setVertreter(int vertreter) {
        this.vertreter = vertreter;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

    public void setBankverbindung(String bankverbindung) {
        this.bankverbindung = bankverbindung;
    }



    public String getKundenname() {
        return kundenname;
    }

    public void setKundenname(String kundenname) {
        this.kundenname = kundenname;
    }




   
   

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBlz() {
        return blz;
    }

    public void setBlz(String blz) {
        this.blz = blz;
    }

    public String getKonto_Nr() {
        return konto_Nr;
    }

    public void setKonto_Nr(String konto_Nr) {
        this.konto_Nr = konto_Nr;
    }


    public Double getKreditlimit() {
        return kreditlimit;
    }

    public void setKreditlimit(Double kreditlimit) {
        this.kreditlimit = kreditlimit;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMobil1() {
        return mobil1;
    }

    public void setMobil1(String mobil1) {
        this.mobil1 = mobil1;
    }

    public String getMobil2() {
        return mobil2;
    }

    public void setMobil2(String mobil2) {
        this.mobil2 = mobil2;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }



    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getName_Anschrift1() {
        return name_Anschrift1;
    }

    public void setName_Anschrift1(String name_Anschrift1) {
        this.name_Anschrift1 = name_Anschrift1;
    }

    public String getName_Anschrift2() {
        return name_Anschrift2;
    }

    public void setName_Anschrift2(String name_Anschrift2) {
        this.name_Anschrift2 = name_Anschrift2;
    }

    public String getName_Anschrift3() {
        return name_Anschrift3;
    }

    public void setName_Anschrift3(String name_Anschrift3) {
        this.name_Anschrift3 = name_Anschrift3;
    }

    public String getName_Anschrift4() {
        return name_Anschrift4;
    }

    public void setName_Anschrift4(String name_Anschrift4) {
        this.name_Anschrift4 = name_Anschrift4;
    }

    public Float getUmsatz_Lfd_Jahr() {
        return umsatz_Lfd_Jahr;
    }

    public void setUmsatz_Lfd_Jahr(Float umsatz_Lfd_Jahr) {
        this.umsatz_Lfd_Jahr = umsatz_Lfd_Jahr;
    }

    public Float getUmsatz_Jahr_1() {
        return umsatz_Jahr_1;
    }

    public void setUmsatz_Jahr_1(Float umsatz_Jahr_1) {
        this.umsatz_Jahr_1 = umsatz_Jahr_1;
    }

    public Float getUmsatz_Jahr_2() {
        return umsatz_Jahr_2;
    }

    public void setUmsatz_Jahr_2(Float umsatz_Jahr_2) {
        this.umsatz_Jahr_2 = umsatz_Jahr_2;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kundennummer != null ? kundennummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MKundenstamm)) {
            return false;
        }
        MKundenstamm other = (MKundenstamm) object;
        if ((this.kundennummer == null && other.kundennummer != null) || (this.kundennummer != null && !this.kundennummer.equals(other.kundennummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jsoft.model.data.Kundenstamm[ kundennummer=" + kundennummer + " ]";
    }

}
