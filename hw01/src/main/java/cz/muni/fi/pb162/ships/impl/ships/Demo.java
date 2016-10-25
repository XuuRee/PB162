/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.ships.impl.ships;
//import cz.muni.fi.pb162.ships.Ship;

import cz.muni.fi.pb162.ships.Direction;


/**
 * @author xvalchar
 */
public class Demo {
    /**
     * Demo class, play with classes and other shit.
     * @param args argument is type of string[]
     */
    public static void main(String[] args) {
        ScoutingShip scoutingShip = new ScoutingShip();
        Frigate frigateShip = new Frigate();
        Cruiser cruiserShip = new Cruiser();
        
        scoutingShip.setBoardPlacement(4, 3, Direction.NORTH);
        
        System.out.println(scoutingShip.toString());
        System.out.println(frigateShip.toString());
        System.out.println(cruiserShip.toString());
        System.out.println(scoutingShip.toStringAnotherInfo());
    }
}
