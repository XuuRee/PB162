/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.ships.impl.ships;

import cz.muni.fi.pb162.ships.Direction;
import cz.muni.fi.pb162.ships.PlayingBoard;
import cz.muni.fi.pb162.ships.Ship;

/**
 * Class representing a playing board
 * 
 * @author Filip Valcháø
 */
public class DefaultPlayingBoard implements PlayingBoard {

    @Override
    public boolean place(Ship ship, int latitude, int longitude, Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ship get(int latitude, int longitude) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ship hit(int latitude, int longitude) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWidth() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
