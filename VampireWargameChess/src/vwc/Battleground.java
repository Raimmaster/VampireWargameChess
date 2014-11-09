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
    static Scanner rd = new Scanner(System.in);
    
    public static void main(String[] args) {
        Random rnd = new Random();
        Player [] jugadores = new Player[2];
        
        System.out.println("\033[32m   ******");
        System.out.println("\033[32m ***");
        System.out.println("\033[32m**** ASTLEVANIA CHESS");
        System.out.println("\033[32m ***");
        System.out.println("\033[32m   ******");
        
        for(int i = 0; i < 2; i++){
            jugadores[i] = initializePlayer(i + 1);
            jugadores[i].resetPiezasPerdidas();
        }        
        GameBoard nx = new GameBoard(jugadores[0], jugadores[1]);         
    }   
    
    public static Player initializePlayer(int i){
        Player player = null;
        String gamer, op;
        do{
            System.out.print("Ingrese nombre de Player " + i + ": ");
            gamer = rd.next();
            player = existe(gamer);
            if (player == null){
                player = new Player(gamer);
                players.add(player);
            }else{
                System.out.print("Ya existe jugador, desea usarlo? (Si/No)");
                op = rd.next();
                if (op.equalsIgnoreCase("no"))
                    player = null;
            }
        }while(player == null);
        
        return player;
    }
    
    private static Player existe(String n){
        for (Player x : players){
            if (x.getName().equalsIgnoreCase(n))
                return x;
        }
        return null;
    }
}
