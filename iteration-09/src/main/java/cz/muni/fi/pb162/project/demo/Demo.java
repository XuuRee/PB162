/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.LabeledPolygon;

/**
 * @author xvalchar
 */
public class Demo {
    /**
     * Demo class, play with class like Triangle, Vertex2D etc.
     * @param args argument is type of string[]
     */
    public static void main(String[] args) {
       
        LabeledPolygon polygon = new LabeledPolygon();
        
        polygon.addVertex("A", new Vertex2D(-100, -100));
        polygon.addVertex("C", new Vertex2D( 100, -100));
        polygon.addVertex("D", new Vertex2D( 100,  100));
        polygon.addVertex("F", new Vertex2D(-100,  100));
        polygon.addVertex("B", new Vertex2D(   0,    0));
        polygon.addVertex("E", new Vertex2D(   0,    0));
        
        System.out.println(polygon.duplicateVertices());
    }
}

