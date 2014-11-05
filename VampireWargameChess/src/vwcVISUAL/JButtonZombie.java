/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwcVISUAL;

import vwc.TipoPieza;

/**
 *
 * @author ADMIN
 */
public class JButtonZombie extends JButtonx{

    public JButtonZombie(int c, int r, char col) {
        super(TipoPieza.ZOMBIE.hp, TipoPieza.ZOMBIE.sp,TipoPieza.ZOMBIE.ap,r,c,TipoPieza.ZOMBIE.getTipo(),col);
    }

    @Override
    public void submenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JButtonx llamar(int opcion, JButtonx p, int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantOpciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ataqueEspecial(JButtonx p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean mover(int fila, int mover){
        return false;
    }
}
