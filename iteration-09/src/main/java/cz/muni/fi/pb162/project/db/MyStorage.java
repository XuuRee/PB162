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

    private Connector connector;
    private int maxAttempts;
    
    /**
     * Constructor 
     * 
     * @param connector connector cant be null
     * @param maxAttempts number of max attempts, cant be less than 1
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
    }
    
    /**
     * Getter variable maxAttempts
     * 
     * @return private variable maxAttempts 
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }
    
    @Override
    public void store(String host, Object data) 
    throws DbUnreachableException, CannotStoreException {
        int attempts = 0;
        Connection connection;
        try {
            connection = connector.getConnection(host);
        } catch (UnknownHostException | NoRouteToHostException ex) {
            throw new DbUnreachableException(ex);    
        } 
        while(attempts < getMaxAttempts()) {
            try {
                connection.sendData(data);
                return;
            } catch (IOException ex) {
                attempts = attempts + 1;            
                if(attempts == getMaxAttempts()) {
                    throw new CannotStoreException(ex);
                }
            }
        }
    }
    
}
