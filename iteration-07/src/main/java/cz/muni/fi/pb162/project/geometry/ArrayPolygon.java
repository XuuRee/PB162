/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;
import java.util.Arrays;

/**
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
 
    /**
     * Invert x and y coordinates
     * 
     * @return inverted ArrayPolygon 
     */
    public ArrayPolygon invert() {
        Vertex2D[] vertexes = new Vertex2D[vertices.length];
        
        for(int i = 0; i < getNumVertices(); i++) {
            vertexes[i] = new Vertex2D(getVertex(i).getX() * (-1), getVertex(i).getY() * (-1));
        }
 
        ArrayPolygon invertPolygon = new ArrayPolygon(vertexes);
        return invertPolygon;
    }
    
    /**
     * Check if polygon have shift first element   
     * 
     * @param pol one of the polygons
     * @return false if polygons are different, true otherwise
     */
    public boolean compareShiftFirstElement(ArrayPolygon pol) {
        int indexFirstElement = -1;
        
        for(int i = 0; i < getNumVertices(); i++) {
            if((getVertex(0).getX() == pol.getVertex(i).getX()) && 
               (getVertex(0).getY() == pol.getVertex(i).getY())) {
                indexFirstElement = i;
            }
        }
   
        int i, j;
        
        for(i = 0, j = indexFirstElement; i < getNumVertices(); i++, j++) {
            if((getVertex(i).getX() != pol.getVertex(j).getX()) || 
               (getVertex(i).getY() != pol.getVertex(j).getY())) {
                return false;
            }
            if(j == getNumVertices() - 1) {
                j = -1;
            }
        }
        
        return true;
    }
    
    /**
     * Reverse points of polygon
     * 
     * @param pol polygon that need to be reversed
     * @return reverse arrayPolygon 
     */
    public ArrayPolygon reverse(ArrayPolygon pol) {
        Vertex2D[] reversePol = new Vertex2D[getNumVertices()];
        
        int i, j;
        
        for(i = 0, j = getNumVertices() - 1; i < getNumVertices(); i++, j--) {
            reversePol[i] = pol.getVertex(j);
        }
        
        /*
        ArrayPolygon reversePolygon = new ArrayPolygon(reversePol);
        return reversePolygon;
        */
        return new ArrayPolygon(reversePol);
    }
    
    /**
     * Compare origin polygon and reverse polygon
     * 
     * @param reversePolygon reverse polygon
     * @return true if origin and reverse polygon are same, false otherwise
     */
    public boolean compareReverse(ArrayPolygon reversePolygon) {
        for(int i = 0; i < getNumVertices(); i++) {
            if((getVertex(i).getX() != reversePolygon.getVertex(i).getX()) || 
               (getVertex(i).getY() != reversePolygon.getVertex(i).getY())) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Compare two polygons
     * 
     * @param pol one of the polygons
     * @return true if two polygons are same, false otherwise
     */
    public boolean compare(ArrayPolygon pol) {
        if(getNumVertices() != pol.getNumVertices()) {
            return false;
        }
        
        if(compareShiftFirstElement(pol)) {
            return true;
        }
        
        ArrayPolygon reversePolygon;
        reversePolygon = reverse(pol);
        
        if(compareReverse(reversePolygon)) {
            return true;
        }
        
        return compareShiftFirstElement(reversePolygon);
    }
}
