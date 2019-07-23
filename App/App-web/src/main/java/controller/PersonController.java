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
import model.PersonsFacade;
/**
 *
 * @author Krisztian
 */
@Named(value = "personController")
@SessionScoped
public class PersonController implements Serializable {

    @EJB
    private AppsFacade appsFacade;

    @EJB
    private PersonsFacade personsFacade;
    private Persons p = new Persons();
    private String appIDS;

    public String getAppIDS() {
        return appIDS;
    }

    public void setAppIDS(String appIDS) {
        this.appIDS = appIDS;
    }

    public Persons getP() {
        return p;
    }

    public void setP(Persons p) {
        this.p = p;
    }
    
    
    public PersonController() {
    }
    
    public List<Persons> findAll(){
        return personsFacade.findAll();   
    }
    
    public List<String> appName(Persons p){
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0;i<p.getAppsList().size();i++){
            names.add(p.getAppsList().get(i).getAppname());
        }
        return names;
    }
    
    public String add(){
        List<Persons> persons= findAll();
        if(persons.size()>0)
            p.setPersonid(persons.get(persons.size()-1).getPersonid().add(BigDecimal.ONE));
        else
            p.setPersonid(BigDecimal.ONE);

        ArrayList<Apps> addedApps = new ArrayList<>();
        Apps app = new Apps();
        
        String[] names = appIDS.split(",");

        for(int i=0;i<names.length;i++){
            app=appsFacade.find(Integer.valueOf(names[i]));
            addedApps.add(app);
        }
        
        p.setAppsList(addedApps);
        personsFacade.create(p);
        p = new Persons();
        return "index"; 
    }
    
    public void delete (Persons p){
        personsFacade.remove(p);
    }
            
}
