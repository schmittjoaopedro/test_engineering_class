package integration.usuario;

import integration.infraestructure.Database;

import java.sql.ResultSet;

public class UsuarioDao {

    private Database database;

    public UsuarioDao(Database database) {
        this.database = database;
    }

    public Usuario porId(int id) {
        try {
            ResultSet resultSet = database.executeQuery("SELECT * FROM USUARIO WHERE ID = " + id);
            Usuario usuario = null;
            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getLong("ID"));
                usuario.setNome(resultSet.getString("NOME"));
                usuario.setEmail(resultSet.getString("EMAIL"));
            }
            return usuario;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Usuario buscarPorNomeEEmail(String nome, String email) {
        try {
            ResultSet resultSet = database.executeQuery("SELECT * FROM USUARIO WHERE NAME = '" + nome + "' AND EMAIL = '" + email + "'");
            Usuario usuario = null;
            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getLong("ID"));
                usuario.setNome(resultSet.getString("NOME"));
                usuario.setEmail(resultSet.getString("EMAIL"));
            }
            return usuario;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void salva(Usuario usuario) {
        database.insert("INSERT INTO USUARIO (NOME, EMAIL) VALUES (?,?)", usuario.getNome(), usuario.getEmail());
    }

}
