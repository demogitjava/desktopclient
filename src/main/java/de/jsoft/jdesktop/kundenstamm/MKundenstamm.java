package de.jsoft.jdesktop.kundenstamm;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
/**
 *
 * @author hoscho
 */
public class MKundenstamm {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String kundennummer;

    private String kundenname;

    private String land;

    private String nameAnschrift1;

    private String nameAnschrift2;

    private String nameAnschrift3;

    private String nameAnschrift4;

    private String strasse;

    private Integer plz;

    private String ort;

    private String iban;

    private String blz;

    private String kontoNr;

    private Double kreditlimit;

    private String telefon;

    private String mobil1;

    private String mobil2;

    private String sip;

    private String email;

    private String ansprechpartner;

    private Float umsatzLfdJahr;

    private Float umsatzJahr1;

    private Float umsatzJahr2;

    private Date timestamp;

    private Integer gebiet;

    private Integer vertreter;

    private String bankverbindung;



    public MKundenstamm() {
    }

    public Integer getGebiet() {
        return gebiet;
    }

    public void setGebiet(Integer gebiet) {
        this.gebiet = gebiet;
    }

    public Integer getVertreter() {
        return vertreter;
    }

    public void setVertreter(Integer vertreter) {
        this.vertreter = vertreter;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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




    public MKundenstamm(String kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(String kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getNameAnschrift1() {
        return nameAnschrift1;
    }

    public void setNameAnschrift1(String nameAnschrift1) {
        this.nameAnschrift1 = nameAnschrift1;
    }

    public String getNameAnschrift2() {
        return nameAnschrift2;
    }

    public void setNameAnschrift2(String nameAnschrift2) {
        this.nameAnschrift2 = nameAnschrift2;
    }

    public String getNameAnschrift3() {
        return nameAnschrift3;
    }

    public void setNameAnschrift3(String nameAnschrift3) {
        this.nameAnschrift3 = nameAnschrift3;
    }

    public String getNameAnschrift4() {
        return nameAnschrift4;
    }

    public void setNameAnschrift4(String nameAnschrift4) {
        this.nameAnschrift4 = nameAnschrift4;
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

    public String getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(String kontoNr) {
        this.kontoNr = kontoNr;
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

    public Float getUmsatzLfdJahr() {
        return umsatzLfdJahr;
    }

    public void setUmsatzLfdJahr(Float umsatzLfdJahr) {
        this.umsatzLfdJahr = umsatzLfdJahr;
    }

    public Float getUmsatzJahr1() {
        return umsatzJahr1;
    }

    public void setUmsatzJahr1(Float umsatzJahr1) {
        this.umsatzJahr1 = umsatzJahr1;
    }

    public Float getUmsatzJahr2() {
        return umsatzJahr2;
    }

    public void setUmsatzJahr2(Float umsatzJahr2) {
        this.umsatzJahr2 = umsatzJahr2;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
