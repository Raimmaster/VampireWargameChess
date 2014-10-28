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
    private final static int VIDA_VAMP = 4;
    private final static int ESCUDO_VAMP = 5;
    private final static int ATTACK_VAMP = 3;
    private final static String TIPO = "Vampiro";
    
    public Vampiro(){
        super(VIDA_VAMP, ESCUDO_VAMP, ATTACK_VAMP, 0, 1, TIPO);
    }
    
    @Override
    public void atacar(Pieza p){
        
    }
    
    @Override
    public void mover(int fila, int columna){
        
    }
    
    @Override
    public void defender(int ap){
        
    }

    @Override
    public Boolean validarMovimiento(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
