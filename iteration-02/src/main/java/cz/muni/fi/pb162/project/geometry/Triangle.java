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
    
    private Triangle subTriangleA = null;
    private Triangle subTriangleB = null;
    private Triangle subTriangleC = null;
    
    private boolean divideTriangle = false;
    
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
        if(getVertexA() != null && getVertexB() != null && getVertexC() != null) {
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
        return(divideTriangle);
        //return(subTriangleA == null && subTriangleB == null && subTriangleC == null ); // different?
    }
    
    /**
     * Method find subtriangle and returns his points
     * 
     * @param i is integer between 0-2
     * @return points of triangle or null 
     */
    public Triangle getSubTriangle(int i) {
        if(divide()) {
            switch(i) {
                case 0: return(subTriangleA);
                case 1: return(subTriangleB);
                case 2: return(subTriangleC);
                default: return null;
            }
        }
        
        return null;
    }
 
    /**
     * Method create new points for  
     * 
     * @return The boolean value true if triangle was not divided before and 
     *         creating new points was successful
     */ 
    public boolean divide() {
        if(isDivided()) {
           return false;
        }
        else {
            pointAB = new Vertex2D(((pointA.getX() + pointB.getX()) / 2), ((pointA.getY() + pointB.getY()) / 2));
            pointBC = new Vertex2D(((pointB.getX() + pointC.getX()) / 2), ((pointB.getY() + pointC.getY()) / 2));
            pointAC = new Vertex2D(((pointA.getX() + pointC.getX()) / 2), ((pointA.getY() + pointC.getY()) / 2));
            
            subTriangleA = new Triangle(pointA, pointAB, pointAC);
            subTriangleB = new Triangle(pointAB, pointB, pointBC);
            subTriangleC = new Triangle(pointAC, pointC, pointBC);
            
            divideTriangle = true;
            return true; 
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
        
        if((Math.abs(d1 - d2) < 0.001 ) && (Math.abs(d1 - d3) < 0.001) &&(Math.abs(d2 - d3) < 0.001 )) {
            return true;
        }
        else {
            return false;
        }
    }
}