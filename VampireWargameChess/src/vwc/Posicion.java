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
public class Posicion {
    private int coordenadas[] = new int[2];
    
    public Posicion(int x, int y){
        coordenadas[0] = x;
        coordenadas[1] = y;
    }
    
    public int getX(){
        return coordenadas[0];
    }
    
    public int getY(){
        return coordenadas[1];
    }
    
    public boolean validarPosicion(int px, int py){
        if (px == coordenadas[0] && py == coordenadas[1])
            return true;
        return false;
    }
}
