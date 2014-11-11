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
public class Vampiro extends Pieza{
    /*private final static int VIDA_VAMP = 4;
    private final static int ESCUDO_VAMP = 5;
    private final static int ATTACK_VAMP = 3;
    private final static String TIPO = "Vampiro";*/
    
    public Vampiro(int r, int c, char col){
        super(TipoPieza.VAMPIRO.hp, TipoPieza.VAMPIRO.sp, TipoPieza.VAMPIRO.ap,
                r, c, TipoPieza.VAMPIRO.getTipo(), col);
    }
    
    @Override
    public void submenu() {
        System.out.printf("Acciones Vampiro: %n"
                + "1. Mover\n"
                + "2. Atacar\n"
                + "3. Ataque Especial\nIngrese su opcion: ");
    }

    @Override
    public void ataqueEspecial(Pieza p) {
        p.setHp(p.hp - 1);
        hp += 1;
    }

    @Override
    public Pieza llamar(int opcion, Pieza p, int fila, int columna) {
        Pieza q = null;
        
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
    

}
