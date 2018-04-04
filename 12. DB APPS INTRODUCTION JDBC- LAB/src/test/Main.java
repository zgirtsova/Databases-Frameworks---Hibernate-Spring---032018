package test;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/sof?createDatabaseIfNotExist=true";
        String USER = "root";
        String PASSWORD = "";

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement prstmt = null;
        ResultSet rs = null;

        String SQL = "CREATE TABLE IF NOT EXISTS admins(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "user VARCHAR(25)," +
                "password VARCHAR(12)" +
                ")";

        String insertString = "" +
                "INSERT INTO admins(user, password)" +
                "VALUES('Mimi', '123456'),('Paul', '456456')";

        String selectSQL = "SELECT * FROM admins";

        String preparedStmt = "SELECT * FROM admins WHERE user = ?";

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            if (conn != null) {
                System.out.println("Connection is opened!");
            }

            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);

            try {
                stmt.executeUpdate(insertString);
                //conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
            }

            prstmt = conn.prepareStatement(preparedStmt);
            prstmt.setString(1, "Gerry");
            prstmt.setInt(1, 1);

            rs = prstmt.executeQuery();

//            rs = stmt.executeQuery(selectSQL);
//
//            if (rs != null) {
//                rs.beforeFirst(); //сложи си курсора преди 1ият ред, защото ResultSet се връща неподреден
//                while (rs.next()){
//                    System.out.format("User: %s, password: %s. %n",
//                            rs.getString("user"),
//                            rs.getString("password"));
//                }
//            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null){
                conn.close();
                conn = null;
                System.out.println("The connection is closed!");
            }
        }
    }
}
