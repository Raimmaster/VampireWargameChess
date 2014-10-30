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

    public Necromancer(int h, int s, int a, int r, int c, String t) {
        super(h, s, a, r, c, t);
    }

    @Override
    public void atacar(Pieza p) {
      p.defender(ap);
    }

    @Override
    public void mover(int fila, int columna) {
      
    }

    @Override
    public void defender(int hp) {
        if (sp>0 && ap>0){
            sp-=1;
            defender(ap-1);
        }else if (hp>0 && ap>0){
                hp-=1;
                defender(ap-1);
        }else if (hp==0 && ap>0)
            System.out.printf("Pieza {%s} destruida!%n",tipo);
    }

    @Override
    public Boolean validarMovimiento(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePosiciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
