package mock.infraestructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Database {

    static {
        try {
            DriverManager.getConnection("jdbc:h2:file:./database/sample;INIT=RUNSCRIPT FROM 'schema.sql'", "sa", "");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:file:./database/sample", "sa", "");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ResultSet executeQuery(Connection conn, String sql) {
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            return resultSet;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void executeSql(Connection conn, String sql) {
        try {
            conn.createStatement().execute(sql);
            conn.commit();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
