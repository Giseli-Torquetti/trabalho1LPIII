package br.edu.unijui.dataBase.Interface;

import br.edu.unijui.dataBase.DAO.QuartoDAO;
import br.edu.unijui.dataBase.DAO.TipoQuartoDAO;
import br.edu.unijui.dataBase.Models.Quarto;
import br.edu.unijui.dataBase.Models.TipoQuarto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QuartoForm extends javax.swing.JPanel {

    private int id;
    private boolean criarNovoTipo = false;
    private ArrayList<TipoQuarto> tipos;

    public QuartoForm() {
        this.id = 0;
        initComponents();
        ListarTipos();
        SelecionarTipo(true);
    }

    public QuartoForm(int idQuarto) {
        this.id = idQuarto;
        initComponents();
        try {
            ListarTipos();
            TipoQuarto tipo = new TipoQuarto();
            Quarto quarto = QuartoDAO.BuscarPorId(idQuarto);
            for (TipoQuarto t : tipos) {
                if (t.getId() == quarto.getTipo()) {
                    tipo = t;
                    break;
                }
            }
            jtNumero.setText(quarto.getNumero());
            jtPrecoDiaria.setText(String.valueOf(quarto.getPreco()));
            jcTipoQuarto.setSelectedItem(tipo);
            SelecionarTipo(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void SelecionarTipo(boolean flag) {
        jbSelecionarTipo.setVisible(!flag);
        jbNovoTipo.setVisible(flag);
        jlSelecionarTipo.setVisible(flag);
        jlNovoTipo.setVisible(!flag);
        jcTipoQuarto.setVisible(flag);
        jtDescricaoTipo.setVisible(!flag);
        this.criarNovoTipo = !flag;
    }

    private void ListarTipos() {
        try {
            tipos = TipoQuartoDAO.BuscaQuartos();
            for (TipoQuarto tipo : tipos) {
                jcTipoQuarto.addItem(tipo);
            }
        } catch (Exception ex) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalvarQuarto = new javax.swing.JButton();
        jtNumero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtPrecoDiaria = new javax.swing.JTextField();
        jtDescricaoTipo = new javax.swing.JTextField();
        jlNovoTipo = new javax.swing.JLabel();
        jbNovoTipo = new javax.swing.JButton();
        jcTipoQuarto = new javax.swing.JComboBox<>();
        jbSelecionarTipo = new javax.swing.JButton();
        jlSelecionarTipo = new javax.swing.JLabel();

        jbSalvarQuarto.setText("Salvar");
        jbSalvarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarQuartoActionPerformed(evt);
            }
        });

        jtNumero.setToolTipText("");

        jLabel1.setText("Número");

        jLabel2.setText("Preço (diária)");

        jtPrecoDiaria.setToolTipText("");

        jtDescricaoTipo.setToolTipText("");
        jtDescricaoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDescricaoTipoActionPerformed(evt);
            }
        });

        jlNovoTipo.setText("Tipo");

        jbNovoTipo.setText("Novo");
        jbNovoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoTipoActionPerformed(evt);
            }
        });

        jbSelecionarTipo.setText("Selecioar");
        jbSelecionarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelecionarTipoActionPerformed(evt);
            }
        });

        jlSelecionarTipo.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlSelecionarTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlNovoTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcTipoQuarto, 0, 110, Short.MAX_VALUE)
                    .addComponent(jtDescricaoTipo)
                    .addComponent(jtPrecoDiaria)
                    .addComponent(jtNumero))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbSelecionarTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbNovoTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSalvarQuarto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtPrecoDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNovoTipo)
                    .addComponent(jtDescricaoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSelecionarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSelecionarTipo)
                    .addComponent(jcTipoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNovoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbSalvarQuarto)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarQuartoActionPerformed
        int idQuarto = this.id;
        String numero = jtNumero.getText();
        double preco = Double.parseDouble(jtPrecoDiaria.getText());
        String descTipo = jtDescricaoTipo.getText();
        TipoQuarto tipo = (TipoQuarto) jcTipoQuarto.getSelectedItem();
        int tipoQuarto = 0;
        if (tipo != null) {
            tipoQuarto = tipo.getId();
        }

        try {
            if (idQuarto == 0) {
                QuartoDAO.CriarQuarto(numero, preco, tipoQuarto, descTipo, this.criarNovoTipo);
                JOptionPane.showMessageDialog(this, "Quarto criado");
                return;
            }

            QuartoDAO.AlterarQuarto(idQuarto, numero, preco, tipoQuarto, descTipo, this.criarNovoTipo);
            JOptionPane.showMessageDialog(this, "Quarto alterado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar dados");
        }
    }//GEN-LAST:event_jbSalvarQuartoActionPerformed

    private void jtDescricaoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDescricaoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDescricaoTipoActionPerformed

    private void jbNovoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoTipoActionPerformed
        SelecionarTipo(false);
    }//GEN-LAST:event_jbNovoTipoActionPerformed

    private void jbSelecionarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecionarTipoActionPerformed
        SelecionarTipo(true);
    }//GEN-LAST:event_jbSelecionarTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbNovoTipo;
    private javax.swing.JButton jbSalvarQuarto;
    private javax.swing.JButton jbSelecionarTipo;
    private javax.swing.JComboBox<Object> jcTipoQuarto;
    private javax.swing.JLabel jlNovoTipo;
    private javax.swing.JLabel jlSelecionarTipo;
    private javax.swing.JTextField jtDescricaoTipo;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtPrecoDiaria;
    // End of variables declaration//GEN-END:variables
}
