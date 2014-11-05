/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vwcVISUAL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vwc.*;

/**
 *
 * @author KELVIN
 */
public class Play extends javax.swing.JFrame {
    private static final int COLUMNAS = 6;
    private static final int FILAS = 6;
    
    private Player player1, player2;
    private Player actual = null;
    Ruleta girar = new Ruleta();
    JButtonx[][] chess = new JButtonx[FILAS][COLUMNAS];
    JButtonx bActual;
    Pieza piezas [][] = new Pieza[FILAS][COLUMNAS];
    int mov=0;
    /**
     * Creates new form Play
     */
    public Play(Player x, Player y){
        initComponents();
        player1=x;
        player2=y;
        player1.setColor('B');
        player2.setColor('N');
        gameInit();
        //inicializarPiezas();
    }
    
    private void action(int x, int y){
        
    }
    
    private void gameInit(){
        int ix=10, iy=90;
        int ex=100, ey=80;
        int i=0, j=0;
        
        for (i = 1; i < 5; i++) {
            for (j = 0; j < 6; j++) {
                //crear el boton
                chess[i][j] = new JButtonx();
                //ubicar el boton
                getContentPane().add(chess[i][j]);
                chess[i][j].setBounds(ix, iy, 90, 70);
                chess[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
                chess[i][j].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/texts.jpg")));
                chess[i][j].setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/textp.jpg")));
                bActual = chess[i][j];
                chess[i][j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.print("Hola");    
                    psp.setValue(bActual.getSp());
                    System.out.print(bActual.getSp());
                    System.out.print("Adios");
                    }
                });
                //poner la imagen de fondo
                //agrega el action
                ix+=ex;
            }
            iy+=ey;
            ix=10;
        }
        char color = 'B';
        chess[0][0] = new JButtonWolf(i,j,color);
        chess[0][5] = new JButtonWolf(i,j,color);
        
        chess[0][1] = new JButtonVampire(i,j,color);
        chess[0][4] = new JButtonVampire(i,j,color);
        
        chess[0][2] = new JButtonNecromancer(i,j,color);
        chess[0][3] = new JButtonNecromancer(i,j,color);
        int n = 0;
        ix = 10;
        iy = 10;
        ex = 100;
        for (int k = 0; k < 6; k++) {
                bActual = chess[n][k];
                getContentPane().add(chess[n][k]);
                chess[n][k].setBounds(ix, iy, 90, 70);
                chess[n][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
                chess[n][k].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/texts.jpg")));
                chess[n][k].setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/textp.jpg")));
                chess[n][k].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.print("Hola");    
                    psp.setValue(bActual.getSp());
                    System.out.print(bActual.getSp());
                    System.out.print("Adios");
                    }
                });
                ix+=ex;
        }
        
        
        color = 'N';
        chess[5][0] = new JButtonWolf(i,j,color);
        chess[5][5] = new JButtonWolf(i,j,color);
        
        chess[5][1] = new JButtonVampire(i,j,color);
        chess[5][4] = new JButtonVampire(i,j,color);
        
        chess[5][2] = new JButtonNecromancer(i,j,color);
        chess[5][3] = new JButtonNecromancer(i,j,color);
        
        n = 5;
        ix = 10;
        iy = 410;
        ex = 100;
        for (int k = 0; k < 6; k++) {
                bActual = chess[n][k];
                getContentPane().add(chess[n][k]);
                chess[n][k].setBounds(ix, iy, 90, 70);
                chess[n][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
                chess[n][k].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/texts.jpg")));
                chess[n][k].setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/textp.jpg")));
                chess[n][k].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    System.out.print("Hola");    
                    psp.setValue(bActual.getSp());
                    System.out.print("Adios");
                    }
                });
                ix+=ex;
        }
        
        
    }
    
