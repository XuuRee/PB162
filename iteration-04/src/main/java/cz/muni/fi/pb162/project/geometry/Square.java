/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class Square extends GeneralRegularPolygon {
     
    public Square(Vertex2D center, double edgeLength) {
        super(center, 4, edgeLength);
    }
    
}
