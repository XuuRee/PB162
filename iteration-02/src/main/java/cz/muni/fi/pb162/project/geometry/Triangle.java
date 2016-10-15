/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class Triangle {
    private Vertex2D pointA;
    private Vertex2D pointB;
    private Vertex2D pointC;
    
    private Vertex2D pointAB;
    private Vertex2D pointBC;
    private Vertex2D pointAC;
    
    /**
     * Constructor
     * 
     * @param pointA point of Triangle
     * @param pointB point of Triangle
     * @param pointC point of Triangle
     */
    public Triangle(Vertex2D pointA, Vertex2D pointB, Vertex2D pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }
    
    public Vertex2D getVertexA() {
        return pointA;
    }

    public Vertex2D getVertexB() {
        return pointB;
    }

    public Vertex2D getVertexC() {
        return pointC;
    }
    
    /**
     * Method print each point of triangle
     * 
     * @return String representation of this object
     */
    public String toString() {
        if(pointA != null && pointB != null && pointC != null) {
            return("Triangle: vertices=" + pointA.toString() + " " + pointB.toString() + " " + pointC.toString());
        }
        else {
            return("INVALID TRIANGLE");
        }
    }
    
    /**
     * Method check if triangle is divided
     * 
     * @return Bool according to pointAB, pointBC and pointAC is null or not
     */
    public boolean isDivided() {
        return(pointAB == null && pointBC == null && pointAC == null);
    }
    
    /**
     * Method find subtriangle and returns his points
     * 
     * @param i is integer between 0-2
     * @return points of triangle or null 
     */
    public String getSubTriangle(int i) {
        if(divide()) {
            switch(i) {
                case 0: return("Triangle: verticeA=" + pointA.toString() + " " 
                                + pointAB.toString() + " " + pointAC.toString());
                case 1: return("Triangle: verticeB=" + pointAB.toString() + " "
                                + pointB.toString() + " " + pointBC.toString());
                case 2: return("Triangle: verticeC=" + pointAC.toString() + " "
                                + pointC.toString() + " " + pointBC.toString());
                default: return null;
            }
        }
        else {
            return null;
        }
    }
 
    /**
     * Method create new points for  
     * 
     * @return The boolean value true if triangle was not divided before and 
     *         creating new points was successful
     */ 
    public boolean divide() {
        if(isDivided()) {
            this.pointAB = new Vertex2D(((pointA.getX() + pointB.getX()) / 2), ((pointA.getY() + pointB.getY()) / 2));
            this.pointBC = new Vertex2D(((pointB.getX() + pointC.getX()) / 2), ((pointB.getY() + pointC.getY()) / 2));
            this.pointAC = new Vertex2D(((pointA.getX() + pointC.getX()) / 2), ((pointA.getY() + pointC.getY()) / 2));
            return true; 
        }
        else {
            return false;
        }
    } 
    
    /**
     * Method check if triangle is equilateral  
     * 
     * @return The boolean value according to triangle is equilateral or not
     */ 
    public boolean isEquilateral() {
        double d1 = pointA.distance(pointB);
        double d2 = pointA.distance(pointC);
        double d3 = pointB.distance(pointC);
        
        if((Math.abs(d1 - d2) < 0.001 ) && (Math.abs(d2 - d3) < 0.001 )) {
            return true;
        }
        else {
            return false;
        }
    }
}

