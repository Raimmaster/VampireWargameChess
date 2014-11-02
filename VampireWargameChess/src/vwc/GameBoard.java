/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vwc;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KELVIN
 */
public final class GameBoard {
    private static Scanner rd = new Scanner(System.in);
    private static Random rnd = new Random();
    private static final int COLUMNAS = 6;
    private static final int FILAS = 6;
    
    private Pieza chess[][] = new Pieza[FILAS][COLUMNAS];
    private String piezas[][] = new String[FILAS][COLUMNAS];
    private Player actual = null;
    
    
    public GameBoard(){
        gameInit();
        printGameBoard();
    }
    
    public GameBoard(Player x, Player y){
        boolean state = false;
        String tipoActual = null, opcion, piezaRul;
        int ruleta = 0, cantGiros, fila, columna;
        
        gameInit();
        printGameBoard();
        x.setColor('B');
        y.setColor('N');
        actual = x;
        char finish = 'X';
        do{
            //Girando la ruleta
            cantGiros = actual.getCantGiros();
            if (cantGiros==1){
                ruleta = girarRuleta();
                if (ruleta==1)
                    tipoActual = "Hombre Lobo";
                else if (ruleta==2)
                    tipoActual = "Vampiro";
                else
                    tipoActual = "Necromancer";
                System.out.print("Tipo a mover: "+tipoActual);
            }else{
                do{
                    ruleta = girarRuleta();
                    cantGiros-=1;
                    if (ruleta==1)
                        tipoActual = "Hombre Lobo";
                    else if (ruleta==2)
                        tipoActual = "Vampiro";
                    else
                        tipoActual = "Necromancer";
                    System.out.println("Tipo a mover: "+tipoActual);
                    System.out.printf("Girar de nuevo la ruleta (Restantes: %d) (Si/No)? ", cantGiros);
                    opcion = rd.next();
                }while(opcion.equalsIgnoreCase("si") && cantGiros>0);
            }
            //Ingreso de coordenadas
            piezaRul = Character.toString(tipoActual.charAt(0)) + Character.toString(actual.getColor());
            
            do{
                do{
                    System.out.print("Ingrese fila de pieza: ");
                    fila = rd.nextInt();
                }while(fila>=0 && fila<=5);
                do{
                    System.out.print("Ingrese columna de pieza: ");
                    columna = rd.nextInt();
                }while(columna>=0 && columna<=5);
                if (piezas[fila][columna].equalsIgnoreCase(piezaRul))
                    state=true;
            }while (state==true);
            
            finish = gameOver();
            if (actual == x) 
                actual = y;
            else
                actual = x;
        }while(finish == 'X');
    }
    
    private void gameInit(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                piezas[i][j]="__";
            }
        }
        chess[0][0] = new Necromancer(0,0,'B');
        piezas[0][0] = "NB";
        //Demas piezas
    }
    
    private char gameOver(){
        int b = 0, n = 0;
        for (Pieza x[] : chess){
            for (Pieza y : x){
                if (y != null){
                    if (y.getColor() == 'B')
                        b++;
                    else 
                        n++;
                }
            }
        }
        if (b == 0) 
            return 'N';
        else if (n == 0) 
            return 'B';
        return 'X';
    }
    
    private void printGameBoard(){
        System.out.print("\t**********************\n\t*");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(" " + piezas[i][j]);
            }
            System.out.print("  *\n\t*");
        }
        System.out.println("*********************");
    }
    
    
    private int girarRuleta(){
        return rnd.nextInt(3)+1;
    }
    
    private boolean buscarPiezaTablero(String t){
        return true;
    }
}
