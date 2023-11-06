package br.edu.unijui.dataBase.Interface;

import br.edu.unijui.dataBase.DAO.QuartoDAO;
import br.edu.unijui.dataBase.DAO.TipoQuartoDAO;
import br.edu.unijui.dataBase.Models.Quarto;
import br.edu.unijui.dataBase.Models.TipoQuarto;
import br.edu.unijui.logging.HotelLogger;
import br.edu.unijui.xml.ManipuladorXML;
import java.awt.HeadlessException;
import java.awt.Window;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

public class QuartoForm extends javax.swing.JPanel {

    private int id;
    private boolean criarNovoTipo = false;
    private ArrayList<TipoQuarto> tipos;
    private ListaQuartos listaQuartos;

    public QuartoForm(ListaQuartos listaQuartos) {
        this.listaQuartos = listaQuartos;
        this.id = 0;
        initComponents();
        ListarTipos();
        
        try {
            
            Document doc = ManipuladorXML.readXmlFile("./config.xml");
            XPathExpression e1 = ManipuladorXML .getXPathExpression("//configuracoes/selecionarTipo");
            boolean selecionarTipo = Boolean.parseBoolean((String) e1.evaluate(doc, XPathConstants.STRING));
            SelecionarTipo(selecionarTipo);
        } catch (XPathExpressionException ex) {
            HotelLogger.log(Level.SEVERE, "Erro ao ler XML de configurações :" + ex.getMessage(), "Quartos.log");
        }
    }

    public QuartoForm(int idQuarto, ListaQuartos listaQuartos) {
        this.listaQuartos = listaQuartos;
        this.id = idQuarto;
        initComponents();
        try {
            ListarTipos();
            TipoQuarto tipo = new TipoQuarto();
            HotelLogger.log(Level.INFO, "Buscando dados do quarto: " + idQuarto, "Quartos.log");
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
        } catch (SQLException ex) {
            HotelLogger.log(Level.SEVERE, "Erro ao buscar dados do quarto " + idQuarto + ": " + ex.getMessage(), "Quartos.log");
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
            HotelLogger.log(Level.INFO, "Buscando tipos de quartos", "Quartos.log");
            tipos = TipoQuartoDAO.BuscaQuartos();
            for (TipoQuarto tipo : tipos) {
                jcTipoQuarto.addItem(tipo);
            }
        } catch (SQLException ex) {
            HotelLogger.log(Level.SEVERE, "Erro ao buscar tipos de quartos: " + ex.getMessage(), "Quartos.log");
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
        jLabel3 = new javax.swing.JLabel();

        jbSalvarQuarto.setBackground(new java.awt.Color(204, 255, 204));
        jbSalvarQuarto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jbSalvarQuarto.setText("Salvar");
        jbSalvarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarQuartoActionPerformed(evt);
            }
        });

        jtNumero.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Número");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Preço (diária)");

        jtPrecoDiaria.setToolTipText("");

        jtDescricaoTipo.setToolTipText("");
        jtDescricaoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDescricaoTipoActionPerformed(evt);
            }
        });

        jlNovoTipo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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

        jlSelecionarTipo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlSelecionarTipo.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Cadastro de quartos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtDescricaoTipo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlSelecionarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlNovoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jcTipoQuarto, 0, 239, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbSelecionarTipo)
                            .addComponent(jbNovoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbSalvarQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtPrecoDiaria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                        .addComponent(jtNumero, javax.swing.GroupLayout.Alignment.LEADING))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtPrecoDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jlNovoTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDescricaoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSelecionarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jlSelecionarTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcTipoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNovoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jbSalvarQuarto)
                .addGap(30, 30, 30))
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

                HotelLogger.log(Level.INFO,
                        "Criando quarto: numero: " + numero + ", preço: " + preco + ", tipo: " + (tipoQuarto == 0 ? descTipo : tipoQuarto),
                        "Quartos.log");
                QuartoDAO.CriarQuarto(numero, preco, tipoQuarto, descTipo, this.criarNovoTipo);
            } else {
                HotelLogger.log(Level.INFO,
                        "Alterando quarto: id: " + idQuarto + ", numero: " + numero + ", preço: " + preco + ", tipo: " + (tipoQuarto == 0 ? descTipo : tipoQuarto),
                        "Quartos.log");
                QuartoDAO.AlterarQuarto(idQuarto, numero, preco, tipoQuarto, descTipo, this.criarNovoTipo);
            }
            JOptionPane.showMessageDialog(this, "Quarto salvo");
            listaQuartos.popularTabela();
            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        } catch (HeadlessException | SQLException ex) {
            if (idQuarto == 0) {
                HotelLogger.log(Level.SEVERE, "Erro ao criar quarto: " + ex.getMessage(), "Quartos.log");
            } else {
                HotelLogger.log(Level.SEVERE, "Erro ao alterar quarto: " + ex.getMessage(), "Quartos.log");
            }
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
    private javax.swing.JLabel jLabel3;
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
