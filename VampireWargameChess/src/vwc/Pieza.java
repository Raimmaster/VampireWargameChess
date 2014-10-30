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
    protected ArrayList<Posicion> posiciones = new ArrayList<>();
    
    /**
     * Constructor de pieza
     * @param h Cantidad de HP que tendrá
     * @param s Cantidad de SP que tendrá
     * @param a Cantidad de AP que tendrá
     * @param r Número de fila
     * @param c Número de columna
     * @param t Nombre del tipo
     */
    public Pieza(int h, int s, int a, int r, int c, String t){
        tipo = t;
        row = r;
        column = s;
        hp = h;
        sp = s;
        ap = a;
        updatePosiciones(row, column);
    }
    
    /**
     * Realiza la acción necesaria de ataque
     * @param p Objeto Pieza que se quiere atacar
     */
    public void atacar(Pieza p){
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
    public boolean mover (int fila, int columna){
        boolean state = false;
        if (validarPosicion(fila,columna)==true){
            for (Posicion x : posiciones){
                if (x.validarPosicion(fila, columna)==true){
                    state = true;
                    //codigo para mover la pieza
                    updatePosiciones(fila, columna);
                }
            }
        }         
        return state;
    }
    
    /**
     * Recibir el dano ocasionado por x pieza
     * @param ap Cantidad de dano inflingido
     */
    public void defender(int ap){
        if (sp>0 && ap>0){
            sp-=1;
            defender(ap-1);
        }else if (hp>0 && ap>0){
                hp-=1;
                defender(ap-1);
        }else if (hp==0)
            System.out.printf("Pieza {%s} destruida!%n",tipo);
    }
    
    /**
     * Funcion para validar el movimiento de x pieza
     * @param fila Posicion de la fila a la que se desea mover
     * @param columna Posicion de la columna a la que se desea mover
     * @return 
     */
    public boolean validarMovimiento(int fila, int columna){
        return true;
    }
    
    /**
     * 
     * @param fila
     * @param columna 
     */
    public void updatePosiciones(int fila, int columna){
        if (fila>0){
            posiciones.add(new Posicion(fila+1, columna));
            if (columna>0)
                posiciones.add(new Posicion(fila+1, columna-1));
            if (columna<5)
                posiciones.add(new Posicion(fila+1, columna+1));
        }
        if (fila<5){
            posiciones.add(new Posicion(fila-1, columna));
            if (columna>0)
                posiciones.add(new Posicion(fila-1, columna-1));
            if (columna<5)
                posiciones.add(new Posicion(fila-1, columna+1));
        }
        if (columna>0)
            posiciones.add(new Posicion(fila, columna-1));
        if (columna<5)
            posiciones.add(new Posicion(fila, columna+1));
        
        //(f - 1, c - 1), (f - 1, c), (f - 1, c + 1);
        //(f, c - 1), (f, c + 1);
        //(f + 1, c - 1), (f + 1, c), (f + 1, c + 1).
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

    public void setAp(int ap) {
        this.ap = ap;
    }
    
    public abstract void submenu();
    
    public abstract void llamar(int opcion);
    
}
