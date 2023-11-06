/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.unijui.dataBase.Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gisel
 */
public class Home extends javax.swing.JPanel {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel");
        frame.setSize(400, 380);
        JPanel panel = new Home();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    

    /**
     * Creates new form Home
     */
    public Home() {
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        ClientesButton = new javax.swing.JButton();
        quartosButton = new javax.swing.JButton();
        reservasButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reservasButton1 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        ClientesButton.setBackground(new java.awt.Color(204, 255, 204));
        ClientesButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ClientesButton.setText("Clientes");
        ClientesButton.setFocusable(false);
        ClientesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesButtonActionPerformed(evt);
            }
        });

        quartosButton.setBackground(new java.awt.Color(204, 255, 204));
        quartosButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        quartosButton.setText("Quartos");
        quartosButton.setFocusPainted(false);
        quartosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quartosButtonActionPerformed(evt);
            }
        });

        reservasButton.setBackground(new java.awt.Color(204, 255, 204));
        reservasButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        reservasButton.setText("Reservas");
        reservasButton.setDefaultCapable(false);
        reservasButton.setFocusPainted(false);
        reservasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Hotel");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Área de gerenciamento do hotel");

        reservasButton1.setBackground(new java.awt.Color(204, 255, 204));
        reservasButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        reservasButton1.setText("Relatórios");
        reservasButton1.setFocusPainted(false);
        reservasButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reservasButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addComponent(reservasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quartosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClientesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(ClientesButton)
                .addGap(18, 18, 18)
                .addComponent(quartosButton)
                .addGap(18, 18, 18)
                .addComponent(reservasButton)
                .addGap(18, 18, 18)
                .addComponent(reservasButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ClientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesButtonActionPerformed
        // TODO add your handling code here:
        new BuscarClientes();

    }//GEN-LAST:event_ClientesButtonActionPerformed

    private void quartosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quartosButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Quartos");
        frame.setSize(400, 380);
        JPanel panel = new ListaQuartos();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }//GEN-LAST:event_quartosButtonActionPerformed

    private void reservasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasButtonActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Quartos");
        frame.setSize(400, 380);
        JPanel panel = new Reserva();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }//GEN-LAST:event_reservasButtonActionPerformed

    private void reservasButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasButton1ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Relatórios");
        frame.setSize(400, 380);
        JPanel panel = new Relatorio();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }//GEN-LAST:event_reservasButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClientesButton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton quartosButton;
    private javax.swing.JButton reservasButton;
    private javax.swing.JButton reservasButton1;
    // End of variables declaration//GEN-END:variables
}
