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
    private static final Scanner rd = new Scanner(System.in);
    private static Random rnd = new Random();
    private static final int COLUMNAS = 6;
    private static final int FILAS = 6;
    
    private Pieza chess[][] = new Pieza[FILAS][COLUMNAS];
    private String piezas[][] = new String[FILAS][COLUMNAS];
    private Player actual = null;
        
    public GameBoard(){               
        gameInit();        
    }
    
    public String playGame(Player x, Player y){
        String tipoActual, piezaRul;
        int cantGiros;
        
        x.setColor('B');
        y.setColor('N');
        actual = x;
        char finish;
        do{//JUEGO - TODO LO NECESARIO            
            //Girando la ruleta
            printGameBoard();

            cantGiros = actual.getCantGiros();
            System.out.println("\n\nTurno del jugador: " + actual.getName());
            cantGiros--;            
            tipoActual = showPiezaActual(girarRuleta());//OBTENER EL NOMBRE DE LA PIEZA A MOVER         
            System.out.print("Tipo a mover: " + tipoActual);
            //elegir el tipo de pieza que se puede usar          
            piezaRul = Character.toString(tipoActual.charAt(0)) + Character.toString(actual.getColor());            
            //Validar las coordenadas de la pieza seleccionada
            Pieza jugador = validarPiezaSeleccionada(piezaRul);
            if (jugador == null){
                return "JUGADOR " + actual.getName() + " SE HA RETIRADO";
            }
            accionarPieza(jugador);
            finish = gameOver();
            actual = actual == x ? y : x;
        }while(finish == 'X' || cantGiros > 0);
        System.out.println("SALIO");
        return null;
    }
    
    //ESPACIOS VACÍOS EN EL ARREGLO
    public void showEmptySpaces(){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[i].length; j++){
                if (chess[i][j] == null)
                    System.out.printf("[%d][%d] - EMPTY\n", i, j);
            }
        }
    }
    
    /**
     * Obtiene el String de la pieza actual a usar
     * @param tipo Número de la ruleta que determina el tipo
     * @return Tipo de Pieza (e.g. Vampiro)
     */
    private String showPiezaActual(int tipo){        
        switch(tipo){
            case 1:
                return "Hombre Lobo";
            case 2:
                return "Vampiro";
            case 3:
                return "Necromancer";
            default:
                return null;
        }
    }
    
    /**
     * Valida las coordenadas de la pieza a usarse
     * @param piezaRul El nombre de la pieza a usarse
     */
    private Pieza validarPiezaSeleccionada(String piezaRul){
        boolean state = false;
        int fila, columna;
        Pieza p = null;
        do{
                do{
                    System.out.print("\nIngrese fila de pieza: ");
                    fila = rd.nextInt();
                }while((fila < -1 && fila > 5));
                do{
                    System.out.print("Ingrese columna de pieza: ");
                    columna = rd.nextInt();
                }while((columna < -1 && columna > 5));
                
                if (fila == -1 && columna == -1){
                    System.out.print("DESEA RETIRARSE DEL JUEGO? Si/No: ");
                    String answer = rd.next();
                    if(answer.equalsIgnoreCase("Si"))
                        return null;
                    else
                        continue;
                }
                
                if (piezas[fila][columna].equalsIgnoreCase(piezaRul))
                    state = true;
        }while(!state);
        
        return chess[fila][columna];
    }
    
    private void accionarPieza(Pieza p){
        p.submenu();
        int eleccion = rd.nextInt();
        switch(eleccion){
            case 1:
                moverPiezaToTile(p);
                break;
            case 2:
                attackPiezaEnemiga(p);
                break;
        }
    }
    
    private void attackPiezaEnemiga(Pieza p){
        boolean atk = false;
        do{
            int coordinates[] = ingresarFilasColumnas();
            if (chess[coordinates[0]][coordinates[1]] == null){
                System.out.println("NO HAY PIEZAS EN ESTA COORDENADA");
                continue;
            }
            Pieza pEnemy = chess[coordinates[0]][coordinates[1]];
            atk = p.validarMovimiento(coordinates[0], coordinates[1]) && pEnemy.getColor() != p.getColor();
            System.out.println(atk);
            if(atk){
                //p.atacar(pEnemy);
                if(p.atacar(pEnemy)){
                    chess[coordinates[0]][coordinates[1]] = null;
                    piezas[coordinates[0]][coordinates[1]] = "__";
                    //System.out.println(piezas[coordinates[0]][coordinates[1]] + " ELIMINATED!!!\n");//PROBAR SI LIMPIO
                }
            }                
        }while(!atk);
    }
    
    /**
     * Ingresa la fila y columna a utilizar (mover o atacar o crear en caso de Necromancer).
     * @return Arreglo de <code>int</code> con las coordenadas
     */
    private int[] ingresarFilasColumnas(){
        int coordinates[] = new int[2];
        for(int i = 0; i < coordinates.length; i++){
            do{                           
                System.out.printf("\nIngrese coordenada de %s: ", (i == 0 ? "fila" : "columna" ));            
                coordinates[i] = rd.nextInt();                         
            }while(coordinates[i] < 0 && coordinates[i] > 5);
        }
        return coordinates;
    }
    
    private void moverPiezaToTile(Pieza p){
        boolean trueMove = false;
        do{
            int coordinates[] = ingresarFilasColumnas();
            if (chess[coordinates[0]][coordinates[1]] != null){
                System.out.println("EL ESPACIO ESTA LLENO; ELIJA OTRAS COORDENADAS!");
                continue;
            }
            //do{
            //System.out.println("TEST");
            int pFila = p.getRow(), pCol = p.getColumn();      
            trueMove = p.mover(coordinates[0], coordinates[1]);
            //System.out.println(trueMove);
            if(trueMove){//mover
                piezas[coordinates[0]][coordinates[1]] =  Character.toString(p.getTipo().charAt(0)) + p.getColor();//cambiar posicion en board
                piezas[pFila][pCol] = "__";
                chess[coordinates[0]][coordinates[1]] = p;//cambiar de posicion
                chess[pFila][pCol] = null;//reset
            }                
            //}while(chess[fila][columna] != null);
        }while(!trueMove);
    }
    
    /**
     * Inicializa en _ las posiciones del board
     */
    private void gameInit(){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                piezas[i][j]="__";
            }
        }
        
        inicializarPiezas();
    }
    
    /**
     * Inicializa las piezas en sus posiciones iniciales
     */
    private void inicializarPiezas(){
        //Ciclo para inicializar las piezas correctamente
        for(int i = 0; i < FILAS; i += 5){
            char colour = i == 0 ? 'B' : 'N';
            
            for(int j = 0; j < COLUMNAS; j++){
                if(j == 0 || j == 5){
                    chess[i][j] = new Wolf(i, j, colour);
                    piezas[i][j] = "H" + colour;
                }else if( j == 1 || j == 4)
                {
                    chess[i][j] = new Vampiro(i, j, colour);
                    piezas[i][j] = "V" + colour;
                }else if(j == 2 || j == 3){
                    chess[i][j] = new Necromancer(i, j, colour);
                    piezas[i][j] = "N" + colour;
                }
            }
        }
    }
    
    /**
     * Determina si el jugador contrario no tiene piezas
     * estableciendo el fin de juego
     * @return 
     */
    private char gameOver(){
        int b = 0, n = 0;
        for (Pieza x[] : chess){
            for (Pieza y : x){
                if (!(y instanceof Zombie) && y != null){//obviar Zombies
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
    
    /**
     * Imprime el tablero
     */
    private void printGameBoard(){
        System.out.print("\n\t***0**1**2**3**4**5***\n\t*");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(" " + piezas[i][j]);
            }
            System.out.printf("  %d\n\t*", i);
        }
        System.out.print("**0**1**2**3**4**5***");
    }
     
    /**
     * Obtiene el número de la pieza a usar
     * @return int Random de la pieza
     */
    private int girarRuleta(){
        return rnd.nextInt(3)+1;
    }
    
    private boolean buscarPiezaTablero(String t){
        boolean found = false;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (piezas[i][j].equalsIgnoreCase(t))
                    found = true;
            }
        }
        return found;
    }
}
