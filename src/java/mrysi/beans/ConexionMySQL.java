package mrysi.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private Connection conn;
    private String bd;
    private String host;
    private String port;

    public ConexionMySQL() {
        bd = "mrysiEscuelas";
        host = "localhost";
        port = "3306";
        conn = null;
    }

    private boolean setDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }

    public Connection getConnection() throws SQLException {
        if (setDriver()) {
            String URL = "jdbc:mysql://" + host + ":" + port + "/" + bd;
            conn = DriverManager.getConnection(URL, "root", "Cristian201101.");
        }
        return conn;
    }
}