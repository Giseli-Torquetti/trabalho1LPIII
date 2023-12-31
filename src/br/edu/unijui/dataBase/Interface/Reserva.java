package br.edu.unijui.dataBase.Interface;

import br.edu.unijui.dataBase.DAO.ClienteDAO;
import br.edu.unijui.dataBase.DAO.QuartoDAO;
import br.edu.unijui.dataBase.DAO.ReservaDAO;
import br.edu.unijui.dataBase.Models.Cliente;
import br.edu.unijui.dataBase.Models.Quarto;
import br.edu.unijui.logging.HotelLogger;
import java.awt.Window;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Reserva extends javax.swing.JPanel {

    public Reserva() {
        initComponents();
        buscarClientes();
        buscarQuartos();
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        checkin.setText(dateFormat.format(date));
    }

    public void buscarClientes() {
        try {
            ArrayList<Cliente> clientes = ClienteDAO.BuscaClientes();
            for (int i = 0; i < clientes.size(); i++) {
                cbCliente.addItem(clientes.get(i));
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possivel buscar os clientes");
        }
    }

    public void buscarQuartos() {
        try {
            ArrayList<Quarto> quartos = (ArrayList<Quarto>) QuartoDAO.BuscaQuartosCB();
            for (int i = 0; i < quartos.size(); i++) {
                cbQuarto.addItem(quartos.get(i));
            }
            System.out.println(cbQuarto);
        } catch (SQLException ex) {
            System.out.println("Não foi possivel buscar os clientes");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbQuarto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        checkout = new javax.swing.JFormattedTextField();
        checkin = new javax.swing.JFormattedTextField();
        salvarReserva = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Reserva");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Quarto");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Check in");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Check out");

        checkout.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        checkin.setEditable(false);
        checkin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        salvarReserva.setBackground(new java.awt.Color(204, 255, 204));
        salvarReserva.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        salvarReserva.setText("Salvar");
        salvarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbQuarto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(salvarReserva)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(salvarReserva)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salvarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarReservaActionPerformed
        // TODO add your handling code here:
        Quarto quarto = (Quarto) cbQuarto.getSelectedItem();
        Cliente cliente = (Cliente) cbCliente.getSelectedItem();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date checkoutDate = null;
        Date checkinDate = null;
        try {
            checkinDate = formato.parse(checkin.getText());
            checkoutDate = formato.parse(checkout.getText());
            if (checkoutDate.before(checkinDate)) {
                JOptionPane.showMessageDialog(this, "Data de checkout não pode ser antes da data de checkin.");
                return;
            }
        } catch (ParseException ex) {
            HotelLogger.log(Level.SEVERE,
                    "Erro ao converter data: " + ex.getMessage(),
                    "Reservas.log");
        }

        try {
            HotelLogger.log(Level.INFO,
                    "Criando reserva: quarto: " + quarto.getId() + ", cliente: " + cliente.getId(),
                    "Reservas.log");
            ReservaDAO.cadastroReserva(quarto, cliente, checkinDate, checkoutDate);
        } catch (SQLException ex) {
            HotelLogger.log(Level.SEVERE,
                    "Erro ao criar reserva: " + ex.getMessage(),
                    "Reservas.log");
            try {
                ReservaDAO.cadastroReserva(quarto, cliente, checkinDate, checkoutDate);
            } catch (SQLException ex1) {
                Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        long diffInMillies = Math.abs(checkoutDate.getTime() - checkinDate.getTime());
        int diff = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        double precoTotal = diff * quarto.getPreco();
        JOptionPane.showMessageDialog(this, "Sucesso! Valor total para " + (String.valueOf(diff)) + " dias = R$ " + (String.valueOf(precoTotal)));

        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }//GEN-LAST:event_salvarReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbCliente;
    private javax.swing.JComboBox<Object> cbQuarto;
    private javax.swing.JFormattedTextField checkin;
    private javax.swing.JFormattedTextField checkout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salvarReserva;
    // End of variables declaration//GEN-END:variables
}
