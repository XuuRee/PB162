/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xuuree
 * @version 2016-09-10
 */
public class Triangle {
    private Vertex2D pointA = new Vertex2D();
    private Vertex2D pointB = new Vertex2D();
    private Vertex2D pointC = new Vertex2D();
    
    private Vertex2D pointAB = new Vertex2D();
    private Vertex2D pointBC = new Vertex2D();
    private Vertex2D pointAC = new Vertex2D();
    
    public void setVertexA(Vertex2D vert) {
        this.pointA = vert;
    }

    public void setVertexB(Vertex2D vert) {
        this.pointB = vert;
    }

    public void setVertexC(Vertex2D vert) {
        this.pointC = vert;
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
        return("Triangle: vertices=" + pointA.toString() + " " + pointB.toString() + " " + pointC.toString());
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
                case 0: return("Triangle: subTriangle0=" + pointA.toString() + " " + pointAB.toString() + " " + pointAC.toString());
                case 1: return("Triangle: subTriangle1=" + pointAB.toString() + " " + pointB.toString() + " " + pointBC.toString());
                case 2: return("Triangle: subTriangle2=" + pointAC.toString() + " " + pointC.toString() + " " + pointBC.toString());
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
        if(!isDivided()) {
            pointAB.setX((pointA.getX() + pointB.getX()) / 2);
            pointAB.setY((pointA.getY() + pointB.getY()) / 2);
            pointBC.setX((pointB.getX() + pointC.getX()) / 2);
            pointBC.setY((pointB.getY() + pointC.getY()) / 2);
            pointAC.setX((pointA.getX() + pointC.getX()) / 2);
            pointAC.setY((pointA.getY() + pointC.getY()) / 2);
            return true;
        }
        else {
            return false;
        }
    } 
}

