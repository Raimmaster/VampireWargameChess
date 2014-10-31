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

    public Necromancer(int r, int c, String t) {
        super(TipoPieza.NECROMANCER.hp, TipoPieza.NECROMANCER.sp, TipoPieza.NECROMANCER.ap,
                r, c, TipoPieza.NECROMANCER.getTipo(), 'P');
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

    /**
     *
     * @param opcion
     * @param p
     * @param fila
     * @param columna
     */
    

    @Override
    public void ataqueEspecial(Pieza p) {
        int ap = p.getSp()+ (this.ap/2);
        p.defender(ap);
    }

    @Override
    public Pieza llamar(int opcion, Pieza p, int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantOpciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
