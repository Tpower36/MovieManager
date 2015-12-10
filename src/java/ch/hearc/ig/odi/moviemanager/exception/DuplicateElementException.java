/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.exception;

/**
 *
 * @author thierry.hubmann
 */
public class DuplicateElementException extends Exception{
    public DuplicateElementException() {
            super();
	}

	/**
	 * 
	 * @param message
	 */
	public DuplicateElementException(String message) {
            super(message);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public DuplicateElementException(String message, Throwable cause) {
            super(message, cause);
	}
    
}
