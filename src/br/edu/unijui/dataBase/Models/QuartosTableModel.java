package br.edu.unijui.dataBase.Models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class QuartosTableModel extends AbstractTableModel {

    private ResultSet resultSet;
    private int numberOfRows;
    private final String[] nomesColunas;

    public QuartosTableModel(String[] colunas){
        numberOfRows = 0;
        this.nomesColunas = colunas;
    }

    //retorna o número de colunas do ResultSet
    @Override
    public int getColumnCount() throws IllegalStateException {
        return nomesColunas.length;
    }

    //retorna o nome de uma determinada coluna do ResultSet
    @Override
    public String getColumnName(int column) throws IllegalStateException {
        if (nomesColunas != null) {
            return nomesColunas[column];
        }
        return "";
    }

    //retorna o número de linhas do ResultSet
    @Override
    public int getRowCount() throws IllegalStateException {
        return numberOfRows;
    }

    //retorna o valor que consta na linha e coluna especificadas
    @Override
    public Object getValueAt(int row, int column) throws IllegalStateException {
        
        try {
            //posiciona em uma linha específica
            resultSet.absolute(row + 1);
            //obtém o objeto de uma coluna específica na linha posicionada
            return resultSet.getObject(column + 1);
        } catch (SQLException ex) {
            Logger.getLogger(QuartosTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return "";
    }

    // atualizar o componente de tabela
    public void setResultSet(ResultSet rs)
            throws SQLException, IllegalStateException {

        //ResultSet com os dados da tabela
        resultSet = rs;

        //obtém o número da linha
        resultSet.last();
        numberOfRows = resultSet.getRow();

        // notifica a JTable de que o modelo foi alterado
        fireTableStructureChanged();
    }

}

