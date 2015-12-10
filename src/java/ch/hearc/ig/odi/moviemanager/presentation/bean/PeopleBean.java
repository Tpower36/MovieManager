/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author thierry.hubmann
 */
@Named(value = "peopleBean")
@RequestScoped
public class PeopleBean {

    @Inject Services services;
    /**
     * Creates a new instance of PeopleBean
     */
    public PeopleBean() {
    }
    
    public List<Person> getPeople(){
        return services.getPeopleList();
    }
}
