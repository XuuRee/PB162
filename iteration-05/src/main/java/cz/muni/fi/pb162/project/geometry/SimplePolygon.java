/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public abstract class SimplePolygon implements Polygon {
    
    @Override
    public double getArea() {
        double area = 0;
        
        for(int i = 0; i < getNumVertices(); i++) {
            if(getVertex(i+1) != null) {
                area += (getVertex(i).getX() * getVertex(i+1).getY()) - (getVertex(i+1).getX() * getVertex(i).getY());
            }
        }
        
        return area/2;
    }

    @Override
    public double getWidth() {
        double max = getVertex(0).getX();
        double min = getVertex(0).getX();
        
        for(int i = 0; i < getNumVertices(); i++) {
            Math.max(getVertex(i).getX(),max);
            Math.min(getVertex(i).getX(),min);
        }
        
        return max - min;
    }

    @Override
    public double getHeight() {
        double max = getVertex(0).getY();
        double min = getVertex(0).getY();
        
        for(int i = 0; i < getNumVertices(); i++) {
            Math.max(getVertex(i).getY(),max);
            Math.min(getVertex(i).getY(), min);
        } 
        
        return max - min;
    }

    @Override
    public double getLength() {
        double length = 0;
        
        for(int i = 0; i < getNumVertices(); i++) {
            if(getVertex(i+1) != null) {    // !!!
                length = getVertex(i).distance(getVertex(i+1));
            }
        }
        
        return length;
    }

    public String toString() {
        return "Polygon: vertices=";
    }
}
