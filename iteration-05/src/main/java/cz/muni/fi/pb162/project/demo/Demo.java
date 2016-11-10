/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author xvalchar
 */
public class Demo {
    /**
     * Demo class, play with class like Triangle, Vertex2D etc.
     * @param args argument is type of string[]
     */
    public static void main(String[] args) {
       Vertex2D pointA = new Vertex2D(-3.0, -1.0);
       Vertex2D pointB = new Vertex2D(-2.0, -2.0);
       Vertex2D pointC = new Vertex2D(-1.0, -1.0);
       
       Triangle triangle =  new Triangle(pointA, pointB, pointC);
       
       System.out.println(triangle.getHeight());
       System.out.println(triangle.getWidth());
       System.out.println(triangle.getLength());
       System.out.println(triangle.getArea());
    }
}

