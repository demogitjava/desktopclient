package de.jsoft.jdesktop.yourcompany;

public class MYourcompanydata implements iMYourcompanydata
{


    private Integer id;

    private String firmenname;
    private String strasse;

    private Integer plz;
    private String ort;
    private String telefon;
    private String email;



    private Integer firmennummer;

    private String steuernummer;
    private String UstIdNr;
    private String geschäftsführer;
    private String amtsgericht;
    private String bank;
    private String kontoinhaber;
    private String iban;




    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getFirmenname() {
        return firmenname;
    }
    @Override
    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }
    @Override
    public String getStrasse() {
        return strasse;
    }
    @Override
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    @Override
    public Integer getPlz() {
        return plz;
    }
    @Override
    public void setPlz(Integer plz) {
        this.plz = plz;
    }
    @Override
    public String getOrt() {
        return ort;
    }
    @Override
    public void setOrt(String ort) {
        this.ort = ort;
    }
    @Override
    public String getTelefon() {
        return telefon;
    }
    @Override
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getSteuernummer() {
        return steuernummer;
    }
    @Override
    public void setSteuernummer(String steuernummer) {
        this.steuernummer = steuernummer;
    }

    @Override
    public String getUstIdNr() {
        return UstIdNr;
    }
    @Override
    public void setUstIdNr(String ustIdNr) {
        UstIdNr = ustIdNr;
    }
    @Override
    public String getGeschäftsführer() {
        return geschäftsführer;
    }
    @Override
    public void setGeschäftsführer(String geschäftsführer) {
        this.geschäftsführer = geschäftsführer;
    }
    @Override
    public String getAmtsgericht() {
        return amtsgericht;
    }
    @Override
    public void setAmtsgericht(String amtsgericht) {
        this.amtsgericht = amtsgericht;
    }
    @Override
    public String getBank() {
        return bank;
    }
    @Override
    public void setBank(String bank) {
        this.bank = bank;
    }
    @Override
    public String getKontoinhaber() {
        return kontoinhaber;
    }
    @Override
    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }
    @Override
    public String getIban() {
        return iban;
    }
    @Override
    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public Integer getFirmennummer() {
        return firmennummer;
    }
    @Override
    public void setFirmennummer(Integer firmennummer) {
        this.firmennummer = firmennummer;
    }
}
