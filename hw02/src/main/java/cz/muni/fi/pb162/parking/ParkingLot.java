package cz.muni.fi.pb162.parking;

import cz.muni.fi.pb162.parking.impl.Car;
import cz.muni.fi.pb162.parking.impl.ParkingTicketType;
import cz.muni.fi.pb162.parking.impl.Person;
import cz.muni.fi.pb162.parking.impl.PlaceOccupiedException;

import java.util.Collection;
import java.util.Set;

/**
 * A place where multiple {@link Car}s are stored.
 * The parking lot interface provides methods for storing, removing, searching Cars.
 * <p>
 * Each parked (stored) Car has its own parking number. One car has exactly one number.
 * @author Marek Sabo.
 */
public interface ParkingLot {

    /**
     * Parks the car on a given parking slot, starting from 0.
     * If car is already parked, it is move from one slot to another.
     * @param car car to be stored
     * @param place index of parking slot
     * @return previous parking slot number, -1 if there wasn't any before
     * @throws PlaceOccupiedException when place is already occupied
     * @throws IllegalArgumentException if car is null or place out of range
     */
    int parkInPlace(Car car, int place) throws PlaceOccupiedException, IllegalArgumentException;

    /**
     * Returns number of car's parking slot, or free parking slot if input is null.
     * @param car the car we are looking for
     * @return parking slot number, -1 if not found
     */
    int findCarNumber(Car car);

    /**
     * Removes car from parking lot, its parking ticket is discarded.
     * @param car object to be removed
     * @return MISSING if car has no ticket, VALID if ticked did not expired, EXPIRED otherwise
     * @throws IllegalArgumentException if car is not in parking lot or parameter is null
     */
    ParkingTicketType leaveParking(Car car);

    /**
     * Returns collection of parked cars on parking lot.
     * @return collection of cars
     */
    Collection<Car> getParkedCars();

    /**
     * Returns maximum capacity of the parking lot.
     * @return maximum cars to be stored
     */
    int getCapacity();

    /**
     * Returns true if there is car parked on place with given parking number, false otherwise.
     * @param parkingNumber number of parking place to be checked
     * @return true if there is a car parked
     */
    boolean isSpaceOccupied(int parkingNumber);

    /**
     * Checks if parking lot is fully occupied.
     * @return true if there is no empty slot on parking lot
     */
    boolean isFull();

    /**
     * Finds vacant parking slot. If there are more options, then it should be,
     * but does not need to be the lowest number.
     * @return number of parking slot without a car
     * @throws PlaceOccupiedException if parking lot is fully occupied
     */
    int getFreeParkingPlace() throws PlaceOccupiedException;

    /**
     * Finds all parking numbers with vacant places.
     * @return collection of numbers of free slots
     */
    Collection<Integer> getFreePlaces();

    /**
     * Finds all car owners which have ticket expired.
     * @return unique owners of cars with expired ticket
     */
    Set<Person> getExpiredCarOwners();

}
