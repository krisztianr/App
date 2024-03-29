/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Apps;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Krisztian
 */
@Stateless
public class AppsFacade extends AbstractFacade<Apps> {

    @PersistenceContext(unitName = "com.mycompany_App-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AppsFacade() {
        super(Apps.class);
    }
 
    
}
