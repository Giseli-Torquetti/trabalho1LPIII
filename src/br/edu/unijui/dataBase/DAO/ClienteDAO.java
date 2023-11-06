/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dataBase.DAO;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.dataBase.Models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ClienteDAO {

    public static ArrayList<Cliente> BuscaClientes() throws SQLException {
        DataBase db = new DataBase();

        ArrayList<Cliente> clientes = new ArrayList();

        if (db.getConnection() == null) {
            return new ArrayList<>();
        }

        PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT * FROM CLIENTES");

        ResultSet resultset = pstmt.executeQuery();

        while (resultset.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(resultset.getInt("id"));
            cliente.setNome(resultset.getString("nome"));
            cliente.setEmail(resultset.getString("email"));
            cliente.setTelefone(resultset.getString("telefone"));
            clientes.add(cliente);
        }
        resultset.close();
        pstmt.close();
        db.close();
        return clientes;
    }

    public static void cadastroCliente(Cliente cliente) throws SQLException {
        DataBase db = new DataBase();

        Connection connection = db.getConnection();

        if (connection == null) {
            return;
        }
        Date dataAtual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataAtualString = dateFormat.format(dataAtual);

        PreparedStatement pstmt = connection.prepareStatement("insert into clientes (nome, email, telefone,dt_cadastro) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getEmail());
        pstmt.setString(3, cliente.getTelefone());        
        pstmt.setString(4, dataAtualString);

       
        pstmt.executeUpdate();

        ResultSet resultSet = pstmt.getGeneratedKeys();
        if (!resultSet.next()) {
            return;
        }

        pstmt.close();
        db.close();
    }

    public static void editarCadastroCliente(Cliente cliente) throws SQLException {
        DataBase db = new DataBase();

        Connection connection = db.getConnection();

        if (connection == null) {
            return;
        }

        connection.setAutoCommit(false);

        PreparedStatement pstmt = connection.prepareStatement("update clientes set nome = ?, email = ?, telefone = ? where id = ?", Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getEmail());
        pstmt.setString(3, cliente.getTelefone());
        pstmt.setInt(4, cliente.getId()); 

        pstmt.executeUpdate();

        connection.commit();
        pstmt.close();
        db.close();

    }
    public static ArrayList<Cliente> buscaClienteEntreDatas(Date dtInical, Date dtFinal) throws SQLException {
        DataBase db = new DataBase();

        Connection connection = db.getConnection();

        if (connection == null) {
            return null;
        }
        
         ArrayList<Cliente> clientes = new ArrayList();

        connection.setAutoCommit(false);

        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM clientes WHERE dt_cadastro BETWEEN ? AND ? ", Statement.RETURN_GENERATED_KEYS);
        pstmt.setDate(1, new java.sql.Date(dtInical.getTime()));        
        pstmt.setDate(2, new java.sql.Date(dtFinal.getTime()));

        
        ResultSet resultset = pstmt.executeQuery();
        while (resultset.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(resultset.getInt("id"));
            cliente.setNome(resultset.getString("nome"));
            cliente.setEmail(resultset.getString("email"));
            cliente.setTelefone(resultset.getString("telefone"));            
            cliente.setDtCadastro(resultset.getDate("dt_cadastro"));

            clientes.add(cliente);
        }

        connection.commit();
        pstmt.close();
        db.close();
        return clientes;
    }
}
