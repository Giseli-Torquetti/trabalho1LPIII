/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.edu.unijui.dataBase.Interface;

import br.edu.unijui.dataBase.DAO.ClienteDAO;
import br.edu.unijui.dataBase.Models.Cliente;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gisel
 */
public class CadastroCliente extends javax.swing.JPanel {
    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente() {
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

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        emailCliente = new javax.swing.JTextField();
        nomeCliente = new javax.swing.JTextField();
        telefoneCliente = new javax.swing.JTextField();
        salvarCliente = new javax.swing.JButton();
        cancelarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        label1.setText("Nome do Cliente");

        label2.setText("Email do cliente");

        label3.setText("Telefone do cliente");

        nomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeClienteActionPerformed(evt);
            }
        });

        salvarCliente.setBackground(new java.awt.Color(204, 255, 204));
        salvarCliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        salvarCliente.setText("Salvar");
        salvarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salvarClienteMouseClicked(evt);
            }
        });

        cancelarCliente.setBackground(new java.awt.Color(204, 204, 204));
        cancelarCliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cancelarCliente.setText("Cancelar");
        cancelarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarClienteMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Cadastro de cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salvarCliente))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarCliente)
                    .addComponent(cancelarCliente))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("Nome do cliente");
        label2.getAccessibleContext().setAccessibleName("Email do cliente:");
    }// </editor-fold>//GEN-END:initComponents

    private void nomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeClienteActionPerformed

    private void salvarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salvarClienteMouseClicked
        // TODO add your handling code here:
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente.getText());
        cliente.setEmail(emailCliente.getText());      
        cliente.setTelefone(telefoneCliente.getText());
        if (!cliente.getNome().isEmpty() && !cliente.getEmail().isEmpty() && !cliente.getTelefone().isEmpty()) {
            ClienteDAO.cadastroCliente(cliente);
            JOptionPane.showMessageDialog(null,
                "Cliente cadastrado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );  
            nomeCliente.setText("");        
            emailCliente.setText("");        
            telefoneCliente.setText("");
        } else {
            JOptionPane.showMessageDialog(null,
                "Preencha todos os campos do cadastro",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );  
        }
       
    }//GEN-LAST:event_salvarClienteMouseClicked

       
    private void cancelarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarClienteMouseClicked
        // TODO add your handling code here:
        nomeCliente.setText("");        
        emailCliente.setText("");        
        telefoneCliente.setText("");
    }//GEN-LAST:event_cancelarClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JLabel jLabel3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JButton salvarCliente;
    private javax.swing.JTextField telefoneCliente;
    // End of variables declaration//GEN-END:variables
}
