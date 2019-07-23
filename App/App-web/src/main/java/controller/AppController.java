/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import entities.*;
import java.math.BigDecimal;
import javax.ejb.EJB;
import model.AppsFacade;
/**
 *
 * @author Krisztian
 */
@Named(value = "appController")
@SessionScoped
public class AppController implements Serializable {

    @EJB
    private AppsFacade appsFacade;
    private Apps a = new Apps();

    public Apps getA() {
        return a;
    }

    public void setA(Apps a) {
        this.a = a;
    }
    
    public AppController() {
    }
    
    public List<Apps> findAll(){
        return this.appsFacade.findAll();
        
    }
    
    public Apps find(int appid){
       return  appsFacade.find(appid);  
    }
    
    public List<String> personName(Apps p){
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0;i<p.getPersonsList().size();i++){
            names.add(p.getPersonsList().get(i).getPersonname());
        }
        return names;
    }
    public String add(){
        List<Apps> apps= findAll();
        if(apps.size()>0)
            this.a.setAppid(apps.get(apps.size()-1).getAppid()+1);    
        else
            this.a.setAppid(1); 
        this.appsFacade.create(this.a);   
        a = new Apps();
        return "index";
    }
    
}
