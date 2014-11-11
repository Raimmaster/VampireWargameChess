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
        System.out.printf("Acciones Necromancer: %n"
                + "1. Mover\n"
                + "2. Atacar\n"
                + "3. Ataque Especial\n"
                + "4. Conjurar Zombie\n"
                + "5. Atacar con Zombie\nIngrese su opcion: ");
    }

    @Override
    public boolean ataqueEspecial(Pieza p) {
        int hpc = p.getHp();
        if (hpc > ap){
            p.setHp(hpc-ap);
            System.out.printf("SE HA ATACADO LA PIEZA %s, SE LE HAN QUITADO %d%nLE QUEDAN %d HP Y %d SP\n",
                    p.tipo, ap, p.hp, p.sp);
            return false;
        }else{
            p.setHp(0);
            System.out.printf("SE HA ATACADO LA PIEZA %s, SE LE HAN QUITADO %d%nLE QUEDAN %d HP Y %d SP\n",
                    p.tipo, hpc, p.hp, p.sp);
            return true;
        }
            
    }

    @Override
    public Pieza llamar(int opcion, Pieza p, int fila, int columna) {
        Pieza q = null;
        switch(opcion){
            case 1:
                mover(fila, columna);
                break;
            case 2:         
                p.defender(ap, ap);
                break;
            case 3:            
                ataqueEspecial(p);
                break;
            case 4:
                //Crear Zombie
                System.out.print("");
                break;
            case 5:       
                p.defender(TipoPieza.ZOMBIE.ap, TipoPieza.ZOMBIE.ap);                   
                break;
        }
        return q;
    }

    @Override
    public int cantOpciones() {
       return 5;
    }

    public Zombie createZombie(int fila, int columna){
        return new Zombie(fila, columna, color);
    }
    
    public void updateSpecial(){
        posiciones.clear();
        updatePosicionesSpecial(row, column, 1);
    }
    
    private void updatePosicionesSpecial(int fila, int columna, int adjPositions){
        final int LIMIT_SUP = 6, LIMIT_INF = -1;//LIMITES DEL BOARD
        if(adjPositions <= 2){
            if (fila < LIMIT_SUP - adjPositions){
                posiciones.add(new Posicion(fila + adjPositions, columna));
                if (columna > LIMIT_INF + adjPositions)
                    posiciones.add(new Posicion(fila + adjPositions, columna - adjPositions));
                if (columna < LIMIT_SUP - adjPositions)
                    posiciones.add(new Posicion(fila + adjPositions, columna + adjPositions));
            }
            if (fila > LIMIT_INF + adjPositions){
                posiciones.add(new Posicion(fila - adjPositions, columna));
                if (columna > LIMIT_INF + adjPositions)
                    posiciones.add(new Posicion(fila - adjPositions, columna - adjPositions));
                if (columna < LIMIT_SUP - adjPositions)
                    posiciones.add(new Posicion(fila - adjPositions, columna + adjPositions));
            }
            if (columna > LIMIT_INF + adjPositions)
                posiciones.add(new Posicion(fila, columna - adjPositions));
            if (columna < LIMIT_SUP - adjPositions)
                posiciones.add(new Posicion(fila, columna + adjPositions));
            
            updatePosicionesSpecial(fila, columna, adjPositions + 1);
        }
    }
}
