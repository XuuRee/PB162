/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.db;

/**
 * @author xvalchar
 */
public class DbException extends Exception {
    
    /**
     * Constructor
     */
    public DbException() {
        super();
    }
    /**
     * Constructor 
     * 
     * @param msg a 
     */
    public DbException(String msg) {
        super(msg);
    }
    
    /**
     * Constructor
     * 
     * @param msg a
     * @param cause 
     */
    public DbException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    /**
     * Constructor
     * 
     * @param cause 
     */
    public DbException(Throwable cause) {
        super(cause);
    }
    
}
