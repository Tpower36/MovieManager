/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import ch.hearc.ig.odi.moviemanager.exception.DuplicateElementException;
import ch.hearc.ig.odi.moviemanager.exception.ElementNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thierry.hubmann
 */
public class Person {
    private Long id;
    private String firstname;
    private String lastname;
    private Map<Long, Movie> movies;

    public Person(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        movies = new HashMap();
    }
    
    /**
     * Cette méthode permet d'ajouter un film. On vérifie d'abbord si la personne
     * n'a pas déjà vu le film et on ajoute la personne à la liste des personnes
     * qui ont vues le film. On ajoute également le film à la liste des films vus
     * par cette personne.
     * @param movie Le film que la personne à vue
     * @throws DuplicateElementException
     */
    public void addMovie(Movie movie) throws DuplicateElementException{
        if(!movie.getPeople().containsKey(id)){
            movies.put(movie.getId(), movie);
            movie.getPeople().put(id, this);
        }
        else{
            throw new DuplicateElementException("La personne à déjà vu ce film");
        }
        
    }
    
    /**
     * Cette méthode va supprimer un film de la liste des films vus par cette personne
     * @param movie Le film à supprimer
     * @throws ElementNotFoundException 
     */
    public void unassignMovie(Movie movie) throws ElementNotFoundException{
        if(movie.getPeople().containsKey(id)){
            movies.remove(movie.getId());
            movie.getPeople().remove(id);
        }
        else{
            throw new ElementNotFoundException("La personne n'a pas vue ce film");
        }
    }
    /**
     * Cette méthode retourne la liste des films convertie en ArrayList
     * @return Une ArrayList de films.
     */
    public List getMoviesList(){
        return new ArrayList(getMovies().values());
    }
    
    /**
     * Cette méthode retourne le nombre de films vu par la personne
     * @return le nombre de films vus
     */
    public int getNumberOfMovies(){
        return movies.size();
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

    public Map getMovies() {
        return movies;
    }

    public void setMovies(Map movies) {
        this.movies = movies;
    }
    
    
}
