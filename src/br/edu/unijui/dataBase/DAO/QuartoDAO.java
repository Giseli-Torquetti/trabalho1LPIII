package br.edu.unijui.dataBase.DAO;

import br.edu.unijui.dataBase.DataBase;
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
}
