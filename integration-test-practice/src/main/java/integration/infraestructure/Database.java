package integration.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {

    boolean initialized = false;

    public Connection getConnection() {
        try {
            if (!initialized) {
                DriverManager.getConnection("jdbc:h2:mem:integration-test;INIT=RUNSCRIPT FROM 'schema.sql'", "sa", "");
            }
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:mem:integration-test", "sa", "");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ResultSet executeQuery(Connection conn, String sql) {
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            return resultSet;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(String sql, Object... parameters) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] instanceof String) {
                    stmt.setString(i + 1, (String) parameters[i]);
                }
            }
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void executeSql(Connection conn, String sql) {
        try {
            conn.createStatement().execute(sql);
            conn.commit();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
