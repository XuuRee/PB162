package cz.muni.fi.pb162.parking;

import cz.muni.fi.pb162.parking.impl.Person;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author msabo
 */
public class PersonTest {

    private Person marek;
    private Person jan;

    @Before
    public void setUp() throws Exception {
        marek = new Person("Marek Sabo", "msabo@email.cz");
        jan = new Person("Jan Novotny", "jn@gmail.com");

    }

    @Test
    public void testAttributes() throws Exception {
        int numberOfAttributes = Person.class.getDeclaredFields().length;
        assertFalse("Too many attributes in class Person", numberOfAttributes > 5);
    }

    @Test
    public void testEquals() throws Exception {
        Person marek1 = new Person("Marek Sabo", "msabo@email.cz");
        assertFalse("People are different.", marek.equals(jan));
        assertFalse("People are different.", marek.equals(marek1));
        marek1.setId(marek.getId());
        assertTrue("Equal of class Person is not set correctly.", marek.equals(marek1));
    }

    @Test
    public void testId() throws Exception {
        int currentId = new Person("Jakub Novak", "jnovak@gmail.com").getId();
        int nextId = new Person("Honza Novak", "hn@gmail.com").getId();
        assertTrue("ID should be in ascending order", currentId + 1 == nextId);
    }


    @Test
    public void testIsAlreadyStored() throws Exception {
        assertTrue("Name should be already stored.", Person.isAlreadyStored(marek.getName()));
        assertFalse("Name is not already stored.", Person.isAlreadyStored("Vasek Matyas"));
    }

}