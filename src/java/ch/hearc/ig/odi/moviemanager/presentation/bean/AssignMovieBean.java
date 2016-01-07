/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.DuplicateElementException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author thierry.hubmann
 */
@Named(value = "assignMovieBean")
@RequestScoped
public class AssignMovieBean {

    @Inject Services services;
    private Movie movieToAssign;
   
   
    
    /**
     * Creates a new instance of AssignMovieBean
     */
    public AssignMovieBean() {
        
    }
    
    /**
     * Cette méthode retourne la liste des films que la personne n'a 
     * pas encore vue
     * @param person
     * @return la liste des films
     */
    public List getUnseenMovies(Person person){
        List<Movie> unseen = new ArrayList<>();
        for (Movie movie : services.getMoviesList()) {
            if(!person.getMovies().containsKey(movie.getId())){
                unseen.add(movie);
            }
        }
        return unseen;
    }
    
    /**
     * Cette méthode permet d'assigner un film à la personne
     * @param person
     * @return un code d'erreur, 0 si tout s'est bien passé
     */
    public int assignMovie(Person person) {
        try {
            services.assignMovieToPerson(movieToAssign, person);
            return 0;
        } catch (DuplicateElementException ex) {
            return 1;
        }
    }

    public Movie getMovieToAssign() {
        return movieToAssign;
    }

    public void setMovieToAssign(Movie movieToAssign) {
        this.movieToAssign = movieToAssign;
    }  
  
}
