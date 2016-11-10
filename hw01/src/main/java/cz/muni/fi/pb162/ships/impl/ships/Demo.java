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
        ScoutingShip scoutingShipEAST = new ScoutingShip();
        ScoutingShip scoutingShipSOUTH = new ScoutingShip();
        ScoutingShip scoutingShipWEST = new ScoutingShip();
        ScoutingShip scoutingShipNORTH = new ScoutingShip();
        
        //----------------------------------------------------------------------
        
        System.out.println("DEBUG LOD EAST!");
        scoutingShipEAST.setBoardPlacement(2, 2, Direction.EAST);
        if(scoutingShipEAST.isPlacedOnBoard()) {
            System.out.println(scoutingShipEAST.getArmor(0,0));
            System.out.println(scoutingShipEAST.hit(0,0));
            System.out.println(scoutingShipEAST.getArmor(1,0));
            System.out.println(scoutingShipEAST.hit(1,0));
            System.out.println(scoutingShipEAST.getArmor(2,0));
            System.out.println(scoutingShipEAST.hit(2,0));
            if(scoutingShipEAST.isDestroyed()) {
                System.out.println("Ship is destroyed!");
            } else {
                System.out.println("Ship is not destroyed!");
            }
        } else {
            System.out.println("Ship is not on the board!");
        }
        
        //----------------------------------------------------------------------
        
        System.out.println("DEBUG LOD WEST!");
        scoutingShipWEST.setBoardPlacement(3, 3, Direction.WEST);
        if(scoutingShipWEST.isPlacedOnBoard()) {
            System.out.println(scoutingShipWEST.getArmor(0,0));
            System.out.println(scoutingShipWEST.hit(0,0));
            System.out.println(scoutingShipWEST.getArmor(1,0));
            System.out.println(scoutingShipWEST.hit(1,0));
            System.out.println(scoutingShipWEST.getArmor(2,0));
            System.out.println(scoutingShipWEST.hit(2,0));
            if(scoutingShipWEST.isDestroyed()) {
                System.out.println("Ship is destroyed!");
            } else {
                System.out.println("Ship is not destroyed!");
            }
        } else {
            System.out.println("Ship is not on the board!");
        }
        
        //----------------------------------------------------------------------
        
        System.out.println("DEBUG LOD NORTH!");
        scoutingShipNORTH.setBoardPlacement(0, 0, Direction.NORTH);
        if(scoutingShipNORTH.isPlacedOnBoard()) {
            System.out.println(scoutingShipNORTH.getArmor(0,0));
            System.out.println(scoutingShipNORTH.hit(0,0));
            System.out.println(scoutingShipNORTH.getArmor(0,1));
            System.out.println(scoutingShipNORTH.hit(0,1));
            System.out.println(scoutingShipNORTH.getArmor(0,2));
            System.out.println(scoutingShipNORTH.hit(0,2));
            if(scoutingShipNORTH.isDestroyed()) {
                System.out.println("Ship is destroyed!");
            } else {
                System.out.println("Ship is not destroyed!");
            }
        } else {
            System.out.println("Ship is not on the board!");
        }
        
        //----------------------------------------------------------------------
        
        System.out.println("DEBUG LOD SOUTH!");
        scoutingShipSOUTH.setBoardPlacement(5, 5, Direction.SOUTH);
        if(scoutingShipSOUTH.isPlacedOnBoard()) {
            System.out.println(scoutingShipSOUTH.getArmor(0,0));
            System.out.println(scoutingShipSOUTH.hit(0,0));
            System.out.println(scoutingShipSOUTH.getArmor(0,1));
            System.out.println(scoutingShipSOUTH.hit(0,1));
            System.out.println(scoutingShipSOUTH.getArmor(0,2));
            System.out.println(scoutingShipSOUTH.hit(0,2));
            if(scoutingShipSOUTH.isDestroyed()) {
                System.out.println("Ship is destroyed!");
            } else {
                System.out.println("Ship is not destroyed!");
            }
        } else {
            System.out.println("Ship is not on the board!");
        }
        
        //----------------------------------------------------------------------
        /*
        Cruiser cruiserShip = new Cruiser();
       
        cruiserShip.setBoardPlacement(1, 4, Direction.SOUTH);
        if(cruiserShip.isPlacedOnBoard()) {
            System.out.println(cruiserShip.getArmor(0,4));
            System.out.println(cruiserShip.getArmor(0,3));
            System.out.println(cruiserShip.getArmor(0,2));
            System.out.println(cruiserShip.getArmor(0,1));
            System.out.println(cruiserShip.getArmor(0,0));
            System.out.println(cruiserShip.getArmor(1,4));
            System.out.println(cruiserShip.getArmor(1,3));
            System.out.println(cruiserShip.getArmor(1,2));
            System.out.println(cruiserShip.getArmor(1,1));
            System.out.println(cruiserShip.getArmor(1,0));
            
            EAST
            System.out.println(cruiserShip.getArmor(0,1));
            System.out.println(cruiserShip.getArmor(1,1));
            System.out.println(cruiserShip.getArmor(2,1));
            System.out.println(cruiserShip.getArmor(3,1));
            System.out.println(cruiserShip.getArmor(4,1));
            System.out.println(cruiserShip.getArmor(0,0));
            System.out.println(cruiserShip.getArmor(1,0));
            System.out.println(cruiserShip.getArmor(2,0));
            System.out.println(cruiserShip.getArmor(3,0));
            System.out.println(cruiserShip.getArmor(4,0));
            */
            /*
            if(scoutingShip.isDestroyed()) {
                System.out.println("Ship is destroyed!");
            } else {
                System.out.println("Ship is not destroyed!");
            }
        } else {
            System.out.println("Ship is not on the board!");
        }*/
    }
}