//    public void chess[0][0]ActionPerformed(java.awt.event.ActionEvent evt){
//        
//    }
    
    private void inicializarPiezas(){
        //Ciclo para inicializar las piezas correctamente
        for(int i = 0; i < FILAS; i += 5){
            char colour;
            if (i == 0)
                colour = 'b';
            else
                colour = 'n';
            
            for(int j = 0; j < COLUMNAS; j++){
                if(j == 0 || j == 5){
                    chess[i][j] = new JButtonWolf(i,j,colour);
                    chess[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolf"+colour+".jpg")));
                    chess[i][j].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolf"+colour+".jpg")));
                }else if( j == 1 || j == 4)
                {
                    chess[i][j] = new JButtonVampire(i,j,colour);
                    chess[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vamp"+colour+".jpg")));
                    chess[i][j].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vamp"+colour+".jpg")));
                }else if(j == 2 || j == 3){
                    chess[i][j] = new JButtonNecromancer(i,j,colour);
                    chess[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reap"+colour+".jpg")));
                    chess[i][j].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reap"+colour+".jpg")));
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        select = new javax.swing.JButton();
        ruleta = new javax.swing.JButton();
        pap = new javax.swing.JProgressBar();
        psp = new javax.swing.JProgressBar();
        php = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bcrear = new javax.swing.JButton();
        bmover = new javax.swing.JButton();
        bespecial = new javax.swing.JButton();
        batacar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GameBoard");
        setPreferredSize(new java.awt.Dimension(625, 630));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        select.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(510, 10, 90, 70);

        ruleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        ruleta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ruleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruletaActionPerformed(evt);
            }
        });
        jPanel1.add(ruleta);
        ruleta.setBounds(10, 10, 90, 70);
        jPanel1.add(pap);
        pap.setBounds(430, 60, 70, 14);

        psp.setMaximum(5);
        psp.setToolTipText("");
        psp.setValue(0);
        jPanel1.add(psp);
        psp.setBounds(430, 20, 70, 14);
        jPanel1.add(php);
        php.setBounds(430, 40, 70, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ap.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(410, 60, 20, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sp.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(410, 20, 20, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/hp.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 40, 20, 20);

        bcrear.setText("CREAR Z.");
        jPanel1.add(bcrear);
        bcrear.setBounds(260, 50, 110, 30);

        bmover.setText("MOVER");
        jPanel1.add(bmover);
        bmover.setBounds(130, 10, 110, 30);

        bespecial.setText("AT. ESPECIAL");
        jPanel1.add(bespecial);
        bespecial.setBounds(130, 50, 110, 30);

        batacar.setText("ATACAR");
        jPanel1.add(batacar);
        batacar.setBounds(260, 10, 110, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 500, 610, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ruletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruletaActionPerformed
        // TODO add your handling code here:
        System.out.print("Hola");
        
    }//GEN-LAST:event_ruletaActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_selectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Play(new Player(""),new Player("")).setVisible(true);
                
            }
        });
    }
    
    private char gameOver(){
        int b = 0, n = 0;
        for (JButton x[] : chess){
            for (JButton y : x){
//                if (!(y instanceof Zombie) && y != null){//obviar Zombies
//                    if (y.getColor() == 'B')
//                        b++;
//                    else 
//                        n++;
//                }
            }
        }
        if (b == 0) 
            return 'N';
        else if (n == 0) 
            return 'B';
        return 'X';
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batacar;
    private javax.swing.JButton bcrear;
    private javax.swing.JButton bespecial;
    private javax.swing.JButton bmover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar pap;
    private javax.swing.JProgressBar php;
    private javax.swing.JProgressBar psp;
    public static javax.swing.JButton ruleta;
    private javax.swing.JButton select;
    // End of variables declaration//GEN-END:variables
}

class Ruleta extends Thread {
    boolean state = true;
    
    
    public void detener(){
        state = false;
    }
    
    
    public void run(){
        int x = 0;
        do{
            if (x==0){
                Play.ruleta.setText("Hola");
                x++;
            }else if (x == 1){
                Play.ruleta.setText("Adios");
                x++;
            }else{
                Play.ruleta.setText("Hola de nuevo");
                x++;
            }
            if (x >= 3)
                x=0;
        }while(state==true);
    }
    
    
}