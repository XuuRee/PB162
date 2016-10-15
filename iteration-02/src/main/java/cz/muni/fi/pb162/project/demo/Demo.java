/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Circle;

/**
 * @author xvalchar
 */
public class Demo {
    /**
     * Demo class, play with Triangle and Vertex2D
     * @param args argument is type of string[]
     */
    public static void main(String[] args) {
        Vertex2D pointA = new Vertex2D(-100,0);
        Vertex2D pointB = new Vertex2D(0,100);
        Vertex2D pointC = new Vertex2D(100,-100);
        
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        Circle circle = new Circle(pointA, 2.0);
        
        System.out.println(triangle.toString());
        
        /*
        System.out.println(triangle.getSubTriangle(0));
        System.out.println(triangle.getSubTriangle(1));
        System.out.println(triangle.getSubTriangle(2));
        System.out.println(circle.toString()); 
        */
        
    }
}
