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
public class Wolf extends Pieza {

    public Wolf(int r, int c, char col) {
        super(TipoPieza.HOMBRE_LOBO.hp, TipoPieza.HOMBRE_LOBO.sp,
                TipoPieza.HOMBRE_LOBO.ap, r, c, TipoPieza.HOMBRE_LOBO.getTipo(), col);
    }

    @Override
    public void submenu() {      
        System.out.printf("Acciones Vampiro: %n"
                + "1. Mover\n"
                + "2. Atacar\n");
    }

    @Override
    public Pieza llamar(int opcion, Pieza p, int fila, int columna) {
        Pieza q = null;
        
        if (opcion == 1)
            mover(fila, columna);
        else if (opcion == 2)
            atacar(p);
        
        return q;
    }
    
    @Override
    public void updatePosiciones(int fila, int columna){
        posiciones.clear();
        updatePosiciones(fila, columna, 1);
    }
    
    //Overload - RECURSIVA
    private void updatePosiciones(int fila, int columna, int adjPositions){
        final int LIMIT_SUP = 6, LIMIT_INF = -1;//LIMITES DEL BOARD
        if(adjPositions <= 2){
            if (fila < LIMIT_SUP - adjPositions){
                posiciones.add(new Posicion(fila + adjPositions, columna));
                if (columna > LIMIT_INF + adjPositions)
                    posiciones.add(new Posicion(fila + 1, columna - 1));
                if (columna < LIMIT_SUP - adjPositions)
                    posiciones.add(new Posicion(fila + 1, columna + 1));
            }
            if (fila > LIMIT_INF + adjPositions){
                posiciones.add(new Posicion(fila - 1, columna));
                if (columna > LIMIT_INF + adjPositions)
                    posiciones.add(new Posicion(fila - 1, columna - 1));
                if (columna < LIMIT_SUP - adjPositions)
                    posiciones.add(new Posicion(fila - 1, columna + 1));
            }
            if (columna > LIMIT_INF + adjPositions)
                posiciones.add(new Posicion(fila, columna - 1));
            if (columna < LIMIT_SUP - adjPositions)
                posiciones.add(new Posicion(fila, columna + 1));
            
            updatePosiciones(fila, columna, adjPositions + 1);
        }  
    }
    
    @Override
    public int cantOpciones() {
        return 2;
    }

    @Override
    public void ataqueEspecial(Pieza p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
