package DB;

import Cryptography.Cryption;
import Model.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

    private static Connection conn;

    private static synchronized void createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + Cryption.decript(Settings.getObject().host) + ":" + Cryption.decript(Settings.getObject().port) + "/ishara_service", Cryption.decript(Settings.getObject().user), Cryption.decript(Settings.getObject().pass));
    }

   
    public static void iud(String query) throws SQLException, ClassNotFoundException {
        if (conn == null) {
            createConnection();
        }
        conn.createStatement().executeUpdate(query);
    }

    public static ResultSet search(String query) throws SQLException, ClassNotFoundException {
        if (conn == null) {
            createConnection();
        }
        return conn.createStatement().executeQuery(query);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null) {
            createConnection();
        }
        return conn;
    }
}