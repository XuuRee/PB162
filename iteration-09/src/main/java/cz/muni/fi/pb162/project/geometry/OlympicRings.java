/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing a Olympic rings
 * 
 * @author Filip Valcháø 
 * @version 2016 10 21
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
    public void setRingsColors() {
        blueCircle.setColor(Color.BLUE);
        redCircle.setColor(Color.RED);
        yellowCircle.setColor(Color.YELLOW);
        greenCircle.setColor(Color.GREEN);
    }
    
    /**
     * Getter for black Olympic Ring.
     * 
     * @return Circle containing Olympic Ring of given color.
     */
    public Circle getBlackRing() {
        return blackCircle;
    }
    
    /**
     * Getter for blue Olympic Ring.
     * 
     * @return Circle containing Olympic Ring of given color.
     */
    public Circle getBlueRing() {
        return blueCircle;
    }
    
    /**
     * Getter for red Olympic Ring.
     * 
     * @return Circle containing Olympic Ring of given color.
     */
    public Circle getRedRing() {
        return redCircle;
    }
    
    /**
     * Getter for yellow Olympic Ring.
     * 
     * @return Circle containing Olympic Ring of given color.
     */
    public Circle getYellowRing() {
        return yellowCircle;
    }
    
    /**
     * Getter for green Olympic Ring.
     * 
     * @return Circle containing Olympic Ring of given color.
     */
    public Circle getGreenRing() {
        return greenCircle;
    }
    
}
