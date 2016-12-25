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
 * Class representing a cruiser
 * 
 * @author Filip Valcháø
 */
public class Cruiser implements Ship {
    
    private final int length;
    private final int width;
    private int latitude;
    private int longitude;
    private ArmorState[][] armor;
    private Direction direction;
    
    /**
     * Constructor without parameter 
     */
    public Cruiser() {
        this.length = 5;
        this.width = 2;
        this.armor = new ArmorState[][] { {ArmorState.REINFORCED, 
                                           ArmorState.REINFORCED, 
                                           ArmorState.REINFORCED, 
                                           ArmorState.REINFORCED, 
                                           ArmorState.REINFORCED}, 
                                          {ArmorState.REINFORCED,
                                           ArmorState.REINFORCED,
                                           ArmorState.REINFORCED,
                                           ArmorState.REINFORCED,
                                           ArmorState.REINFORCED} };  
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
        
        return latitude >= 0 && longitude >= 0; 
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
       switch(armor[x][y]) {
           case REINFORCED: 
                armor[x][y] = ArmorState.SOUND;
                break;
           case SOUND:
                armor[x][y] = ArmorState.DESTROYED;
                break;
       }
        
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
