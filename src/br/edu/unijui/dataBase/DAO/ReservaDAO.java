/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dataBase.DAO;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.dataBase.Models.Cliente;
import br.edu.unijui.dataBase.Models.Quarto;
import br.edu.unijui.dataBase.Models.Reserva;
import br.edu.unijui.dataBase.Models.TipoQuarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gisel
 */
public class ReservaDAO {

    public static void cadastroReserva(Quarto quarto, Cliente cliente, Date checkinDate, Date checkoutDate) throws SQLException {

        DataBase db = new DataBase();

        Connection connection = db.getConnection();

        if (connection == null) {
            return;
        }

        connection.setAutoCommit(false);

        PreparedStatement pstmt = connection.prepareStatement("insert into reservas (quartos_id, clientes_id, checkin, checkout) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, quarto.getId());
        pstmt.setInt(2, cliente.getId());
        pstmt.setDate(3, new java.sql.Date(checkinDate.getTime()));
        pstmt.setDate(4, new java.sql.Date(checkoutDate.getTime()));
        pstmt.executeUpdate();

        ResultSet resultSet = pstmt.getGeneratedKeys();
        if (!resultSet.next()) {
            return;
        }

        connection.commit();
        pstmt.close();
        db.close();
    }
    
    public static ArrayList<Reserva> buscarReservasEntreDatas(Date dtInical, Date dtFinal) throws SQLException {
        DataBase db = new DataBase();

        Connection connection = db.getConnection();

        if (connection == null) {
            return null;
        }
        
         ArrayList<Reserva> reservas = new ArrayList();

        connection.setAutoCommit(false);

        PreparedStatement pstmt = connection.prepareStatement(
            "SELECT r.id, c.nome, q.numero, t.descricao, r.checkin, r.checkout " +
"FROM reservas r, clientes c, quartos q, tipo_quartos t " +
"WHERE r.checkin >= ? and r.checkout <= ? " +
"and c.id = r.clientes_id " +
"and q.id = r.quartos_id " +
"and t.id = q.tipo_quartos_id "
        , Statement.RETURN_GENERATED_KEYS);
        pstmt.setDate(1, new java.sql.Date(dtInical.getTime()));        
        pstmt.setDate(2, new java.sql.Date(dtFinal.getTime()));

        
        ResultSet resultset = pstmt.executeQuery();
        while (resultset.next()) {
            Reserva reserva = new Reserva();
            reserva.setId(resultset.getInt("id"));
            reserva.setCheckin(resultset.getDate("checkin"));            
            reserva.setCheckout(resultset.getDate("checkout"));
            Quarto quarto = new Quarto();
            quarto.setNumero(resultset.getString("numero"));
            reserva.setQuarto_rel(quarto);
            TipoQuarto tipo = new TipoQuarto();
            tipo.setDescricao(resultset.getString("descricao"));
            quarto.setTipo_rel(tipo);
            Cliente cliente = new Cliente();
            cliente.setNome(resultset.getString("nome"));
            reserva.setCliente_rel(cliente);
            reservas.add(reserva);         

        }

        connection.commit();
        pstmt.close();
        db.close();
        return reservas;
    }

}
