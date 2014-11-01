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
    ArrayList<Player> players = new ArrayList<>();
    Player topTen[] = new Player[10];
    
    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        Random rnd;
        System.out.println("\033[32m   ******");
        System.out.println("\033[32m ***");
        System.out.println("\033[32m**** ASTLEVANIA CHESS");
        System.out.println("\033[32m ***");
        System.out.println("\033[32m   ******");
        
        GameBoard nx = new GameBoard();
        
        
    }
    
    private Player existe(String n){
        for (Player x:players){
            if (x.getName().equalsIgnoreCase(n))
                return x;
        }
        return null;
    }
}
