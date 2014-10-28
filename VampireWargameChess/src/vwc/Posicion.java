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
        coordenadas[1]=x;
        coordenadas[2]=y;
    }
    
    public int getX(){
        return coordenadas[1];
    }
    
    public int getY(){
        return coordenadas[2];
    }
}
