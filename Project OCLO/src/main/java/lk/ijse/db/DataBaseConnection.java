package lk.ijse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/oclo";
    private final static Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "VpnSachitha123@");
    }

    private static DataBaseConnection dataBaseConnection;
    private Connection connection;

    private DataBaseConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, props);
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if(dataBaseConnection == null) {
            return dataBaseConnection = new DataBaseConnection();
        } else {
            return dataBaseConnection;
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
