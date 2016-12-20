/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing a triangle
 * 
 * @author Filip Valcháø
 * @version 2016 7 11
 */
public class Triangle extends ArrayPolygon implements Solid {
    
    private Triangle subTriangleA = null;
    private Triangle subTriangleB = null;
    private Triangle subTriangleC = null;
    
    public static final double EPSILON = 0.001;
    
    /**
     * Constructor
     * 
     * @param pointA point of Triangle
     * @param pointB point of Triangle
     * @param pointC point of Triangle
     */
    public Triangle(Vertex2D pointA, Vertex2D pointB, Vertex2D pointC) {
        super(new Vertex2D[] {pointA, pointB, pointC});
    }
    
    /**
     * Overloaded constructor
     * 
     * @param pointA point of Triangle
     * @param pointB point of Triangle
     * @param pointC point of Triangle
     * @param depth depth of Sierpinski triangle
     */
    public Triangle(Vertex2D pointA, Vertex2D pointB, Vertex2D pointC, int depth) {
        this(pointA, pointB, pointC);
        divide(depth);
    }
    
    /**
     * Method check if triangle is divided
     * 
     * @return boolean according to pointAB, pointBC and pointAC is null or not
     */
    public boolean isDivided() {
        return subTriangleA != null;
    }
    
    /**
     * Method find subtriangle and returns his points
     * 
     * @param i is integer between <0,2>
     * @return points of triangle or null 
     */
    public Triangle getSubTriangle(int i) {
        if(!isDivided()) {
            return null;
        } else {
            switch(i) {
                case 0: return subTriangleA;
                case 1: return subTriangleB;
                case 2: return subTriangleC;
                default: return null;
            }
        }
    }
 
    /**
     * Divide triangle
     * 
     * @return The boolean value true if triangle was divided 
     */ 
    public boolean divide() {
        if(!isDivided()) {
            Vertex2D subVertA = new Vertex2D(((super.getVertex(0).getX() + super.getVertex(1).getX()) / 2),((super.getVertex(0).getY() + super.getVertex(1).getY()) / 2));
            Vertex2D subVertB = new Vertex2D(((super.getVertex(1).getX() + super.getVertex(2).getX()) / 2),((super.getVertex(1).getY() + super.getVertex(2).getY()) / 2));
            Vertex2D subVertC = new Vertex2D(((super.getVertex(2).getX() + super.getVertex(0).getX()) / 2),((super.getVertex(2).getY() + super.getVertex(0).getY()) / 2));
        
            subTriangleA = new Triangle(super.getVertex(0), subVertA, subVertC);
            subTriangleB = new Triangle(subVertA, super.getVertex(1), subVertB);
            subTriangleC = new Triangle(super.getVertex(2), subVertC, subVertB);
            
            return true;
        } else {
            return false;
        }
    } 
    
    /**
     * Divide triangle with known depth  
     * 
     * @param depth number of subtriangles
     */
    public void divide(int depth) {
        if (depth > 0) { 
            divide();
            getSubTriangle(0).divide(depth - 1);
            getSubTriangle(1).divide(depth - 1);
            getSubTriangle(2).divide(depth - 1);
        }
    }
    
    /**
     * Method check if triangle is equilateral  
     * 
     * @return The boolean value according to triangle is equilateral or not
     */ 
    public boolean isEquilateral() {
        double d1 = super.getVertex(0).distance(super.getVertex(1));
        double d2 = super.getVertex(0).distance(super.getVertex(2));
        double d3 = super.getVertex(1).distance(super.getVertex(2));
        
        return(Math.abs(d1 - d2) < EPSILON && Math.abs(d1 - d3) < EPSILON);
    }

}