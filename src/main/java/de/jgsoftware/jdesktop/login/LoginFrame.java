/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.jdesktop.login;

public class LoginFrame implements iLoginFrame
{
    
    private int id;
    
    private String de;
    private String fr;
    private String uk;
    
    private String framename;
    private String esp;
    
    private String it;
    private String tr;
    
    private String bindto;

    @Override
    public String getIt() {
        return it;
    }
    @Override
    public void setIt(String it) {
        this.it = it;
    }
    @Override
    public String getTr() {
        return tr;
    }
    @Override
    public void setTr(String tr) {
        this.tr = tr;
    }
    @Override
    public String getBindto() {
        return bindto;
    }
    @Override
    public void setBindto(String bindto) {
        this.bindto = bindto;
    }



    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getDe() {
        return de;
    }
    @Override
    public void setDe(String de) {
        this.de = de;
    }
    @Override
    public String getFr() {
        return fr;
    }
    @Override
    public void setFr(String fr) {
        this.fr = fr;
    }
    @Override
    public String getUk() {
        return uk;
    }
    @Override
    public void setUk(String uk) {
        this.uk = uk;
    }


    @Override
    public String getFramename() {
        return framename;
    }
    @Override
    public void setFramename(String framename) {
        this.framename = framename;
    }

    @Override
    public String getEsp() {
        return esp;
    }
    @Override
    public void setEsp(String esp) {
        this.esp = esp;
    }
}
