/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.parking.impl;

import cz.muni.fi.pb162.parking.ParkingLot;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a parking lot
 * 
 * @author Filip Valchář
 */
public class ParkingLotImpl implements ParkingLot {

    private final ArrayList<Car> list;
    
    /**
     * Constructor
     * 
     * @param capacity size of parking lot
     */
    public ParkingLotImpl(int capacity) {
        this.list = new ArrayList<>();
        for(int i = 0; i < capacity; i++) {
            list.add(null);
        }
    }
    
    @Override
    public int parkInPlace(Car car, int place) throws PlaceOccupiedException, IllegalArgumentException {
        if(car == null) { 
            throw new IllegalArgumentException("Illegal argument !");
        }
        
        if(place > getCapacity() || place < 0) {
            throw new IllegalArgumentException("Illegal argument !");
        }
        
        if(list.get(place) instanceof Car) {
            throw new PlaceOccupiedException("Place is occupied !");
        } 
        
        if(list.contains(car)) {
            int previous = list.indexOf(car);
            list.remove(car);
            list.set(place, car);
            return previous;
        }
        
        list.set(place, car);
        return -1;
    }

    @Override
    public int findCarNumber(Car car) {
        return list.indexOf(car);
    }

    @Override
    public ParkingTicketType leaveParking(Car car) {
        if(car.getTicket() == null) {
            list.remove(car);
            list.add(null);
            return ParkingTicketType.MISSING;
        }
        if(car.getTicket().hasExpired()) {
            list.remove(car);
            list.add(null);
            car.removeTicket();
            return ParkingTicketType.EXPIRED;
        } else { 
            list.remove(car);
            list.add(null);
            car.removeTicket();
            return ParkingTicketType.VALID;
        }
    }

    @Override
    public Collection<Car> getParkedCars() {
        Collection<Car> carList = new ArrayList<>();
 
        for(Car car : list) {
            if(car instanceof Car) {
                carList.add(car);
            }
        }
        
        return carList;
    }

    @Override
    public int getCapacity() {
        return list.size();
    }

    @Override
    public boolean isSpaceOccupied(int parkingNumber) {
        return list.get(parkingNumber) != null;
    }

    @Override
    public boolean isFull() {
        return getCapacity() == getParkedCars().size();
    }

    @Override
    public int getFreeParkingPlace() throws PlaceOccupiedException {
        if(isFull()) {
            throw new PlaceOccupiedException("Place is occupied !");
        } 
           
        return getFreePlaces().iterator().next();
    }

    @Override
    public Collection<Integer> getFreePlaces() {
        Collection<Integer> vacantPlaces = new ArrayList<>();
        
        for(int i = 0; i < getCapacity(); i++) {
            if(!isSpaceOccupied(i)) {
                vacantPlaces.add(i);
            }
        }
        
        return vacantPlaces;
    }

    @Override
    public Set<Person> getExpiredCarOwners() {
        Set<Person> expireOwners = new HashSet<>();
        
        for(Car car : list) {
            if(car.getTicket().hasExpired()) {
                expireOwners.add(car.getOwner());
            }   
        }
        
        return expireOwners;
    }
    
}
