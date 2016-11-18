/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Circle;
//import cz.muni.fi.pb162.project.db.MyStorage;

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
        Circle circle = new Circle(point, 1.0);
    }
}

