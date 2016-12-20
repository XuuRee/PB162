/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

import java.util.Comparator;

/**
 * Class to compare two Vertex2D
 * 
 * @author Filp Valcháø
 * @version 2016 12 20
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {
    
    @Override
    public int compare(Vertex2D a, Vertex2D b) {
        return a.compareTo(b) * (-1);
    }
    
}
