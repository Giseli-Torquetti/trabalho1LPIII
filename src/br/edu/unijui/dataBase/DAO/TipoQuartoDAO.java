package br.edu.unijui.dataBase.DAO;

import br.edu.unijui.dataBase.DataBase;
import br.edu.unijui.dataBase.Models.TipoQuarto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoQuartoDAO {

    public static ArrayList<TipoQuarto> BuscaQuartos() throws SQLException {
        DataBase db = new DataBase();

        if (db.getConnection() == null) {
            return null;
        }

        ArrayList<TipoQuarto> tipos = new ArrayList<TipoQuarto>();

        PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT * from tipo_quartos", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultset = pstmt.executeQuery();
        while (resultset.next()) {
            TipoQuarto tipo = new TipoQuarto();
            tipo.setId(resultset.getInt("id"));
            tipo.setDescricao(resultset.getString("descricao"));
            tipos.add(tipo);
        }

        return tipos;
    }
}
