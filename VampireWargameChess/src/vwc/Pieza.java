/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwc;

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
    
    @Override
    public String toString() {
        return "Pieza{" + "tipo=" + tipo + ", hp=" + hp + ", sp=" + sp + ", ap=" + ap + '}';
    }
    
}
