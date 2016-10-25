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
public class ScoutingShip implements Ship {
    private final int length;                                                   // !!! Can be final?
    private final int width;
    private final ArmorState armor;
    
    private int latitude; 
    private int longitude; 
    private Direction direction;
    
    /**
     * Parameterless Constructor
     */
    public ScoutingShip() {                                     
        this.length = 3;
        this.width = 1;
        this.armor = ArmorState.SOUND;
    }

    /**
     * Should not be here!
     * @return String location of point
     */
    public String toString() {
        return("Constructor ScoutingShip -> Length: " + getLength() + " " + "Width: " + getWidth() + " " + "Armor: " + getArmor());
    }
    
    @Override
    public int getLength() {
        return(length);
    }
    
    @Override
    public int getWidth() {
        return(width);
    }

    /**
     * Should not be here!
     * @return armor of the ship
     */
    public ArmorState getArmor() {
        return(armor);
    }
    
    @Override
    public void setBoardPlacement(int latitude, int longitude, Direction direction) {
       this.latitude = latitude;
       this.longitude = longitude;
       this.direction = direction;
    }

    //--------------------------------------------------------------------------
    
    @Override
    public boolean isPlacedOnBoard() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    //--------------------------------------------------------------------------
    
    @Override
    public int getLatitude() {
        return(latitude);
    }
    
    @Override
    public int getLongitude() {
        return(longitude);
    }

    @Override
    public Direction getDirection() {
        return(direction);
    }
    
    public String toStringAnotherInfo() {
        return("LLD -> Latitude: " + getLatitude() + " " + "Longitude: " + getLongitude() + " " + "Direction: " + getDirection());
    }
    
    //--------------------------------------------------------------------------

    @Override
    public ArmorState getArmor(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
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
