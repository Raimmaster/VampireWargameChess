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
public class JButtonWolf extends JButtonx{

    public JButtonWolf(int r, int c, char col) {
        super(TipoPieza.HOMBRE_LOBO.hp, TipoPieza.HOMBRE_LOBO.sp,
                TipoPieza.HOMBRE_LOBO.ap, r, c, TipoPieza.HOMBRE_LOBO.getTipo(), col);
        
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolf"+Character.toLowerCase(col)+".jpg")));
        super.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/textp.jpg")));
    }

    @Override
    public void submenu() {      
        System.out.printf("Acciones Vampiro: %n "
                + "1. Mover\n"
                + "2. Atacar\n");}

    @Override
    public JButtonx llamar(int opcion, JButtonx p, int fila, int columna) {
        JButtonx q = null;
        
        if (opcion == 1)
            mover(fila, columna);
        else if (opcion == 2)
            atacar(p);
        
        return q;
    }

    @Override
    public int cantOpciones() {
        return 2;
    }

    @Override
    public void ataqueEspecial(JButtonx p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
