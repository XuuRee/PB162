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
     * Demo class, play with Triangle and Vertex2D
     * @param args argument is type of string[]
     */
    public static void main(String[] args) {
        Vertex2D pointA = new Vertex2D();
        Vertex2D pointB = new Vertex2D();
        Vertex2D pointC = new Vertex2D();

        pointA.setX(-100);
        pointA.setY(0);
        pointB.setX(0);
        pointB.setY(100);
        pointC.setX(100);
        pointC.setY(-100);
 
        Triangle triangle = new Triangle();
        
        triangle.setVertexA(pointA);
        triangle.setVertexB(pointB);
        triangle.setVertexC(pointC);
                
        System.out.println(triangle.toString());
        System.out.println(triangle.getSubTriangle(0));
        System.out.println(triangle.getSubTriangle(1));
        System.out.println(triangle.getSubTriangle(2));
    }
}

