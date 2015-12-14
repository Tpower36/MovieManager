/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.exception.DuplicateElementException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author thierry.hubmann
 */
@Named(value = "movieCreateBean")
@RequestScoped
public class MovieCreateBean {

    @Inject Services services;
    private Long id;
    private String name;
    private String producer;
    /**
     * Creates a new instance of MovieCreateBean
     */
    public MovieCreateBean() {
    }

    /**
     * Cette méthode appelle la méthode de service pour ajouter un film
     * @return un code d'erreur
     */
    public int createMovie(){
        try {
            services.saveMovie(id, name, producer);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    
    
    
}
