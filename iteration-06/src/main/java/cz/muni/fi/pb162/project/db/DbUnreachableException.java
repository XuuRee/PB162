/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.db;

/**
 * @author xvalchar
 */
public class DbUnreachableException extends DbException {
    
    /**
     * Constructor
     */
    public DbUnreachableException() {
        super();
    }
    
    /**
     * Constructor 
     * 
     * @param msg a 
     */
    public DbUnreachableException(String msg) {
        super(msg);
    }
    
    /**
     * Constructor 
     * 
     * @param msg a
     * @param cause 
     */
    public DbUnreachableException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    /**
     * Constructor 
     * 
     * @param cause 
     */
    public DbUnreachableException(Throwable cause) {
        super(cause);
    }
    
}
