/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

/**
 * Class with two attributes which represents a point
 * 
 * @author Filip Valcháø
 * @version 2016 10 11
 */
public class Vertex2D implements Comparable<Vertex2D> {
    
    private final double x;
    private final double y;

    /**
     * Constructor for Vertex2D
     * 
     * @param x first coordinates of point
     * @param y second coordinates of point
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Getter for parameter x
     * 
     * @return double type of value x 
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for parameter y
     * 
     * @return double type of value y 
     */
    public double getY() {
        return y;
    }

    /**
     * Method returning string point in brackets, ie. [x, y]
     * 
     * @return String location of point
     */
    public String toString() {
        return("[" + getX() + ", " + getY() + "]");
    }
    
    /**
     * Method find distance between two points  
     * 
     * @param point second point of the distance
     * @return value -1 if point does not exist or count distance between two points
     */
    public double distance(Vertex2D point) {
        if(point == null) { 
            return(-1.0); 
        } else {
            double pointX = point.getX();
            double pointY = point.getY();
            double distance = (Math.pow(pointX - getX(), 2) + Math.pow(pointY - getY(), 2));
            return Math.sqrt(distance);
        }
    }   
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        
        if (!(obj instanceof Vertex2D)) {
            return false;
        }
        
        Vertex2D other = (Vertex2D) obj;
      
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
    
    @Override
    public int hashCode() { 
        return (int) (getX() * getY()); 
    }
    
    @Override
    public int compareTo(Vertex2D vertex) {
        int result = Double.compare(getX(), vertex.getX());
        
        if(result == 0) {
            result = Double.compare(getY(), vertex.getY());
        }
        
        return result;
    }
    
}