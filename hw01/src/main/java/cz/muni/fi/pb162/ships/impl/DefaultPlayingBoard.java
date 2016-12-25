/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.muni.fi.pb162.ships.impl;

import cz.muni.fi.pb162.ships.Direction;
import cz.muni.fi.pb162.ships.PlayingBoard;
import cz.muni.fi.pb162.ships.Ship;

/**
 * Class representing a playing board
 * 
 * @author Filip Valcháø
 */
public class DefaultPlayingBoard implements PlayingBoard {

    private final int width;
    private final int height;
    private final Ship[][] board;
    
    /**
     * Constructor 
     * 
     * @param width width of playing board
     * @param height height of playing board
     */
    public DefaultPlayingBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new Ship[width][height];
    }
    
    /**
     * Check if coordinates are well placed on the board
     * 
     * @param ship given ship
     * @return true if coordinates are right, false otherwise 
     */
    private boolean checkCoordinatesOnBoard(Ship ship) {
        
        int longitude = ship.getLongitude();
        int latitude = ship.getLatitude();
        
        switch(ship.getDirection()) {
            case NORTH: 
                if(latitude + ship.getWidth() - 1 > getWidth() || longitude + ship.getLength() - 1 > getHeight()) {
                    return false;
                }
                return true;
            
            case SOUTH: 
                if(latitude > getWidth() || longitude > getHeight()) {
                    return false;
                }
                if(longitude - ship.getLength() + 1 < 0 || latitude - ship.getWidth() + 1 < 0) {
                    return false;
                }
                return true;
                
            case EAST: 
                if(longitude > getHeight()) {
                    return false;
                }
                if(latitude + ship.getLength() - 1 > getWidth() || longitude - ship.getWidth() + 1 < 0) {
                    return false;
                }
                return true;
            
            case WEST: 
                if(latitude > getWidth()) {
                    return false;
                }
                if(longitude + ship.getWidth() - 1 > getHeight() || latitude - ship.getLength() + 1 < 0) {
                    return false;
                }
                return true;
                
            default:
                return false;
        }
    }
    
    /**
     * Check if given ship overlay another ship on board
     * 
     * @param ship given ship that we need save on board
     * @return true if ship is not overlaying another ship, false otherwise
     */
    private boolean overlayingShips(Ship ship) {
        int latitude = ship.getLatitude();
        int longitude = ship.getLongitude();
        
        switch(ship.getDirection()) {
            case NORTH:
                for(int i = latitude; i < latitude + ship.getWidth(); i++) {
                    for(int j = longitude; j < longitude + ship.getLength(); j++) {
                        if(board[i][j] instanceof Ship) {
                            return false;
                        }
                    }
                }
                return true;
            
            case SOUTH:
                for(int i = latitude; i > latitude - ship.getWidth(); i--) {
                    for(int j = longitude; j > longitude - ship.getLength(); j--) {
                        if(board[i][j] instanceof Ship) {
                            return false;
                        }
                    }
                }
                return true;
            
            case EAST:
                for(int i = longitude; i > longitude - ship.getWidth(); i--) {
                    for(int j = latitude; j < latitude + ship.getLength(); j++) {
                        if(board[i][j] instanceof Ship) {
                            return false;
                        }
                    }
                }
                return true;
            
            case WEST:
                for(int i = longitude; i < longitude + ship.getWidth(); i++) {
                    for(int j = latitude; j > latitude - ship.getLength(); j--) {
                        if(board[i][j] instanceof Ship) {
                            return false;
                        }
                    }
                }
                return true;
                
            default:
                return false;
        }
    } 
    
    /**
     * Save coordinates on board 
     * 
     * @param ship given ship that we need save on board
     * @return true if coordinates of ship are saved on board, false otherwise
     */
    private boolean saveCoordinatesOnBoard(Ship ship) {
        int latitude = ship.getLatitude();
        int longitude = ship.getLongitude();
        
        switch(ship.getDirection()) {
            case NORTH:
                for(int i = latitude; i < latitude + ship.getWidth(); i++) {
                    for(int j = longitude; j < longitude + ship.getLength(); j++) {
                        board[i][j] = ship;
                    }
                }
                return true;
            
            case SOUTH:
                for(int i = latitude; i > latitude - ship.getWidth(); i--) {
                    for(int j = longitude; j > longitude - ship.getLength(); j--) {
                        board[i][j] = ship;
                    }
                }
                return true;
            
            case EAST:
                for(int i = longitude; i > longitude - ship.getWidth(); i--) {
                    for(int j = latitude; j < latitude + ship.getLength(); j++) {
                        board[i][j] = ship;
                    }
                }
                return true;
            
            case WEST:
                for(int i = longitude; i < longitude + ship.getWidth(); i++) {
                    for(int j = latitude; j > latitude - ship.getLength(); j--) {
                        board[i][j] = ship;
                    }
                }
                return true;
            
            default:
                return false;
        }
    }

    @Override
    public boolean place(Ship ship, int latitude, int longitude, Direction direction) {
        ship.setBoardPlacement(latitude, longitude, direction);
        
        if(!ship.isPlacedOnBoard()) {
            return false;
        }
        
        if(!checkCoordinatesOnBoard(ship)) {
            return false;
        }
        
        if(!overlayingShips(ship)) {
            return false;
        }
      
        return saveCoordinatesOnBoard(ship);
    }

    @Override
    public Ship get(int latitude, int longitude) {
        return board[latitude][longitude];
    }

    /**
     * Transform coordinates and hit the ship
     * 
     * @param ship given ship
     * @param latitude x coordinates of the hit
     * @param longitude y coordinates of the hit
     * @return ship with hit, or null
     */
    private Ship transformCoordinates(Ship ship, int latitude, int longitude) {
        int x = 0; 
        
        switch(ship.getDirection()) {
            case NORTH:
                for(int i = ship.getLatitude(); i < ship.getLatitude() + ship.getWidth(); i++, x++) {
                    int y = 0;
                    for(int j = ship.getLongitude(); j < ship.getLongitude() + ship.getLength(); j++, y++) {
                        if(i == latitude && j == longitude) {
                            ship.hit(x, y);
                        }
                    }
                }
                break; 
            
            case SOUTH:
                for(int i = ship.getLatitude(); i > ship.getLatitude() - ship.getWidth(); i--, x++) {
                    int y = 0;
                    for(int j = ship.getLongitude(); j > ship.getLongitude() - ship.getLength(); j--, y++) {
                        if(i == latitude && j == longitude) {
                            ship.hit(x, y);
                        }
                    }
                }
                break;
               
            case EAST:
                for(int i = ship.getLongitude(); i > ship.getLongitude() - ship.getWidth(); i--, x++) {
                    int y = 0;
                    for(int j = ship.getLatitude(); j < ship.getLatitude() + ship.getLength(); j++, y++) {
                        if(i == latitude && j == longitude) {
                            ship.hit(x, y);
                        }
                    }
                }
                break;
            
            case WEST:
                for(int i = ship.getLongitude(); i < ship.getLongitude() + ship.getWidth(); i++, x++) {
                    int y = 0;
                    for(int j = ship.getLatitude(); j > ship.getLatitude() - ship.getLength(); j--, y++) {
                        if(i == latitude && j == longitude) {
                            ship.hit(x, y);
                        }
                    }
                }
                break;
        }
        
        return ship;
    }
    
    @Override
    public Ship hit(int latitude, int longitude) {
        Ship ship = get(latitude, longitude);
        
        if(ship == null) {
            return null;
        }
        
        return transformCoordinates(ship, latitude, longitude); 
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    
}

