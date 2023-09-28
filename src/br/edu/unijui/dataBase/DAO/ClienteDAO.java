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
import java.util.ArrayList;

/**
 *
 * @author gisel
 */
public class ClienteDAO {
    public static ArrayList<Cliente> BuscaClientes () throws SQLException {
       DataBase db = new DataBase();
       
       ArrayList<Cliente> clientes = new ArrayList();
       
       if(db.getConnection() == null) return new ArrayList<>();
       
       PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT * FROM CLIENTES");
       
       ResultSet resultset = pstmt.executeQuery();
       
       while (resultset.next()){
           Cliente cliente = new Cliente();
           cliente.setId(resultset.getInt("id_cliente"));           
           cliente.setNome(resultset.getString("nome_cliente"));
           cliente.setEmail(resultset.getString("email_cliente"));
           cliente.setTelefone(resultset.getString("telefone_cliente"));           
           clientes.add(cliente);
       }
       resultset.close();
       pstmt.close();
       db.close();
       return clientes;
    } 
    
    public static void cadastroCliente(Cliente cliente){
        try{
            DataBase db = new DataBase();
            
            Connection connection = db.getConnection();
            
            if(connection == null) return;
            
            connection.setAutoCommit(false);
            
            PreparedStatement pstmt = connection.prepareStatement("insert into clientes (nome, email, telefone) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());          
            pstmt.setString(3, cliente.getTelefone());
            pstmt.executeUpdate();
             
            ResultSet resultSet = pstmt.getGeneratedKeys();
            if (!resultSet.next()) return;

            connection.commit();
            pstmt.close();
            db.close();   
            
        }catch (SQLException ex) {
           System.out.println("Não foi possivel cadastrar um novo cliente"); 
        }
    }
}

