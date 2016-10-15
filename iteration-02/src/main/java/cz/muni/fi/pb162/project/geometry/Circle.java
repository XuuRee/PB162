/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class Circle {
    private Vertex2D center;
    private double radius;
    
    /**
     * Constructor
     * 
     * @param center center of the circle
     * @param radius radius of the circle
     */
    public Circle(Vertex2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    
    /**
     * Nonparametric constructor
     */
    public Circle() {
        this(new Vertex2D(0,0), 1.0);
    }
    
    public double getRadius() {
        return this.radius;
    }
    
    public Vertex2D getCenter() {
        return this.center;
    }
    
    /**
     * Method print center of circle and radius
     * 
     * @return String representation of this object
     */
    public String toString() {
        return("Circle: center=" + center.toString() + ", radius=" + radius);
    }
}
