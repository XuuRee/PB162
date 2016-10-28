/**
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */

package cz.muni.fi.pb162.ships.impl.ships;
import cz.muni.fi.pb162.ships.ArmorState;
import cz.muni.fi.pb162.ships.Direction;
import cz.muni.fi.pb162.ships.Ship;

/**
 * @author xvalchar
 */
public class ScoutingShip implements Ship 
{
    private final int length;                                                   
    private final int width;
    private final ArmorState[] armor;
    
    private int latitude; 
    private int longitude; 
    private Direction direction;
    
    /**
     * Parameterless Constructor
     */
    public ScoutingShip() {                                     
        this.length = 3;
        this.width = 1;
        this.armor = new ArmorState[] {ArmorState.DESTROYED, ArmorState.REINFORCED, ArmorState.SOUND};
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
     * Should be different kind of setBoardPlacemenet;
     * latitude = x vertex
     * longitude = y vertex
     */
    @Override
    public void setBoardPlacement(int latitude, int longitude, Direction direction) {
       this.latitude = latitude; 
       this.longitude = longitude;
       this.direction = direction;
    }
    
    @Override
    public boolean isPlacedOnBoard() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
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
    
    /**
     * min: 0, max {getWidth() - 1}, AND armor[i]?
     * 
     * @param x coordinates x (sirka lodi, width) 1
     * @param y coordinates y (delka lodi, length) 3 pole [0,1,2]
     * @return ArmorState
     */
    @Override
    public ArmorState getArmor(int x, int y) {
        switch(getDirection()) {
            case EAST:
                if(y == getLongitude()) {
                    for(int i = 0; i < getLength(); i++) {
                        if(x == (getLatitude() + i)) {
                            return armor[i];
                        }
                    }   
                } 
                return null;
            
            case SOUTH:
                if(x == getLatitude()) {
                    for(int i = 0; i < getLength(); i++) {
                        if(y == (getLongitude() - i)) {
                            return armor[i];
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
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDestroyed() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }    
}
