/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;
import java.util.Arrays;

/**
 * STILL IN PROCESS !!!
 * 
 * @author xvalchar
 */
public class ArrayPolygon extends SimplePolygon {
    
    private final Vertex2D[] vertices;
    
    /**
     * Check if parameter vertices is not null and copy array of vertices to  
     * private final Vertex2D vertices
     * 
     * @param vertices array of points (Vertex2D)
     * @throws IllegalArgumentException if vertices or any vertice in array is null 
     */
    public ArrayPolygon(Vertex2D[] vertices) throws IllegalArgumentException {
        if(vertices == null) {
            throw new IllegalArgumentException("Vertices is null!");
        }
        
        for(int i = 0; i < vertices.length; i++) {
            if(vertices[i] == null) {
                throw new IllegalArgumentException("Vertice " + i + " is null!");
            }
        }
        
        this.vertices = Arrays.copyOf(vertices, vertices.length);
    }
    
    @Override
    public Vertex2D getVertex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Index i is < 0!");
        }
     
        return vertices[index % vertices.length];
    }
 
    @Override
    public int getNumVertices() {
        return vertices.length;
    }
 
    public ArrayPolygon invert() {
        Vertex2D[] vertexes = new Vertex2D[vertices.length];
        
        for(int i = 0; i < getNumVertices(); i++) {
            vertexes[i] = new Vertex2D(getVertex(i).getX() * (-1), getVertex(i).getY() * (-1));
        }
 
        ArrayPolygon invertPolygon = new ArrayPolygon(vertexes);
        return invertPolygon;
    }
    
    public boolean compareShiftFirstElement(ArrayPolygon pol) {
        int indexFirstElement = -1;
         
        for(int i = 0; i < getNumVertices(); i++) {
            if((getVertex(0).getX() == pol.getVertex(i).getX()) && (getVertex(0).getY() == pol.getVertex(i).getY())) {
                indexFirstElement = i;
            }
        }
        
        System.out.println("FIRST ELEMENT   ->     " + indexFirstElement);
        
        int i, j;
        
        for(i = 0, j = indexFirstElement; i < getNumVertices(); i++, j++) {
            System.out.println(i + " " + j + getVertex(i) + " " + pol.getVertex(j));
            if((getVertex(i).getX() != pol.getVertex(j).getX()) || (getVertex(i).getY() != pol.getVertex(j).getY())) {
                return false;
            }
            if(j == getNumVertices() - 1) {
                j = -1;
            }
        }
        
        return true;
    }
    
    public boolean compareReverse(ArrayPolygon pol) {
        return true;
    }
    
    public boolean compare(ArrayPolygon pol) {
        if(getNumVertices() != pol.getNumVertices()) {
            return false;
        }
                 
        if(compareShiftFirstElement(pol)) {
            System.out.println("Posunuti prvniho elementu JE v poradku");
        }
        else {
            System.out.println("Posunuti prvniho elementu NENI v poradku");
        }
        
        return true;
    }
}
