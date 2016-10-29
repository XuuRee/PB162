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
       
        scoutingShip.setBoardPlacement(0, 0, Direction.NORTH);
        if(scoutingShip.isPlacedOnBoard()) {
            System.out.println(scoutingShip.getArmor(0,0));
            System.out.println(scoutingShip.hit(0,0));
            System.out.println(scoutingShip.getArmor(0,1));
            System.out.println(scoutingShip.hit(0,1));
            System.out.println(scoutingShip.getArmor(0,2));
            System.out.println(scoutingShip.hit(0,2));
            if(scoutingShip.isDestroyed()) {
                System.out.println("Ship is destroyed!");
            } else {
                System.out.println("Ship is not destroyed!");
            }
        } else {
            System.out.println("Ship is not on the board!");
        }
        
        Cruiser cruiserShip = new Cruiser();
        cruiserShip.armorToString();
    }
}
