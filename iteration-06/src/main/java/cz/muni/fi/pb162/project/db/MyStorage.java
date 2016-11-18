/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.db;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

/**
 * @author xvalchar
 */
public class MyStorage implements Storage {

    private Connector  connector;
    private Connection connection;
    private int        maxAttempts;
    private int        attempts;
    
    /**
     * Constructor 
     * 
     * @param connector a
     * @param maxAttempts 
     */
    public MyStorage(Connector connector, int maxAttempts) {
        if(connector == null) { 
            throw new NullPointerException("Param connector is null !"); 
        }
        
        if(maxAttempts < 1) { 
            throw new IllegalArgumentException("Param maxAttempts is < 1 !"); 
        }
        
        this.connector = connector;
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }
    
    /**
     * Getter variable maxAttempts
     * 
     * @return private variable maxAttempts 
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }
    
    /**
     * Getter variable attempts
     * 
     * @return private variable attempts
     */
    public int getAttempts() {
        return attempts;
    }
    
    @Override
    public void store(String host, Object data) 
    throws DbUnreachableException, CannotStoreException {
        try {
            connection = connector.getConnection(host);
        } catch (UnknownHostException | NoRouteToHostException ex) {
            throw new DbUnreachableException(ex);    
        } 
        while(getAttempts() < getMaxAttempts()) {
            try {
                connection.sendData(data);
                break;
            } catch (IOException ex) {
                attempts = attempts + 1;            
                if(getAttempts() == getMaxAttempts()) {
                    throw new CannotStoreException(ex);
                }
            }
        }
    }
    
}
