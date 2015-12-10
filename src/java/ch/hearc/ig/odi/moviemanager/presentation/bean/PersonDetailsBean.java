/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.bean;

import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author thierry.hubmann
 */
@Named(value = "personDetailsBean")
@SessionScoped
public class PersonDetailsBean implements Serializable{

    @Inject
    Services services;
    private Person person;

    /**
     * Creates a new instance of PersonDetailsBean
     */
    public PersonDetailsBean() {
    }
    
    /**
     * Cette méthode permet de récupérer la personne sur laquelle l'utilisateur
     * à cliqué pour ensuite pouvoir afficher ses détails.
     * @param person la personne cliquée
     * @return 0 si tout s'est bien passé et un code erreur dans le cas opposé
     */
    public int recupPerson(Person person){
        if(person != null){
            this.person = person;
            return 0;
        }
        else{
            return 1; //Not found
        }
        
        
    }

    public Person getPerson() {
        return person;
    }

}
