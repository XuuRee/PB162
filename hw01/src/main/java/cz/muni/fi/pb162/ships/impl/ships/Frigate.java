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
public class Frigate implements Ship {
    private final int length;                                                   
    private final int width;
    private final ArmorState[] armor;
    
    private int latitude; 
    private int longitude; 
    private Direction direction;
    
    /**
     * Parameterless Constructor
     */
    public Frigate() {                                                         
        this.length = 5;
        this.width = 1;
        this.armor = new ArmorState[] {ArmorState.SOUND, ArmorState.SOUND, 
                                       ArmorState.SOUND, ArmorState.SOUND, 
                                       ArmorState.SOUND};
    }
        
    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }
    
    @Override
    public void setBoardPlacement(int latitude, int longitude, Direction direction) {
        this.latitude = latitude; 
        this.longitude = longitude;
        this.direction = direction;

    }

    @Override
    public boolean isPlacedOnBoard() {
        if(getLatitude() >= 0 && getLongitude() >= 0) {
            switch(getDirection()) {
                case EAST:
                    return true;
                case SOUTH:
                    if(getLongitude() < getLength()) {
                        return false;
                    }
                    return true;
                case WEST:
                    if(getLatitude() < getLength()) {
                        return false;
                    }
                    return true;
                case NORTH: 
                    return true;
                default: return false;
            }
        }
        return false;
    }

    @Override
    public int getLatitude() {
        return latitude;
    }
    
    @Override
    public int getLongitude() {
        return longitude;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public ArmorState getArmor(int x, int y) {
        switch(getDirection()) {
            // Jdu na vychod -> x nabyva hodnot 0, 1, 2, y porad 0
            case EAST:
                for(int i = 0; i < getLength(); i++) {
                    if(x == i) {
                        return armor[i];
                    }
                }
                return null;
            
            case SOUTH:
                // Jdu na jih -> x porad 0, y nabyva hodnot 0,1,2
                for(int i = 0; i < getLength(); i++) {
                    if(y == i) {
                        return armor[i];
                    }
                }
                return null;
            
            case WEST:
                // Jdu na zapad -> y porad 0, x nabyva hodnot 0,1,2
                for(int i = 0; i < getLength(); i++) {
                    if(x == i) {
                        return armor[i];
                    }
                }
                return null;
            
            case NORTH:
                // Jdu na sever -> x porad 0, y nabyva hodnot 0,1,2
                for(int i = 0; i < getLength(); i++) {
                    if(y == i) {
                        return armor[i];
                    }
                }
                return null;
            
            default:
                return null;
        }
    }

    @Override
    public ArmorState hit(int x, int y) {
        switch(getDirection()) {
            case EAST:
                for(int i = 0; i < getLength(); i++) {
                    if(x == i) {
                        return armor[i] = ArmorState.DESTROYED;
                    }
                }    
                return null;
            
            case SOUTH:
                for(int i = 0; i < getLength(); i++) {
                    if(y == i) {
                        return armor[i] = ArmorState.DESTROYED;
                    }
                }
                return null;
            
            case WEST:
                for(int i = 0; i < getLength(); i++) {
                    if(x == i) {
                        return armor[i] = ArmorState.DESTROYED;
                    }
                }
                return null;
            
            case NORTH:
                for(int i = 0; i < getLength(); i++) {
                    if(y == i) {
                        return armor[i] = ArmorState.DESTROYED;
                    }
                }
                return null;
            
            default:
                return null;
        }
    }
    
    @Override
    public boolean isDestroyed() {
        boolean destroy = true;
        
        switch(getDirection()) {
            case EAST:
                for(int i = 0; i < getLength(); i++) {
                    if( getArmor(i,0)!= ArmorState.DESTROYED ) {
                        destroy = false;
                    }
                }
                return destroy;
            
            case SOUTH:
                for(int i = 0; i < getLength(); i++) {
                    if( getArmor(0,i)!= ArmorState.DESTROYED ) {
                        destroy = false;
                    }
                }
                return destroy;
            
            case WEST:
                for(int i = 0; i < getLength(); i++) {
                    if( getArmor(i,0)!= ArmorState.DESTROYED ) {
                        destroy = false;
                    }
                }
                return destroy;
                
            case NORTH:
                for(int i = 0; i < getLength(); i++) {
                    if( getArmor(0,i)!= ArmorState.DESTROYED ) {
                        destroy = false;
                    }
                }
                return destroy;
            
            default:
                return destroy;
        }
    }    
}