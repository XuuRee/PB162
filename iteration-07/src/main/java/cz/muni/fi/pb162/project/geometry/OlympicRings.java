/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * @author xvalchar
 */
public class OlympicRings extends Circle {

    private final Circle blackCircle;
    private final Circle blueCircle;
    private final Circle redCircle;
    private final Circle yellowCircle;
    private final Circle greenCircle;
   
    /**
     * Constructor
     * 
     * @param center center of black ring
     * @param radius radius of all circles
     */
    public OlympicRings(Vertex2D center, double radius) {
        blackCircle = new Circle(center, radius);
        redCircle = new Circle(new Vertex2D(center.getX() + 2 * radius + 10, center.getY()), radius);
        blueCircle = new Circle(new Vertex2D(center.getX() - 2 * radius - 10, center.getY()), radius);
        greenCircle = new Circle(new Vertex2D(center.getX() + radius + 5, center.getY() - radius), radius);
        yellowCircle = new Circle(new Vertex2D(center.getX() - radius - 5, center.getY() - radius), radius);
        setRingsColors();
    }
    
    /**
     * Set color on each rings
     */
    public final void setRingsColors() {
        blueCircle.setColor(Color.BLUE);
        redCircle.setColor(Color.RED);
        yellowCircle.setColor(Color.YELLOW);
        greenCircle.setColor(Color.GREEN);
    }
       
    public Circle getBlackRing() {
        return blackCircle;
    }
    
    public Circle getBlueRing() {
        return blueCircle;
    }
    
    public Circle getRedRing() {
        return redCircle;
    }
    
    public Circle getYellowRing() {
        return yellowCircle;
    }
    
    public Circle getGreenRing() {
        return greenCircle;
    }
}
