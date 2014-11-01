/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vwc;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Raim
 */
public class Battleground {
    static ArrayList<Player> players = new ArrayList<>();
    static Player topTen[] = new Player[10];
    
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        Random rnd = new Random();
        Player player1 = null;
        Player player2 = null;
        String jug1,jug2, opcion;
        
        System.out.println("\033[32m   ******");
        System.out.println("\033[32m ***");
        System.out.println("\033[32m**** ASTLEVANIA CHESS");
        System.out.println("\033[32m ***");
        System.out.println("\033[32m   ******");
        
        do{
            System.out.print("Ingrese nombre de Player1: ");
            jug1 = rd.next();
            player1 = existe(jug1);
            if (player1==null){
                player1 = new Player(jug1);
                players.add(player1);
            }else{
                System.out.print("Ya existe jugador, desea usarlo? (Si/No)");
                opcion = rd.next();
                if (opcion.equalsIgnoreCase("no"))
                    player1=null;
            }
        }while(player1==null);
        //System.out.print("Paso a player2\n");
        do{
            System.out.print("Ingrese nombre de Player2: ");
            jug2 = rd.next();
            player2 = existe(jug2);
            if (player2==null){
                player2 = new Player(jug2);
                players.add(player1);
            }else{
                System.out.print("Ya existe jugador, desea usarlo? (Si/No)");
                opcion = rd.next();
                if (opcion.equalsIgnoreCase("no"))
                    player2=null;
            }
        }while(player2==null);
        //System.out.print("Termino player2\n");
        GameBoard nx = new GameBoard(player1,player2);
        
        
    }
    
    private static  Player existe(String n){
        for (Player x:players){
            if (x.getName().equalsIgnoreCase(n))
                return x;
        }
        return null;
    }
}
