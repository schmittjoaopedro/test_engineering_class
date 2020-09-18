package integration.usuario;

import integration.infraestructure.Database;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuarioDaoTest {

    @Test
    public void deveEncontrarPeloNomeEEmailMockado() throws Exception {
        // Mock
        String sqlConsulta = "SELECT * FROM USUARIO WHERE NAME = 'Joao Schmitt' AND EMAIL = 'joao@schmitt.com'";
        Connection connection = mock(Connection.class);
        ResultSet resultSet = mock(ResultSet.class);
        Database database = mock(Database.class);
        when(database.getConnection()).thenReturn(connection);
        when(database.executeQuery(connection, sqlConsulta)).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getLong("ID")).thenReturn(1L);
        when(resultSet.getString("NOME")).thenReturn("Joao Schmitt");
        when(resultSet.getString("EMAIL")).thenReturn("joao@schmitt.com");

        // Test case
        UsuarioDao usuarioDao = new UsuarioDao(database);
        // Criar usuario na base
        Usuario usuarioNovo = new Usuario("Joao Schmitt", "joao@schmitt.com");
        usuarioDao.salva(usuarioNovo);
        // Carregar usuario salvo
        Usuario usuario = usuarioDao.buscarPorNomeEEmail("Joao Schmitt", "joao@schmitt.com");
        Assert.assertEquals(usuario.getId(), 1L, 0);
        Assert.assertEquals(usuario.getNome(), "Joao Schmitt");
        Assert.assertEquals(usuario.getEmail(), "joao@schmitt.com");
    }
}
