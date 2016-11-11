/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.ArrayPolygon;

/**
 * @author xvalchar
 */
public class Demo {
    /**
     * Demo class, play with class like Triangle, Vertex2D etc.
     * @param args argument is type of string[]
     */
    public static void main(String[] args) {
       
        /*
        Vertex2D pointA = new Vertex2D(-3.0, -1.0);
        Vertex2D pointB = new Vertex2D(-2.0, -2.0);
        Vertex2D pointC = new Vertex2D(-1.0, -1.0);
       
        Triangle triangle =  new Triangle(pointA, pointB, pointC);
       
        System.out.println(triangle.getHeight());
        System.out.println(triangle.getWidth());
        System.out.println(triangle.getLength());
        System.out.println(triangle.getArea());
       
        ArrayPolygon pol = new ArrayPolygon(new Vertex2D[]{pointA, pointB, pointC});
        
        System.out.println(pol.getVertex(0));
        System.out.println(pol.getVertex(1));
        System.out.println(pol.getVertex(2));
        
        pol = pol.invert();
        
        System.out.println(pol.getVertex(0));
        System.out.println(pol.getVertex(1));
        System.out.println(pol.getVertex(2));
        */
        
         Vertex2D[] vert1 = {
            new Vertex2D(-100,-100),
            new Vertex2D( -40,  10),
            new Vertex2D(  50,  20),
            new Vertex2D(  10, -20),
            new Vertex2D(  60, -40)
        };
        
        Vertex2D[] vert2 = {
            new Vertex2D(  50,  20),
            new Vertex2D(  10, -20),
            new Vertex2D(  60, -40),
            new Vertex2D(-100,-100),
            new Vertex2D( -40,  10)
        };
        
        Vertex2D[] vert3 = {
            new Vertex2D( -40,  10),
            new Vertex2D(-100,-100),
            new Vertex2D(  60, -40),
            new Vertex2D(  10, -20),
            new Vertex2D(  50,  20)
        };
        
        Vertex2D[] vert4 = {
            new Vertex2D( -40,  10),
            new Vertex2D(-100,-100),
            new Vertex2D(  50,  20),
            new Vertex2D(  10, -20),
            new Vertex2D(  60, -40)
        };
        
        if (!new ArrayPolygon(vert1).compare(new ArrayPolygon(vert1))) {
            System.out.println("Chyba implementace compare() - prvni a prvni polygon jsou stejne");
        } else if (!new ArrayPolygon(vert1).compare(new ArrayPolygon(vert2))) {
            System.out.println("Chyba implementace compare() - prvni a druhy polygon jsou stejne");
        } else if (!new ArrayPolygon(vert1).compare(new ArrayPolygon(vert3))) {
            System.out.println("Chyba implementace compare() - prvni a treti polygon jsou stejne");
        } else if (new ArrayPolygon(vert1).compare(new ArrayPolygon(vert4))) {
            System.out.println("Chyba implementace compare() - prvni a ctvrty polygon nejsou stejne");
        } else {
            System.out.println("GRATUJEME - Zda se, ze metoda compare() je spravne");
        }
    }
}

