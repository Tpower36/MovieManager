/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.ElementNotFoundException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author thierry.hubmann
 */
@Named(value = "unassignMovieBean")
@RequestScoped
public class UnassignMovieBean {

    @Inject
    Services services;
   
    /**
     * Creates a new instance of UnassignMovieBean
     */
    public UnassignMovieBean() {
    }

    /**
     * Permet d'enlever le film de la liste
     * @param person
     * @param movie
     * @return un code d'erreur, 0 si tout est en ordre
     */
    public int unassignMovie(Person person, Movie movie) {
        try {
            services.unassignMovie(person, movie);
            return 0;
        } catch (ElementNotFoundException ex) {
            return 1;
        }
    }
}
