/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.ships.impl.ships;

import cz.muni.fi.pb162.ships.Direction;
import cz.muni.fi.pb162.ships.Ship;
import cz.muni.fi.pb162.ships.impl.DefaultPlayingBoard;
import cz.muni.fi.pb162.ships.PlayingBoard;

/**
 *
 * @author Filip_000
 */
public class Demo {
 
    /**
     * Class demo, playing with objects; 
     * 
     * @param args String argument
     */
    public static void main(String[] args) {
        Ship scoutingShip = new ScoutingShip();
        Ship cruiser = new Cruiser();
        Ship frigate = new Frigate();
        
        PlayingBoard board = new DefaultPlayingBoard(9,9);
        
        System.out.println(board.place(cruiser, 0, 0, Direction.NORTH));
        System.out.println(board.place(frigate, 8, 0, Direction.NORTH));
        System.out.println(board.place(scoutingShip, 0, 7, Direction.EAST));
        
        System.out.println(board.get(0, 0).getArmor(0, 0));
        
        board.hit(0, 0);
        
        System.out.println(board.get(0, 0).getArmor(0, 0));
    }
    
}
