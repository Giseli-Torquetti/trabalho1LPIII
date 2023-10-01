package br.edu.unijui.dataBase.Interface;

import br.edu.unijui.dataBase.DAO.QuartoDAO;
import br.edu.unijui.dataBase.Models.QuartosTableModel;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ListaQuartos extends javax.swing.JPanel {

    private static QuartosTableModel tableModel = new QuartosTableModel(new String[]{"Código", "Número", "Preço", "Tipo"});

    public ListaQuartos() {
        initComponents();
        popularTabela();
    }

    private void popularTabela() {
        try {
            ResultSet quartos = QuartoDAO.BuscaQuartos();
            tableModel.setResultSet(quartos);
            jtQuartos.setModel(tableModel);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtQuartos = new javax.swing.JTable();
        jbCriarQuarto = new javax.swing.JButton();

        jtQuartos.setModel(tableModel);
        jtQuartos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtQuartosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtQuartos);

        jbCriarQuarto.setText("Criar novo");
        jbCriarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCriarQuartoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jbCriarQuarto)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jbCriarQuarto)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jbCriarQuarto.getAccessibleContext().setAccessibleName("jbCriarNovo");
    }// </editor-fold>//GEN-END:initComponents

    private void jbCriarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCriarQuartoActionPerformed
        JFrame frame = new JFrame("Quarto");
        frame.setSize(400, 380);
        JPanel panel = new QuartoForm();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }//GEN-LAST:event_jbCriarQuartoActionPerformed

    private void jtQuartosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtQuartosMouseClicked
        if (evt.getClickCount() != 2) {
            return;
        }

        JTable target = (JTable) evt.getSource();
        int id = (int) target.getValueAt(target.getSelectedRow(), 0);
        JFrame frame = new JFrame("Quarto");
        frame.setSize(400, 380);
        JPanel panel = new QuartoForm(id);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }//GEN-LAST:event_jtQuartosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCriarQuarto;
    private javax.swing.JTable jtQuartos;
    // End of variables declaration//GEN-END:variables
}
