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
        return(length);
    }

    @Override
    public int getWidth() {
        return(width);
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
    
    public void armorToString() {
        System.out.println(armor[0][0]);
        System.out.println(armor[0][1]);
        System.out.println(armor[0][2]);
        System.out.println(armor[0][3]);
        System.out.println(armor[0][4]);
        System.out.println(armor[1][0]);
        System.out.println(armor[1][1]);
        System.out.println(armor[1][2]);
        System.out.println(armor[1][3]);
        System.out.println(armor[1][4]);
    }
    
    @Override
    public void setBoardPlacement(int latitude, int longitude, Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
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
