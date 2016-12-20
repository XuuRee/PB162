/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class Vertex2D implements Comparable<Vertex2D> {
    
    private final double x;
    private final double y;

    //public static final double EPSILON = 0.001;
    
    /**
     * Constructor
     * 
     * @param x first coordinates of point
     * @param y second coordinates of point
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * @return String location of point
     */
    public String toString() {
        return("[" + getX() + ", " + getY() + "]");
    }
    
    /**
     * Method find distance between two points  
     * 
     * @param point second point of the distance
     * @return value -1.0 if point does not exist or count distance between two 
     *         points
     */
    public double distance(Vertex2D point) {
        if(point == null) { 
            return(-1.0); 
        } else {
            return(Math.sqrt((Math.pow(x - point.getX(),2)) + Math.pow(y - point.getY(),2)));
        }
    }   
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vertex2D)) {
            return false;
        }
        
        if (obj == this) {
            return true;
        }
        
        Vertex2D other = (Vertex2D) obj;
        // EPSILON, porovnavani double
        return this.x == other.x && this.y == other.y;
    }
    
    @Override
    public int hashCode() { 
        return (int) (x * y); 
    }
    
    @Override
    public int compareTo(Vertex2D vertex) {
        int result = Double.compare(x, vertex.getX());
        
        if(result == 0) {
            result = Double.compare(y, vertex.getY());
        }
        
        return result;
    }
}