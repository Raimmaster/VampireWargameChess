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
public class Zombie extends Pieza{

    public Zombie(int c, int r, char col) {
        super(TipoPieza.ZOMBIE.hp, TipoPieza.ZOMBIE.sp,TipoPieza.ZOMBIE.ap,r,c,TipoPieza.ZOMBIE.getTipo(),col);
    }

    @Override
    public void submenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pieza llamar(int opcion, Pieza p, int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantOpciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ataqueEspecial(Pieza p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mover(int fila, int mover){
        System.out.print("CEREBROS......");
    }
}
