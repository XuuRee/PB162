/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.ships.impl.ships;
import cz.muni.fi.pb162.ships.ArmorState;
import cz.muni.fi.pb162.ships.Direction;
import cz.muni.fi.pb162.ships.Ship;

/**
 *
 * @author xvalchar
 */
public class Cruiser implements Ship {
    private final int length;                                                   
    private final int width;
    private final ArmorState armor;
    
    /**
     * Parameterless Constructor
     */
    public Cruiser() {                                                         
        this.length = 5;
        this.width = 2;
        this.armor = ArmorState.REINFORCED;
    }
    
    /**
     * @return String location of point
     */
    public String toString() {
        return("Constructor CruiserShip -> Length: " + getLength() + " " + "Width: " + getWidth() + " " + "Armor: " + getArmor());
    }
    
     @Override
    public int getLength() {
        return(length);
    }

    @Override
    public int getWidth() {
        return(width);
    }
    
    public ArmorState getArmor() {
        return(armor);
    }

    @Override
    public void setBoardPlacement(int latitude, int longitude, Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPlacedOnBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLongitude() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLatitude() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direction getDirection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArmorState getArmor(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArmorState hit(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDestroyed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
