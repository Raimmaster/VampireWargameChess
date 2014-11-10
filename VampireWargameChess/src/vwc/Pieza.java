/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwc;

import java.util.ArrayList;

/**
 *
 * @author Raim
 */
public abstract class Pieza {
    protected String tipo; //nombre del tipo de pieza
    protected int row, column; //coordenadas de la posición de la pieza
    protected int hp; //health points
    protected int sp; //shield points
    protected int ap; //attack points
    protected char color; //color, B o N
    protected ArrayList<Posicion> posiciones = new ArrayList<>();

    public String getTipo() {
        return tipo;
    }
    
    /**
     * Constructor de pieza
     * @param h Cantidad de HP que tendrá
     * @param s Cantidad de SP que tendrá
     * @param a Cantidad de AP que tendrá
     * @param r Número de fila
     * @param c Número de columna
     * @param t Nombre del tipo
     * @param col Color de la pieza
     */
    public Pieza(int h, int s, int a, int r, int c, String t, char col){
        tipo = t;
        row = r;
        column = c;
        hp = h;
        sp = s;
        ap = a;
        color = col;
        updatePosiciones(row, column);
    }
    
    /**
     * Realiza la acción necesaria de ataque
     * @param p Objeto Pieza que se quiere atacar
     */
    public final void atacar(Pieza p){
        p.defender(ap);
    }
    
    /**
     * Valida la posición de la pieza
     * @param fila Número de la fila de pieza
     * @param columna Número de la columna de la pieza
     * @return true si esa es la coordenada
     */
    public boolean validarPosicion(int fila, int columna){
        if (fila == row && columna == column)
            return true;
        
        return false;
    }
    
    /**
     * Mover la pieza a la coordenada especificada
     * @param fila Número de la fila donde nos queremos mover
     * @param columna Número de la columna donde nos queremos mover
     * @return <code>true</code> si se puede mover
     */
    public void mover (int fila, int columna){        
        if(validarMovimiento(fila, columna)){
            row = fila;
            column = columna;            
        }else
            System.out.println("COORDENADAS INVALIDAS.");
    }
    
    /**
     * Recibir el dano ocasionado por x pieza
     * @param ap Cantidad de dano inflingido
     */
    public final void defender(int ap){
        if (sp > 0 && ap > 0){
            sp--;
            defender(ap - 1);
        }else if (hp > 0 && ap > 0){
            hp--;
            defender(ap - 1);
        }else if (hp == 0)
            System.out.printf("Pieza {%s} destruida!%n", tipo);
    }
    
    /**
     * Funcion para validar el movimiento de x pieza
     * @param fila Posicion de la fila a la que se desea mover
     * @param columna Posicion de la columna a la que se desea mover
     * @return 
     */
    public boolean validarMovimiento(int fila, int columna){
        boolean state = false;
        for (Posicion x : posiciones){
                if (x.getX() == fila && x.getY() == columna){
                    state = true;
                }
        }
        return state;
    }
    
    /**
     * 
     * @param fila
     * @param columna 
     */
    public void updatePosiciones(int fila, int columna){
        posiciones.clear();
        if (fila < 5){
            posiciones.add(new Posicion(fila + 1, columna));
            if (columna > 0)
                posiciones.add(new Posicion(fila + 1, columna - 1));
            if (columna < 5)
                posiciones.add(new Posicion(fila + 1, columna + 1));
        }
        if (fila > 0){
            posiciones.add(new Posicion(fila - 1, columna));
            if (columna > 0)
                posiciones.add(new Posicion(fila - 1, columna - 1));
            if (columna < 5)
                posiciones.add(new Posicion(fila - 1, columna + 1));
        }
        if (columna > 0)
            posiciones.add(new Posicion(fila, columna - 1));
        if (columna < 5)
            posiciones.add(new Posicion(fila, columna + 1));
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
        
    @Override
    public String toString() {
        return "Pieza{" + "tipo=" + tipo + ", hp=" + hp + ", sp=" + sp + ", ap=" + ap + '}';
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getAp() {
        return ap;
    }    
    
    public char getColor(){
        return color;
    }
    
    public abstract void submenu();
    
    public abstract Pieza llamar(int opcion, Pieza p, int fila, int columna);
    
    public abstract int cantOpciones();
    
    public abstract void ataqueEspecial(Pieza p);
    
}