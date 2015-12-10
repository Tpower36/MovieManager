/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author thierry.hubmann
 */
@Named(value = "movieDetailsBean")
@SessionScoped
public class MovieDetailsBean implements Serializable {

    Movie movie;

    @Inject
    Services services;

    /**
     * Creates a new instance of MovieDetailsBean
     */
    public MovieDetailsBean() {
    }
    
    /**
     * Cette méthode permet de récupérer le film sur lequel l'utilisateur
     * à cliqué pour ensuite pouvoir afficher ses détails.
     * @param movie le film cliqué
     * @return 0 si tout s'est bien passé et un code erreur dans le cas opposé
     */
    public int recupMovie(Movie movie) {
        if (movie != null) {
            this.movie = movie;
            return 0;
        } else {
            return 1; //Not found
        }
    }

    public Movie getMovie() {
        return movie;
    }
    
    
}
