/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private final Vertex2D center;
    private final int numEdges;
    private final double edgeLength;
    private String color;
    
    /**
     * Constructor
     * 
     * @param center center of polygon
     * @param numEdges number of edges
     * @param edgeLength length of edge
     */
    public GeneralRegularPolygon(Vertex2D center, int numEdges, double edgeLength) {
        this.center = center;
        this.numEdges = numEdges;
        this.edgeLength = edgeLength;
        setColor("black");
    }
    
    @Override
    public int getNumEdges() {
        return numEdges ;
    }

    @Override
    public double getEdgeLength() {
        return edgeLength;
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return(getEdgeLength() / (2 * Math.sin(Math.PI / getNumEdges())) );
    }

    @Override
    public double getArea() {
        return(((getNumEdges() * Math.pow(getRadius(),2) * Math.sin(2*Math.PI / getNumEdges()) ) / 2));
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
        return(getNumEdges() * getEdgeLength());
    }

    @Override
    public String getColor() {
        return color;
    }
   
    @Override
    public final void setColor(String color) {
        this.color = color;
    }
    
    /**
     * @return String location of point
     */
    public String toString() {
        return(getNumEdges() + "-gon: center=" + getCenter() + ", " + "edge "
                + "length=" + getEdgeLength() + ", color=" + getColor());
    }
}
