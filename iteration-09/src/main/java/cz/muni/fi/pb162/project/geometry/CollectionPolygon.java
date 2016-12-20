/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing polygon via list
 * 
 * @author Filip Valcháø
 * @version 2016 11 19
 */
public class CollectionPolygon extends SimplePolygon {

    private List<Vertex2D> list;
    
    /**
     * Constructor
     * 
     * @param vertices array of points (Vertex2D)
     * @throws IllegalArgumentException 
     */
    public CollectionPolygon(Vertex2D[] vertices) throws IllegalArgumentException {
        if(vertices == null) {
            throw new IllegalArgumentException("Vertices is null!");
        }
        
        for(int i = 0; i < vertices.length; i++) {
            if(vertices[i] == null) {
                throw new IllegalArgumentException("Vertice " + i + " is null!");
            }
        }
        
        this.list = new ArrayList<>(Arrays.asList(vertices));
    }
    
    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if(index < 0) {
            throw new IllegalArgumentException("Index i is < 0!");
        }
     
        return list.get(index % list.size());
    }

    @Override
    public int getNumVertices() {
        return list.size();
    }
    
    /**
     * Method return vertices
     * 
     * @return list of vertices
     */
    public Collection<Vertex2D> getVertices() {
        return Collections.unmodifiableList(list);
    }
    
    /**
     * Method invert List of Vertex2D
     * 
     * @return array of inverted polygons
     */
    public CollectionPolygon invert() {
        Vertex2D[] array = new Vertex2D[getNumVertices()];
        int i, j;
        
        for(i = 0, j = getNumVertices() - 1; i < getNumVertices(); i++, j--) {
            array[i] = list.get(j);
        }
        
        return new CollectionPolygon(array); 
    }
    
    /**
     * Remove left most vertices a these vertices return in ArrayList 
     * 
     * @return ArrayList of remove Vertex2D 
     */
    public Collection<Vertex2D> removeLeftmostVertices() {
        
        List<Vertex2D> listVertex = new ArrayList<>();
        Vertex2D mostLeftElement = list.get(0);
        
        for(Vertex2D element : list) {
            if(element.getX() < mostLeftElement.getX()) {
                mostLeftElement = element;
            }
        }
        
        listVertex.add(mostLeftElement);
        list.remove(mostLeftElement);
        
        for(Vertex2D element : list) {
            if(element.getX() == mostLeftElement.getX()) {
                listVertex.add(element);
            }
        }
        
        list.removeAll(listVertex);
        return listVertex;
    }
    
}
