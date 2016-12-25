/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.parking.impl;

/**
 * Class representing exception place occupied
 * 
 * @author Filip Valchář
 */
public class PlaceOccupiedException extends Exception {
    
    /**
     * Constructor
     */
    public PlaceOccupiedException() {
        super();
    }
    
    /**
     * Constructor 
     * 
     * @param msg message
     */
    public PlaceOccupiedException(String msg) {
        super(msg);
    }
    
    /**
     * Constructor
     * 
     * @param msg message
     * @param cause cause of exception
     */
    public PlaceOccupiedException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    /**
     * Constructor
     * 
     * @param cause cause of exception
     */
    public PlaceOccupiedException(Throwable cause) {
        super(cause);
    }
    
}
