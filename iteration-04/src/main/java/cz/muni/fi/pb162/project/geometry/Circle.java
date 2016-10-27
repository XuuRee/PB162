/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class Circle extends GeneralRegularPolygon implements Solid {
    private double radius;
    
    /**
     * Constructor
     * 
     * @param center center of the circle
     * @param radius radius of the circle
     */
    public Circle(Vertex2D center, double radius) {
        super(center,Integer.MAX_VALUE,0);
        this.radius = radius;
    }
    
    /**
     * Nonparametric constructor
     */
    public Circle() {
        this(new Vertex2D(0,0), 1.0);
    }
    
    @Override
    public double getRadius() {
        return radius;
    }
    
    /*
    @Override
    public Vertex2D getCenter() {
        return center;
    }
    */
    
    /**
     * Method print center of circle and radius
     * 
     * @return String representation of this object
     */
    public String toString() {
        return("Circle: center=" + getCenter() + ", radius=" + getRadius());
    }

    @Override
    public double getArea() {
        return(Math.PI * Math.pow(getRadius(),2)); 
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
        return(2 * Math.PI * getRadius());
    }
}
