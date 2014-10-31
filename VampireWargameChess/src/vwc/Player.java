/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vwc;

/**
 *
 * @author KELVIN
 */
public class Player {
    private String name;
    private int points;
    private char color;
    
    public Player(String n){
        name = n;
        points = 0;
        color = 'X';
    }
    
    public String getName() {
        return name;
    }
    
    public void addpoints(){
        points+=3;
    }
    
    public int getPoints(){
        return points;
    }
    
    public char getColor(){
        return color;
    }
}
