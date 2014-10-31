/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwc;

/**
 *
 * @author ADMIN
 */
public class Necromancer extends Pieza{

    public Necromancer(int r, int c, char col) {
        super(TipoPieza.NECROMANCER.hp, TipoPieza.NECROMANCER.sp, TipoPieza.NECROMANCER.ap,
                r, c, TipoPieza.NECROMANCER.getTipo(), col);
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
    public void ataqueEspecial(Pieza p) {
        int ap = p.getSp()+ (this.ap/2);
        p.defender(ap);
    }

    @Override
    public Pieza llamar(int opcion, Pieza p, int fila, int columna) {
        Pieza q = null;
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

}
