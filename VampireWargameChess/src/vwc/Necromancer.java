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
                + "1. Mover\n"
                + "2. Atacar\n"
                + "3. Ataque Especial\n"
                + "4. Conjurar Zombie\n"
                + "5. Atacar con Zombie\n");
    }

    @Override
    public void ataqueEspecial(Pieza p) {
        int ap = p.getSp()+ (this.ap/2);
        p.defender(ap);
    }

    @Override
    public Pieza llamar(int opcion, Pieza p, int fila, int columna) {
        Pieza q = null;
        switch(opcion){
            case 1:
                mover(fila, columna);
                break;
            case 2:         
                p.defender(ap);
                break;
            case 3:            
                ataqueEspecial(p);
                break;
            case 4:
                //Crear Zombie
                System.out.print("");
                break;
            case 5:       
                p.defender(TipoPieza.ZOMBIE.ap);                   
                break;
        }
        return q;
    }

    @Override
    public int cantOpciones() {
       return 5;
    }

}
