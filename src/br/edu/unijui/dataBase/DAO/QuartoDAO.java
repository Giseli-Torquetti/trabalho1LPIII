package br.edu.unijui.dataBase.DAO;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.dataBase.Models.Quarto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuartoDAO {

    public static ResultSet BuscaQuartos() throws SQLException {
        DataBase db = new DataBase();

        if (db.getConnection() == null) {
            return null;
        }

        PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT quartos.id, numero, preco_diaria, descricao,"
                + "(case when quartos.id in (select quartos_id from reservas where CURDATE() between checkin and checkout) then 'Ocupado' else 'Livre' end) as status \n"
                + "FROM quartos\n"
                + "INNER JOIN tipo_quartos ON (quartos.tipo_quartos_id = tipo_quartos.id)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultset = pstmt.executeQuery();
        return resultset;
    }

    public static Quarto BuscarPorId(int id) throws SQLException {
        DataBase db = new DataBase();

        if (db.getConnection() == null) {
            return null;
        }

        PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT * \n"
                + "FROM quartos\n"
                + "where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        pstmt.setInt(1, id);
        ResultSet resultset = pstmt.executeQuery();
        if (resultset.next()) {
            Quarto quarto = new Quarto();
            quarto.setId(resultset.getInt("id"));
            quarto.setNumero(resultset.getString("numero"));
            quarto.setPreco(resultset.getDouble("preco_diaria"));
            quarto.setTipo(resultset.getInt("tipo_quartos_id"));
            return quarto;
        }

        return null;
    }

    public static void CriarQuarto(String numero, double preco, int tipo, String descricaoTipo, boolean criarTipo) throws SQLException {
        DataBase db = new DataBase();
        Connection connection = db.getConnection();
        if (connection == null) {
            return;
        }

        PreparedStatement pstmt;
        connection.setAutoCommit(false);

        if (criarTipo) {
            pstmt = connection.prepareStatement("insert into tipo_quartos (descricao) values (?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, descricaoTipo);

            pstmt.executeUpdate();

            ResultSet resultSet = pstmt.getGeneratedKeys();
            if (!resultSet.next()) {
                return;
            }

            tipo = resultSet.getInt(1);
        }

        pstmt = connection.prepareStatement("insert into quartos (numero, preco_diaria, tipo_quartos_id) values (?,?,?)");
        pstmt.setString(1, numero);
        pstmt.setDouble(2, preco);
        pstmt.setInt(3, tipo);
        pstmt.executeUpdate();

        connection.commit();
        pstmt.close();
        db.close();
    }

    public static void AlterarQuarto(int idQuarto, String numero, double preco, int tipo, String descricaoTipo, boolean criarTipo) throws SQLException {
        DataBase db = new DataBase();
        Connection connection = db.getConnection();
        if (connection == null) {
            return;
        }

        PreparedStatement pstmt;
        connection.setAutoCommit(false);

        if (criarTipo) {
            pstmt = connection.prepareStatement("insert into tipo_quartos (descricao) values (?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, descricaoTipo);

            pstmt.executeUpdate();

            ResultSet resultSet = pstmt.getGeneratedKeys();
            if (!resultSet.next()) {
                return;
            }

            tipo = resultSet.getInt(1);
        }

        pstmt = connection.prepareStatement("update quartos set numero = ?, preco_diaria = ?, tipo_quartos_id = ? where id = ?");
        pstmt.setString(1, numero);
        pstmt.setDouble(2, preco);
        pstmt.setInt(3, tipo);
        pstmt.setInt(4, idQuarto);
        pstmt.executeUpdate();

        connection.commit();
        pstmt.close();
        db.close();
    }

    public static ArrayList<Quarto> BuscaQuartosCB() throws SQLException {
        DataBase db = new DataBase();

        ArrayList<Quarto> quartos = new ArrayList();

        if (db.getConnection() == null) {
            return new ArrayList<>();
        }

        PreparedStatement pstmt = db.getConnection().prepareStatement("select * from quartos where id not in (select quartos_id from reservas where curdate() between checkin and checkout)");

        ResultSet resultset = pstmt.executeQuery();
        System.out.println(resultset);

        while (resultset.next()) {
            Quarto quarto = new Quarto();
            quarto.setId(resultset.getInt("id"));
            quarto.setNumero(resultset.getString("numero"));
            quarto.setPreco(resultset.getDouble("preco_diaria"));
            quarto.setTipo(resultset.getInt("tipo_quartos_id"));
            quartos.add(quarto);
        }
        System.out.println(quartos);
        resultset.close();
        pstmt.close();
        db.close();
        return quartos;
    }
}
