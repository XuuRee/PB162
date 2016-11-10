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
    private final ArmorState[][] armor = new ArmorState[2][5];
    
    private int latitude; 
    private int longitude; 
    private Direction direction;
    
    /**
     * Parameterless Constructor
     */
    public Cruiser() {                                                         
        this.length = 5;
        this.width = 2;
        fillArray(this.armor);
    }
    
     @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }
    
    /**
     * Method fillArray fill 2D array by REINFORCED value
     * 
     * @param armor empty 2D array
     */
    public final void fillArray(ArmorState[][] armor) { 
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                armor[i][j] = ArmorState.REINFORCED;
            }
        }
    }
    
    @Override
    public void setBoardPlacement(int latitude, int longitude, Direction direction) {
        this.latitude = latitude; 
        this.longitude = longitude;
        this.direction = direction;
    }

    /**
     * Musim poresit jestli se lode prekryvaji, pripadne jestli nezachazeji 
     * souradnicemi na opacny konec hraci plochy.
    
    @Override
    public boolean isPlacedOnBoard() {
        if(getLatitude() >= 0 && getLongitude() >= 0) {
            switch(getDirection()) {
                case EAST: 
                    if(getLongitude() < getWidth() - 1) {
                        return false;
                    }
                    return true;
                case SOUTH:
                    if(getLatitude() < getWidth() - 1 || getLongitude() < getLength() - 1) {
                        return false;
                    }
                    return true;
                case WEST:
                    if(getLatitude() < getLength() - 1) {
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
    */
 
    @Override
    public int getLongitude() {
        return longitude;
    }

    @Override
    public int getLatitude() {
        return latitude;
    }

    @Override
    public Direction getDirection() {
         return direction;
    }

    /*
    @Override
    public ArmorState getArmor(int x, int y) {
        switch(getDirection()) {
            case EAST:
                if(y == getLongitude() || y == getLongitude() - 1) { 
                    for(int i = 0; i < getWidth(); i++) {
                        for(int j = 0; j < getLength(); j++) {
                            if(x == (getLatitude() + j) && y == (getLongitude() - i)) {
                                return armor[i][j];
                            }
                        }
                    }   
                } 
                return null;
           
            case SOUTH:
                if(x == getLatitude() || x == (getLatitude() - 1)) {
                    for(int i = 0; i < getWidth(); i++) {
                        for(int j = 0; j < getLength(); j++) {
                            if(y == (getLongitude() - j) && x == (getLatitude() - i)) {
                                return armor[i][j];
                            }
                        }   
                    }
                }
                return null;
    
            case WEST:
                if(y == getLongitude()) {
                    for(int i = 0; i < getLength(); i++) {
                        if(x == (getLatitude() - i)) {
                            return armor[i];
                        }
                    }   
                }
                return null;
            
            case NORTH:
                if(x == getLatitude()) {
                    for(int i = 0; i < getLength(); i++) {
                        if(y == (getLongitude() + i)) {
                            return armor[i];
                        }
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
                if(y == getLongitude() || y == getLongitude() - 1) { 
                    for(int i = 0; i < getWidth(); i++) {
                        for(int j = 0; j < getLength(); j++) {
                            if(x == (getLatitude() + j) && y == (getLongitude() - i)) {
                                if(armor[i][j] == ArmorState.REINFORCED) {
                                    return armor[i][j] = ArmorState.SOUND;
                                } else {
                                    return armor[i][j] = ArmorState.DESTROYED;
                                }
                            }
                        }
                    }   
                } 
                return null;
                
            case SOUTH:
                if(x == getLatitude() || x == (getLatitude() - 1)) {
                    for(int i = 0; i < getWidth(); i++) {
                        for(int j = 0; j < getLength(); j++) {
                            if(y == (getLongitude() - j) && x == (getLatitude() - i)) {
                                if(armor[i][j] == ArmorState.REINFORCED) {
                                    return armor[i][j] = ArmorState.SOUND;
                                } else {
                                    return armor[i][j] = ArmorState.DESTROYED;
                                }
                            }
                        }   
                    }
                }
                return null;
                
            default:
                return null;
        }
    }

    @Override
    public boolean isDestroyed() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
    */
}
