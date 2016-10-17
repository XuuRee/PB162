/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class Vertex2D {
    private double x;
    private double y;

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
        return("[" + x + ", " + y + "]");
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
}