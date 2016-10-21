package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 *
 * Trida umoznujici vykresleni grafickych objektu pozadovanych v ramci nepovinnych ukolu.
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;
 * @version 2013-09-05
 *
 */

public class DrawExtra02 extends Draw {

    @Override
    public boolean paintTriangle(Triangle triangle) {
        boolean ret = super.paintTriangle(triangle);
        if (!ret) {
            return ret;
        }
        if (!triangle.isDivided()) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            paintTriangle(triangle.getSubTriangle(i));
        }
        return true;
    }

    protected static Triangle cloneTriangle(Triangle tri, double shiftX, double shiftY, int recursion, boolean constr) {
        Vertex2D origA = tri.getVertexA();
        Vertex2D origB = tri.getVertexB();
        Vertex2D origC = tri.getVertexC();
        
        Vertex2D newA = new Vertex2D(origA.getX()+shiftX, origA.getY()+shiftY);
        Vertex2D newB = new Vertex2D(origB.getX()+shiftX, origB.getY()+shiftY);
        Vertex2D newC = new Vertex2D(origC.getX()+shiftX, origC.getY()+shiftY);
        
        if (constr) {
            return new Triangle(newA, newB, newC, recursion);
        } else {
            Triangle ret = new Triangle(newA, newB, newC);
            ret.divide(recursion);
            return ret;
        }
    }
    
    public static void main(String[] args) {
        double triSize = 120; // width/length of single trianle
        double space = 10; // horizontal space between triangles
        Vertex2D v1 = new Vertex2D(-60,-60);
        Vertex2D v2 = new Vertex2D(0,60);
        Vertex2D v3 = new Vertex2D(60,-60);

        Triangle tri = new Triangle(v1, v2, v3, 0);

        Draw canvas = new DrawExtra02();
        
        // first raw
        for (int i = -1; i < 4; i++) {
            double shiftX = (i-1) * (triSize + space);
            double shiftY = triSize;
            Triangle shTri = cloneTriangle(tri, shiftX, shiftY, -1, false);
            if (shTri.divide(i)) canvas.paintTriangle(shTri);
        }

        //second raw
        for (int i = -1; i < 4; i++) {
            double shiftX = (i-1) * (triSize + space);
            double shiftY = -triSize;
            Triangle shTri = cloneTriangle(tri, shiftX, shiftY, i, true);
            canvas.paintTriangle(shTri);
        }
        
        canvas.startPainting();
    }
   
}
