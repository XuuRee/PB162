/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing a square
 * 
 * @author Filip Valcháø
 * @version 2016 10 22
 */
public class Square extends GeneralRegularPolygon {
     
    /**
     * Constructor 
     * 
     * @param center center of square
     * @param edgeLength length of edge 
     */
    public Square(Vertex2D center, double edgeLength) {
        super(center, 4, edgeLength);
    }
    
    /**
     * Overloaded constructor, creates square from given length of edge and square center.
     * 
     * @param center center of square
     * @param edgeLength length of edge
     */
    public Square (double edgeLength, Vertex2D center){
        super(center, 4, edgeLength * Math.sqrt(2));
    }
    
}
