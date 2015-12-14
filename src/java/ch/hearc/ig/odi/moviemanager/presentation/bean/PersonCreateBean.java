/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.exception.DuplicateElementException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author thierry.hubmann
 */
@Named(value = "personCreateBean")
@RequestScoped
public class PersonCreateBean {

    @Inject Services services;
    private Long id;
    private String firstname;
    private String lastname;
    
    /**
     * Creates a new instance of PersonCreateBean
     */
    public PersonCreateBean() {
    }

    /**
     * Cette méthode récupère les éléments entrés dans le formulaire et ajoute
     * une personne en appelant la méthode save de la classe de services.
     * @return 
     */
    public int createPerson(){
        try {
            services.savePerson(id, firstname, lastname);
            return 0;
        } catch (DuplicateElementException ex) {
            return 1;
        }
       
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    
}
