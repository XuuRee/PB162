/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.GeneralRegularPolygon;

/**
 * @author xvalchar
 */
public class Demo {
    /**
     * Demo class, play with class like Triangle, Vertex2D etc.
     * @param args argument is type of string[]
     */
    public static void main(String[] args) {
       
        Vertex2D point = new Vertex2D(0.0, 0.0);
        GeneralRegularPolygon polygon = new GeneralRegularPolygon(point, 6, 2.0);
        
        System.out.println(polygon.getNumVertices());
        System.out.println(polygon.getVertex(0));
        System.out.println(polygon.getVertex(1));
        System.out.println(polygon.getVertex(2));
        System.out.println(polygon.getVertex(3));
        System.out.println(polygon.getVertex(4));
        System.out.println(polygon.getVertex(5));
    }
}

