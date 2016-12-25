package cz.muni.fi.pb162.parking.factory;

import cz.muni.fi.pb162.parking.impl.Car;
import cz.muni.fi.pb162.parking.impl.Person;

import java.util.Random;


/**
 * Factory which generates Cars. Every Car is different from the previous ones.
 * @author msabo
 */
public class CarFactory {

    private static final String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();

    /**
     * Generates unique Person and unique Car.
     * @return generated car
     */
    public static Car generateCar() {
        Person randomPerson = PersonFactory.generatePerson();
        return new Car(randomString(7), randomPerson);
    }

    /**
     * Generates random alphanumeric String.
     * @param length length of generated string
     * @return alphanumeric string
     */
    private static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for( int i = 0; i < length; i++) {
            sb.append(SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length())));
        }
        return sb.toString();
    }
}
