/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwcVISUAL;
import vwc.*;
/**
 *
 * @author ADMIN
 */
public class JButtonVampire extends JButtonx{

    public JButtonVampire(int r, int c, char col) {
        super(TipoPieza.VAMPIRO.hp, TipoPieza.VAMPIRO.sp, TipoPieza.VAMPIRO.ap, r, c,TipoPieza.VAMPIRO.getTipo() , col);
    }

    @Override
    public void submenu() {
        System.out.printf("Acciones Vampiro: %n "
                + "1. Mover\n"
                + "2. Atacar\n"
                + "3. Ataque Especial\n");
    }

    @Override
    public JButtonx llamar(int opcion, JButtonx p, int fila, int columna) {
        JButtonx q = null;
        
        if (opcion == 1)
            mover(fila, columna);
        else if (opcion == 2)
            atacar(p);
        else if (opcion == 3)
            ataqueEspecial(p);
        
        return q;
    }

    @Override
    public int cantOpciones() {
        return 3;
    }

    @Override
    public void ataqueEspecial(JButtonx p) {
        p.setHp(p.hp - 1);
        hp += 1;
    }
    
}
