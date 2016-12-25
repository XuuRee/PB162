package cz.muni.fi.pb162.parking;

import cz.muni.fi.pb162.parking.factory.CarFactory;
import cz.muni.fi.pb162.parking.impl.Car;
import cz.muni.fi.pb162.parking.impl.ParkingLotImpl;
import cz.muni.fi.pb162.parking.impl.ParkingTicketType;
import cz.muni.fi.pb162.parking.impl.Person;
import cz.muni.fi.pb162.parking.impl.PlaceOccupiedException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Class testing ParkingLot.
 * @author msabo
 */
public class ParkingLotTest {

    private static final int MAX_CARS = 3;
    private ParkingLot lot;
    private Car car;
    private Car car2;

    @Before
    public void setUp() throws Exception {
        lot = new ParkingLotImpl(MAX_CARS);

        Person marek = new Person("Marek Sabo", "msabo@email.cz");
        Person jan = new Person("Jan Novotny", "jn@gmail.com");
        car = new Car("PB162FF", marek);
        car2 = new Car("MT134CA", jan);
    }

    @Test
    public void testAttributes() throws Exception {
        Field[] fields = ParkingLotImpl.class.getDeclaredFields();
        int numberOfAttributes = fields.length;
        assertFalse("Too many attributes in " + ParkingLotImpl.class, numberOfAttributes > 2);
        assertTrue("Class does not contain List attribute", Arrays.toString(fields).contains("List"));
    }

    @Test
    public void testParkInPlace() throws Exception {
        final int FIRST = 0;
        final int NEXT = 1;
        int ret = lot.parkInPlace(car, FIRST);
        assertTrue("Car not parked in correct place", lot.findCarNumber(car) == FIRST);
        assertTrue("Return value is incorrect", ret == -1);
        ret = lot.parkInPlace(car, NEXT);
        assertTrue("Car not re-parked", lot.findCarNumber(car) == NEXT);
        assertTrue("Return value is incorrect", ret == FIRST);
    }


