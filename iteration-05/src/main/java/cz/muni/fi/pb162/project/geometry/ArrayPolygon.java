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
    
}
