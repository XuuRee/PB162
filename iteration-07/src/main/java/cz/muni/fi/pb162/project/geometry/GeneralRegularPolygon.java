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
    private Color color;
    
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
        setColor(Color.BLACK);
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
    public Color getColor() {
        return color;
    }
   
    @Override
    public final void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Method print number of edges, center, length of edges and color 
     * of polygon.
     * 
     * @return String location of point
     */
    public String toString() {
        return(getNumEdges() + "-gon: center=" + getCenter() + ", " + "edge "
                + "length=" + getEdgeLength() + ", color=" + getColor());
    }
    
    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        double x = getCenter().getX() - getRadius() * Math.cos((index * 2 * Math.PI) / getNumEdges());
        double y = getCenter().getY() - getRadius() * Math.sin((index * 2 * Math.PI) / getNumEdges());
        return new Vertex2D(x,y);
    }
    
    @Override
    public int getNumVertices() {
        return numEdges;
    }
   
    /**
     * Triangulate divide polygon on triangles
     * 
     * @return array of triangles that divide regular polygon 
     */
    public Triangle[] triangulate() {
        Triangle[] triangles = new Triangle[getNumEdges()];
        
        for(int i = 0; i < getNumEdges(); i++) {
            triangles[i] = new Triangle(getCenter(), getVertex(i), getVertex(i + 1));
        }
        
        return triangles;
    }

}