    @Test
    public void testParkInPlace2() throws Exception {
        try {
            lot.parkInPlace(null, 0);
            fail("Exception IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException _e) {
            // ok
        }
    }

    @Test
    public void testParkInPlace3() throws Exception {
        try {
            lot.parkInPlace(car, -1);
            fail("Exception IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException _e) {
            // ok
        }
    }

    @Test
    public void testParkInPlace4() throws Exception {
        try {
            lot.parkInPlace(car, MAX_CARS + 1);
            fail("Exception IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException _e) {
            // ok
        }
    }

    @Test
    public void testFindCarNumber() throws Exception {
        final int FIRST = 0;
        final int LAST = MAX_CARS - 1;
        lot.parkInPlace(car, FIRST);
        assertTrue("Didn't find correct place number", lot.findCarNumber(car) == FIRST);
        Car generated = CarFactory.generateCar();
        lot.parkInPlace(generated, LAST);
        assertTrue("Didn't find correct place number", lot.findCarNumber(generated) == LAST);
        assertTrue("Finding non-existing car should return -1", lot.findCarNumber(CarFactory.generateCar()) == -1);
    }

    @Test
    public void testLeaveParking() throws Exception {
        lot.parkInPlace(car, 0);
        assertTrue("Incorrect ticket type returned", lot.leaveParking(car) == ParkingTicketType.MISSING);
        assertTrue("Car not left", lot.findCarNumber(car) == -1);
    }
    
    @Test
    public void testLeaveParking2() throws Exception {
        car.buyTicket(1);
        lot.parkInPlace(car, 0);
        assertTrue("Incorrect ticket type returned", lot.leaveParking(car) == ParkingTicketType.VALID);
        assertTrue("Car not left", lot.findCarNumber(car) == -1);
    }

    @Test
    public void testLeaveParking3() throws Exception {
        car.buyTicket(-1);
        lot.parkInPlace(car, 0);
        assertTrue("Incorrect ticket type returned", lot.leaveParking(car) == ParkingTicketType.EXPIRED);
        assertTrue("Car not left", lot.findCarNumber(car) == -1);
    }

    @Test
    public void testGetParkedCars() throws Exception {
        final String WRONG_SIZE = "Returned parked cars size is not correct";
        final String NOT_CONTAINS = "Returned collection does not contain parked car";
        lot.parkInPlace(car, 0);
        assertTrue(WRONG_SIZE, lot.getParkedCars().size() == 1);
        assertTrue(NOT_CONTAINS, lot.getParkedCars().contains(car));
        Car generated = CarFactory.generateCar();
        lot.parkInPlace(generated, 1);
        assertTrue(WRONG_SIZE, lot.getParkedCars().size() == 2);
        assertTrue(NOT_CONTAINS, lot.getParkedCars().contains(generated));
        lot.leaveParking(car);
        assertTrue(WRONG_SIZE, lot.getParkedCars().size() == 1);
        assertFalse("Returned collection should contain parked car", lot.getParkedCars().contains(car));
    }

    @Test
    public void testGetCapacity() throws Exception {
        assertTrue(lot.getCapacity() == MAX_CARS);
        lot.parkInPlace(car, 0);
        assertTrue(lot.getCapacity() == MAX_CARS);
    }
    @Test
    public void testIsSpaceOccupied() throws Exception {
        final int OCCUPIED = 0;
        lot.parkInPlace(car, OCCUPIED);
        assertTrue(lot.isSpaceOccupied(OCCUPIED));
        assertFalse(lot.isSpaceOccupied(1));
    }

    @Test
    public void testIsFull() throws Exception {
        for (int place = 0; place < MAX_CARS; place++) {
            assertFalse("Lot should not be full!", lot.isFull());
            lot.parkInPlace(CarFactory.generateCar(), place);
        }
        assertTrue(lot.isFull());
    }

    @Test
    public void testGetFreeParkingPlace() throws Exception {
        for (int place = 0; place < MAX_CARS; place++) {
            int freePlace = lot.getFreeParkingPlace();
            assertFalse("Should return free parking place!", lot.isSpaceOccupied(freePlace));
            lot.parkInPlace(CarFactory.generateCar(), place);
        }
        try {
            lot.getFreeParkingPlace();
            fail("PlaceOccupiedException should be thrown");
        } catch (PlaceOccupiedException _e) {
            // ok
        }
    }

    @Test
    public void testGetFreePlaces() throws Exception {
        lot.parkInPlace(car, 0);
        lot.parkInPlace(CarFactory.generateCar(), 1);
        lot.parkInPlace(CarFactory.generateCar(), MAX_CARS - 1);
        Collection<Integer> vacantPlaces = lot.getFreePlaces();
        for (int i = 0; i < MAX_CARS; i++) {
            if (!lot.isSpaceOccupied(i) && !vacantPlaces.contains(i)) {
                fail("Vacant place " + i + " is not in collection");
            }
        }
    }

    @Test
    public void testGetExpiredCarOwners() throws Exception {
        Car car2 = CarFactory.generateCar();
        Car car3 = CarFactory.generateCar();

        car.buyTicket(-1); // negative days to simulate expired ticket
        car2.buyTicket(1);
        car3.buyTicket(-5);

        lot.parkInPlace(car, 0);
        lot.parkInPlace(car2, 1);
        lot.parkInPlace(car3, 2);
        Set<Person> expiredOwners = lot.getExpiredCarOwners();

        assertTrue("Size of set does not match", expiredOwners.size() == 2);
        assertTrue("Owner of expired ticket car is missing", expiredOwners.contains(car.getOwner()));
        assertFalse("Owner of car", expiredOwners.contains(car2.getOwner()));
        assertTrue("Owner of car expired ticket should be in set", expiredOwners.contains(car3.getOwner()));
    }
}