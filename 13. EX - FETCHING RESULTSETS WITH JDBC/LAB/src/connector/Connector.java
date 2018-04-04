package connector;

import java.sql.Connection;
import java.sql.*;
import java.util.Properties;

public class Connector implements  AutoCloseable{

    private static final String CREATE_IF_NOT_EXIST = "?createDatabaseIfNotExist=true";
    private static final String MYSQL_CONFIG = "&useSSL=false";

    private static Connection conn = null;

    /**
     * Generate a connection that we would use to connect to the database
     *
     * @param driver - database driver
     * @param username - database username
     * @param password - database password
     * @param host - database host
     * @param port - database port
     * @param dbName - database name
     * @throws SQLException
     */

    public static void initConnection(String driver, String username,
                                      String password, String host, String port, String dbName) throws SQLException {
        Properties connectionProp = new Properties();
        connectionProp.put("user", username);
        connectionProp.put("password", password);
        conn = DriverManager.getConnection("jdbc" + ":" + driver + "://" + host + ":" +
                port + "/" + dbName + CREATE_IF_NOT_EXIST + MYSQL_CONFIG, connectionProp);

        //"jdbc:mysql://localhost:3306/soft_uni?createDatabaseIfNotExist=true";
    }

    public static Connection getConn() {
        return conn;
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
