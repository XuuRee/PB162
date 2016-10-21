/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class Circle implements Solid {
    private Vertex2D center;
    private double radius;
    
    public static final double PI = 3.141592;
    
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

    @Override
    public double getArea() {
        return(PI * Math.pow(getRadius(),2));
    }

    @Override
    public double getWidth() {
        return(2 * getRadius());
    }

    @Override
    public double getHeight() {
        return(2 * getRadius());
    }

    @Override
    public double getLength() {                                    
        return(2 * PI * getRadius());
    }
}
