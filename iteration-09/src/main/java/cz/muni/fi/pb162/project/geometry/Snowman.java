/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing a Snowman (circles, circles and smaller circles)
 * 
 * @author Filip Valcháø 
 * @version 2016 10 15
 */
public class Snowman {
    
    private Circle bottomBall = null;
    private Circle middleBall = null;
    private Circle topBall = null;
    private Circle leftBall = null;
    private Circle rightBall = null;
    private double factor = 0;

    private static final double FAC = 0.8;
    
    /**
     * Constructor for Snowman (creates 5 circles formed in snowman shape - 3 circles body, 2 circles hands)
     * 
     * @param radius parameter radius of center
     * @param factor parameter factor is the shrinking factor of circles.
     */
    public Snowman(double radius, double factor) {
        if ( factor < 0 || factor > 1) {
            this.factor = FAC;
        } else {
            this.factor = factor;
        }
        
        this.bottomBall = createBall(new Vertex2D(0,0), radius);
        this.middleBall = createBall(new Vertex2D(0, (radius + radius * factor)), getRadius(radius, 1));
        this.topBall = createBall(new Vertex2D(0, radius + ((2*radius) * factor) + (radius * Math.pow(factor, 2))), getRadius(radius, 2));    
        this.rightBall = createBall(new Vertex2D((getRadius(radius, 1) + (getRadius(radius, 1)/2)), (radius + radius * factor)), getRadius(radius, 1)/2);
        this.leftBall = createBall(new Vertex2D(-(getRadius(radius, 1) + (getRadius(radius, 1)/2)), (radius + radius * factor)), getRadius(radius, 1)/2);
    }
    
    /**
     * Getter for bottom ball
     * 
     * @return Circle object bottomBall
     */
    public Circle getBottomBall() {
        return bottomBall;
    }
    
    /**
     * Getter for middle ball
     * 
     * @return Circle object middleBall
     */
    public Circle getMiddleBall() {
        return middleBall;
    }
    
    /**
     * Getter for top ball
     * 
     * @return Circle object topBall
     */
    public Circle getTopBall() {
        return topBall;
    }
    
    /**
     * Getter for left hand ball
     * 
     * @return Circle object leftBall
     */
    public Circle getLeftHandBall() {
        return leftBall;
    }
    
    /**
     * Getter for right hand ball
     * 
     * @return Circle object rightBall
     */
    public Circle getRightHandBall() {
        return rightBall;
    }
    
    /**
     * Method to calculate radius of ball
     * 
     * @param Double parameter radius marks radius of circle from it's center.
     * @param Integer parameter ball is number of ball we want to create
     * @return Radius of given ball as type Double
     */
    private double getRadius (double radius, int ball) {
        if (ball <= 0) {
            return radius;
        } else {
            return radius * Math.pow(factor, ball);
        }
    }
    
    /**
     * Method to create ball from given parameters
     * 
     * @param Vertex2D center of circle given by X, Y coordinates
     * @param Double parameter radius marks radius of circle from its center
     * @return mew Circle object
     */
    private Circle createBall(Vertex2D center, double radius) {
        return new Circle(center, radius);
    }
    
}
