/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vwcVISUAL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import vwc.*;

/**
 *
 * @author KELVIN
 */
public class Play extends javax.swing.JFrame implements ActionListener{
    
    private static final int COLUMNAS = 6;
    private static final int FILAS = 6;
    
    private Player player1, player2;
    private Player actual = null;
    private Ruleta girar = new Ruleta();
    static JButtonx[][] chess = new JButtonx[FILAS][COLUMNAS];
    //Pieza piezas [][] = new Pieza[FILAS][COLUMNAS];
    public static int accion=0;
    private int clics = 0;
    private JButtonx boton1;
    private JButtonx boton2;
    private String tipoActual = "Vacio";
    /**
     * Creates new form Play
     */
    public Play(Player x, Player y){
        initComponents();
        player1=x;
        player2=y;
        player1.setColor('B');
        player2.setColor('N');
        actual = player2;
        gameInit();
        desactivarBotones();
        girar.start();
        changePlayer();
        desactivarOpciones();
        //inicializarPiezas();
    }
    
    private void gameInit(){
        int ix=10, iy=90;
        int ex=100, ey=80;
        int i=0, j=0;
        
        for (i = 1; i < 5; i++) {
            for (j = 0; j < 6; j++) {
                //crear el boton
                chess[i][j] = new JButtonx(Integer.toString(i)+Integer.toString(j));
                //ubicar el boton
                getContentPane().add(chess[i][j]);
                chess[i][j].setBounds(ix, iy, 90, 70);
                chess[i][j].addActionListener(this);
                ix+=ex;
            }
            iy+=ey;
            ix=10;
        }
        char color = 'B';
        i = 0;
       
        chess[0][0] = new JButtonWolf(i,0,color);
        chess[0][5] = new JButtonWolf(i,5,color);
        
        chess[0][1] = new JButtonVampire(i,1,color);
        chess[0][4] = new JButtonVampire(i,4,color);
        
        chess[0][2] = new JButtonNecromancer(i,2,color);
        chess[0][3] = new JButtonNecromancer(i,3,color);
        int n = 0;
        ix = 10;
        iy = 10;
        ex = 100;
        for (int k = 0; k < 6; k++) {
                getContentPane().add(chess[n][k]);
                chess[n][k].setBounds(ix, iy, 90, 70);
                chess[n][k].addActionListener(this);
                ix+=ex;
        }
        
        i=5;
        color = 'N';
        chess[5][0] = new JButtonWolf(i,0,color);
        chess[5][5] = new JButtonWolf(i,5,color);
        
        chess[5][1] = new JButtonVampire(i,1,color);
        chess[5][4] = new JButtonVampire(i,4,color);
        
        chess[5][2] = new JButtonNecromancer(i,2,color);
        chess[5][3] = new JButtonNecromancer(i,3,color);
        
        n = 5;
        ix = 10;
        iy = 410;
        ex = 100;
        for (int k = 0; k < 6; k++) {
                getContentPane().add(chess[n][k]);
                chess[n][k].setBounds(ix, iy, 90, 70);
                chess[n][k].addActionListener(this);
                ix+=ex;
        }
        
        
    }
    
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
                    chess[i][j].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolf"+colour+".jpg")));
                }else if( j == 1 || j == 4)
                {
                    chess[i][j] = new JButtonVampire(i,j,colour);
                    chess[i][j].setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vamp"+colour+".jpg")));
                }else if(j == 2 || j == 3){
                    chess[i][j] = new JButtonNecromancer(i,j,colour);
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
        batacar = new javax.swing.JButton();
        bespecial = new javax.swing.JButton();
        batacarz = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        select.setBounds(510, 20, 90, 70);

        ruleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        ruleta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ruleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruletaActionPerformed(evt);
            }
        });
        jPanel1.add(ruleta);
        ruleta.setBounds(10, 20, 90, 70);

        pap.setMaximum(5);
        jPanel1.add(pap);
        pap.setBounds(430, 70, 70, 14);

        psp.setMaximum(5);
        psp.setToolTipText("");
        jPanel1.add(psp);
        psp.setBounds(430, 30, 70, 14);

        php.setMaximum(5);
        jPanel1.add(php);
        php.setBounds(430, 50, 70, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ap.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(410, 70, 20, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sp.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(410, 30, 20, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/hp.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 50, 20, 20);

        bcrear.setText("CREAR Z.");
        bcrear.setToolTipText("Crear Zombie");
        bcrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcrearActionPerformed(evt);
            }
        });
        jPanel1.add(bcrear);
        bcrear.setBounds(230, 40, 110, 20);

        bmover.setText("MOVER");
        bmover.setToolTipText("Mover X Pieza [Excepto Zombie]");
        bmover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmoverActionPerformed(evt);
            }
        });
        jPanel1.add(bmover);
        bmover.setBounds(110, 15, 110, 30);

        batacar.setText("ATACAR");
        batacar.setToolTipText("Realizar Ataque Especial [Si lo tiene]");
        batacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batacarActionPerformed(evt);
            }
        });
        jPanel1.add(batacar);
        batacar.setBounds(110, 55, 110, 30);

        bespecial.setText("AT. ESPECIAL");
        bespecial.setToolTipText("Atacar a X Pieza");
        bespecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bespecialActionPerformed(evt);
            }
        });
        jPanel1.add(bespecial);
        bespecial.setBounds(230, 10, 110, 20);

        batacarz.setText("ATACAR Z.");
        batacarz.setToolTipText("Atacar con Zombie");
        batacarz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batacarzActionPerformed(evt);
            }
        });
        jPanel1.add(batacarz);
        batacarz.setBounds(230, 70, 110, 20);

        jLabel4.setText("Seleccion");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(534, 5, 50, 14);

        jLabel5.setText("Ruleta");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 5, 34, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 500, 610, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ruletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruletaActionPerformed
        // TODO add your handling code here:
        girar.detener();
        ruleta.setEnabled(false);
        tipoActual = girar.getTipo();
        System.out.print(tipoActual);
        
        activarBotones();
        if (actual == player1) {
                desactivarPiezas('N');
        }else{
                desactivarPiezas('B');
        }
    }//GEN-LAST:event_ruletaActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_selectActionPerformed

    private void bmoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmoverActionPerformed
        // TODO add your handling code here:
        accion = 1;
        activarBotones();
        if (actual == player1) {
                desactivarPiezas('N');
        }else{
                desactivarPiezas('B');
        }
    }//GEN-LAST:event_bmoverActionPerformed

    private void bespecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bespecialActionPerformed
        // TODO add your handling code here:
        accion = 3;
        
        activarBotones();
        if (actual == player1) {
                desactivarPiezas('N');
        }else{
                desactivarPiezas('B');
        }
    }//GEN-LAST:event_bespecialActionPerformed

    private void batacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batacarActionPerformed
        // TODO add your handling code here:
        accion = 2;
        
        activarBotones();
        if (actual == player1) {
                desactivarPiezas('N');
        }else{
                desactivarPiezas('B');
        }
    }//GEN-LAST:event_batacarActionPerformed

    private void bcrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcrearActionPerformed
        // TODO add your handling code here:
        JButtonx buscarx = buscar("Necromancer");
        if (buscarx != null){
            accion = 4;
            desactivarPiezas('B');
            desactivarPiezas('N');
            JOptionPane.showMessageDialog(this, "Seleccione la posicion donde desea crear Zombie", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            clics++;
            
            activarBotones();
            if (actual == player1) {
                    desactivarPiezas('N');
            }else{
                    desactivarPiezas('B');
            }
        }
    }//GEN-LAST:event_bcrearActionPerformed

    private void batacarzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batacarzActionPerformed
        // TODO add your handling code here:
        accion = 5;
        
        if (actual == player1) {
                desactivarPiezas('N');
        }else{
                desactivarPiezas('B');
        }
    }//GEN-LAST:event_batacarzActionPerformed

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
                new Play(new Player("NxR"),new Player("RAIM")).setVisible(true);
                
            }
        });
    }
    
    private char gameOver(){
        int b = 0, n = 0;
        for (JButtonx x[] : chess){
            for (JButtonx y : x){
                if (!(y instanceof JButtonZombie) && !y.getTipo().equalsIgnoreCase("Vacio")){//obviar Zombies
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batacar;
    private javax.swing.JButton batacarz;
    private javax.swing.JButton bcrear;
    private javax.swing.JButton bespecial;
    private javax.swing.JButton bmover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar pap;
    private javax.swing.JProgressBar php;
    private javax.swing.JProgressBar psp;
    public static javax.swing.JButton ruleta;
    private javax.swing.JButton select;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        String coord = e.getActionCommand();
        int x = coord.charAt(0) - 48;
        int y = coord.charAt(1) - 48;
        JButtonx este = chess[x][y];
            
            System.out.println(x + " - " + y);
            //chess[x][y].printPosiblesPosiciones();
            
            psp.setValue(chess[x][y].getSp());
            php.setValue(chess[x][y].getHp());
            pap.setValue(chess[x][y].getAp());
            select.setIcon(este.getIcon());
            
        if (clics==0 && chess[x][y].getTipo().equalsIgnoreCase(tipoActual)){
            int op = JOptionPane.showConfirmDialog(this, "Desea seleccionar esta pieza para ejecutar una accion?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION){
                boton1 = chess[x][y];
                clics++;
                activarOpciones();
                desactivarBotones();
            }
            
        }else if (clics == 1){
            int op = JOptionPane.showConfirmDialog(this, "Desea seleccionar esta pieza para ejecutar la accion seleccionada sobre ella?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION){
                boton2 = chess[x][y];
                
                if (accion == 1){
                    
                    if (boton1.validarMovimiento(x,y) && boton2.getHp()==0){
                        int f, c;
                        f = boton1.getRow();
                        c = boton1.getColumn();
                        Icon image = boton1.getIcon();
                        Icon image2 = boton2.getIcon();
                        
                        chess[x][y] = boton1;
                        boton2.setIcon(image);
                        boton2 = null;
                        
                        chess[f][c] = boton2;
                        boton1.setIcon(image2);
                        chess[f][c] = new JButtonx(Integer.toString(f)+Integer.toString(c));
                        chess[x][y].setIcon(image);
                        boton1.setIcon(image2);
                        boton1 = null;
                        chess[x][y].updatePosiciones(x, y);
                        
                        System.out.print("Pieza Movida");
                    }
                }else if (accion == 2){
                    
                }else if (accion == 3){
                    
                }else if (accion ==4){
                    
                }else if (accion == 5){
                    
                }
                    
                clics--;
                
                girarRuleta();
                ruleta.setEnabled(true);
                accion = 0;
                tipoActual = "ninguno";
            }
            
        }
    }
    
    public static void desactivarBotones(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                chess[i][j].setEnabled(false);
            }
        }
    }
    
    public static void activarBotones(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                chess[i][j].setEnabled(true);
            }
        }
    }
    
    public void activarOpciones(){
        bmover.setEnabled(true);
        bespecial.setEnabled(true);
        batacar.setEnabled(true);
        bcrear.setEnabled(true);
        batacarz.setEnabled(true);
    }
    
    public void desactivarOpciones(){
        bmover.setEnabled(false);
        bespecial.setEnabled(false);
        batacar.setEnabled(false);
        bcrear.setEnabled(false);
        batacarz.setEnabled(false);
    }
    
    public void changePlayer(){
        if (actual == player1) {
                actual = player2;
                desactivarPiezas('N');
        }else{
                actual = player1;
                desactivarPiezas('B');
        }
    }
    
    public void desactivarPiezas(char c){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (chess[i][j].getColor()==c)
                    chess[i][j].setEnabled(false);
            }
        }
    }
    
    public JButtonx buscar(String tipo){
        JButtonx buscar = null;
        for (JButtonx bx[] : chess){
            for (JButtonx by : bx){
                if (by.getTipo().equalsIgnoreCase(tipo))
                    buscar = by;
            }
        }
        return buscar;
    }
    
    public void girarRuleta(){
        girar = new Ruleta();
        girar.start();
    }
    
    public void moverPieza(JButtonx e, int x, int y){
        chess[x][y] = e;
        chess[x][y].setIcon(e.getIcon());
        chess[x][y].updatePosiciones(x, y);
        int f, c;
        f = e.getRow();
        c = e.getColumn();
        chess[f][c] = new JButtonx(Integer.toString(f)+Integer.toString(c));
    }
}

class Ruleta extends Thread {
    private boolean state = true;
    private int x = 0;
    
    public void detener(){
        state = false;;
        Play.desactivarBotones();
        System.out.print(x);
        
    }
    
    public void run(){
        
        while(state==true){
            if (x==0){
                Play.ruleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolfb.jpg")));
                x++;
            }else if (x == 1){
                Play.ruleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vampb.jpg")));
                x++;
            }else{
                Play.ruleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reapb.jpg")));
                x++;
            }
            if (x >= 3)
                x=0;
        }
    }
    
    public String getTipo(){
        try {
            Thread.sleep (1000);
        } catch (Exception e) {
            // Mensaje en caso de que falle
        }
        if (x==1)
            return "Hombre Lobo";
        else if (x==2)
            return "Vampiro";
        return "Necromancer";
    }
    
    
}