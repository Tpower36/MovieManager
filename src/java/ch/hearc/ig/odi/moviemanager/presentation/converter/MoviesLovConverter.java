/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation.converter;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.service.Services;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author thierry.hubmann
 */
@Named(value="moviesLovConverter")
@RequestScoped
public class MoviesLovConverter implements Converter{

    @Inject Services services;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null){
            return null;
        }
        else{
            Movie m = services.getMovieById(Long.valueOf(value));
            return m;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        else if(value instanceof Movie){
            return String.valueOf(((Movie) value).getId());
        }
        else{
            return "";
        }
    }
    
}
