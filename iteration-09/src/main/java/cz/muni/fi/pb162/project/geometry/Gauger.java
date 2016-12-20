/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

/**
 * Class Gauger with two constructors
 * 
 * @author Filip Valcháø
 * @version 2016 19 17
 */
public class Gauger {
   
    /**
    * Print information about Measurable object
    * 
    * @param m object (measurable)
    */
    public static void printMeasurement(Measurable m) {
        System.out.println(m.toString());
        System.out.println("Length/Perimeter: " + m.getLength());
    }
    
    /**
     * Print information about Measurable object
     * 
     * @param s object (solid)
     */
    public static void printMeasurement(Solid s) {
        printMeasurement((Measurable)s);
        System.out.println("Area: " + s.getArea());
    }
    
}
