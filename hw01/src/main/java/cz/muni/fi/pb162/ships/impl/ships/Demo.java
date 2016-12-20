/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb162.ships.impl.ships;

import cz.muni.fi.pb162.ships.Ship;

/**
 *
 * @author Filip_000
 */
public class Demo {
 
    /**
     * Class demo, plays with objects; 
     * 
     * @param args String argument
     */
    public static void main(String[] args) {
        
        Ship cruiser = new Cruiser();
        
        System.out.println("CRUISER SHIP ->");
        System.out.println(cruiser.getArmor(0, 0));
        System.out.println(cruiser.getArmor(0, 1));
        System.out.println(cruiser.getArmor(0, 2));
        System.out.println(cruiser.getArmor(0, 3));
        System.out.println(cruiser.getArmor(0, 4));
        System.out.println(cruiser.getArmor(1, 0));
        System.out.println(cruiser.getArmor(1, 1));
        System.out.println(cruiser.getArmor(1, 2));
        System.out.println(cruiser.getArmor(1, 3));
        System.out.println(cruiser.getArmor(1, 4));
        System.out.println(cruiser.isDestroyed());
        System.out.println(cruiser.hit(0,1));
        /*
        System.out.println("SCOUTING SHIP ->");
        System.out.println(scoutingShip.getArmor(0, 0));
        System.out.println(scoutingShip.getArmor(0, 1));
        System.out.println(scoutingShip.getArmor(0, 2));
        System.out.println(scoutingShip.isDestroyed());
        scoutingShip.hit(0,1);
        System.out.println(scoutingShip.getArmor(0, 0));
        System.out.println(scoutingShip.getArmor(0, 1));
        System.out.println(scoutingShip.getArmor(0, 2));
        */
        /*
        System.out.println("FRIGATE ->");
        System.out.println(frigate.isDestroyed());
        frigate.hit(0,1);
        frigate.hit(0,0);
        frigate.hit(0,2);
        frigate.hit(0,3);
        frigate.hit(0,4);
        System.out.println(frigate.isDestroyed());
        System.out.println(frigate.getArmor(0, 0));
        System.out.println(frigate.getArmor(0, 1));
        System.out.println(frigate.getArmor(0, 2));
        System.out.println(frigate.getArmor(0, 3));
        System.out.println(frigate.getArmor(0, 4));
        */
    }
    
}
