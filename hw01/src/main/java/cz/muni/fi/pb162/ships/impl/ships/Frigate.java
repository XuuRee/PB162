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
 * Class representing a frigate
 * 
 * @author Filip Valcháø
 */
public class Frigate implements Ship {
    
    private final int length;
    private final int width;
    private int latitude;
    private int longitude;
    private ArmorState[][] armor;
    private Direction direction;
    
    /**
     * Constructor without parameter 
     */
    public Frigate() {
        this.length = 5;
        this.width = 1;
        this.armor = new ArmorState[][] { {ArmorState.SOUND, 
                                           ArmorState.SOUND, 
                                           ArmorState.SOUND, 
                                           ArmorState.SOUND, 
                                           ArmorState.SOUND} };   
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
        if(direction == null) {
            return false;
        }
        
        return latitude > 0 && longitude > 0; 
    }

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

    @Override
    public ArmorState getArmor(int x, int y) {
        return armor[x][y];
    }

    @Override
    public ArmorState hit(int x, int y) {
        armor[x][y] = ArmorState.DESTROYED;        
        return armor[x][y];
    }

    @Override
    public boolean isDestroyed() {
        boolean destroyed = true;
        
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < length; j++) {
                if(getArmor(i,j) != ArmorState.DESTROYED) {
                    destroyed = false;
                }
            }
        }
        
        return destroyed;
    }
    
}
