/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwc;

import java.util.ArrayList;

/**
 *
 * @author Raim
 */
public abstract class Pieza {
    protected String tipo; //nombre del tipo de pieza
    protected int row, column; //coordenadas de la posición de la pieza
    protected int hp; //health points
    protected int sp; //shield points
    protected int ap; //attack points
    protected ArrayList<Posicion> posiciones = new ArrayList<>();
    
    /**
     * Constructor de pieza
     * @param h Cantidad de HP que tendrá
     * @param s Cantidad de SP que tendrá
     * @param a Cantidad de AP que tendrá
     * @param r Número de fila
     * @param c Número de columna
     * @param t Nombre del tipo
     */
    public Pieza(int h, int s, int a, int r, int c, String t){
        tipo = t;
        row = r;
        column = s;
        hp = h;
        sp = s;
        ap = a;
    }
    
    /**
     * Realiza la acción necesaria de ataque
     * @param p Objeto Pieza que se quiere atacar
     */
    public abstract void atacar(Pieza p);
    
    /**
     * Valida la posición de la pieza
     * @param fila Número de la fila de pieza
     * @param columna Número de la columna de la pieza
     * @return true si esa es la coordenada
     */
    public boolean validarPosicion(int fila, int columna){
        if (fila == row && columna == column)
            return true;
        
        return false;
    }
    
    /**
     * Mover la pieza a la coordenada especificada
     * @param fila Número de la fila donde nos queremos mover
     * @param columna Número de la columna donde nos queremos mover
     */
    public abstract void mover (int fila, int columna);
    
    /**
     * Recibir el dano ocasionado por x pieza
     * @param ap Cantidad de dano inflingido
     */
    public abstract void defender(int ap);
    
    /**
     * Funcion para validar el movimiento de x pieza
     * @param fila Posicion de la fila a la que se desea mover
     * @param columna Posicion de la columna a la que se desea mover
     * @return 
     */
    public abstract Boolean validarMovimiento(int fila, int columna);
    
    /**
     * Funcion para actualizar las posiciones a las que la pieza x se puede mover
     */
    public abstract void updatePosiciones();
    
    @Override
    public String toString() {
        return "Pieza{" + "tipo=" + tipo + ", hp=" + hp + ", sp=" + sp + ", ap=" + ap + '}';
    }
    
}
