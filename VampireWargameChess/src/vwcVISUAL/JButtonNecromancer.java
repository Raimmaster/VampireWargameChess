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
public class JButtonNecromancer extends JButtonx{

    public JButtonNecromancer(int r, int c, char col) {
        super(TipoPieza.NECROMANCER.hp, TipoPieza.NECROMANCER.sp, TipoPieza.NECROMANCER.ap,
                r, c, TipoPieza.NECROMANCER.getTipo(), col);
        
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reap"+Character.toLowerCase(col)+".jpg")));
        super.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/textp.jpg")));
    }

    @Override
    public void submenu() {
        System.out.printf("Acciones Necromancer: %n "
                + "1. Mover"
                + "2. Atacar"
                + "3. Ataque Especial"
                + "4. Conjurar Zombie"
                + "5. Atacar con Zombie");
    }

    @Override
    public JButtonx llamar(int opcion, JButtonx p, int fila, int columna) {
        JButtonx q = null;
        if (opcion==1)
            mover(fila, columna);
        if (opcion==2)
            p.defender(ap);
        if (opcion==3)
            ataqueEspecial(p);
        if (opcion==4)
            //Crear Zombie
            System.out.print("");
        if (opcion==5)
            p.defender(TipoPieza.ZOMBIE.ap);   
        return q;
    }

    @Override
    public int cantOpciones() {
        return 5;
    }

    @Override
    public void ataqueEspecial(JButtonx p) {
        int ap = p.getSp()+ (this.ap/2);
        p.defender(ap);
    }
    
}
