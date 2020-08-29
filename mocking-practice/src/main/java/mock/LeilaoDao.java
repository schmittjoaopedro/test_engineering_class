package mock;

import mock.infraestructure.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LeilaoDao {

    public void salva(Leilao leilao) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO LEILAO (NOME_PRODUTO, ENCERRADO, DATA) VALUES (?,?,?)");
            stmt.setString(1, leilao.getNomeProduto());
            stmt.setBoolean(2, leilao.isEncerrado());
            stmt.setDate(3, new Date(leilao.getData().getTimeInMillis()));
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void atualiza(Leilao leilao) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE LEILAO SET NOME_PRODUTO=?, ENCERRADO=?, DATA=? WHERE ID=?");
            stmt.setString(1, leilao.getNomeProduto());
            stmt.setBoolean(2, leilao.isEncerrado());
            stmt.setDate(3, new Date(leilao.getData().getTimeInMillis()));
            stmt.setLong(4, leilao.getId());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Leilao> correntes() {
        return buscaPorSql("SELECT * FROM LEILAO");
    }

    public List<Leilao> encerrados() {
        return buscaPorSql("SELECT * FROM LEILAO WHERE ENCERRADO = true");
    }

    private List<Leilao> buscaPorSql(String sql) {
        try {
            Connection con = Database.getConnection();
            ResultSet resultSet = Database.executeQuery(con, sql);
            List<Leilao> leilaos = new ArrayList<>();
            while (resultSet.next()) {
                Leilao leilao = new Leilao(resultSet.getString("NOME_PRODUTO"));
                leilao.setId(resultSet.getLong("ID"));
                leilao.setEncerrado(resultSet.getBoolean("ENCERRADO"));
                leilao.setData(Calendar.getInstance());
                leilao.getData().setTimeInMillis(resultSet.getDate("DATA").getTime());
                leilaos.add(leilao);
            }
            return leilaos;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
