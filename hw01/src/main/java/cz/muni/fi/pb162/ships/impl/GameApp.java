/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.ships.impl;

import cz.muni.fi.pb162.ships.PlayingBoard;
import cz.muni.fi.pb162.ships.Ship;
import cz.muni.fi.pb162.ships.game.AbstractGameApp;
import cz.muni.fi.pb162.ships.game.Game;
import cz.muni.fi.pb162.ships.impl.ships.Cruiser;
import cz.muni.fi.pb162.ships.impl.ships.Frigate;
import cz.muni.fi.pb162.ships.impl.ships.ScoutingShip;

/**
 * Class representing a single turn in the game
 * 
 * @author Filip Valcháø
 */
public class GameApp extends AbstractGameApp {

    /**
     * Constructor 
     * 
     * @param game game 
     */
    public GameApp(Game game) {
        super(game);
    }

    @Override
    protected boolean playTurn(String input) {
        String delims = "[ ]+";
        String[] tokens = input.split(delims);
        int[] numbers = new int[2];
        
        if(tokens.length != 2) {
            return false;
        } else {
            for(int i = 0; i < tokens.length; i++) {
                numbers[i] = Integer.parseInt(tokens[i]);
            }
            
            getGame().hit(numbers[0], numbers[1]);
            
            return true;
        }
    }
    
     /**
      * Program entry point
      * 
      * @param args command line arguments (not supported)
      */
     public static void main(String[] args) {
         PlayingBoard board = new DefaultPlayingBoard(5,5);
         Game g = new Game(board);
         
         Ship scoutingShip = new ScoutingShip();
         Ship cruiser = new Cruiser();
         Ship frigate = new Frigate();
         
         g.placeShips(scoutingShip, cruiser, frigate);
         
         AbstractGameApp app = new GameApp(g);
         
         app.run();
     }
    
}
