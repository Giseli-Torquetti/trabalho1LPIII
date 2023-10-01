package br.edu.unijui.dataBase.Interface;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel");
        frame.setSize(400, 380);
        JPanel panel = new Inicio();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    
    public Inicio() {
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

        jButton1 = new javax.swing.JButton();
        Cliente = new javax.swing.JButton();

        jButton1.setText("Quartos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Cliente.setText("Clientes");
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(Cliente))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(Cliente)
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addGap(145, 145, 145))
        );

        jButton1.getAccessibleContext().setAccessibleName("jbQuartos");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = new JFrame("Quartos");
        frame.setSize(400, 380);
        JPanel panel = new ListaQuartos();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
           try {
            new BuscarClientes(); 
         } catch (SQLException | ClassNotFoundException ex) {
             Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
         }

    }//GEN-LAST:event_ClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cliente;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
