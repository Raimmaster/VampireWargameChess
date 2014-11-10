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
    private int points, piezasPerdidas;
    private char color;
    private boolean active;
    
    public Player(String n){
        name = n;
        points = 0;
        piezasPerdidas = 0;
        color = 'X';
        active = false;
    }
    
    public boolean getActive(){
        return active;
    }

    public void usePlayer(){
        active = true;
    }

    public void disablePlayer(){
        active = false;
    }
    
    public String getName() {
        return name;
    }
    
    public void addpoints(){
        points += 3;
    }
    
    public int getPoints(){
        return points;
    }
    
    public char getColor(){
        return color;
    }
    
    public void setColor(char c){
        color = c;
    }
    
    public void aumentarPiezasPerdidas(){
        piezasPerdidas++;
    }
    
    public void resetPiezasPerdidas(){
        piezasPerdidas = 0;
    }
    
    public int getCantGiros(){
        if (piezasPerdidas >= 4)
            return 3;
        else if (piezasPerdidas >= 2)
            return 2;
        else
            return 1;
    }
}
