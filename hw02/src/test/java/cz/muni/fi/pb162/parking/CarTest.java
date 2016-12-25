package cz.muni.fi.pb162.parking;

import cz.muni.fi.pb162.parking.impl.Car;
import cz.muni.fi.pb162.parking.impl.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author msabo
 */
public class CarTest {

    private Person marek;
    private Car car;
    private Car car2;
    private Car car3;

    @Before
    public void setUp() throws Exception {
        marek = new Person("Marek Sabo", "msabo@email.cz");
        Person jan = new Person("Jan Novotny", "jn@gmail.com");
        car = new Car("PB162FF", marek);
        car2 = new Car("MT134CA", marek);
        car3 = new Car("MT134CA", jan);
    }


    @Test
    public void testAttributes() throws Exception {
        int numberOfAttributes = Car.class.getDeclaredFields().length;
        assertFalse("Too many attributes in class Ca", numberOfAttributes > 3);
    }

    @Test
    public void testIsValidPlate() throws Exception {
        final String WRONG = "Wrong plate marked as valid.";
        final String CORRECT = "Correct plate was marked invalid.";
        assertTrue(CORRECT, Car.isValidPlate(car.getRegistrationPlate()));
        assertTrue(CORRECT, Car.isValidPlate("101ABCD"));
        assertFalse(WRONG, Car.isValidPlate("wtf123"));
        assertFalse(WRONG, Car.isValidPlate("wtf12345"));
        assertFalse(WRONG, Car.isValidPlate("!@#$.()"));
        assertFalse(WRONG, Car.isValidPlate("MT142!A"));
    }

    @Test
    public void testEquals() throws Exception {
        final String CORRECT = "Same cars marked as different.";
        final String WRONG = "Cars are different, not same!.";
        Car car1 = new Car(car.getRegistrationPlate(), marek);
        assertFalse(WRONG, car.equals(car2) );
        assertFalse(WRONG, car1.equals(car2) );
        assertFalse(WRONG, car2.equals(car1) );
        assertFalse(WRONG, car2.equals(car3) );
        assertTrue(CORRECT, car.equals(car1) );
        assertTrue(CORRECT, car1.equals(car) );

        Person marek1 = marek;
        Car car4 = new Car(car.getRegistrationPlate(), marek1);
        assertTrue(CORRECT, car.equals(car4) );

    }

    @Test
    public void testBuyTicket() throws Exception {
        assertTrue(car.buyTicket(3));
        assertFalse(car.buyTicket(2));
        assertTrue(car2.buyTicket(-1));
    }
}