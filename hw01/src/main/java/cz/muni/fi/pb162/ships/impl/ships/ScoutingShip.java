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
    
    /*
    public void ScoutingShip(int length, int width, ArmorState armor) {
        this.length = length;
        this.width = width;
        this.armor = SOUND;
    }
    */
    
    public ScoutingShip(ArmorState armor) {                                     // !!! this is bad, probably
        this.length = 3;
        this.width = 1;
        this.armor = armor;
    }

    @Override
    public int getLength() {
        return(length);
    }
    
    @Override
    public int getWidth() {
        return(width);
    }

    @Override
    public void setBoardPlacement(int latitude, int longitude, Direction direction) {
       
    }

    @Override
    public boolean isPlacedOnBoard() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLongitude() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLatitude() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Direction getDirection() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

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
