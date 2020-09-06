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

    public void salvarPagamento(Pagamento pagamento) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO PAGAMENTO (LEILAO_ID, LEILAO_NOME_PRODUTO) VALUES (?, ?)");
            stmt.setLong(1, pagamento.getLeilao().getId());
            stmt.setString(2, pagamento.getLeilao().getNomeProduto());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Leilao> correntes() {
        return buscaLeiloesPorSql("SELECT * FROM LEILAO");
    }

    public List<Leilao> encerrados() {
        return buscaLeiloesPorSql("SELECT * FROM LEILAO WHERE ENCERRADO = true");
    }

    public List<Pagamento> pagamentos() {
        return buscaPagamentosPorSql("SELECT * FROM PAGAMENTO");
    }

    public void imprimeBase() {
        System.out.println("Leiloes salvos na base de dados");
        for (Leilao leilao : correntes()) {
            System.out.println(leilao);
        }
        System.out.println("Pagamentos salvos na base de dados");
        for (Pagamento pagamento : pagamentos()) {
            System.out.println(pagamento);
        }
    }

    private List<Leilao> buscaLeiloesPorSql(String sql) {
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

    private List<Pagamento> buscaPagamentosPorSql(String sql) {
        try {
            Connection con = Database.getConnection();
            ResultSet resultSet = Database.executeQuery(con, sql);
            List<Pagamento> pagamentos = new ArrayList<>();
            while (resultSet.next()) {
                Leilao leilao = new Leilao(resultSet.getString("LEILAO_NOME_PRODUTO"));
                leilao.setId(resultSet.getLong("LEILAO_ID"));
                Pagamento pagamento = new Pagamento(leilao);
                pagamento.setId(resultSet.getLong("ID"));
                pagamentos.add(pagamento);
            }
            return pagamentos;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
