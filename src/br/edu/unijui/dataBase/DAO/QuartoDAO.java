package br.edu.unijui.dataBase.DAO;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.dataBase.Models.Quarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuartoDAO {

    public static ResultSet BuscaQuartos() throws SQLException {
        DataBase db = new DataBase();

        if (db.getConnection() == null) {
            return null;
        }

        PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT quartos.id, numero, preco_diaria, descricao \n"
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
}
