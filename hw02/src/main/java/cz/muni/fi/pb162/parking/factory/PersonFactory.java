package cz.muni.fi.pb162.parking.factory;

import cz.muni.fi.pb162.parking.impl.Person;

import java.util.Random;

/**
 * Generates random real boy names.
 * @author msabo
 */
public class PersonFactory {

    private static final Random RANDOM = new Random();

    private static final String[] NAMES = { "Adam", "Igor",  "Ivan",  "Jakub", "Jozef", "Marek",  "Matej", "Oliver",
            "Richard", "Samuel", "Vaclav" }; // sorry girls

    private static final String[] SURNAMES = { "Maly", "Velky",  "Sakal",  "Lamos", "Novak", "Novotny",  "Sabo", "Rak",
            "Barbierik", "Matko", "Hrivnak" };

    /**
     * Generates random (unique) Person.
     * @return person
     */
    public static Person generatePerson() {
        String name = generateName();
        String surname = generateSurname();
        String email = (name + surname + "@gmail.com").toLowerCase();
        return new Person(name + " " + surname,  email);
    }

    /**
     * Generates boy name.
     * @return name
     */
    public static String generateName() {
        int index = RANDOM.nextInt(NAMES.length);
        return NAMES[index];
    }

    /**
     * Generates boy surname.
     * @return surname
     */
    public static String generateSurname() {
        int index = RANDOM.nextInt(SURNAMES.length);
        return SURNAMES[index];
    }

}
