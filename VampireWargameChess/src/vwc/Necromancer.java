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
                r, c, TipoPieza.NECROMANCER.getTipo());
    }

}
