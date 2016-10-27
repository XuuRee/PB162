/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class RegularOctagon extends GeneralRegularPolygon {
    /**
     * Constructor
     * 
     * @param center center of polygon
     * @param numEdges number of edges
     * @param edgeLength length of edge
     */
    public RegularOctagon(Vertex2D center, int numEdges, double edgeLength) {
        super(center, numEdges, edgeLength);
    }
    
}
