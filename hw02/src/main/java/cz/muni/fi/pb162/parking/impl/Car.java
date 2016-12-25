/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.parking.impl;

import cz.muni.fi.pb162.parking.ParkingTicket;

/**
 * Class representing a car
 * 
 * @author Filip Valchář
 */
public class Car {
    
    private String registrationPlate;
    private Person person;
    private ParkingTicket ticket;
    
    /**
     * Constructor 
     * 
     * @param registrationPlate registration plate of car
     * @param person person (owner of the car)
     */
    public Car(String registrationPlate, Person person) {
        this.registrationPlate = registrationPlate;
        this.person = person;
        this.ticket = null;
    }
    
    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }
    
    public Person getOwner() {
        return person;
    }

    public void setOwner(Person person) {
        this.person = person;
    }
    
    public ParkingTicket getTicket() {
        return ticket;
    }
    
    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
    
    /**
     * Check if registration plate is valid (length of string is equal to seven 
     * and contains only digits and letters)
     * 
     * @param registrationPlate String contains registration plate 
     * @return true if plate is valid, false otherwise 
     */
    public static boolean isValidPlate(String registrationPlate) {
        
        if(registrationPlate.length() != 7) {
            return false;
        }
        
        for (char ch : registrationPlate.toCharArray()) { 
            if(!Character.isDigit(ch) && !Character.isLetter(ch)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Method buy ticket for single car.
     * 
     * @param days number of days that ticket is not expired 
     * @return False if ticket is already bought, otherwise buy ticket and 
     * return true
     */
    public boolean buyTicket(int days) {
        if(ticket != null) {
            return false;
        }
        
        ticket = new ParkingTicket(days);
        return true;
    }
   
    /**
     * Method remove ticket for single car.
     * 
     * @return False if ticket does not exist, otherwise remove ticket. 
     */
    public boolean removeTicket() {
        if(ticket == null) {
            return false;
        }
        
        ticket = null;
        return true;
    }
    
    @Override
    public String toString() {
        return "Registration plate: " + getRegistrationPlate() + ", Person: " + getOwner();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) {
            return false;
        }
        
        if (!(obj instanceof Car)) {
            return false;
        }
        
        Car other = (Car) obj;
        
        if(!this.registrationPlate.equals(other.registrationPlate)) {     
            return false;
        }
        
        return this.person.equals(other.person);
    }
    
    @Override
    public int hashCode() {
        return (int) registrationPlate.hashCode() * person.hashCode();
    }
    
}
