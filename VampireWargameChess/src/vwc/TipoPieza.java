/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwc;

/**
 *
 * @author Raim
 */
public enum TipoPieza {
    HOMBRE_LOBO(5, 2, 5){//hp 5, sp 2, ap 5
        @Override
        public String getTipo(){
            return "Hombre Lobo";
        };
    }, VAMPIRO(4, 5, 3){//hp 4, sp 5, ap 3
        @Override
        public String getTipo(){
            return "Vampiro";
        };
    }, NECROMANCER(3, 1, 4){//hp 3, sp 1, ap 4
        @Override
        public String getTipo(){
            return "Necromancer";
        };
    }, ZOMBIE(1, 0, 1){//hp 1, sp 0, ap 1
        @Override
        public String getTipo(){
            return "Zombie";
        };
    };
    public final int hp, sp, ap;
    
    private TipoPieza(int h, int s, int a){
        hp = h;
        sp = s;
        ap = a;
    }
    
    public abstract String getTipo();
}
