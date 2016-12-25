package cz.muni.fi.pb162.parking.impl;

import java.util.ArrayList;

/**
 * Class represents people.
 */
public class Person {

    private String name;
    private String email;
    private int id;
    private static int incrementId = 1;
    private static ArrayList<String> list = new ArrayList<>();
    
    /**
     * Constructor with 2 parameters.
     * 
     * @param name real name & surname
     * @param email person's email
     */
    public Person(String name, String email) { 
        this.name = name;
        this.email = email;
        id = (incrementId++);
        list.add(name);   
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Static method check if create name is stored. 
     * 
     * @param name searched name
     * @return true if name is already stored, false otherwise
     */
    public static boolean isAlreadyStored(String name) {
        for(String nameList : list) {
            if(nameList.equals(name)) {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "[ ID: " + getId() + ", Name: " + getName() + ", E-mail: " + getEmail() + " ]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        
        if (!(obj instanceof Person)) {
            return false;
        }
        
        Person other = (Person) obj;
        
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }
   
}
