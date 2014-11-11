/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import vwc.GameBoard;
import vwc.Player;

/**
 *
 * @author Raim
 */
public class Battleground {
    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<String> lastTen = new ArrayList<>();
    static Scanner rd = new Scanner(System.in);
    
    public static void main(String[] args) {
        Random rnd = new Random();
        Player [] jugadores = new Player[2];
        byte opcion;        
        
        do{
            System.out.println("\033[32m   ******");
            System.out.println("\033[32m ***");
            System.out.println("\033[32m**** ASTLEVANIA CHESS");
            System.out.println("\033[32m ***");
            System.out.println("\033[32m   ******");
            
            System.out.print("1. Iniciar Partida.\n2. Ranking historico de jugadores.\n" + 
                    "3. Log de las ultimas 10 partidas.\n4. Salir.\nIngrese el numero de su opcion: ");
            opcion = rd.nextByte();
            
            switch(opcion){
                case 1:
                    GameBoard vampireChess = new GameBoard();
                    resetActivePlayers();                         
                    for(int i = 0; i < 2; i++){
                        jugadores[i] = initializePlayer(i + 1);
                        jugadores[i].resetPiezasPerdidas();
                    }
                    lastTen.add(0,vampireChess.playGame(jugadores[0], jugadores[1]));
                    onlyTen();
                    break;
                case 2://RANKING
                    printRanking();
                    break;
                case 3://LOG - LAST 10 GAMES
                    printLastTen();
                    break;
                case 4://SALIR
                    System.out.println("ADIOS...");
                    break;
                default:
                    System.out.println("Opcion invalida. Ingrese de nuevo.");
            }
        }while(opcion != 4);  
        
    }   
    
    private static Player initializePlayer(int i){
        Player player = null;
        String gamer, op;
        do{
            System.out.print("Ingrese nombre de Player " + i + ": ");
            gamer = rd.next();
            player = existe(gamer);
            if (player == null){
                player = new Player(gamer);
                players.add(player);
                player.usePlayer();
            }else if (player.getActive()){
                System.out.println("Jugador ya seleccionado para jugar");
                player = null;
            }else{
                System.out.print("Ya existe jugador, desea usarlo? (Si/No)");
                op = rd.next();
                if (op.equalsIgnoreCase("si"))
                    player.usePlayer();
                else
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
    
    private static void onlyTen(){
        if (lastTen.size() > 10){
            for (int i = 9; i < lastTen.size() - 1; i++) {
                lastTen.remove(i);
            }
        }
//        for(String s : lastTen)
//            System.out.println(s);
    }
    
    public static void addPoints(Player x){
        x.addpoints();
        updateRanking(x, 0);
    }
    
    private static void updateRanking(Player x, int y){
        if (y < players.size()){
            if (x.getPoints() > players.get(y).getPoints()){
                players.remove(x);
                players.add(y, x);
                return;
            }else
                updateRanking(x, y+1);
                
        }
    }

    private static void resetActivePlayers(){
        for (Player x : players){
            x.disablePlayer();
        }
    }
    
    private static void printRanking(){
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("Nombre: %s - %d points%n", players.get(i).getName(), players.get(i).getPoints());
        }
    }
    
    private static void printLastTen(){
        for (int i = 0; i < lastTen.size(); i++) {
            System.out.println(lastTen.get(i));
        }
    }
}
