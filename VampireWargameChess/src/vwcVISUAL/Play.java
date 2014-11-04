/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vwcVISUAL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;
import vwc.*;

/**
 *
 * @author KELVIN
 */
public class Play extends javax.swing.JFrame {
    private static final int COLUMNAS = 6;
    private static final int FILAS = 6;
    
    private Player actual = null;
    Ruleta girar = new Ruleta();
    JButton[][] chess = new JButton[FILAS][COLUMNAS];
    Pieza piezas [][] = new Pieza[FILAS][COLUMNAS];
    /**
     * Creates new form Play
     */
    public Play(){
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chess02 = new javax.swing.JButton();
        chess00 = new javax.swing.JButton();
        chess01 = new javax.swing.JButton();
        chess05 = new javax.swing.JButton();
        chess03 = new javax.swing.JButton();
        chess04 = new javax.swing.JButton();
        chess12 = new javax.swing.JButton();
        chess10 = new javax.swing.JButton();
        chess11 = new javax.swing.JButton();
        chess15 = new javax.swing.JButton();
        chess13 = new javax.swing.JButton();
        chess14 = new javax.swing.JButton();
        chess22 = new javax.swing.JButton();
        chess20 = new javax.swing.JButton();
        chess21 = new javax.swing.JButton();
        chess25 = new javax.swing.JButton();
        chess23 = new javax.swing.JButton();
        chess24 = new javax.swing.JButton();
        chess32 = new javax.swing.JButton();
        chess30 = new javax.swing.JButton();
        chess31 = new javax.swing.JButton();
        chess35 = new javax.swing.JButton();
        chess33 = new javax.swing.JButton();
        chess34 = new javax.swing.JButton();
        chess42 = new javax.swing.JButton();
        chess40 = new javax.swing.JButton();
        chess41 = new javax.swing.JButton();
        chess45 = new javax.swing.JButton();
        chess43 = new javax.swing.JButton();
        chess44 = new javax.swing.JButton();
        chess52 = new javax.swing.JButton();
        chess51 = new javax.swing.JButton();
        chess55 = new javax.swing.JButton();
        chess53 = new javax.swing.JButton();
        chess54 = new javax.swing.JButton();
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
        chess50 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GameBoard");
        setPreferredSize(new java.awt.Dimension(625, 630));
        getContentPane().setLayout(null);

        chess02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reap.jpg"))); // NOI18N
        getContentPane().add(chess02);
        chess02.setBounds(210, 10, 90, 70);

        chess00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolf.jpg"))); // NOI18N
        chess00.setToolTipText("WB");
        chess00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chess00ActionPerformed(evt);
            }
        });
        getContentPane().add(chess00);
        chess00.setBounds(10, 10, 90, 70);

        chess01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vamp.jpg"))); // NOI18N
        getContentPane().add(chess01);
        chess01.setBounds(110, 10, 90, 70);

        chess05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolf.jpg"))); // NOI18N
        getContentPane().add(chess05);
        chess05.setBounds(510, 10, 90, 70);

        chess03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reap.jpg"))); // NOI18N
        getContentPane().add(chess03);
        chess03.setBounds(310, 10, 90, 70);

        chess04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vamp.jpg"))); // NOI18N
        getContentPane().add(chess04);
        chess04.setBounds(410, 10, 90, 70);

        chess12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess12);
        chess12.setBounds(210, 90, 90, 70);

        chess10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess10);
        chess10.setBounds(10, 90, 90, 70);

        chess11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess11);
        chess11.setBounds(110, 90, 90, 70);

        chess15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess15);
        chess15.setBounds(510, 90, 90, 70);

        chess13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess13);
        chess13.setBounds(310, 90, 90, 70);

        chess14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess14);
        chess14.setBounds(410, 90, 90, 70);

        chess22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess22);
        chess22.setBounds(210, 170, 90, 70);

        chess20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess20);
        chess20.setBounds(10, 170, 90, 70);

        chess21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess21);
        chess21.setBounds(110, 170, 90, 70);

        chess25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess25);
        chess25.setBounds(510, 170, 90, 70);

        chess23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess23);
        chess23.setBounds(310, 170, 90, 70);

        chess24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess24);
        chess24.setBounds(410, 170, 90, 70);

        chess32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess32);
        chess32.setBounds(210, 250, 90, 70);

        chess30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess30);
        chess30.setBounds(10, 250, 90, 70);

        chess31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess31);
        chess31.setBounds(110, 250, 90, 70);

        chess35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess35);
        chess35.setBounds(510, 250, 90, 70);

        chess33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess33);
        chess33.setBounds(310, 250, 90, 70);

        chess34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess34);
        chess34.setBounds(410, 250, 90, 70);

        chess42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess42);
        chess42.setBounds(210, 330, 90, 70);

        chess40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess40);
        chess40.setBounds(10, 330, 90, 70);

        chess41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess41);
        chess41.setBounds(110, 330, 90, 70);

        chess45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess45);
        chess45.setBounds(510, 330, 90, 70);

        chess43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess43);
        chess43.setBounds(310, 330, 90, 70);

        chess44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        getContentPane().add(chess44);
        chess44.setBounds(410, 330, 90, 70);

        chess52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reapb.jpg"))); // NOI18N
        getContentPane().add(chess52);
        chess52.setBounds(210, 410, 90, 70);

        chess51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vampb.jpg"))); // NOI18N
        getContentPane().add(chess51);
        chess51.setBounds(110, 410, 90, 70);

        chess55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolfb.jpg"))); // NOI18N
        getContentPane().add(chess55);
        chess55.setBounds(510, 410, 90, 70);

        chess53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reapb.jpg"))); // NOI18N
        getContentPane().add(chess53);
        chess53.setBounds(310, 410, 90, 70);

        chess54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/vampb.jpg"))); // NOI18N
        getContentPane().add(chess54);
        chess54.setBounds(410, 410, 90, 70);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(510, 10, 90, 70);

        ruleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/text.jpg"))); // NOI18N
        ruleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruletaActionPerformed(evt);
            }
        });
        jPanel1.add(ruleta);
        ruleta.setBounds(10, 10, 90, 70);
        jPanel1.add(pap);
        pap.setBounds(430, 60, 70, 14);
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

        chess50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wolfb.jpg"))); // NOI18N
        getContentPane().add(chess50);
        chess50.setBounds(10, 410, 90, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ruletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruletaActionPerformed
        // TODO add your handling code here:
        System.out.print("Hola");
        
    }//GEN-LAST:event_ruletaActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_selectActionPerformed

    private void chess00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chess00ActionPerformed
        // TODO add your handling code here:
        select.setIcon(chess00.getIcon());
        
    }//GEN-LAST:event_chess00ActionPerformed

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
                new Play().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batacar;
    private javax.swing.JButton bcrear;
    private javax.swing.JButton bespecial;
    private javax.swing.JButton bmover;
    private javax.swing.JButton chess00;
    private javax.swing.JButton chess01;
    private javax.swing.JButton chess02;
    private javax.swing.JButton chess03;
    private javax.swing.JButton chess04;
    private javax.swing.JButton chess05;
    private javax.swing.JButton chess10;
    private javax.swing.JButton chess11;
    private javax.swing.JButton chess12;
    private javax.swing.JButton chess13;
    private javax.swing.JButton chess14;
    private javax.swing.JButton chess15;
    private javax.swing.JButton chess20;
    private javax.swing.JButton chess21;
    private javax.swing.JButton chess22;
    private javax.swing.JButton chess23;
    private javax.swing.JButton chess24;
    private javax.swing.JButton chess25;
    private javax.swing.JButton chess30;
    private javax.swing.JButton chess31;
    private javax.swing.JButton chess32;
    private javax.swing.JButton chess33;
    private javax.swing.JButton chess34;
    private javax.swing.JButton chess35;
    private javax.swing.JButton chess40;
    private javax.swing.JButton chess41;
    private javax.swing.JButton chess42;
    private javax.swing.JButton chess43;
    private javax.swing.JButton chess44;
    private javax.swing.JButton chess45;
    private javax.swing.JButton chess50;
    private javax.swing.JButton chess51;
    private javax.swing.JButton chess52;
    private javax.swing.JButton chess53;
    private javax.swing.JButton chess54;
    private javax.swing.JButton chess55;
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