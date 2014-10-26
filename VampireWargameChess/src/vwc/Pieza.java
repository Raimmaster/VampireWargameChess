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
    protected String tipo;
    protected int hp;
    protected int sp;
    protected int ap;
    
    public abstract Pieza atacar();
    public abstract void mover (int fila, int columna);
    
    @Override
    public String toString() {
        return "Pieza{" + "tipo=" + tipo + ", hp=" + hp + ", sp=" + sp + ", ap=" + ap + '}';
    }
    
}
